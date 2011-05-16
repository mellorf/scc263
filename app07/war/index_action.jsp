<%@page import="java.sql.*, java.util.*, org.usp.app07.db.*, org.usp.app07.core.*"%>
<html>
	<head>
		<title>Resultado do Google</title>
	</head>

	<body>
<%

String query = request.getParameter("query");
Database db = new Database();
db.connect();

ResultSet rs = Page.findByQuery(db, query);
/*
while(rs.next()) {
	out.print(rs.getString("tmsp")+"<br>");
	out.print(rs.getString("url")+"<br>");
	out.print(rs.getString("body")+"<br><br>");
}*/

Page p = null;
while ((p = Page.next(rs)) != null) {
	out.print(p.getTmsp()+"<br>");
	out.print(p.getUrl()+"<br>");
	out.print(p.getBody()+"<br><br>");
}

db.close();

%>
	</body>
</html>
