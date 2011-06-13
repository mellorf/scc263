<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:loadBundle basename="jsfks.bundle.messages" var="msg"/>
<html>
 <head>
  <title>Titulo da Página</title>
 </head>
 <body>
   <f:view>
     <h1>
      <h:outputText value="#{msg.inputname_header}"/>
     </h1>
     <h:form id="helloForm">
      <h:outputText value="#{msg.prompt}"/>
      <h:inputText value="#{personBean.personName}" />
      <h:commandButton action="greeting" value="#{msg.button_text}" />
     </h:form>
   </f:view>
 </body>
</html>  
