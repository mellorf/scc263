<%@ page import="java.sql.*" %>
<%

	/* query */
	String query = request.getParameter("query");

	String driver = "org.postgresql.Driver";
	String url = "jdbc:postgresql://localhost:5432/app04db";
	String username = "app04";
	String password = "password";

	Class.forName(driver);

	Connection conn = DriverManager.getConnection(url, username,
		password);

	// Janela de comandos ou sessao com o banco de dados
	Statement stmt = conn.createStatement();

	ResultSet rs = 
		stmt.executeQuery(
		"select url, body from info where body like '%"+
		query+"%'");

	while (rs.next()) {
		out.println(rs.getString("url")+"<br>"+rs.getString("body")+"<br><br>");
	}

	stmt.close();

	conn.close();

%>
