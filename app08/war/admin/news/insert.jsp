<%@page import="org.usp.app08.db.*, org.usp.app08.core.*, java.sql.*" %>
<jsp:include page="../session.jsp"/>
<jsp:include page="../header.jsp"/>
		<form action="insert_action.jsp">
			<div class="text">Timestamp: </div><input class="text" type="text" name="tmsp"><br>
			<div class="text">Headline: </div><input class="text" type="text" name="headline"><br>
			<div class="text">Body: </div><textarea class="text" name="body" rows="5" cols="40"></textarea><br>
			<div class="text">User: </div><select class="text" name="email"><%

			Database db = new Database();
			db.connect();
			ResultSet rs = User.findAll(db);
			User user = null;

			while ((user = User.next(rs)) != null) {
				out.println("<option value=\""+
				user.getEmail()+"\">"+
				user.getName()+"</option>");
			}

			db.close();
			
			%></select><br>
			<input class="text" type="submit" value="Insert">
		</form>
<jsp:include page="../footer.jsp"/>
