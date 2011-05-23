<jsp:useBean id="user" class="sistema.User" scope="page"/>
<jsp:setProperty name="user" property="*"/> 
<%
	user.insert();
%>
<jsp:include page="message.jsp?msg=0" />
