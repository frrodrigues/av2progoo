package br.mb.tutorialJdbcSwingMysql.controller;

import br.mb.tutorialJdbcSwingMysql.model.Contato;
import br.mb.tutorialJdbcsSwingMysql.dao.ContatoDao;
import br.mb.tutorialJdbcSwingMysql.model.Consulta;
import br.mb.tutorialJdbcsSwingMysql.dao.ConsultaDAO;
import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ConsultaController extends Consulta{


    public void salvar(String dtcons, String hora, String nome) 
		throws SQLException, ParseException 
	{
        Consulta consulta = new Consulta();
        consulta.setDtcons(dtcons);
        consulta.setHora(hora);
        consulta.setNome(nome);

        new ConsultaDAO().salvar(consulta);
    }

    public void alterar(long id, String dtcons, String hora, String nome) 
		throws ParseException, SQLException 
	{
        
    	Consulta consulta = new Consulta();
        consulta.setId(id);
        consulta.setDtcons(dtcons);
        consulta.setHora(hora);
        consulta.setNome(nome);

        new ConsultaDAO().alterar(consulta);
    }

    public List listaConsultas() {
        ConsultaDAO dao = new ConsultaDAO();
        try {
            return dao.findConsultas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
				"Problemas ao localizar a consulta" + 
				e.getLocalizedMessage()
			);
        }
        return null;
    }

    public void excluir(long id) throws SQLException {
        new ConsultaDAO().excluir(id);
    }

    public Consulta buscaConsultaporNome(String nome) throws SQLException {
        ConsultaDAO dao = new ConsultaDAO();
        return dao.findByName(nome);
    }
}