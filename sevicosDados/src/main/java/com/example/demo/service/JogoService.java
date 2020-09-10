package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Jogo;

public interface JogoService {
	
	
	List<Jogo> getAll();
	
	Jogo getById(String id);
	
	Jogo addNewJogo(Jogo jogo);
	
	Jogo updateJogo(Jogo jogo);
	
	Boolean deleteJogo(String id);
	
	List<Jogo> getByControlador(String nome);
	
	List<Jogo> getByAticoControlador(String nome);
}
