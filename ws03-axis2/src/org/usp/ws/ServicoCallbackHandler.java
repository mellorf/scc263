
/**
 * ServicoCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package org.usp.ws;

    /**
     *  ServicoCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServicoCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServicoCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServicoCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getJavaBean method
            * override this method for handling normal response from getJavaBean operation
            */
           public void receiveResultgetJavaBean(
                    org.usp.ws.ServicoStub.GetJavaBeanResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getJavaBean operation
           */
            public void receiveErrorgetJavaBean(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for soma method
            * override this method for handling normal response from soma operation
            */
           public void receiveResultsoma(
                    org.usp.ws.ServicoStub.SomaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from soma operation
           */
            public void receiveErrorsoma(java.lang.Exception e) {
            }
                


    }
    