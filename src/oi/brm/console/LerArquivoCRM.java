package oi.brm.console;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oi.brm.utils.UtilsOCT;

import org.apache.log4j.Logger;

public class LerArquivoCRM implements Runnable{

	
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
	private static Logger logger = Logger.getLogger(LerArquivoCRM.class
			.getName());
	
	
	@Override
	public void run() {
		
		while (true) {
			if (retornaQuantidadePendente() > 0){
				Connection conexao = null;
				try {
					conexao = Conexao.getConnectionParametrizada(tipo, login, senha, host, sid, porta, host2, porta2);
					BigDecimal id_arquivoimportacao = retornaIdArquivoImportacao(conexao);
					if (id_arquivoimportacao != null){
						
						AtualizaCRM _atualizaCRM = new AtualizaCRM();

						_atualizaCRM.setCon(conexao);
						_atualizaCRM.setId_arquivoimportacao(id_arquivoimportacao);
						_atualizaCRM.setPath_destino(getPath_destino());
						
						Thread threadCRM = new Thread(_atualizaCRM);
						threadCRM.start();
					}else{
						continue;
					}
				} catch (Exception e) {
					LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
				}
			}else{
				//logger.warn("NÃO EXISTEM DADOS PARA SER INTEGRADO COM O CRM.");
				LogDAO.inseriLogSucesso(con, null, "NÃO EXISTEM DADOS PARA SER INTEGRADO COM O CRM.", "SISTEMA");
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
				}
			}
		}
		
	}
	
	// Ajustar pra receber a nova tabela interfacecrm_processooct
	public int retornaQuantidadePendente() {

		PreparedStatement pstm = null;
		String sql = "select count(1) as quantidade from interfacecrm_processo where  interfacecrm_processosessionid is null";
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = getCon().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt("quantidade");
			}
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			UtilsOCT.closePreparedStatement(pstm, con, logger);
			
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
		}
		return 0;
	}
	
// Ajustar as consultas pra receber a nova tabela interfacecrm_processoOCT	
public BigDecimal retornaIdArquivoImportacao(Connection conexao) {
		
		String sql = "select max(id_arquivoimportacao) as id_arquivoimportacao from interfacecrm_processo  where interfacecrm_processosessionid = "
				+ UtilsOCT.retornaSessionID(conexao, con, logger);
		ResultSet rs = null;
		Statement stm = null;
		PreparedStatement pstm = null;
		sql = "update interfacecrm_processo set interfacecrm_processosessionid = "
				+ UtilsOCT.retornaSessionID(conexao,con, logger)
				+ " where id_interfacecrm_processo in (select max(id_interfacecrm_processo) from interfacecrm_processo where  interfacecrm_processosessionid is null )";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.execute();
			pstm.close();
			conexao.commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			UtilsOCT.closePreparedStatement(pstm, con, logger);
		}

		sql = "select max(id_arquivoimportacao) as id_arquivoimportacao from interfacecrm_processo  where interfacecrm_processosessionid = "
				+ UtilsOCT.retornaSessionID(conexao, con, logger);
		try {
			stm = conexao.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				 return rs.getBigDecimal("id_arquivoimportacao");
			}
			conexao.commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
		}
		return null;
	}

	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath_destino() {
		return path_destino;
	}

	public void setPath_destino(String path_destino) {
		this.path_destino = path_destino;
	}
	

}
