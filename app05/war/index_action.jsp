<%@page import="java.sql.*, java.util.*"%>
<html>
	<head>
		<title>Resultado do Google</title>
	</head>

	<body>
<%

String query = request.getParameter("query");

//out.print(query); -> escrever no browser do cliente
//System.out.print(query); -> escrever no terminal do server

// JVM
//   - loader / carga de classes
//   - criar objetos a partir dessa classe
//   - Java Reflection API
Class.forName("org.postgresql.Driver");
String url = "jdbc:postgresql://localhost:5432/app05db";
String username = "app05";
String password = "password";
Connection conn = DriverManager.getConnection(url, username, password); // 42

Statement stmt = conn.createStatement();
//stmt.executeQuery(); -> SELECT / ST PROCEDURE
//stmt.executeUpdate(); -> INSERT / DELETE ...
ResultSet rs = stmt.executeQuery("select tmsp, url, body from page where body like '%"+query+"%' or url like '%"+query+"%'");

while(rs.next()) {
	out.print(rs.getString("tmsp")+"<br>");
	out.print(rs.getString("url")+"<br>");
	out.print(rs.getString("body")+"<br><br>");
}

stmt.close();

conn.close();

%>
	</body>
</html>
