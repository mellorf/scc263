<jsp:include page="userservlet">
	<jsp:param name="type" value="5"/>
</jsp:include>
<%@page import="org.usp.dropbox.core.*" %>
<html>
	<head>
		<title>MountBOX</title>
		<link rel='stylesheet' type='text/css' href='css/style.css'>
	</head>

	<body cellspacing="0" cellpadding="0" topmargin="0" leftmargin="0">
		<table border="0" align="center">
			<tr align="center"><td colspan="2"><img src="images/mount.jpg" border="0"></td></tr>
			<tr>
				<td class="menu"><a href='dropbox.jsp?iparent=<%

						User user = (User) session.getAttribute("user");
						out.print(user.getINode());

						%>'>Home Directory</a></td>
				<td class="menu"><a href="/dropbox/userservlet?type=4">Logout</a></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;
			</td></tr>
			<form name="form" method="post" action="/dropbox/dropfileservlet">
			<input type="hidden" name="type" value="-1"/>
			<input type="hidden" name="iparent" value='<%= request.getParameter("iparent") %>'/>
			<tr>
				<td colspan="2">
					<table border="0">
					<jsp:include page="dropfileservlet">
						<jsp:param name="type" value="105"/>
						<jsp:param name="iparent" 
							value='<%= request.getParameter("iparent") %>'/>
					</jsp:include>
					<tr><td colspan="2">&nbsp;</td></tr>
						<tr><td colspan="2">&nbsp;</td></tr>
						<tr>
							<td align="center" colspan="2">
								<input class="text" type="submit" value="Delete">
								&nbsp;&nbsp;&nbsp;

								<input class="text" type="button" value="Create"
								onClick="document.form.action='create.jsp'; document.form.submit();">
								&nbsp;&nbsp;&nbsp;
								<input class="text" type="button" value="Upload" 
								onClick="document.form.action='upload.jsp'; document.form.submit();">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</form>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2" class="copyleft">MountBOX -- copyleft by Mello</td></tr>
		</table>
	</body>
</html>
