package exercicioArquivosGenericFood.view;

import java.io.IOException;
import exercicioArquivosGenericFood.controller.ArquivosController;
import exercicioArquivosGenericFood.controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new ArquivosController();
		String path = "C:\\temp";
		String nome = "generic_food.csv";
		
		try {
			arqCont.readFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}