<jsp:useBean id="user" class="org.usp.news.User" scope="page"/>
<jsp:setProperty name="user" property="*"/> 
<%
	user.remove();
%>
<jsp:include page="message.jsp?msg=5" />
