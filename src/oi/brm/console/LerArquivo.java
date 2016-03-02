package oi.brm.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class LerArquivo implements Runnable {

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
	private static Logger logger = Logger.getLogger(LerArquivo.class.getName());

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

	public void run() {
		if (getCon() != null) {
			try {
				if (getCon().isClosed()) {
					setCon(Conexao.getConnectionParametrizada(getTipo(),
							getLogin(), getSenha(), getHost(), getSid(),
							getPorta(), getHost2(), getPorta2()));
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			}

		}
		try {
			inseriLinhaBanco();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (getCon() != null) {
				try {
					if (!getCon().isClosed()) {
						getCon().close();
					}
				} catch (Exception e) {
					logger.warn(e.getMessage());
					LogDAO.inseriLogErro(con, null, e.getMessage(),
							"SISTEMA");
				}
			}
		}
	}

	public void inseriLinhaBanco() throws Exception {
		String linha = null;
		int quantidade_linha = 0;
		int id = 0;

		atualizaAgendaIncioConsumo(arquivo);
		iniciaVariaveisOracle();
		gravaCabecalho();
		id = retornaIDCabecalho();

		FileReader reader = new FileReader((getPath() + "/" + arquivo.toUpperCase()).replace(".TXT",".PROC"));
		BufferedReader leitor = new BufferedReader(reader);
		String empresa = "";
		while ((linha = leitor.readLine()) != null) {
			if (quantidade_linha == 0 && !arquivo.toUpperCase().contains("FIMLOTE")) {
				empresa = retornaEmpresa(linha);
			}
			gravaLinha(id, linha, getPath(), empresa, quantidade_linha);
			quantidade_linha++;
		}

		leitor.close();
		reader.close();

		atualizaAgendaFimConsumo(getArquivo());
		atualizaCabecalho(quantidade_linha, id);

		Principal.copy(new File((getPath() + "/" + arquivo.toUpperCase()).replace(".TXT", ".PROC")), new File((getPath_destino() + "/" + arquivo.toUpperCase()).replace(".TXT", ".PROC")), true);
		Principal.copy(new File((getPath() + "/" + arquivo.toUpperCase()).replace(".TXT", ".MD5" )), new File((getPath_destino() + "/" + arquivo.toUpperCase()).replace(".TXT", ".MD5")), true);
		
		  
        try{
        	
        	if (arquivo.toUpperCase().contains("FIMLOTE")){
        		logger.debug("****  ARQUIVO FIMLOTE IDENTIFICADO  ****");
        	}
        	
        	
	         // arquivo a ser movido
	  		File proc = new File(getPath() + "/"
	  				+ arquivo.toUpperCase().replace(".TXT", ".PROC"));
	
	        // arquivo a ser movido
	 		File md5 = new File(getPath() + "/"
	 				+ arquivo.toUpperCase().replace(".TXT", ".MD5"));
	
	 		// diretorio de destino
	 		File dir = new File(getPath_destino());
	
	 		// move o arquivo para o novo diretorio
	 		boolean okproc = proc.renameTo(new File(dir, proc.getName()));
	
	 		if (okproc) {
				logger.debug("Arquivo PROC foi movido com sucesso");
			} else {
				logger.debug("Nao foi possivel mover o arquivo");
			}
	 		
	 		boolean okmd5 = md5.renameTo(new File(dir, md5.getName()));
			
	 		if (okmd5) {
				logger.debug("Arquivo MD5 foi movido com sucesso");
			} else {
				logger.debug("Nao foi possivel mover o arquivo");
			}
        }catch (Exception ex){
       		logger.debug(ex.getLocalizedMessage());
        }
	}

	public void gravaLinha(int id, String linha, String path, String empresa,
			Integer nrlinha) {
		PreparedStatement pstm = null;
		String sql = "INSERT /*+ APPEND */ INTO logimportacao_oct (ID_ARQUIVOIMPORTACAO, LOGIMPORTACAONRLINHA, LOGIMPORTACAOLINHA, LOGIMPORTACAOSTATUS, LOGIMPORTACAODATA, LOGIMPORTACAOTIPOARQUIVO, ID_EMPRESA ) VALUES (?, ?, ?, ?, sysdate, '"
				+ retornaTipoArquivo() + "', ?) ";
		try {
			pstm = getCon().prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setInt(2, nrlinha);
			pstm.setString(3, linha);
			pstm.setInt(4, 9);
			pstm.setString(5, empresa);
			pstm.execute();
			pstm.close();
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

	}

	public void iniciaVariaveisOracle() {
		CallableStatement cs = null;
		try {
			cs = getCon().prepareCall(
					"{call pc_adn_sva.up_inicializa_variaveis }");
			cs.execute();
			cs.close();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

	}

	public int retornaIDCabecalho() {
		String sql = "select max(ID_ARQUIVOIMPORTACAO) as id from arquivoimportacao_oct where ARQUIVOIMPORTACAOCAMINHO = '"
				+ getArquivo() + "' ";
		ResultSet rs = null;
		Statement stm = null;
		int id = 0;

		try {
			stm = getCon().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("id");
			}
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

		return id;
	}

	public String retornaEmpresa(String linha) {
		String empresa = linha.substring(15, 19);
		return empresa;
	}

	public void gravaCabecalho() {
		PreparedStatement pstm = null;
		String sql = "INSERT INTO arquivoimportacao_oct (ARQUIVOIMPORTACAOCAMINHO, ARQUIVOIMPORTACAODATA, ARQUIVOIMPORTACAOTIPO) VALUES (?, sysdate, '"
				+ retornaTipoArquivo() + "') ";

		try {
			pstm = getCon().prepareStatement(sql);
			pstm.setString(1, getArquivo());
			pstm.execute();
			pstm.close();
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

	}

	public void atualizaCabecalho(int quantidade, int id) {
		PreparedStatement pstm = null;
		String sql = "UPDATE arquivoimportacao_oct SET ARQUIVOIMPORTACAOSTATUS = 1, ARQUIVOIMPORTACAOQTLINHAS = ?, ARQUIVOIMPORTACAOQTLINHASOK = ?, ARQUIVOIMPORTACAOQTLINHASERRO = 0 WHERE ID_ARQUIVOIMPORTACAO = ?";

		try {
			pstm = getCon().prepareStatement(sql);
			pstm.setInt(1, quantidade);
			pstm.setInt(2, 0);
			pstm.setInt(3, id);
			pstm.execute();
			pstm.close();
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

	}

	public void atualizaAgendaFimConsumo(String arquivo) {
		PreparedStatement pstm = null;
		String sql = "UPDATE agenda_oct SET AGENDAFIMCONSUMO = sysdate, AGENDASTATUS = 2 WHERE UPPER(AGENDAARQUIVO) = UPPER(?) and AGENDAFIMCONSUMO is null and AGENDATIPOARQUIVO = '"
				+ retornaTipoArquivo() + "'";
		try {
			pstm = getCon().prepareStatement(sql);
			pstm.setString(1, arquivo);
			pstm.execute();
			pstm.close();
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

	}

	public void atualizaAgendaIncioConsumo(String arquivo) {
		PreparedStatement pstm = null;
		String sql = "UPDATE agenda_oct SET AGENDAINICIOCONSUMO = sysdate, AGENDASTATUS = 1 WHERE UPPER(AGENDAARQUIVO) = UPPER(?) and AGENDAINICIOPROC is null and AGENDATIPOARQUIVO = '"
				+ retornaTipoArquivo() + "'";

		try {
			pstm = getCon().prepareStatement(sql);
			pstm.setString(1, arquivo);
			pstm.execute();
			pstm.close();
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

	}

	public String retornaArquivoPendente() {
		String sql = "select AGENDAARQUIVO from agenda_oct where AGENDAINICIOCONSUMO is null and AGENDATIPOARQUIVO = '"
				+ retornaTipoArquivo() + "'";
		ResultSet rs = null;
		Statement stm = null;

		try {
			stm = getCon().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				return rs.getString("AGENDAARQUIVO");
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

		return null;
	}

	public String retornaTipoArquivo() {
		String sql = "select arquivotipo, arquivonome from arquivo";
		ResultSet rs = null;
		Statement stm = null;

		try {
			stm = getCon().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				if (getArquivo().contains(rs.getString("arquivonome"))) {
					return rs.getString("arquivotipo");
				}
			}
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());

				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					;
				}
			}
		}

		return null;
	}

}
