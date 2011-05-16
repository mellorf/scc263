package org.usp.mvc01.core;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public class GetFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {

	    ServletContext sc = getServletContext();
	    String filename = sc.getRealPath("uploadedFiles/"+request.getParameter("filename"));

	    String mimeType = sc.getMimeType(filename);
	    if (mimeType == null) {
		sc.log("Could not get MIME type of "+filename);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return;
	    }

	    response.setContentType(mimeType);

	    // definindo tamanho do arquivo
	    File file = new File(filename);
	    response.setContentLength((int)file.length());

	    // Abrindo arquivo
	    FileInputStream in = new FileInputStream(file);
	    OutputStream out = response.getOutputStream();

	    // Enviando
	    byte[] buf = new byte[1024];
	    int count = 0;
	    while ((count = in.read(buf)) >= 0) {
		out.write(buf, 0, count);
	    }
	    in.close();
	    out.close();
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {
		doGet(request, response);
	}
}
