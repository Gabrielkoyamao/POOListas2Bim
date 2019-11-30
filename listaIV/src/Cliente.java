import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) 
                throws UnknownHostException, IOException {
        // dispara cliente
        new Cliente("127.0.0.1", 12345).executa();
    }
    
    private static int chave=5;
    private String host;
    private int porta;

    public Cliente (String host, int porta) {
        this.host = host;
        this.porta = porta;
    }
    
    public static String encriptar(String texto){
		StringBuilder textoCifrado = new StringBuilder();
		int tamanhoTexto = texto.length();
		for(int c=0; c < tamanhoTexto; c++){
			int letraCifradaASCII = ((int) texto.charAt(c)) + chave;
			while(letraCifradaASCII > 126)
				letraCifradaASCII -= 94;
			textoCifrado.append( (char)letraCifradaASCII );
		}
		return textoCifrado.toString();
	}


    public void executa() throws UnknownHostException, IOException {
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println("O cliente se conectou ao servidor!");

        // thread para receber mensagens do servidor
        Recebedor r = new Recebedor(cliente.getInputStream());
        new Thread(r).start();

        // lê msgs do teclado e manda pro servidor
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(encriptar(teclado.nextLine()));
        }

        saida.close();
        teclado.close();
        cliente.close();        
    }
}