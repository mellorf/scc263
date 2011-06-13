<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:loadBundle basename="game.messages" var="msg"/>

<html>
 <head>
    <title>inputnumber.jsp</title>
 </head>
 <body>
     <!-- Todos comandos JSF devem ser colocados dentro da tag view a seguir -->
     <!-- Pode haver somente uma view na pagina WEB -->
     <f:view>
      <h:form id="inputNumbers">
       <p>
         <h:outputText value="#{msg.how_to_play}"/>
       </p>
       <p>
	 <!-- message imprime qualquer mensagem gerada pela aplicacao -->
         <h:messages style="color: blue"/>
       </p>
       <p>
         <h:inputText value="#{numberBean.userNumber}" required="true">
           <f:validateLongRange minimum="0" maximum="100"/>
         </h:inputText>

	 <!-- botao retorna success ou null. O padrao do JSF eh fazer refresh na pagina -->
         <h:commandButton value="#{msg.makeguess_button}" action="#{numberBean.checkGuess}"/>
       </p>
      </h:form>
    </f:view>
 </body>
</html>
