package org.apache.ws.axis2;
 
import org.apache.ws.axis2.FuncaoStub.MaiorPrimoResponse;
 
public class Client {
    public static void main(String[] args) throws Exception {
        FuncaoStub stub = new FuncaoStub();
 
        FuncaoStub.MaiorPrimo request = new FuncaoStub.MaiorPrimo();
        request.setArgs0(Integer.parseInt(args[0]));
 
        MaiorPrimoResponse response = stub.maiorPrimo(request);
 
        System.out.println("Response : " + response.get_return());
    }
}
