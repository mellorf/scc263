<%@ page import="java.sql.*, org.usp.news.*, java.util.*" %>
<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

<tr>
	<td>
		<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class="titulocentral">Interface Administrativa: Usu&aacute;rios: Editar</td>
			</tr>
			<tr><td>&nbsp;</td></tr>

			<form action="admin_user_edit_action.jsp">
			<tr>
			<td class="campocentral">
				<select name="login">
					<option value="-1">---Selecione---</option>
					<%
						
					ResultSet rs = User.findAll();
					User user = null;

					while ((user = User.next(rs)) != null) {
						out.println("<option value=\""+user.getLogin()+"\">"+user.getName()+"</option>");
					}

					%>
				</select>
			</td>
			</tr>
			<tr><td class="campocentral"><input type="button" name="back" value="Voltar" onClick="javascript: history.back();">&nbsp;<input type="submit" name="edit" value="Editar">&nbsp;<input type="submit" name="edit" value="Remover"></td></tr>
			</form>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
