package oi.brm.console;

import org.apache.log4j.Logger;

public class Main {

	
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	
	public static void main(String[] args) {

		try {
			logger.warn("ROBO OCT INICIADO.");
			Principal principal = new Principal();
			Thread thread = new Thread(principal);
			thread.start();
			
		}catch (Exception e) {
			logger.warn("[ERRO ROBO OCT] - " + e.getMessage());
		}
		
	}

}
