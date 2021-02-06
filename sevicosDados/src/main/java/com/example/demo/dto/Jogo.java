package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Jogo {
	
	@Id
	private String id;
	private ListaFase fases;
	private Boolean ativo;
	private String controlador;
	private String numeroFase;
	
	public Jogo(String id, ListaFase fases, Boolean ativo, String controlador) {
		super();
		this.id = id;
		this.fases = fases;
		this.ativo = ativo;
		this.controlador = controlador;
	}
	
	public Jogo() {
		super();
	}

	public void gerar(Boolean soma, String controlador) {
		this.id = null;
		this.fases = new ListaFase();
		this.fases.gerarListaFases(soma);
		this.ativo = true;
		this.controlador = controlador;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ListaFase getFases() {
		return fases;
	}

	public void setFases(ListaFase fases) {
		this.fases = fases;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getControlador() {
		return controlador;
	}

	public void setControlador(String controlador) {
		this.controlador = controlador;
	}

	public String getNumeroFase() {
		return numeroFase;
	}

	public void setNumeroFase(String mumeroFase) {
		this.numeroFase = mumeroFase;
	}

	@Override
	public String toString() {
		return "Jogo [id=" + id + ", fases=" + fases + ", ativo=" + ativo + ", controlador=" + controlador
				+ ", mumeroFase=" + numeroFase + "]";
	}
}
