package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ServidorController {
	private ServerSocket socketServidor;
	private String path;
	
	public ServidorController(String path) throws IOException{
		System.out.println("Iniciando servidor");
		socketServidor = new ServerSocket(1236);
		this.path = path;
	}
	public void iniciar() throws Exception{
		while(true) {
			Socket socketEscuta = socketServidor.accept();
			InputStreamReader streamReader = 
					new InputStreamReader(socketEscuta.getInputStream());
			
			BufferedReader reader = new BufferedReader (streamReader);
			String textoEnviado = reader.readLine();
//			System.out.println(textoEnviado);
			if(socketEscuta!=null) {
				System.out.println("Listando: " + path);
				for (String arq : this.listFiles()) {
					System.out.println(arq);
				}
			}
			reader.close();
		}
	}
	
	public ArrayList<String> listFiles() throws IOException {
		ArrayList<String> files = new ArrayList<String>();
		Files.list(Paths.get(path))
        .filter(Files::isRegularFile)
        .forEach(a -> files.add(a.toString()));
		return files;
	}
}
