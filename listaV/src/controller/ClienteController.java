package controller;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteController {

	private String ip="localhost";
	private Socket socketCliente;
	
	public ClienteController() throws Exception{
		System.out.println("Fazendo conexão");
		socketCliente = new Socket(ip,1236);
	}
	
	public void conectarEnviar()throws Exception{
		PrintWriter escritor = 
				new PrintWriter(socketCliente.getOutputStream());
		System.out.println("Enviando...");
		escritor.write("Teste");
		escritor.close();
	}
}
