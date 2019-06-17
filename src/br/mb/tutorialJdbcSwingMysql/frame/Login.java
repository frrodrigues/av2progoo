package br.mb.tutorialJdbcSwingMysql.frame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private final JButton btnEnviar = new JButton("Enviar ");
	private final JTextField username = new JTextField();
	private final JLabel lblUsername = new JLabel("Username ");
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		username.setBounds(129, 100, 164, 26);
		contentPane.add(username);
		username.setColumns(10);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsername.setBounds(33, 88, 126, 36);
		contentPane.add(lblUsername);
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Login self = this;
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(username.getText().equals("admin") && password.getText().equals("poo")) {
					ContatoFrame a = new ContatoFrame();
						self.dispose();
						a.setVisible(true);	
						}
						else
							JOptionPane.showMessageDialog(null,"Senha ou login incorretos");
			}
		});
		btnEnviar.setBounds(152, 196, 126, 26);
		contentPane.add(btnEnviar);
		
		JLabel lblPassword = new JLabel("Password ");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPassword.setBounds(33, 147, 104, 16);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(129, 149, 164, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblTelaDeLogin = new JLabel("Agendamento de Consulta");
		lblTelaDeLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelaDeLogin.setBounds(101, 25, 303, 38);
		contentPane.add(lblTelaDeLogin);
	}
}