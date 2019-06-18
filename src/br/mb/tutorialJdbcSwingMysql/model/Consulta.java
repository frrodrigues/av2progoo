package br.mb.tutorialJdbcSwingMysql.model;

import java.sql.Date;

public class Consulta {
	private Long id;
	private String dtcons;
	private String hora;
	private String nome;
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
