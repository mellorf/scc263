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
				<td class="titulocentral">Interface Administrativa: Not&iacute;cias: Remover</td>
			</tr>
			<tr><td>&nbsp;</td></tr>

			<form action="admin_news_remove_action.jsp">
			<input type="hidden" name="code" value="<%= news.getCode() %>">
			<input type="hidden" name="datetime" value="<%= news.getDatetime() %>">
			<input type="hidden" name="title" value="<%= news.getTitle() %>">
			<input type="hidden" name="body" value="<%= news.getBody() %>">
				<tr><td class="campocentral">Data e Hora: <%= news.getDatetime() %></td></tr>
			<tr><td class="campocentral">T&iacute;tulo: <%= news.getTitle() %></td></tr>
			<tr><td>&nbsp;</td></tr>

			<tr><td class="campocentral">Corpo:</td></tr>
			<tr><td class="campocentral"><%= news.getBody() %></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td class="campocentral"><input type="button" name="back" value="Voltar" onClick="javascript: history.back();">&nbsp;<input type="submit" name="remove" value="Remover"></td></tr>
			</form>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
