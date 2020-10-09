package com.example.demo.dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Resultado;
import com.example.demo.service.ResultadoService;
import com.google.gson.Gson;

@Service
public class ControllerResultado {
	
	@Autowired
	private ResultadoService service;
	
	public Resultado saveJson(String json) {
				
		return service.addNewResultado(new Gson().fromJson(json, Resultado.class));
	}	
}
