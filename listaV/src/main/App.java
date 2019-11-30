package main;
import java.util.Scanner;

import controller.ServidorController;
import controller.ThreadController;

public class App {

	public static void main(String[] args) throws Exception {
		
		Scanner opt = new Scanner(System.in);
		String pathServidorDir = "C:\\Users\\User\\Desktop\\";
		
		System.out.println("Deseja selecionar o path dos arquivos do servidor? [s/N]");
		if("s".equals(opt.nextLine().toLowerCase())) {
			System.out.println("Digite o PATH:");
			pathServidorDir = opt.nextLine(); 
		}
		
		ThreadController threadCtrl = new ThreadController();
		Thread clientThrd = new Thread(threadCtrl);
		clientThrd.start();
		
		ServidorController serv = new ServidorController(pathServidorDir);
		serv.iniciar();
	}
}
