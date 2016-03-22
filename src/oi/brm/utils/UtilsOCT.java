package oi.brm.utils;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;

import oi.brm.console.LogDAO;

import org.apache.log4j.Logger;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class UtilsOCT {
	
	
	public static void closePreparedStatement(PreparedStatement p_PreparedStatement, Connection p_Connection, Logger p_Logger){
		if (p_PreparedStatement != null) {
		      try {
		    	  p_PreparedStatement.close();
		      } catch (SQLException sqe) {
		    	  p_Logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(p_Connection, null, sqe.getMessage(), "SISTEMA");
		      } catch (RuntimeException re) {
		    	  p_Logger.warn(re.getMessage());
					LogDAO.inseriLogErro(p_Connection, null, re.getMessage(), "SISTEMA");
		      }
		   }
		
		
	}
	
	
	
	
	public static void iniciaVariaveisOracle(Connection p_Connection, Logger logger, Connection con){
		CallableStatement cs = null;
		try{
			cs = p_Connection.prepareCall("{call pc_adn_sva.up_inicializa_variaveis }");
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
	public static BigDecimal retornaSessionID(Connection conexao, Connection con, Logger logger) {
		String sql = "select userenv('sessionid') id from dual";
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = conexao.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				return rs.getBigDecimal("id");
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
	
	public static String retornaValorXML(String _xml, String tag, Connection con) {
		SAXBuilder sb = new SAXBuilder();
		org.jdom.Document d;
		try {
			d = sb.build(new StringReader(_xml));
			Element mural = d.getRootElement();
			Iterator<Element> i = mural.getChildren().iterator();
			while (i.hasNext()) {
				Element element = (Element) i.next();
				if (element.getName().equalsIgnoreCase(tag)){
					return element.getValue();
				}
			}
		} catch (JDOMException e) {
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} catch (IOException e) {
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}
		
		return "";
	}
	
        public static String dateToStringTimestamp(Date date) {
            return String.valueOf(dateToTimestamp(date));
        }
    
        public static Long dateToTimestamp(Date date) {
            return date.getTime() / 1000;
        }

}
