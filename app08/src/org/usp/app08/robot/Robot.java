package org.usp.app08.robot;

import java.io.*;
import java.net.*;

public class Robot {

	public static String getData(String path) 
		throws Exception {
		URL url = new URL(path);
		URLConnection uconn = url.openConnection();

		BufferedReader br = 
			new BufferedReader(
			new InputStreamReader(
				uconn.getInputStream()));
		//uconn.getOutputStream()
		String buffer = "";
		String str = null;

		while ((str = br.readLine()) != null) {
			buffer += str + "\n";
		}

		//uconn.closeConnection();

		return buffer;
	}
	
	public static void main(String args[]) throws Exception {
		System.out.println(
			Robot.getData(args[0])
			);
	}
}
