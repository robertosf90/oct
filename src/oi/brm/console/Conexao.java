package oi.brm.console;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Henrique Nunes
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import org.apache.log4j.Logger;

public class Conexao {

	private static Connection conn = null;
	private static Logger logger = Logger.getLogger(Conexao.class.getName());
	
	public static Connection getConnectionParametrizada(String tpBanco, String usuario, String senha, String ip, String sid, String porta, String ip2, String porta2) throws Exception {
		java.sql.Connection conn = null;
		try {
			
			Locale.setDefault(new Locale("pt", "BR"));

			if (tpBanco.equalsIgnoreCase("ORACLE")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				
				conn = DriverManager.getConnection(getConnectionUrlParametrizada(tpBanco, usuario, senha, ip, sid, porta, ip2, porta2), usuario,senha);
				conn.setAutoCommit(false);
			}
			return conn;

		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
		return conn;
	}
	
	public static Connection getConnectionBilling(String tpBanco, String usuario, String senha, String ip, String sid, String porta) throws Exception {
		java.sql.Connection conn = null;
		try {

			if (tpBanco.equals("ORACLE")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(
						getConnectionUrlBilling(tpBanco, usuario, senha, ip, sid, porta), usuario,
						senha);
				conn.setAutoCommit(false);
			}

			return conn;

		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
	}

	private static String getConnectionUrlParametrizada(String tpbanco, String usuario, String senha, String ip, String sid, String porta, String ip2, String porta2) {
		String _url = "";
		if (ip2 == null){
			ip2 = ip;
		}
		if (porta2 == null){
			porta2 = porta;
		}
		if (tpbanco.equalsIgnoreCase("ORACLE")){
			//INTERNO  _url = "jdbc:oracle:thin:@" + ip + ":" + porta + ":" + sid;
			_url = "jdbc:oracle:thin:@(DESCRIPTION =  (FAILOVER = YES)  (ADDRESS_LIST =    (ADDRESS = (PROTOCOL = TCP)(HOST =  " + ip +")(PORT = 1521))  )  (CONNECT_DATA =    (SERVER = DEDICATED)    (SERVICE_NAME = " +sid+ ")    (UR=A)    (FAILOVER_MODE =      (TYPE = SELECT)      (METHOD = BASIC)      (RETRIES = 10)      (DELAY = 5)    )  ))";
    		//HOMOLOGACAO _url = "jdbc:oracle:thin:@(DESCRIPTION =  (FAILOVER = YES)  (ADDRESS_LIST =     (ADDRESS = (PROTOCOL = TCP)(HOST = " + ip +")(PORT = 1521))	  )			  (CONNECT_DATA =			    (SERVER = DEDICATED)			    (SERVICE_NAME =  " +sid+ ")			    (UR=A)(FAILOVER_MODE =(TYPE = SELECT)(METHOD = BASIC)(RETRIES = 10)(DELAY = 5))))";
		}
		
		return _url;
	}

	private static String getConnectionUrlBilling(String tpbanco, String usuario, String senha, String ip, String sid, String porta) {
		String _url = "";
		if (tpbanco.equals("ORACLE"))
			// INTERNO  _url = "jdbc:oracle:thin:@vmadnsa03:1521:igbill";
			_url = "jdbc:oracle:thin:@(DESCRIPTION =  (FAILOVER = YES) (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = " + ip + ")(PORT = " + porta + "))	)  (CONNECT_DATA =    (SERVER = DEDICATED)  (SERVICE_NAME = " + sid+ ")  (UR=A)   (FAILOVER_MODE =   (TYPE = SELECT)  (METHOD = BASIC)  (RETRIES = 10) (DELAY = 5)    )   )    )";
		return _url;
	}

}
