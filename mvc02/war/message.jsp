<html>
	<head>
		<title>MountBOX</title>
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
		int msg = Integer.parseInt(request.getParameter("msg"));

		switch (msg) {
			case -1: out.println("General error."); break;
			case 0: out.println("Operation not defined."); break;
			//case 1: out.println(); break;
			case 2: 
				out.println("User registered."); 
				out.println("&nbsp;&nbsp;&nbsp;"); 
				out.println("<input type=button value=Close onClick='javascript:window.close()'>");
				break;
			case 3: out.println("User information incorrect."); break;
			case 404: out.println("Operation not allowed."); break;
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
			<tr><td colspan="2" class="copyleft">MountBOX -- copyleft by Mello</td></tr>
		</table>
	</body>
</html>
