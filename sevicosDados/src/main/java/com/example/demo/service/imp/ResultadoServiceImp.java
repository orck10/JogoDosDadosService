package com.example.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Resultado;
import com.example.demo.repositories.RepoResultado;
import com.example.demo.service.ResultadoService;

@Service
public class ResultadoServiceImp implements ResultadoService{
	
	@Autowired
	RepoResultado repoResultado;
	
	@Override
	public List<Resultado> getAll() {
		return this.repoResultado.findAll();
	}

	@Override
	public Resultado addNewResultado(Resultado r) {
		return this.repoResultado.insert(r);
	}

	@Override
	public List<Resultado> getByJogoId(String id) {
		return this.repoResultado.findByJogoId(id);
	}
}
