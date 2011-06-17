<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:loadBundle basename="game.messages" var="msg"/>

<html>
 <f:view>
   <h:form id="result">
     <p>
       <h:outputFormat value="#{msg.success_text}">
         <f:param value="#{numberBean.userNumber}"/>
       </h:outputFormat>
     </p>
     <p>
       <h:commandButton value="#{msg.tryagain_button}"
       			action="#{numberBean.playagain}"/>
     </p>
   </h:form>
 </f:view>
</html>
