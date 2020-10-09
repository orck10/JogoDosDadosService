package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ResultadoService;

@RestController
@RequestMapping(path = "/api/resultado")
public class ResultadosController {

	@Autowired
	private ResultadoService resultadoService;
	
	@GetMapping(path = "/resultados")
	public ResponseEntity<?> novoJogo(@RequestParam(value = "id", defaultValue = "Teste", required = true) String id){
		return ResponseEntity.ok(resultadoService.getByJogoId(id));
	}
}
