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
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td colspan="2">
					<table border="0">
						<tr>
							<td class="text">
	<%
		int msgresult = Integer.parseInt(request.getParameter("msg"));

		switch (msgresult) {
			case -1: out.println(msg.getString("GENERAL_ERROR")); break;
			case 0: out.println(msg.getString("NOTDEFINED_ERROR")); break;
			case 2: 
				out.println(msg.getString("USERREGISTERED")); 
				out.println("&nbsp;&nbsp;&nbsp;"); 
				out.println("<input type=button value=Close onClick='javascript:window.close()'>");
				break;
			case 3: out.println(msg.getString("USERINFINCORRECT")); break;
			case 404: out.println(msg.getString("OPERATIONNOTALLOWED")); break;
		}
	%>
							
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2" class="copyleft"><%= msg.getString("COPYLEFT") %></td></tr>
		</table>
	</body>
</html>
