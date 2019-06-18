package br.mb.tutorialJdbcSwingMysql.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.mb.tutorialJdbcSwingMysql.controller.ConsultaController;
import br.mb.tutorialJdbcSwingMysql.controller.ContatoController;
import br.mb.tutorialJdbcSwingMysql.model.Consulta;
import br.mb.tutorialJdbcSwingMysql.model.Contato;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Agenda extends JFrame{

	private JFrame frame;
	private JTextField lbldt;
	private JTextField lblhora;
	private JTextField lblnome;
	private List <Consulta> consultaList = new ConsultaController().listaConsultas();
	private int registroAtual = 0;
	private Long key;
	private JTextField txtLocalizar;
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
		System.err.println();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
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
		
		lbldt = new JTextField();
		lbldt.setBounds(89, 108, 135, 20);
		frame.getContentPane().add(lbldt);
		lbldt.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(31, 138, 48, 23);
		frame.getContentPane().add(lblHora);
		
		lblhora = new JTextField();
		lblhora.setBounds(89, 139, 135, 20);
		frame.getContentPane().add(lblhora);
		lblhora.setColumns(10);
		
		JLabel lblNomeDoContato = new JLabel("Nome");
		lblNomeDoContato.setBounds(31, 77, 48, 14);
		frame.getContentPane().add(lblNomeDoContato);
		
		lblnome = new JTextField();
		lblnome.setBounds(89, 74, 135, 20);
		frame.getContentPane().add(lblnome);
		lblnome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickSalvar();
				
			}
		});
		btnSalvar.setBounds(303, 73, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickAlterar();
				
			}
		});
		btnAlterar.setBounds(303, 108, 89, 23);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickExcluir();
				
			}
		});
		btnExcluir.setBounds(303, 142, 89, 23);
		frame.getContentPane().add(btnExcluir);
		
		txtLocalizar = new JTextField();
		txtLocalizar.setBounds(31, 195, 175, 20);
		frame.getContentPane().add(txtLocalizar);
		
		JLabel lbLocalizar = new JLabel("Localizar por nome");
		lbLocalizar.setBounds(31, 176, 220, 20);
		frame.getContentPane().add(lbLocalizar);
		
		JButton btnLocalizar = new JButton("Ir");
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickLocalizar();
							}
		});
		btnLocalizar.setBounds(210, 195, 55, 20);
		frame.getContentPane().add(btnLocalizar);
	}
	
    private void clearFields() {
    	lbldt.setText("");
    	lblhora.setText("");
    	lblnome.setText("");
    }
	private void onClickSalvar() {
        ConsultaController cc = new ConsultaController();
        try {
        	cc.salvar( lbldt.getText(),lblhora.getText(),lblnome.getText());
            JOptionPane.showMessageDialog(this, "Consulta salva com sucesso!");
            clearFields();
          consultaList = new ConsultaController().listaConsultas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
				"Nao foi possivel salvar consulta" + 
				e.getLocalizedMessage()
			);
        }catch (ParseException e) {
            JOptionPane.showMessageDialog(this, 
				"Horarrio e data indisponiveis" + 
				e.getLocalizedMessage()
		);
        }
    }
	
	
	 private void onClickAlterar() {
	        ConsultaController cc = new ConsultaController();
	       
			long id = 0L;
			
			if (key == null) {
	            id = consultaList.get(registroAtual).getId();
	        } else {
	            id = key;
	            //key = null;
	        }
			
	        try {
	            cc.alterar(id,lbldt.getText(),lblhora.getText(),lblnome.getText());
	            JOptionPane.showMessageDialog(this, "Consulta alterada com sucesso");
	            clearFields();
	            consultaList = new ConsultaController().listaConsultas();
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar consulta" + e.getLocalizedMessage());
	        } catch (ParseException e) {
	            JOptionPane.showMessageDialog(this, "data indisponivel" + e.getLocalizedMessage());
	        }
	    }
	 private void onClickExcluir() {
	       ConsultaController cc = new ConsultaController();
	       long id = 0L;
			
			if (key == null) {
	            id = consultaList.get(registroAtual).getId();
	        } else {
	            id = key;
	            //key = null;
	        } 
	       //long id =consultaList.get(registroAtual).getId();
	        System.err.println();
	        try {
	            cc.excluir(id);
	            JOptionPane.showMessageDialog(this, "Consulta excluido com sucesso!");
	            clearFields();
	           consultaList = new ConsultaController().listaConsultas();
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(this, 
					"Nao foi possivel excluir a consulta!n" + 
					e.getLocalizedMessage()
				);
	        }
	    }
	 
	 private void onClickLocalizar() {
	        ConsultaController cc = new ConsultaController();
	        	        try {
	            Consulta c = cc.buscaConsultaporNome(txtLocalizar.getText());
	            lblnome.setText(c.getNome());
	            lbldt.setText(c.getDtcons());
	            lblhora.setText(c.getHora());
				key = c.getId();
				
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(this, 
					"Ocorreu um erro, tente novamente!n" + 
					e.getLocalizedMessage()
				);
	        } catch (NullPointerException e){
	            JOptionPane.showMessageDialog(this, 
					"Consulta não localizdo ou não existe!n" + 
					e.getLocalizedMessage()
				);
	        }
	    }
}
	
    

