package org.usp.dropbox.config;

public interface Default {
	// number of DB connections
	public int dbconnections = 5;

	// directory to store data
	public String dropboxPath = "/tmp";

	// space
	public long defaultSpace = 10 * 1024 * 1024; // Bytes

	// servlets
	public int INSERT = 0;
	public int REMOVE = 1;
	public int EDIT   = 2;

	// user servlet
	public int LOGIN  = 3;
	public int LOGOUT = 4;
	public int CONFIRMLOGIN = 5;

	// dropfile servlet
	public int FILEUPLOAD 	= 100;
	public int FILEDOWNLOAD	= 101;
	public int FILEREMOVE 	= 102;
	public int MKDIR 	= 103;
	public int RMDIR 	= 104;
	public int LIST 	= 105;
}
