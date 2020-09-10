package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Jogo;
import com.example.demo.service.JogoService;

@RestController
@RequestMapping(path = "/api/jogo")
public class JogoController {
	
	@Autowired
	private JogoService jogoService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Jogo>> getAll(){
		return ResponseEntity.ok(jogoService.getAll());
	}
	
	@GetMapping(path = "/novoSoma")
	public ResponseEntity<Jogo> novoJogo(@RequestParam(value = "nome", defaultValue = "Teste", required = true) String nome){
		Jogo jogo = new Jogo();
		jogo.gerar(true, nome);
		return ResponseEntity.ok(jogoService.addNewJogo(jogo));
	}
	
	@GetMapping(path = "/controlador")
	public ResponseEntity<List<Jogo>> getAllByControlador(@RequestParam(value = "nome", defaultValue = "Teste", required = true) String nome){
		return ResponseEntity.ok(jogoService.getByControlador(nome));
	}
	
	@GetMapping(path = "/controlador/ativos")
	public ResponseEntity<List<Jogo>> getAllActivoByControlador(@RequestParam(value = "nome", defaultValue = "Teste", required = true) String nome){
		return ResponseEntity.ok(jogoService.getByAticoControlador(nome));
	}
}
