package oi.brm.console;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.security.MessageDigest;
import java.sql.Connection;

import org.apache.log4j.Logger;
 
public class MD5CheckSum 
{
	
	private static Logger logger = Logger.getLogger(MD5CheckSum.class.getName());

   
    
    public static boolean ValidaMD5(String path, String arquivo, Connection con ) {
    	
    	   	
    	String msg_erro = null;
    	
    	try{
	    	MessageDigest md = MessageDigest.getInstance("MD5");
	    	
	        FileInputStream fis = new FileInputStream(path+ "/"+ arquivo);
	        FileReader reader = null;  
	        BufferedReader leitor = null;  
	        byte[] dataBytes = new byte[1024];
	        String linha = null;
	 
	        int nread = 0; 
	        while ((nread = fis.read(dataBytes)) != -1) {
	          md.update(dataBytes, 0, nread);
	        };
	        fis.close();
	        byte[] mdbytes = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < mdbytes.length; i++) {
	          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        try{
	        	reader = new FileReader(path+"/" + arquivo.toUpperCase().replace(".TXT", ".MD5"));
	        }catch (Exception e) {
	        	msg_erro = "MD5 NÃO ENCONTRADO.";
	        	LogDAO.inseriLogLote(con, arquivo, msg_erro);
				LogDAO.inseriLogErro(con, null, msg_erro, "SISTEMA");

				return false;
			}
	        leitor = new BufferedReader(reader);  
	        while ((linha = leitor.readLine()) != null) { 
	        	 if (linha.toUpperCase().contains(sb.toString().toUpperCase()) && linha.toUpperCase().contains(arquivo.toUpperCase().replace(".txt", "").replace(".TXT", ""))){
	        	   
	        		 return true;
	        	 }else{
	        	 
	        		 return false;
	        	 }
	        }
	     	return false;
    	}catch (Exception e) {
    		if (msg_erro == null){
    			msg_erro = e.getMessage();
    			
    		}
			LogDAO.inseriLogErro(con, null, msg_erro, "SISTEMA");
			LogDAO.inseriLogLote(con, arquivo, msg_erro);
			return false;
			
    	}
    }
}