package br.mb.tutorialJdbcSwingMysql.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Agenda extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda window = new Agenda();
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
	public Agenda() {
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
		
		JLabel lblNewLabel = new JLabel("Agendamento de consulta");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(21, 11, 219, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDataDaConsulta = new JLabel("Data");
		lblDataDaConsulta.setBounds(31, 111, 48, 14);
		frame.getContentPane().add(lblDataDaConsulta);
		
		textField = new JTextField();
		textField.setBounds(89, 108, 135, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(31, 138, 48, 23);
		frame.getContentPane().add(lblHora);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 139, 135, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNomeDoContato = new JLabel("Nome");
		lblNomeDoContato.setBounds(31, 77, 48, 14);
		frame.getContentPane().add(lblNomeDoContato);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 74, 135, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(303, 73, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(303, 108, 89, 23);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(303, 142, 89, 23);
		frame.getContentPane().add(btnExcluir);
	}

}
