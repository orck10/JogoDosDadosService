package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.dto.Resultado;

public interface RepoResultado extends MongoRepository<Resultado, String>{
	
	
	@Query(value="{ idJogo : ?0}")
	public List<Resultado> findByJogoId(String id);
}
