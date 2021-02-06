package com.example.demo.utils;

public enum EscoposContador {
	CONTADORJOGO("ContadorJogo");
	
	private String escopo;

	private EscoposContador(String escopo) {
		this.escopo = escopo;
	}
	
	public String getEscopo() {
		return escopo;
	}
}
