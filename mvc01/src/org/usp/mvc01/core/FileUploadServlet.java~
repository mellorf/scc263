package org.usp.mvc01.core;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public class FileUploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {

	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();

	 boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	 if (!isMultipart) {
		 out.print("formulário comum");
	 } else {
		   out.print("formulário multipart");
		   FileItemFactory factory = new DiskFileItemFactory();
		   ServletFileUpload upload = new ServletFileUpload(factory);

		   List items = null;
		   try {
			   items = upload.parseRequest(request);
		   } catch (FileUploadException e) {
			   e.printStackTrace();
		   }

		   Iterator itr = items.iterator();

		   while (itr.hasNext()) {
			   FileItem item = (FileItem) itr.next();

			   if (item.isFormField()) {
				   // campo normal
				   out.print(item.getFieldName()+": "+item.getString()+"<br>");
			   } else {
				   try {
					   String itemName = item.getName();

					   out.print("<br>ContentType: "+
						item.getContentType()+"<br>");
					   out.print("<br>Size: "+
						item.getSize()+"<br>");

					   File savedFile = new File(
					     getServletContext().getRealPath("/")+
					     "uploadedFiles/"+itemName);

					   item.write(savedFile);  

					   out.println("Arquivo: "+
					     getServletContext().getRealPath("/")+
					     "uploadedFiles"+"/"+itemName);
				   } catch (Exception e) {
					   e.printStackTrace();
				   }
			   }
		   }
	   }
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {
		doGet(request, response);
	}
}
