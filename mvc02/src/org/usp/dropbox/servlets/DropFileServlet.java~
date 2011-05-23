package org.usp.dropbox.servlets;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.usp.dropbox.db.*;
import org.usp.dropbox.core.*;
import org.usp.dropbox.config.*;
import org.usp.dropbox.bundles.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public class DropFileServlet extends HttpServlet implements Default {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {

	   String targetUrl = null;
	   try {
		HttpSession session = request.getSession();
		PrintWriter out = null; // response.getWriter();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			targetUrl = "index.jsp";
			response.sendRedirect(targetUrl);
			// FIXME espero que funcione
		}

		int inode = -1, iparent = -1;
		String name = null;
		Directory dir = null;
		Database db = null;
		DropFile file = null;
		int type = -1;
		FileItem fitem = null;

		boolean isMultipart = ServletFileUpload.
			isMultipartContent(request);

		if (isMultipart) {
			   FileItemFactory factory = 
				   new DiskFileItemFactory();
			   ServletFileUpload upload = 
				   new ServletFileUpload(factory);

			   List items = null;
			   try {
				   items = 
					upload.parseRequest(request);
			   } catch (FileUploadException e) {
				   e.printStackTrace();
			   }

			   Iterator itr = items.iterator();

			   while (itr.hasNext()) {
				   FileItem item = (FileItem) itr.next();

				   if (item.isFormField()) { // form field
					if (item.getFieldName().equals("type")) {
						try {
							type =
							 Integer.parseInt(item.getString());
						} catch (Exception e) {
							targetUrl = "message.jsp?msg=0";
							response.sendRedirect(targetUrl);
						}
					} else if (item.getFieldName().equals("iparent")) {
						iparent = Integer.parseInt(item.getString());
					}
				   } else { // is a file
					   fitem = item;
				   }
			   }
		} else {
			try {
				type = Integer.parseInt(request.getParameter("type"));
				iparent = Integer.parseInt(request.getParameter("iparent"));
			} catch (Exception e) {
				targetUrl = "message.jsp?msg=0";
				response.sendRedirect(targetUrl);
			}
		}

		if (!user.verifyDirectoryAccess(iparent)) {
			targetUrl = "dropbox.jsp";
			response.sendRedirect(targetUrl);
			// FIXME espero que funcione
			// log de informacoes do sistema
		}

		switch (type) {
			// File
			case FILEUPLOAD:
				// INPUT
				// file name
				// directory inode

				// inserting into database
				file = new DropFile();
				file.setIParent(iparent);
				file.setName(fitem.getName());
				file.setMimeType(fitem.getContentType());
				file.setSize(fitem.getSize());
				file.insert();

				// saving into filesystem
				File savedFile = new File(
				  file.getParent().getPath()+
				  "/"+file.getName());
				fitem.write(savedFile);
				targetUrl = "dropbox.jsp?iparent="+
					iparent;

				break;
			case FILEDOWNLOAD: 
				// INPUT
				// click on file
				// file inode
				
				file = new DropFile(
					Integer.parseInt(
					request.getParameter("inode")
					)
					);

				String filename = file.getParent().
					getPath()+"/"+
					file.getName();

				String mimeType = file.getMimeType();
				response.setContentType(mimeType);

				File downfile = new File(filename);
				response.setContentLength(
					(int)downfile.length()
					);

				FileInputStream in = 
					new FileInputStream(
						downfile
						);

				// Enviando
				byte[] buf = new byte[1024];
				int count = 0;
	    			OutputStream os = 
					response.getOutputStream();
				while ((count = in.read(buf)) >= 0) {
				    os.write(buf, 0, count);
				}
				in.close();
				os.close();

				break;
			case FILEREMOVE: 
				// INPUT
				// click on file
				// file inode
				inode = 
				  Integer.parseInt(
					request.getParameter("inode")
				  );
				file = new DropFile(inode);
				file.remove();
				targetUrl = "dropbox.jsp?iparent="+
					iparent;

				break;

			// Directory
			case MKDIR: 
				// INPUT
				// parent inode
				// directory name
				name =
				   request.getParameter("name");
				dir = new Directory(iparent);
				dir.mkdir(name);
				targetUrl = "dropbox.jsp?iparent="+
					iparent;
				break;
			case RMDIR: 
				// INPUT
				// click on directory
				// directory inode
				inode = 
				  Integer.parseInt(
					request.getParameter("inode")
				  );
				dir = new Directory(inode);
				dir.rmdir();
				targetUrl = "dropbox.jsp?iparent="+
					iparent;
				break;

			// List all
			case LIST: 
				// INPUT
				// user email (from session) to verify permission
				dir = new Directory(iparent);
				db = DBManager.getInstance().
					getDatabase();

				ResultSet subdirs = dir.getDirectories(db);

				// Helper
				Directory d = null;

				// Voltar
				d = new Directory(iparent);
				out = response.getWriter();
				out.println(ViewHelper.getDirectoryEntry(d.getIParent(), ".."));

				// listar subdirs
				while ((d = Directory.next(subdirs)) != null) {
					out.println(ViewHelper.getDirectoryEntry(d.getINode(), d.getName()));
				}

				// listar files
				ResultSet files = dir.getDropFiles(db);
				DropFile f = null;
				while ((f = DropFile.next(files)) != null) {
					out.println(ViewHelper.getDropFileEntry(f.getIParent(), f.getINode(), f.getName(), f.getMimeType()));
				}

				DBManager.getInstance().
					closeDatabase(db);

				break;

			default: 
				targetUrl = "message.jsp?msg=404";
				break;
		}
	   } catch (Exception e) {
		e.printStackTrace();
		targetUrl = "message.jsp?msg=-1";
	   } finally {
	   	response.sendRedirect(targetUrl);
	   }
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, java.io.IOException {
		doGet(request, response);
	}
}
