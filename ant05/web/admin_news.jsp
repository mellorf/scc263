<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

<tr>
	<td>
		<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class="titulocentral">Interface Administrativa: Notícias</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td class="campocentral"><a href="admin_news_insert.jsp">Inserir</a></td>
			</tr>
			<tr>
				<td class="campocentral"><a href="admin_news_edit.jsp">Editar/Remover</a></td>
			</tr>
			<tr>
				<td class="campocentral"><input type="button" name="back" value="Voltar" onClick="history.back();"></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
