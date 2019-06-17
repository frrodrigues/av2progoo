package br.mb.tutorialJdbcSwingMysql.model;

import java.sql.Date;

public class Consulta {
	private Long id;
	private String dtcons;
	private String hora;
	private Long idcontato;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDtcons() {
		return dtcons;
	}
	public void setDtcons(String dtcons) {
		this.dtcons = dtcons;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Long getIdcontato() {
		return idcontato;
	}
	public void setIdcontato(Long idcontato) {
		this.idcontato = idcontato;
	}

}
