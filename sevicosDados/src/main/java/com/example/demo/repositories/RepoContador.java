package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.dto.Contador;

public interface RepoContador extends MongoRepository<Contador, String>{
	
	@Query(value="{ escopo : ?0}")
	public List<Contador> findByEscopo(String escopo);
}
