package tarefa02Processos03.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import tarefa02Processos03.controller.BotaoCancelar;
import tarefa02Processos03.controller.BotaoOK;
import tarefa02Processos03.controller.BotaoProcurar;

public class TelaExecutar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCaminho;
	private JButton btnOK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExecutar frame = new TelaExecutar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaExecutar() {
		setTitle("Executar");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaExecutar.class.getResource("../img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 509, 462, 215);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIcone = new JLabel("");
		lblIcone.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblIcone.setIcon(new ImageIcon(TelaExecutar.class.getResource("../img/icon.png")));
		lblIcone.setBounds(18, 20, 48, 39);
		contentPane.add(lblIcone);

		JLabel lblDescricaoExecutar1 = new JLabel("Digite o nome de um programa, pasta, documento ou");
		lblDescricaoExecutar1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		lblDescricaoExecutar1.setBounds(76, 20, 355, 16);
		contentPane.add(lblDescricaoExecutar1);

		JLabel lblDescricaoExecutar2 = new JLabel("recurso da Internet e o Windows o abrir\u00E1 para voc\u00EA.");
		lblDescricaoExecutar2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		lblDescricaoExecutar2.setBounds(76, 35, 370, 16);
		contentPane.add(lblDescricaoExecutar2);

		JLabel lblAbrir = new JLabel("Abrir:");
		lblAbrir.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		lblAbrir.setBounds(20, 73, 48, 14);
		contentPane.add(lblAbrir);

		tfCaminho = new JTextField();
		tfCaminho.setBounds(76, 69, 355, 23);
		tfCaminho.setColumns(10);
		tfCaminho.addActionListener(new BotaoOK(tfCaminho, this));
		tfCaminho.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (tfCaminho.getText().isEmpty())
					btnOK.setEnabled(false);
				else
					btnOK.setEnabled(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.add(tfCaminho);

		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(0, 109, 456, 77);
		panelButtons.setLayout(null);
		contentPane.add(panelButtons);

		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		btnOK.setEnabled(false);
		btnOK.setBounds(98, 22, 89, 23);
		btnOK.addActionListener(new BotaoOK(tfCaminho, this));
		panelButtons.add(btnOK);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		btnCancelar.setBounds(197, 22, 103, 23);
		btnCancelar.addActionListener(new BotaoCancelar(this));
		panelButtons.add(btnCancelar);

		JButton btnProcurar = new JButton("Procurar...");
		btnProcurar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		btnProcurar.setBounds(310, 22, 120, 23);
		btnProcurar.addActionListener(new BotaoProcurar(this, tfCaminho, btnOK));
		panelButtons.add(btnProcurar);
	}
}
