package tarefa02Processos03.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BotaoProcurar implements ActionListener {

	private JButton btnOK;
	private JTextField tfCaminho;
	private Component programa;

	public BotaoProcurar(Component programa, JTextField tfCaminho, JButton btnOK) {
		this.tfCaminho = tfCaminho;
		this.programa = programa;
		this.btnOK = btnOK;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Executáveis (.exe)", "exe");
		
		String diretorioBase = System.getProperty("user.home")+"/Desktop";
		File dir = new File(diretorioBase);
		
		JFileChooser choose = new JFileChooser();
		choose.setDialogTitle("Procurar");
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.addChoosableFileFilter(filtro);
		choose.setAcceptAllFileFilterUsed(false);
		String caminhoArquivo = "";
		
		int retorno = choose.showOpenDialog(programa);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			tfCaminho.setText(caminhoArquivo);
			btnOK.setEnabled(true);
		}
	}

}
