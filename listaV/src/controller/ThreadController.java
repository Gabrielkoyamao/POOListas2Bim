package controller;

public class ThreadController implements Runnable {

	private ClienteController cl;
	
	@Override
	public void run() {
		try {
			cl = new ClienteController();
			cl.conectarEnviar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

