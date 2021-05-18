package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Jogo;

public interface JogoService {
	
	
	public List<Jogo> getAll();
	
	public Jogo getById(String id);
	
	public Jogo addNewJogo(String nome) throws Exception;
	
	public Jogo addNewJogoSub(String nome) throws Exception;
	
	public Jogo updateJogo(Jogo jogo);
	
	public Boolean deleteJogo(String id);
	
	public List<Jogo> getByControlador(String nome);
	
	public List<Jogo> getByAticoControlador(String nome);
}
