<jsp:useBean id="news" class="org.usp.news.News" scope="page"/>
<jsp:setProperty name="news" property="*"/> 
<%
	news.insert();
%>
<jsp:include page="message.jsp?msg=1" />
