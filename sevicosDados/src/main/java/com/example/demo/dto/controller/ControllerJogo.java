package com.example.demo.dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Jogo;
import com.example.demo.error.ErroGenerico;
import com.example.demo.service.JogoService;

@Service
public class ControllerJogo {
	@Autowired
	private JogoService jogoService;
	
	public Jogo buscarJogoAtivPorId(String id) {
		Jogo jogo = jogoService.getById(id);
		if(jogo != null && jogo.getAtivo()) {
			return jogo;
		}
		throw new ErroGenerico("Não há jogos ativos com esse id");
	}
	
	public Jogo desativarJogo(String id) {
		Jogo jogo = jogoService.getById(id);
		jogo.setAtivo(false);
		return jogoService.updateJogo(jogo);
	}
}
