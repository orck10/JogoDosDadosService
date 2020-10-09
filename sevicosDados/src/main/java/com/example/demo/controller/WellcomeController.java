package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WellcomeController {
	@RequestMapping("/")
	public String welcome() {
		return "wellcome";
	}
	
	@RequestMapping("/painel")
	public String painel() {
		return "PainelDados";
	}
}