<html>
	<head>
		<title>MountBOX</title>
		<link rel='stylesheet' type='text/css' href='css/style.css'>
	</head>

	<body cellspacing="0" cellpadding="0" topmargin="0" leftmargin="0">
		<table border="0" align="center">
			<tr align="center"><td colspan="2"><img src="images/mount.jpg" border="0"></td></tr>
			<!-- tr>
				<td class="menu"><a href="site.jsp">Home</a></td>
				<td class="menu"><a href="#">Logout</a></td>
			</tr -->
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td colspan="2">
					<form method="post" action="/dropbox/userservlet">
					<input type="hidden" name="type" value="3">
					<table border="0">
						<tr>
							<td class="text">Email:</td>
							<td><input class="text" type="text" name="email" size="25"></td>
						</tr>
						<tr>
							<td class="text">Password:</td>
							<td><input class="text" type="password" name="password" size="15"></td>
						</tr>
						<tr><td colspan="2">&nbsp;</td></tr>
						<tr>
							<td align="center" colspan="2">
								<input class="text" type="button" value="Regiter me" onclick="window.open('insert.jsp', 'windowname1', 'width=550, height=230'); return false;">
								&nbsp;&nbsp;&nbsp;
								<input class="text" type="submit" value="Sign in">
							</td>
						</tr>
					</table>
					</form>
				</td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2" class="copyleft">MountBOX -- copyleft by Mello</td></tr>
		</table>
	</body>
</html>
