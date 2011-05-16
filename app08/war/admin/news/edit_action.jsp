<%@page import="org.usp.app08.db.*, org.usp.app08.core.*, java.sql.*" %>
<jsp:include page="../session.jsp"/>
<jsp:include page="../header.jsp"/>
<%

int id = Integer.parseInt(request.getParameter("id"));
News news = new News(id);
User suser = news.getUser();

%>
		<form action="edit_action2.jsp">
			<input type="hidden" name="id" value="<%= news.getId() %>">
			<div class="text">Timestamp: </div><input class="text" type="text" name="tmsp" value="<% out.print(news.getTmsp()); %>"><br>
			<div class="text">Headline: </div><input class="text" type="text" name="headline" value="<%= news.getHeadline() %>"><br>
			<div class="text">Body: </div><textarea class="text" name="body" rows="5" cols="40"><%= news.getBody() %></textarea><br>
			<div class="text">User: </div><select class="text" name="email"><%

			Database db = new Database();
			db.connect();
			ResultSet rs = User.findAll(db);
			User user = null;

			while ((user = User.next(rs)) != null) {
			 if (user.getEmail().equals(
				suser.getEmail())) {
				out.println("<option value=\""+
				user.getEmail()+"\" selected>"+
				user.getName()+"</option>");
			 } else {
				out.println("<option value=\""+
				user.getEmail()+"\">"+
				user.getName()+"</option>");
			 }
			}

			db.close();
			
			%></select><br>
			<input class="text" type="submit" value="Edit">
		</form>
<jsp:include page="../footer.jsp"/>
