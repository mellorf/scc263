<%@page import="java.sql.*, org.usp.app08.db.*, org.usp.app08.core.*" %>
<jsp:include page="header.jsp"/>
<table align="center">
<%

	DBManager manager = DBManager.getInstance();
	Database db = manager.getDatabase();
	//Database db = new Database();
	//db.connect();
	ResultSet rs = News.findLast(db, 10);

	News news = null;
	while ((news = News.next(rs)) != null) {
		out.println("<tr><td><div class=\"tmsp\">"+news.getTmsp()+"</div></td></tr>");
		out.println("<tr><td><div class=\"headline\">"+news.getHeadline()+"</div></td></tr>");
		out.println("<tr><td><div class=\"body\">"+news.getBody()+"</div></td></tr>");
		out.println("<tr><td>&nbsp;</td></tr>");
	}

	//db.close();
 	manager.closeDatabase(db);

	%>
<table>
<jsp:include page="footer.jsp"/>
