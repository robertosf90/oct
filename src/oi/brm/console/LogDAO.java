package oi.brm.console;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class LogDAO {
	
	private static Logger logger = Logger.getLogger(LogDAO.class.getName());

	
	public static boolean inseriLogSucesso(Connection con, Integer id, String msg, String robo)  {
		return inseriLog(con, id, msg, robo, 0);
	}


	public static boolean inseriLogErro(Connection con, Integer id, String msg, String robo) {
		return inseriLog(con, id, msg, robo, 1);
	}
	

	public static boolean inseriLog(Connection con, Integer id, String msg, String robo, Integer log_flag) {
		String sql = "INSERT INTO log_integrador (log_dtini, log_texto, log_flag, robo_nome) VALUES (sysdate, ?, ?, ?)";
		PreparedStatement pstm = null;
		if (msg == null){
			msg = "Mensagem de erro, não tratada.";
		}
		if (msg.length() > 3000){
			msg = msg.substring(0, 2999);
		}
		if ( log_flag == 1)
     		msg = "Erro - " + msg;
		else 
			msg = "Sucesso - " + msg; 
		try{
			pstm = con.prepareStatement(sql);
			pstm.setString(1,  msg);
			pstm.setInt(2,  log_flag);
			pstm.setString(3,  robo);
			pstm.execute();	
			pstm.close();
			con.commit();
		}catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception sqe) {
					logger.warn(sqe.getMessage());
				}
			}
		}
		return true;
	}
	
	
	public static boolean inseriLogLote(Connection con, String arquivo, String msg) {
		CallableStatement cs = null;
		try{
			cs = con.prepareCall("{call UP_ATUALIZA_ERROLOTE('" + arquivo + "', '" + msg+ "') }");
			cs.execute();
			cs.close();
		}catch (Exception e) {
			logger.debug(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}finally{
			if (cs != null) {
			      try {
			    	  cs.close();
			      } catch (SQLException sqe) {
						logger.debug(sqe.getMessage());
						LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
			      } catch (RuntimeException re) {
						logger.debug(re.getMessage());
						LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
			      }
			   }
		}
		return true;
	}
}
