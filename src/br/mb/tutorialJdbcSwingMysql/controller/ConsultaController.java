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
public class ConsultaController {

	/*private Date formatarData(String data) throws ParseException {
      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       return new Date( formatter.parse(data).getTime() );
    	}*/
	
    public void salvar(String dtcons, String hora, Long idcontato) 
		throws SQLException, ParseException 
	{
        Consulta consulta = new Consulta();
        consulta.setDtcons(dtcons);
        consulta.setHora(hora);
        consulta.setIdcontato(idcontato);

        new ConsultaDAO().salvar(consulta);
    }

    public void alterar(long id, String dtcons, String hora, Long idcontato) 
		throws ParseException, SQLException 
	{
        
    	Consulta consulta = new Consulta();
        consulta.setId(id);
        consulta.setDtcons(dtcons);
        consulta.setHora(hora);
        consulta.setIdcontato(idcontato);

        new ConsultaDAO().alterar(consulta);
    }

    public List listaContatos() {
        ConsultaDAO dao = new ConsultaDAO();
        try {
            return dao.findContatos();
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

    public Consulta buscaConsultapornome(String nome) throws SQLException {
        ConsultaDAO dao = new ConsultaDAO();
        return dao.findByName(nome);
    }
}