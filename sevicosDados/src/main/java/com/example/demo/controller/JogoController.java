package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Jogo;
import com.example.demo.dto.controller.ControllerJogo;
import com.example.demo.dto.controller.ControllerResultado;
import com.example.demo.service.JogoService;

import static com.example.demo.utils.CriaHeaders.criaHeaders;

@RestController
@RequestMapping(path = "/api/jogo")
public class JogoController {
	
	@Autowired
	private JogoService jogoService;
	
	@Autowired
	private ControllerResultado resultadoController;
	
	@Autowired
	private ControllerJogo JogoController;

	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Jogo>> getAll(){
		return ResponseEntity.ok().headers(criaHeaders()).body(jogoService.getAll());
	}
	
	@GetMapping(path = "/novoSoma")
	public ResponseEntity<?> novoJogo(@RequestParam(value = "nome", required = true) String nome) throws Exception{
		return ResponseEntity.ok().headers(criaHeaders()).body(jogoService.addNewJogo(nome));
	}
	
	@GetMapping(path = "/novoSubtracao")
	public ResponseEntity<Jogo> novoSubitracao(@RequestParam(value = "nome", required = true) String nome) throws Exception{
		return ResponseEntity.ok().headers(criaHeaders()).body(jogoService.addNewJogoSub(nome));
	}
	
	@GetMapping(path = "/controlador")
	public ResponseEntity<List<Jogo>> getAllByControlador(@RequestParam(value = "nome", defaultValue = "Teste", required = true) String nome){
		return ResponseEntity.ok().headers(criaHeaders()).body(jogoService.getByControlador(nome));
	}
	
	@GetMapping(path = "/controlador/ativos")
	public ResponseEntity<List<Jogo>> getAllActivoByControlador(@RequestParam(value = "nome", defaultValue = "Teste", required = true) String nome){
		return ResponseEntity.ok().headers(criaHeaders()).body(jogoService.getByAticoControlador(nome));
	}
	
	@GetMapping(path = "/jogar")
	public ResponseEntity<Jogo> getById(@RequestParam(value = "id", defaultValue = " ", required = true) String id){
		return ResponseEntity.ok().headers(criaHeaders()).body(JogoController.buscarJogoAtivPorId(id));
	}
	
	@PostMapping(path = "/resultados")
	public ResponseEntity<?> postResultados(@RequestBody String json){	
		return ResponseEntity.ok()
				.headers(criaHeaders())
				.body(resultadoController.saveJson(json));
	}
	
	@GetMapping(path = "/desativar")
	public ResponseEntity<Jogo> desativarJogo(@RequestParam(value = "id", defaultValue = "Teste", required = true) String id){
		return ResponseEntity.ok(JogoController.desativarJogo(id));
	}
}
