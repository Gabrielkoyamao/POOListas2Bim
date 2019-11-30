package controller;
import java.util.Scanner;

public class Utils {

	public Scanner scanner;
	

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public int opcao() {
		int op = scanner.nextInt();
		return op;
	}

	public String texto() {
		String t = scanner.nextLine();
		return t;
	}

	@Override
	protected void finalize() throws Throwable {
		scanner.close();
	}
}
