package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.dto.Jogo;

public interface RepoJogo extends MongoRepository<Jogo, String> {

	@Query(value="{ controlador : ?0}")
	public List<Jogo> findByContolador(String nome);
	
	@Query(value="{ controlador : ?0, ativo : ?1}")
	public List<Jogo> findByAtivoContolador(String nome, Boolean ativo);
	
	@Query(value="{ numeroFase : ?0}")
	public Jogo findByNumeroFase(String numeroFase);
	
	@Query(value="{ numeroFase : ?0, ativo : true}")
	public List<Jogo> findByNumeroFaseAtivo(String numeroFase);

}