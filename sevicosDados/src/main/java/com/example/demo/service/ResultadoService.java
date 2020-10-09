package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Resultado;

public interface ResultadoService {
	public List<Resultado> getAll();
	public Resultado addNewResultado(Resultado r);
	public List<Resultado> getByJogoId (String id);
}
