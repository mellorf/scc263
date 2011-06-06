package org.usp.ws;
 
import org.usp.ws.ServicoStub.SomaResponse;

public class Client {
    public static void main(String[] args) throws Exception {
        ServicoStub stub = new ServicoStub();
 
        //Create the request
        ServicoStub.Soma request = new ServicoStub.Soma();
        request.setValor1(Integer.parseInt(args[0]));
        request.setValor2(Integer.parseInt(args[1]));
 
        //Invoke the service
        SomaResponse response = stub.soma(request);
        System.out.println("Response : " + response.get_return());
    }
}
