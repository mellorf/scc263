package com.mobilefish;

import org.apache.log4j.Logger; // usar o log4j

public class Log4jDemo {

	static Logger log = 
		Logger.getLogger("com.mobilefish.Log4jDemo");

	public static void main(String args[]) {

		log.debug("This is my debug message.");
		log.info("This is my info message.");
		log.warn("This is my warn message.");
		log.error("This is my error message.");
		log.fatal("This is my fatal message.");
	}
}
