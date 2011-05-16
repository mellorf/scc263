<%@ include file="header.jsp" %>

	<tr><td><table align="center" size="50%" border="0" cellspacing="10">
		<tr><td class="titulo2" colspan="2">Mensagem</td></tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr><td class="mensagem"><%

		switch ((new Integer(request.getParameter("msg"))).intValue()) {
			case 0: out.println("Usu&aacute;rio cadastrado com sucesso!");
				break;
			case 1: out.println("Not&iacute;cia cadastrada com sucesso!");
				break;
			case 2: out.println("Not&iacute;cia atualizada com sucesso!");
				break;
			case 3: out.println("Not&iacute;cia removida com sucesso!");
				break;
			case 4: out.println("Usu&aacute;rio atualizado com sucesso!");
				break;
			case 5: out.println("Usu&aacute;rio removido com sucesso!");
				break;
		}
		
		%></td></tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr><td colspan="2" align="center"><input type="button" name="back" value="Voltar" onClick="javascript: history.go(-3);"></td></tr>
		<tr><td colspan="2">&nbsp;</td></tr>
	</table></td></tr>

<%@ include file="footer.jsp" %>
