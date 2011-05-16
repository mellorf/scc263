<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

<tr>
	<td>
		<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class="titulocentral">Interface Administrativa: Notícias: Inserir</td>
			</tr>
			<tr><td>&nbsp;</td></tr>

			<form action="admin_news_insert_action.jsp">
			<tr><td class="campocentral">Data e Hora: <input type="text" name="datetime" size="40"></td></tr>
			<tr><td class="campocentral">Título: <input type="text" name="title" size="50"></td></tr>
			<tr><td>&nbsp;</td></tr>

			<tr><td class="campocentral">Corpo:</td></tr>
			<tr><td class="campocentral"><textarea name="body" rows="4" cols="60"></textarea></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td class="campocentral"><input type="button" name="back" value="Voltar" onClick="javascript: history.back();">&nbsp;<input type="submit" name="insert" value="Inserir"></td></tr>
			</form>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
