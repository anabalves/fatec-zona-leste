package aula3.view;

import aula3.controller.ProcessosController;

public class Principal {

	public static void main(String[] args) {
		
		ProcessosController procController = new ProcessosController();
		String os = procController.getOS();
		System.out.println(os);
		
//		String process = "C:\\Windows\\write.exe";
//		procController.callProcess(process);
		
//		String process = "D:\\Program Files\\Microsoft VS Code\\Code.exe";
//		procController.callProcess(process);
		
//		String process = "TASKLIST /FO TABLE";
//		procController.readProcess(process);
		
//		String process = "ping -t10 www.google.com.br";
//		procController.readProcess(process);
		
//		String process = "TRACERT www.uol.com.br";
//		procController.readProcess(process);
		
//		String process = "ipconfig";
//		procController.readProcess(process);
		
//		String param = "cmd.exe";
//		procController.killProcess(param);
		
//		String param = "24404";
//		procController.killProcess(param);
	}

}
