package br.mb.tutorialJdbcSwingMysql.frame;

import br.mb.tutorialJdbcSwingMysql.controller.ContatoController;
import br.mb.tutorialJdbcSwingMysql.model.Contato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.lang.Integer.*;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class ContatoFrame extends JFrame {

    private JLabel lbNome, lbTel, lbCpf;
    private JTextField txtNome, txtTel, txtCpf, txtLocalizar;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar;
    private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;

    private List <Contato> contatoList = new ContatoController().listaContatos();
    private int registroAtual = 0;
	private Long key;
	private JButton btnAgendarConsulta;

    public ContatoFrame() {
        super("Contatos");
        Container tela = getContentPane();
        getContentPane().setLayout(null);
        lbNome = new JLabel("Nome");
        lbTel = new JLabel("Telefone");
        lbCpf = new JLabel("CPF");

        lbNome.setBounds(10, 10, 240, 15);
        lbTel.setBounds(10, 50, 240, 15);
        lbCpf.setBounds(10, 90, 240, 15);

        lbNome.setForeground(Color.BLACK);
        lbTel.setForeground(Color.BLACK);
        lbCpf.setForeground(Color.BLACK);

        lbNome.setFont(new Font("Courier New", Font.BOLD, 14));
        lbTel.setFont(new Font("Courier New", Font.BOLD, 14));
        lbCpf.setFont(new Font("Courier New", Font.BOLD, 14));

        tela.add(lbNome);
        tela.add(lbTel);
        tela.add(lbCpf);

        txtNome = new JTextField();
        txtTel = new JTextField();
        txtCpf = new JTextField();

        txtNome.setBounds(10, 25, 265, 20);
        txtTel.setBounds(10, 65, 265, 20);
        txtCpf.setBounds(10, 105, 265, 20);

        tela.add(txtNome);
        tela.add(txtTel);
        tela.add(txtCpf);

        btnSalvar = new JButton("Salvar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnClear = new JButton("Limpar");
        btnPrimeiro = new JButton("|<");
        btnAnterior = new JButton("<<");
        btnProximo = new JButton(">>");
        btnUltimo = new JButton(">|");

        btnSalvar.setBounds(299, 25, 80, 20);
        btnAlterar.setBounds(299, 65, 80, 20);
        btnExcluir.setBounds(299, 105, 80, 20);

        tela.add(btnSalvar);
        tela.add(btnAlterar);
        tela.add(btnExcluir);

        btnPrimeiro.setBounds(10, 135, 50, 20);
        btnAnterior.setBounds(60, 135, 50, 20);
        btnClear.setBounds(110, 135, 75, 20);
        btnProximo.setBounds(185, 135, 50, 20);
        btnUltimo.setBounds(235, 135, 50, 20);

        tela.add(btnPrimeiro);
        tela.add(btnAnterior);
        tela.add(btnClear);
        tela.add(btnProximo);
        tela.add(btnUltimo);

        JLabel lbLocalizar = new JLabel("Localizar por nome");
        lbLocalizar.setBounds(10, 160, 220, 20);

        txtLocalizar = new JTextField();
        txtLocalizar.setBounds(10, 180, 175, 20);

        btnLocalizar = new JButton("Ir");
        btnLocalizar.setBounds(195, 180, 55, 20);

        tela.add(lbLocalizar);
        tela.add(txtLocalizar);
        tela.add(btnLocalizar);
        ContatoFrame self = this;
        btnAgendarConsulta = new JButton("Agendar");
        btnAgendarConsulta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
    	    				Agenda ag = new Agenda();
    						self.dispose();
    						ag.setVisible(true);	
    						}
    	});
        btnAgendarConsulta.setBounds(273, 169, 106, 31);
        getContentPane().add(btnAgendarConsulta);

        setSize(416, 250);
        setVisible(true);
        setLocationRelativeTo(null);

        btnSalvar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickSalvar();
                    }
                }
        );

        btnAlterar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAlterar();
                    }
                }
        );

        btnExcluir.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickExcluir();
                    }
                }
        );

        btnClear.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearFields();
                        registroAtual = 0;
                    }
                }
        );

        btnLocalizar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickLocalizar();
                    }
                }
        );

        btnPrimeiro.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickPrimeiro();
                    }
                }
        );
        btnAnterior.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAnterior();
                    }
                }
        );

        btnProximo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickProximo();
                    }
                }
        );

        btnUltimo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickUltimo();
                    }
                }
        );
    }

    private void onClickUltimo() {
        registroAtual = contatoList.size() - 1;
        getValores(registroAtual);
    }

    private void onClickProximo() {
        if (registroAtual != contatoList.size() - 1) {
            getValores(++registroAtual);
        }
    }

    private void onClickAnterior() {
        if (registroAtual != 0) {
            getValores(--registroAtual);
        }
    }

    private void onClickPrimeiro() {
        registroAtual = 0;
        getValores(registroAtual);
    }

    private void getValores(int index) {
        if (index <= contatoList.size() - 1) {
            Contato contatoAtual = contatoList.get(index);
            txtNome.setText(contatoAtual.getNome());
            txtTel.setText(Integer.toString(contatoAtual.getTel()));
            txtCpf.setText(Integer.toString(contatoAtual.getCpf()));
        }
    }

    private void onClickAlterar() {
        ContatoController cc = new ContatoController();
       
		long id = 0L;
		
		if (key == null) {
            id = contatoList.get(registroAtual).getId();
        } else {
            id = key;
            key = null;
        }
		
        try {
            cc.alterar(id, txtNome.getText(),Integer.parseInt(txtTel.getText()),Integer.parseInt(txtCpf.getText()));
            JOptionPane.showMessageDialog(this, "Contato alterado com sucesso!");
            clearFields();
            contatoList = new ContatoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar contato!n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data possui formato inválido!n" + e.getLocalizedMessage());
        }
    }

    private void onClickSalvar() {
        ContatoController cc = new ContatoController();
        try {
        	cc.salvar(txtNome.getText(), Integer.parseInt(txtTel.getText()),Integer.parseInt(txtCpf.getText()));
            JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
            clearFields();
            contatoList = new ContatoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
				"Nao foi possivel salvar contato!n" + 
				e.getLocalizedMessage()
			);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, 
				"Data possui formato inválido!n" + 
				e.getLocalizedMessage()
		);
        }
    }

    private void onClickExcluir() {
        ContatoController cc = new ContatoController();
        long id = contatoList.get(registroAtual).getId();
        try {
            cc.excluir(id);
            JOptionPane.showMessageDialog(this, "Contato excluido com sucesso!");
            clearFields();
            contatoList = new ContatoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
				"Nao foi possivel excluir o contato!n" + 
				e.getLocalizedMessage()
			);
        }
    }

    private void onClickLocalizar() {
        ContatoController cc = new ContatoController();
        try {
            Contato c = cc.buscaContatoPorNome(txtLocalizar.getText());
            txtNome.setText(c.getNome());
            txtTel.setText(Integer.toString((c.getTel())));
           txtCpf.setText(Integer.toString(c.getCpf()));
			key = c.getId();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
				"Ocorreu um erro, tente novamente!n" + 
				e.getLocalizedMessage()
			);
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, 
				"Contato não localizdo ou não existe!n" + 
				e.getLocalizedMessage()
			);
        }
    }
  

    private void clearFields() {
        txtNome.setText("");
        txtTel.setText("");
       txtCpf.setText("");
        txtLocalizar.setText("");
    }

    public static void main(String[] args) {
        ContatoFrame frame = new ContatoFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}