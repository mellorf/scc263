<%@page import="org.usp.app08.core.*, org.usp.app08.db.*, java.sql.*" %>
<jsp:include page="../session.jsp"/>
<jsp:include page="../header.jsp"/>
	<form action="remove_action.jsp">
	<div class="text">Select: </div><select class="text" name="id">
	<%
		Database db = new Database();
		db.connect();
		ResultSet rs = News.findAll(db);

		News news = null;
		while ((news = News.next(rs)) != null) {
			out.println("<option value=\""+
			news.getId()+"\">"+news.getHeadline()+
			"</option>");
		}

		db.close();
	%>
	</select><br>
	<input class="text" type="submit" value="Remove">
	</form>
<jsp:include page="../footer.jsp"/>
