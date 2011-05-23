<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

<tr>
	<td>
		<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class="titulocentral">Interface Administrativa: Usu&aacute;rios: Inserir</td>
			</tr>
			<tr><td>&nbsp;</td></tr>

			<form action="User" method="post">
			<input type="hidden" name="function" value="0">
			<tr><td class="campocentral">Nome: <input type="text" name="name" size="50"></td></tr>
			<tr><td class="campocentral">Login: <input type="text" name="login" size="15"></td></tr>
			<tr><td class="campocentral">Password: <input type="password" name="passwd" size="15"></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td class="campocentral"><input type="button" name="back" value="Voltar" onClick="javascript: history.back();">&nbsp;<input type="submit" name="insert" value="Inserir"></td></tr>
			</form>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
