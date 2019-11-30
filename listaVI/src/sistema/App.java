package sistema;

import java.io.IOException;

import controller.MenuController;
import controller.Utils;

public class App {

	public static void main(String[] args) throws IOException {
		
		
		MenuController menu = new MenuController();	
		Utils ctrl = new Utils();
		
		int opc = 99;
		while(opc != 0) {
			menu.start();
			opc = ctrl.opcao();
			switch(opc) {
				case 1:
					menu.subMenuCadastro();
					break;
				case 2:
					menu.subMenuListar();
					break;
				case 3:
					menu.subMenuRelatorio();
					break;
				case 4:
					menu.subMenuHistorico();
					break;
				case 5:
					menu.subMenuAtendimento();
					break;
				default:
					menu.start();
					break;
			}
		}
	}
}
