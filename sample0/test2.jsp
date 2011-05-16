<%

String variavel = request.getParameter("test");
session.setAttribute("oi", variavel);
session.setAttribute("oi2", variavel);
session.setAttribute("oi3", variavel);

session.setMaxInactiveInterval(60); // segundos

%>
<a href=test3.jsp>clicar</a>
