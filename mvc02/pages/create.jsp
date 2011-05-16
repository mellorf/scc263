<jsp:include page="userservlet">
	<jsp:param name="type" value="5"/>
</jsp:include>
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
		<table border="0" align="center">
			<tr align="center"><td colspan="2"><img src="images/mount.jpg" border="0"></td></tr>
			<tr>
				<td class="menu"><a href="dropbox.jsp"><%= msg.getString("HOME") %></a></td>
				<td class="menu"><a href="/dropbox/userservlet?type=4"><%= msg.getString("LOGOUT") %></a></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;
			</td></tr>
			<form action="/dropbox/dropfileservlet" method="post">
			<input type="hidden" name="type" value="103">
			<input type="hidden" name="iparent" value='<%= request.getParameter("iparent") %>'>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr>
				<td class="text"><%= msg.getString("DIRNAME") %></td>
				<td class="text"><input class="text" type="text" name="name"></td>
			</tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr>
				<td align="center"><input class="text" type="button" value='<%= msg.getString("BACK") %>' onClick='javascript: history.back();'></td>
				<td align="center"><input class="text" type="submit" value='<%= msg.getString("CREATE") %>'></td>
			</tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			</form>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2" class="copyleft"><%= msg.getString("COPYLEFT") %></td></tr>
		</table>
	</body>
</html>
