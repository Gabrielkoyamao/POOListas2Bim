import java.io.InputStream;
import java.util.Scanner;

public class Recebedor implements Runnable {

    private InputStream servidor;
    private static int chave=5;
    
    public Recebedor(InputStream servidor) {
        this.servidor = servidor;
    }
    
    
    public static String decriptar(String textoCifrado){
		StringBuilder texto = new StringBuilder();
		int tamanhoTexto = textoCifrado.length();
		for(int c=0; c < tamanhoTexto; c++){
			int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - chave;
			while(letraDecifradaASCII < 32)
				letraDecifradaASCII += 94;
			texto.append( (char)letraDecifradaASCII );
	  }
	  return texto.toString();
	}

    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner s = new Scanner(this.servidor);
        while (s.hasNextLine()) {
            System.out.println(decriptar(s.nextLine()));
        }
    }
}