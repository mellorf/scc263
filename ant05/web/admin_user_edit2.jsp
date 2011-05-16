<%@ page import="java.sql.*, org.usp.news.*, java.util.*" %>
<%

	String login = request.getParameter("login");

	User user = User.findByPrimaryKey(login);

%>
<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

<tr>
	<td>
		<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class="titulocentral">Interface Administrativa: Usu&aacute;rios: Editar</td>
			</tr>
			<tr><td>&nbsp;</td></tr>

			<form action="admin_user_edit2_action.jsp">
			<input type="hidden" name="login" value="<%= user.getLogin() %>">
			<tr><td class="campocentral">Nome: <input type="text" name="name" size="50" value="<%= user.getName() %>"></td></tr>
			<tr><td class="campocentral">Login: <%= user.getLogin() %></td></tr>
			<tr><td class="campocentral">Senha: <input type="password" name="passwd" size="50" value="<%= user.getPasswd() %>"></td></tr>
			<tr><td>&nbsp;</td></tr>

			<tr><td class="campocentral"><input type="button" name="back" value="Voltar" onClick="javascript: history.back();">&nbsp;<input type="submit" name="edit" value="Editar"></td></tr>
			</form>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
