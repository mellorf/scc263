package org.usp.dropbox.bundles;

import java.util.*;
import org.usp.dropbox.config.*;

public class ViewHelper implements Default {

	public static String getDirectoryEntry(int inode, String name) {
		StringBuffer buffer = new StringBuffer("");

		if (inode != -1) {
			buffer.append("<tr>\n");
			buffer.append("<td class=\"text\">\n");
			if (!name.equals("..")) {
				buffer.append("<input type='radio' name='inode' value='"+inode+"' onClick='document.form.type.value=104'/>");
			}
			buffer.append("<img src=\"images/close.png\" border=\"0\" width=\"25\">\n");
			buffer.append("<a href=\"dropbox.jsp?iparent="+inode+"\">"+name+"</a>");
			buffer.append("</td>\n");
			buffer.append("</tr>\n");
		}

		return buffer.toString();
	}


	public static String getDropFileEntry(int iparent, int inode, String name, String mimeType) {
		StringBuffer buffer = new StringBuffer("");

		System.out.println("drop: "+inode+", "+name+", "+mimeType);

		buffer.append("<tr>");
		buffer.append("<td class=\"text\">");
		buffer.append("<input type='radio' name='inode' value='"+inode+"' onClick='document.form.type.value=102'/>");
		buffer.append("<img src=\"");
			
		// helper
		if (mimeType.equals("application/x-pdf")
			|| mimeType.equals("application/pdf")) {

			buffer.append("images/pdf.gif");
		} else if (mimeType.equals("application/x-mpg")
			|| mimeType.equals("application/mpg")
			|| mimeType.equals("application/x-audio")
			|| mimeType.equals("application/mov")) {
			buffer.append("images/movie.gif");
		} else if (mimeType.equals("image/jpg") 
			|| mimeType.equals("image/png") 
			|| mimeType.equals("image/gif")) {
			buffer.append("images/image.png");
		} else {
			buffer.append("images/file.png");
		}

		buffer.append("\" border=\"0\" width=\"25\">");
		buffer.append("<a href=\"/dropbox/dropfileservlet?type=101&iparent="+iparent+"&inode="+inode+"\">"+name+"</a>");
		buffer.append("</td>");
		buffer.append("</tr>");

		return buffer.toString();
	}
}
