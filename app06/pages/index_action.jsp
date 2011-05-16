<%@page import="java.sql.*, java.util.*, org.usp.app06.db.*"%>
<html>
	<head>
		<title>Resultado do Google</title>
	</head>

	<body>
<%

String query = request.getParameter("query");
Database db = new Database();
db.connect();

ResultSet rs = db.query("select tmsp, url, body from page where body like '%"+query+"%' or url like '%"+query+"%'");

while(rs.next()) {
	out.print(rs.getString("tmsp")+"<br>");
	out.print(rs.getString("url")+"<br>");
	out.print(rs.getString("body")+"<br><br>");
}

db.close();

%>
	</body>
</html>
