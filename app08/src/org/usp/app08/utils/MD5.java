package org.usp.app08.utils;

import java.security.*;

public class MD5 {
	public static String encode(String msg) throws Exception {

		MessageDigest md = MessageDigest.getInstance("MD5");

		// "senha"
		// s -> 16 bits
		md.update(msg.getBytes(), 0, msg.length());

		// roda MD5
		byte[] mdbytes = md.digest();
	 
		// conversao para hexa -> print
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++) {
		  sb.append(Integer.toString((mdbytes[i] & 0xff) 
					  + 0x100, 16).substring(1));
		}
	 
		return sb.toString();
	}

	public static void main(String args[]) throws Exception {
		MD5.encode(args[0]);
	}
}
