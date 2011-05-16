<jsp:include page="userservlet">
	<jsp:param name="type" value="5"/>
</jsp:include>

<html>
	<head>
		<title>MountBOX</title>
		<link rel='stylesheet' type='text/css' href='css/style.css'>
	</head>

	<body cellspacing="0" cellpadding="0" topmargin="0" leftmargin="0">
		<table border="0" align="center">
			<tr align="center"><td colspan="2"><img src="images/mount.jpg" border="0"></td></tr>
			<tr>
				<td class="menu"><a href="dropbox.jsp">Home Directory</a></td>
				<td class="menu"><a href="/dropbox/userservlet?type=4">Logout</a></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;
			</td></tr>
			<form action="/dropbox/dropfileservlet" method="post" enctype="multipart/form-data">
			<input type="hidden" name="type" value="100">
			<input type="hidden" name="iparent" value='<%= request.getParameter("iparent") %>'>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr>
				<td class="text">File:</td>
				<td class="text"><input class="text" type="file" name="name"></td>
			</tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr>
				<td align="center"><input class="text" type="button" value="Back" onClick='javascript: history.back();'></td>
				<td align="center"><input class="text" type="submit" value="Upload"></td>
			</tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			<tr><td class="text" colspan="2">&nbsp;</td></tr>
			</form>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2" class="copyleft">MountBOX -- copyleft by Mello</td></tr>
		</table>
	</body>
</html>
