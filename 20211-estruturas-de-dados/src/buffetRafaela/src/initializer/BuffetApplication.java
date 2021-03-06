package initializer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.TelaDashboard;

public class BuffetApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuffetApplication frame = new BuffetApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	private void pegarResolucao() {
//		Toolkit t = Toolkit.getDefaultToolkit();
//		Dimension dimensao = t.getScreenSize();
//		int larg = dimensao.width;
//		int alt = dimensao.height;
//		setBounds(0, 0, larg, alt);
//	}

	public BuffetApplication() {
		setTitle("Buffet Application");
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		setIconImage(iconeRafaelaBuffet);
		setResizable(false);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		pegarResolucao();
		setBounds(0, 0, 1480, 861);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 220, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(495, 99, 434, 409);
		String path = new File("").getAbsolutePath();
		contentPane.setLayout(null);
		lblLogo.setIcon(new ImageIcon(path + "\\src\\view\\assets\\logotipo.png"));
		contentPane.add(lblLogo);
		
		JLabel lblBemVindo = new JLabel("Seja bem-vindo");
		lblBemVindo.setForeground(Color.BLACK);
		lblBemVindo.setBounds(541, 516, 347, 71);
		lblBemVindo.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 40));
		contentPane.add(lblBemVindo);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(647, 598, 138, 36);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDashboard telaDashboard = new TelaDashboard();
				telaDashboard.setVisible(true);
				dispose();
			}
		});
		btnEntrar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		contentPane.add(btnEntrar);
	}
}