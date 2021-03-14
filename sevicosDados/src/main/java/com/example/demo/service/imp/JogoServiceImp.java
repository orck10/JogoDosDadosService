package com.example.demo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Contador;
import com.example.demo.dto.Jogo;
import com.example.demo.repositories.RepoContador;
import com.example.demo.repositories.RepoJogo;
import com.example.demo.service.JogoService;
import com.example.demo.utils.EscoposContador;

@Service
public class JogoServiceImp implements JogoService{
	
	@Autowired
	private RepoJogo repoJogo;
	
	@Autowired
	private RepoContador repoContador;
	
	@Override
	public List<Jogo> getAll() {
		List<Jogo> temp = this.repoJogo.findAll();
		return temp;
	}

	@Override
	public Jogo getById(String id) {
		List<Jogo> j = this.repoJogo.findByNumeroFase(id);
		return j.get(0);
	}

	@Override
	public Jogo addNewJogo(String nome) {
		return this.repoJogo.save(novoJogo(nome, true));
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

	@Override
	public Jogo addNewJogoSub(String nome) {
		return this.repoJogo.save(novoJogo(nome, false));
	}
	
	private Jogo novoJogo(String nome, Boolean soma) {
		Jogo jogo = new Jogo();
		jogo.gerar(soma, nome);
		List<Contador> cont = repoContador.findByEscopo(EscoposContador.CONTADORJOGO.getEscopo());
		if(cont == null || cont.isEmpty() || cont.size() < 1) {
			Contador contador = new Contador(EscoposContador.CONTADORJOGO.getEscopo(), 1);
			cont = new ArrayList<Contador>();
			contador = repoContador.save(contador);
			cont.add(contador);
			jogo.setNumeroFase(contador.getContador().toString());
		}
		else {
			Contador contador = cont.get(0);
			contador.setContador(contador.getContador()+1);
			contador = repoContador.save(contador);
			jogo.setNumeroFase(contador.getContador().toString());
		}
		return this.repoJogo.save(jogo);
	}
}
