import org.apache.ws.axis2.*;
 
public class Client {
    public static void main(String[] args) throws Exception {
	// criando objeto stub
        FuncaoStub stub = new FuncaoStub();

	// criando objeto para representar a chamada
        FuncaoStub.MaiorPrimo request = 
		new FuncaoStub.MaiorPrimo();
        request.setArgs0(Integer.parseInt(args[0]));

	// invocando o stub para encaminhar a requisicao da chamada
	// chamada bloqueante com timeout
        FuncaoStub.MaiorPrimoResponse response = 
		stub.maiorPrimo(request);

	// resultado
        System.out.println("Response : " + response.get_return());
    }
}
