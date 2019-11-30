package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Teste {
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> teste = new ArrayList<String>();
		Files.list(Paths.get("C:\\Users\\User\\Desktop"))
        .filter(Files::isRegularFile)
        .forEach(a -> teste.add(a.toString()));
		
	}
}
