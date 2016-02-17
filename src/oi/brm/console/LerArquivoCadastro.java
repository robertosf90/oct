package oi.brm.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import oi.brm.utils.UtilsOCT;
import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

public class LerArquivoCadastro implements Runnable {

	private String tipo;
	private String login;
	private String senha;
	private String sid;
	private String porta;
	private String host;
	private String porta2;
	private String host2;
	private String path;
	private String path_destino;
	private Connection con;
	private String arquivo;

	private static Logger logger = Logger.getLogger(LerArquivoCadastro.class
			.getName());

	@Override
	public void run() {

		connectToDataBase();

		// Entender como o pessoal da Oi dispara o robo
		// TODO: Alterar a lógica pra retirar o loop infinito
		while (true) {
			try {
				if (populaAgendaCadastro()) {
					if (inseriLinhaBanco() > 0) {
					    //Essa parte Guilherme vai fazer
						consomeCadastro(getArquivo(), getTipo());
					}

				} else {
					LogDAO.inseriLogSucesso(con, null,
							"OCT-CADASTRO SLEEPING.", "SISTEMA");
					Thread.sleep(10000);
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			}
		}

	}

	private int inseriLinhaBanco() {
		String linha = null;
		String arquivo = getArquivo();
		int qtd_linha = 0;
		FileReader reader = null;  
        BufferedReader leitor = null;  
		
        atualizaAgendaIncioConsumo(arquivo);
        
        UtilsOCT.iniciaVariaveisOracle(getCon(),logger,con);
        
        try{
        	
        	reader = new FileReader((getPath() + "/" + arquivo).replace(".TXT", ".PROC").replace(".txt", ".PROC"));  
	        leitor = new BufferedReader(reader);  
	        
			while ((linha = leitor.readLine()) != null) {
				gravaLinha(linha, qtd_linha);
				qtd_linha++;
			}
			
			leitor.close();
			reader.close();
        	
			// é feito uma conversao pro MD5 pra garantir a autenticidade... haja visto que o arquivo passa por varias empresas
			if (qtd_linha > 0){
	        	 atualizaAgendaFimConsumo(arquivo);
	        	 Principal.copy(new File((getPath() + "/" + arquivo.toUpperCase()).replace(".TXT", ".PROC")), new File((getPath_destino() + "/" + arquivo.toUpperCase()).replace(".TXT", ".PROC")), true);
	        	 Principal.copy(new File((getPath() + "/" + arquivo.toUpperCase()).replace(".TXT", ".MD5")), new File((getPath_destino() + "/" + arquivo.toUpperCase()).replace(".TXT", ".MD5")), true);
	         }else{
	        	 atualizaAgendaFimConsumoFalha(arquivo);
	        	 Principal.copy(new File((getPath() + "/" + arquivo.toUpperCase()).replace(".TXT", ".PROC")), new File((getPath_destino() + "/" + arquivo.toUpperCase()).replace(".PROC", ".TXT")), true);
	        	 Principal.copy(new File((getPath() + "/" + arquivo.toUpperCase()).replace(".TXT", ".MD5")), new File((getPath_destino() + "/" + arquivo.toUpperCase()).replace(".MD5", ".TXT")), true);
	        	 LogDAO.inseriLogErro(con, null, "O ARQUIVO " + arquivo + " NÃO CONTINHA LINHAS E FOI MOVIDO PARA PASTA DE PROCESSADOS.", "SISTEMA");
	         }
        	
        }catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}finally{
			try{
				leitor.close();
				reader.close();
			}catch (Exception e) {
				logger.warn(e.getMessage());
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			}
		}
        
		
		return qtd_linha;
	}

	
	// Analisar se precisa duplicar a tabela Agenda e 
	private void atualizaAgendaIncioConsumo(String arquivo) {
		
	    
		PreparedStatement pstm = null;
		String sql = "UPDATE agenda SET AGENDAINICIOCONSUMO = sysdate, AGENDASTATUS = 1 WHERE UPPER(AGENDAARQUIVO) = UPPER(?) and AGENDAINICIOCONSUMO is null and AGENDATIPOARQUIVO not in ('M', 'N', 'O')";
		
		try{
			pstm = getCon().prepareStatement(sql);
			pstm.setString(1,  arquivo);
			pstm.execute();	
			pstm.close();
			getCon().commit();
		}catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}finally{
			UtilsOCT.closePreparedStatement(pstm, con, logger);
		}
		
	}

	// Criar parametros novos para OCT
	private boolean populaAgendaCadastro() {
		PreparedStatement pstm = null;
		File dir = new File(path);
		File nome = null;

		boolean achou = false;
		boolean isPreenchido = false;

		String sql = "INSERT INTO agenda (AGENDAARQUIVO, AGENDATIPOARQUIVO, AGENDAORDEMPROC, AGENDASTATUS) VALUES (?, (select NVL(MAX(arquivotipo), 'NAO ENCONTRADO') from arquivo where instr(UPPER(trim(?)),ARQUIVONOME,1) >0), (select NVL(MAX(arquivoordem), 99) from arquivo where instr(UPPER(trim(?)),ARQUIVONOME,1) >0), 0)";

		//alterar o not in para receber apenas cadastro do OCT
		List<String> lista = Principal.retornaListaArquivosCadastro();
		try {
			String[] filhos = null;
			try {
				dir.isDirectory();
			} catch (Exception e) {
				logger.warn("NAO E DIRETORIO.");
				return false;
			}
			try {
				filhos = dir.list();
				int g = filhos.length;
				logger.warn("QUANTIDADE G:" + g);
			} catch (Exception e) {
				logger.warn("NAO E FILHOS.");
				return false;
			}

			for (int i = 0; i < filhos.length; i++) {
				if (!filhos[i].toUpperCase().endsWith(".TXT")) {
					continue;
				} else {
					for (String arq : lista) {
						if (filhos[i].toUpperCase().contains(arq.toUpperCase())) {
							achou = true;
							nome = new File(dir, filhos[i]);
							break;
						}
					}
				}
				if (achou) {
					break;
				}

			}
			if (!achou) {
				return false;
			}

			if (nome.isFile()) {
				try {
					MD5CheckSum.ValidaMD5(path, nome.getName(), con);
				} catch (Exception e) {
					logger.warn(e.getMessage());
				}
				if (achou && MD5CheckSum.ValidaMD5(path, nome.getName(), con)) {
					try {

						Boolean _rename = nome.renameTo(new File(nome
								.getAbsolutePath().replace(".TXT", ".PROC")
								.replace(".txt", ".PROC")));
						if (!_rename) {
							logger.warn("[ERRO ROBO OCT] - NAO FOI POSSIVEL RENOMEAR O ARQUIVO");
							return false;
						} else {
							logger.warn("[ROBO OCT] - FOI POSSIVEL RENOMEAR O ARQUIVO");
							try {
								logger.warn(sql.replace("?", "'"
										+ nome.getName().toUpperCase() + "'"));
								pstm = getCon().prepareStatement(sql);
								pstm.setString(1, nome.getName().toUpperCase());
								pstm.setString(2, nome.getName().toUpperCase());
								pstm.setString(3, nome.getName().toUpperCase());
								pstm.execute();
								pstm.close();
								getCon().commit();
								arquivo = nome.getName();
								return true;
							} catch (Exception e) {
								logger.warn("[ERRO ROBO OCT] - "
										+ e.getMessage());
								nome.renameTo(new File(nome.getAbsolutePath()
										.replace(".PROC", ".TXT")
										.replace(".proc", ".TXT")));
								return false;
							}
						}

					} catch (Exception e) {
						logger.warn("[ERRO ROBO OCT] - NAO FOI POSSIVEL RENOMEAR O ARQUIVO");
						return false;
					}

				}

			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			if (e.getMessage().contains("00001") ){
				try{
					Principal.copy(new File((getPath() + "/" + nome.getName().toUpperCase())), new File((getPath_destino() + "/" + nome.getName().toUpperCase())), true);
					Principal.copy( new File((getPath() + "/" + nome.getName().toUpperCase().replace(".TXT", ".MD5"))) , new File((getPath_destino() + "/" + nome.getName().toUpperCase().replace(".TXT", ".MD5"))), true);					
					LogDAO.inseriLogErro(con, null, "ARQUIVO: " + nome.getName() + " JÁ PROCESSADO E MOVIDO DE PASTA. ", "SISTEMA");
				}catch (Exception ex) {
					logger.warn(ex.getMessage());
					LogDAO.inseriLogErro(con, null, ex.getMessage(), "SISTEMA");
				}
			}
		}finally{
			UtilsOCT.closePreparedStatement(pstm,con,logger);
		}
	

		return isPreenchido;
	}

	private void connectToDataBase() {
		if (getCon() != null) {
			try {
				if (getCon().isClosed()) {
					setCon(Conexao.getConnectionParametrizada(getTipo(),
							getLogin(), getSenha(), getHost(), getSid(),
							getPorta(), getHost2(), getPorta2()));
				}
			} catch (Exception e) {
				logger.warn("[ERRO ROBO OCT] - " + e.getMessage());
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			}

		}
	}
	
	//Analisar se precisa duplicar a tabela TEM_CONSUMO_CADASTRO
	public void gravaLinha(String linha, int ordem) throws SQLException{
		PreparedStatement pstm = null;
		String sql = "INSERT INTO TEMP_CONSUMO_CADASTRO (LINHA, ORDEM) VALUES (?, ?)";
		
		try{
			pstm = getCon().prepareStatement(sql);
			pstm.setString(1,  linha);
			pstm.setInt(2,  ordem);
			pstm.execute();	
			pstm.close();
			getCon().commit();
		}catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}finally{
		  UtilsOCT.closePreparedStatement(pstm, con, logger);
		}
		
	}
	
	public void atualizaAgendaFimConsumo(String arquivo){
		PreparedStatement v_PreparedStatement = null;
		String sql = "UPDATE agenda SET AGENDAFIMCONSUMO = sysdate, AGENDASTATUS = 2 WHERE UPPER(AGENDAARQUIVO) = UPPER(?) and AGENDAFIMCONSUMO is null and AGENDAINICIOPROC is null and AGENDATIPOARQUIVO not in ('M', 'N', 'O')";

		try{
			v_PreparedStatement = getCon().prepareStatement(sql);
			v_PreparedStatement.setString(1,  arquivo);
			v_PreparedStatement.execute();	
			v_PreparedStatement.close();
			getCon().commit();
		}catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}finally{
			UtilsOCT.closePreparedStatement(v_PreparedStatement, con, logger);
		}
		
	}
	public void atualizaAgendaFimConsumoFalha(String arquivo){
		PreparedStatement v_PreparedStatement = null;
		String sql = "DELETE FROM agenda WHERE UPPER(AGENDAARQUIVO) = UPPER(?) and AGENDAFIMCONSUMO is null and AGENDAINICIOPROC is null and AGENDATIPOARQUIVO not in ('M', 'N', 'O')";

		try{
			v_PreparedStatement = getCon().prepareStatement(sql);
			v_PreparedStatement.setString(1,  arquivo);
			v_PreparedStatement.execute();	
			v_PreparedStatement.close();
			getCon().commit();
		}catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}finally{
			UtilsOCT.closePreparedStatement(v_PreparedStatement, con, logger);
		}
		
	}
	
	public void consomeCadastro(String arquivo, String tipo){
		CallableStatement cs = null;
		try{
			
			cs = getCon().prepareCall("{call up_sva_le_txt_cadastro(?,?) }");
			cs.setString(1, arquivo);
			cs.registerOutParameter(2, OracleTypes.VARCHAR);
			cs.execute();
			cs.close();
		}catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}finally{
			if (cs != null) {
			      try {
			    	  cs.close();
			      } catch (SQLException sqe) {
						logger.warn(sqe.getMessage());
						LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
			      } catch (RuntimeException re) {
						logger.warn(re.getMessage());
						LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
			      }
			   }
		}
		
	}
	

	public String getPath_destino() {
		return path_destino;
	}

	public void setPath_destino(String path_destino) {
		this.path_destino = path_destino;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPorta2() {
		return porta2;
	}

	public void setPorta2(String porta2) {
		this.porta2 = porta2;
	}

	public String getHost2() {
		return host2;
	}

	public void setHost2(String host2) {
		this.host2 = host2;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

}
