package br.mb.tutorialJdbcSwingMysql.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtlogin;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(82, 36, 93, 38);
		frame.getContentPane().add(lblLogin);
		
		txtlogin = new JTextField();
		txtlogin.setBounds(186, 45, 96, 20);
		frame.getContentPane().add(txtlogin);
		txtlogin.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(186, 76, 96, 20);
		frame.getContentPane().add(txtpass);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(82, 85, 48, 14);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblSistemaDeAgendamento = new JLabel("Sistema de agendamento de consulta");
		lblSistemaDeAgendamento.setBounds(10, 11, 272, 14);
		frame.getContentPane().add(lblSistemaDeAgendamento);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user= txtlogin.getText();
				String pass= txtpass.getText();
				if (user=="admin" && pass=="poo")
				{
					
				}
			}
		});
		btnEntrar.setBounds(186, 107, 89, 23);
		frame.getContentPane().add(btnEntrar);
	}
}
