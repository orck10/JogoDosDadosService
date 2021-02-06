package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contador {
	
	@Id
	private String id;
	private String escopo;
	private Integer contador;
	
	public Contador(String escopo, Integer contador) {
		super();
		this.escopo = escopo;
		this.contador = contador;
	}
	
	public Contador() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEscopo() {
		return escopo;
	}
	public void setEscopo(String escopo) {
		this.escopo = escopo;
	}
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	@Override
	public String toString() {
		return "Contador [id=" + id + ", escopo=" + escopo + ", contador=" + contador + "]";
	}
}
