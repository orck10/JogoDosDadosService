package com.example.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Jogo;
import com.example.demo.repositories.RepoJogo;
import com.example.demo.service.JogoService;

@Service
public class JogoServiceImp implements JogoService{
	
	@Autowired
	private RepoJogo repoJogo;
	
	
	@Override
	public List<Jogo> getAll() {
		List<Jogo> temp = this.repoJogo.findAll();
		return temp;
	}

	@Override
	public Jogo getById(String id) {
		Optional<Jogo> j = this.repoJogo.findById(id);
		return j.get();
	}

	@Override
	public Jogo addNewJogo(Jogo jogo) {
		return this.repoJogo.save(jogo);
	}

	@Override
	public Jogo updateJogo(Jogo jogo) {
		if(jogo.getId() != null) {
			return repoJogo.save(jogo);
		}
		return null;
	}

	@Override
	public Boolean deleteJogo(String id) {
		try {
			repoJogo.deleteById(id);
			return true;
		}catch (Exception e) {
			System.out.println("Erro ao deletar :" + e.toString());
		}
		return false;
	}

	@Override
	public List<Jogo> getByControlador(String nome) {
		Jogo jogo = new Jogo();
		jogo.setControlador(nome);
		List<Jogo> temp = this.repoJogo.findByContolador(nome);
		return temp;
	}

	@Override
	public List<Jogo> getByAticoControlador(String nome) {
		Jogo jogo = new Jogo();
		jogo.setControlador(nome);
		List<Jogo> temp = this.repoJogo.findByAtivoContolador(nome, true);
		return temp;
	}

}
