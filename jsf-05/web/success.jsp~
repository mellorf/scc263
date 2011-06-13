<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:loadBundle basename="sistema.messages" var="msg"/>

<jsp:include page="header.jsp" />
<!-- chama header para execução e depois inclui aqui -->

	<td>
    		<f:view>
		<table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class="titulocentral"><h:outputText value="#{msg.title}"/></td>
			</tr>
			<tr><td>&nbsp;</td></tr>

      			<h:form id="result">
				<tr><td class="campocentral">
		<h:outputText value="#{msg.success}"/>
				</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td class="campocentral">
		<h:commandButton value="#{msg.back}" 
			action="#{user.back}"/></td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td><h:messages style="color: blue"/></td></tr>
				<tr><td>&nbsp;</td></tr>
      			</h:form>
    		</f:view>
		</table>
	</td>
</tr>

<!-- inclui primeiro e depois processa -->
<%@ include file="footer.jsp" %>
