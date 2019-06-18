package br.mb.tutorialJdbcSwingMysql.controller;

import br.mb.tutorialJdbcSwingMysql.model.Contato;
import br.mb.tutorialJdbcsSwingMysql.dao.ContatoDao;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ContatoController extends Contato {

  

    public void salvar(String nome, int tel, int cpf) 
		throws SQLException, ParseException 
	{
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setTel(tel);
        contato.setCpf(cpf);

        new ContatoDao().salvar(contato);
    }

    public void alterar(long id, String nome, int tel, int cpf) 
		throws ParseException, SQLException 
	{
        
		Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setTel(tel);
        contato.setCpf(cpf);

        new ContatoDao().alterar(contato);
    }

    public List listaContatos() {
        ContatoDao dao = new ContatoDao();
        try {
            return dao.findContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
				"Problemas ao localizar contaton" + 
				e.getLocalizedMessage()
			);
        }
        return null;
    }

    public void excluir(long id) throws SQLException {
        new ContatoDao().excluir(id);
    }

    public Contato buscaContatoPorNome(String nome) throws SQLException {
        ContatoDao dao = new ContatoDao();
        return dao.findByName(nome);
    }
}