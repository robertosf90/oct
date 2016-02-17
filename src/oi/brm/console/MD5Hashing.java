package oi.brm.console;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.security.MessageDigest;

public class MD5Hashing {
	
	public static String retornaMD5(String path, String arquivo) {
		MessageDigest md = null;
		FileInputStream fis = null;
		FileReader reader = null;
		BufferedReader leitor = null;
		byte[] dataBytes = new byte[1024];
		String linha = null;
		StringBuffer sb = null;
		try {
			md = MessageDigest.getInstance("MD5");
			fis = new FileInputStream(path + arquivo);
			int nread = 0;
			while ((nread = fis.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
			;
			byte[] mdbytes = md.digest();

			// convert the byte to hex format method 1
			sb = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
		} catch (Exception e) {

		}
		return sb.toString();
	}
}
