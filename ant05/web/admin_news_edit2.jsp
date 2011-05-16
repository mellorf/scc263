<%@ page import="java.sql.*, org.usp.news.*, java.util.*" %>
<%

	Integer code = new Integer(request.getParameter("code"));
	int code_int = code.intValue();

	News news = News.findByPrimaryKey(code_int);

%>
<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

<tr>
	<td>
		<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class="titulocentral">Interface Administrativa: Not&iacute;cias: Editar</td>
			</tr>
			<tr><td>&nbsp;</td></tr>

			<form action="admin_news_edit2_action.jsp">
				<input type="hidden" name="code" value="<%= news.getCode() %>">
				<tr><td class="campocentral">Data e Hora: <input type="text" name="datetime" size="40" value="<%= news.getDatetime() %>"></td></tr>
			<tr><td class="campocentral">T&iacute;tulo: <input type="text" name="title" size="50" value="<%= news.getTitle() %>"></td></tr>
			<tr><td>&nbsp;</td></tr>

			<tr><td class="campocentral">Corpo:</td></tr>
			<tr><td class="campocentral"><textarea name="body" rows="4" cols="60"><%= news.getBody() %></textarea></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td class="campocentral"><input type="button" name="back" value="Voltar" onClick="javascript: history.back();">&nbsp;<input type="submit" name="edit" value="Editar"></td></tr>
			</form>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
