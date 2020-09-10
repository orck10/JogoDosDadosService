package com.example.demo.dto;

public class Fase {
	private Integer n1;
	private Integer n2;
	private Boolean soma;
	
	public Fase(Integer n1, Integer n2, Boolean soma) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.soma = soma;
	}
	
	public Fase() {
		super();
		this.n1 = null;
		this.n2 = null;
		this.soma = null;
	}

	public Integer getN1() {
		return n1;
	}

	public void setN1(Integer n1) {
		this.n1 = n1;
	}

	public Integer getN2() {
		return n2;
	}

	public void setN2(Integer n2) {
		this.n2 = n2;
	}

	public Boolean getSoma() {
		return soma;
	}

	public void setSoma(Boolean soma) {
		this.soma = soma;
	}

	@Override
	public String toString() {
		return "Fase [n1=" + n1 + ", n2=" + n2 + ", soma=" + soma + "]";
	}
}
