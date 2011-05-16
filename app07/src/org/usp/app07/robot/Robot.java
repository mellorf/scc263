package org.usp.app07.robot;

import java.net.*; // acesso a rede TCP/IP
import java.io.*;  // streams

public class Robot {

	public static String get(String path) throws Exception {
		String buffer = "";
		URL url = new URL(path);
		URLConnection uconn = url.openConnection();
		InputStream is = uconn.getInputStream();

		// Scanner DataInputStream BufferedReader
		BufferedReader br = new BufferedReader(
					new InputStreamReader(
						is
					)
				);
		String str = null;
		while ((str = br.readLine()) != null) {
			buffer += str;
		}

		return buffer;
	}

	// Teste de unidade
	public static void main(String args[]) throws Exception {
		String str = Robot.get("http://www.google.com");
		System.out.println(str);
	}
}
