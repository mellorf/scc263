<html>
<body>
<h2>Teste de JavaBean User:</h2>
<% 

	com.attainware.maven2example.User u = new com.attainware.maven2example.User();

	u.setCode(1);
	u.setName("Teste");

	out.println(u.getCode()+", "+u.getName());
%>
</body>
</html>
