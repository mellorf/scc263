<%@page import="java.util.*" %>
<%
	Locale currentLocale = request.getLocale();
	ResourceBundle msg = ResourceBundle.getBundle("org.usp.dropbox.bundles.messages", currentLocale);
%>
<html>
	<head>
		<title><%= msg.getString("TITLE") %></title>
		<link rel='stylesheet' type='text/css' href='css/style.css'>
	</head>

	<body cellspacing="0" cellpadding="0" topmargin="0" leftmargin="0">
		<form method="post" action="/dropbox/userservlet">
		<input type="hidden" name="type" value="0">
		<table border="0" align="center">
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr>
				<td class="text"><%= msg.getString("EMAIL") %></td>
				<td class="text"><input class="text" type="text" name="email" size="25"></td>
			</tr>
			<tr>
				<td class="text"><%= msg.getString("NAME") %></td>
				<td class="text"><input class="text" type="text" name="name" size="45"></td>
			</tr>
			<tr>
				<td class="text"><%= msg.getString("PASSWORD") %></td>
				<td class="text"><input class="text" type="password" name="password" size="15"></td>
			</tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr>
				<td colspan="2" align="center"><input class="text" type="submit" value='<%= msg.getString("REGISTER") %>'></td>
			</tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
		</table>
		</form>
	</body>
</html>
