<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

<tr>
	<td>
		<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class="titulocentral">Interface Administrativa</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td class="campocentral"><a href="admin_news.jsp">Notícias</a></td>
			</tr>
			<tr>
				<td class="campocentral"><a href="admin_user.jsp">Usuários</a></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
