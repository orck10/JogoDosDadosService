package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListaFase {
	private List<Fase> fases;

	public ListaFase(List<Fase> fases) {
		super();
		this.fases = fases;
	}
	
	public ListaFase() {
	}

	public List<Fase> getFases() {
		return fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

	@Override
	public String toString() {
		return "ListaFase [fases=" + fases + "]";
	}
	
	public void gerarListaFases(Boolean soma) {
		this.fases = new ArrayList<Fase>();
		int cont = 0;
		
		if(soma) {
			while(cont <= 5) {
				Integer n1 = ThreadLocalRandom.current().nextInt(1, 7);
				Integer n2 = ThreadLocalRandom.current().nextInt(1, 7);
				
				Fase fase = new Fase(n1, n2, soma);
				
				if(!temFase(n1, n2)) {
					this.fases.add(fase);
					cont ++;
				}
			}
		}else {
			while(cont <= 5) {
				Integer n1 = ThreadLocalRandom.current().nextInt(1, 7);
				Integer n2 = ThreadLocalRandom.current().nextInt(1, n1+1);
				
				Fase fase = new Fase(n1, n2, soma);
				
				if(!temFase(n1, n2)) {
					this.fases.add(fase);
					cont ++;
				}
			}
		}
	}
	
	private Boolean temFase(Integer n1, Integer n2) {
		for(Fase fase : this.fases) {
			if(fase.getN1().equals(n1) && fase.getN2().equals(n2)) {
				return true;
			}
		}
		return false;
	}
}
