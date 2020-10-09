package com.example.demo.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Resultado {
	
	@Id
	private String id;
	private String nome;
	private String idJogo;
	private List<Boolean> resultados;
	
	public Resultado(String id, String nome, String idJogo, List<Boolean> resultados) {
		super();
		this.id = id;
		this.nome = nome;
		this.idJogo = idJogo;
		this.resultados = resultados;
	}
	
	public Resultado() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(String idJogo) {
		this.idJogo = idJogo;
	}

	public List<Boolean> getResultados() {
		return resultados;
	}

	public void setResultados(List<Boolean> resultados) {
		this.resultados = resultados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idJogo == null) ? 0 : idJogo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((resultados == null) ? 0 : resultados.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultado other = (Resultado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idJogo == null) {
			if (other.idJogo != null)
				return false;
		} else if (!idJogo.equals(other.idJogo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (resultados == null) {
			if (other.resultados != null)
				return false;
		} else if (!resultados.equals(other.resultados))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resultados [id=" + id + ", nome=" + nome + ", idJogo=" + idJogo + ", resultados=" + resultados + "]";
	}
}
