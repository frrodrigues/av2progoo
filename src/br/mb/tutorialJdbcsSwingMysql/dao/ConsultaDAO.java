package br.mb.tutorialJdbcsSwingMysql.dao;
import br.mb.tutorialJdbcSwingMysql.model.Contato;
import br.mb.tutorialJdbcSwingMysql.model.Consulta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO extends GenericDao {
	public void salvar(Consulta consulta) throws SQLException {
    String insert = "INSERT INTO CONSULTAS(dtcons, hora, idcontato) VALUES(?,?,?)";
    save(insert, consulta.getDtcons(), consulta.getHora(), consulta.getIdcontato());
}
public void alterar(Consulta consulta) throws SQLException {
    String update = "UPDATE CONSULTAS " +
            "SET dtcons = ?, hora = ?, idcontato = ? " +
            "WHERE id = ?";
    update(update, consulta.getId(),  consulta.getDtcons(), consulta.getHora(), consulta.getIdcontato());
}

public void excluir(long id) throws SQLException {
    String delete = "DELETE FROM CONSULTAS WHERE id = ?";
    delete(delete, id);
}

public List findConsultas() throws SQLException {
    List consultas = new ArrayList();

    String select = "SELECT * FROM CONTATOS";

    PreparedStatement stmt = 
		getConnection().prepareStatement(select);
		
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        Consulta consulta = new Consulta();
        consulta.setId(rs.getLong("id"));
        consulta.setDtcons(rs.getString("dtcons"));
        consulta.setHora(rs.getString("hora"));
        consulta.setIdcontato(rs.getLong("idcontato"));
        consultas.add(consulta);
    }

    rs.close();
    stmt.close();
    getConnection().close();

    return consultas;

}}
