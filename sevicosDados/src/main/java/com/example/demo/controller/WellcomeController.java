package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WellcomeController {
	
	@RequestMapping("/")
	public String welcome() {
		Date date = new Date();
		System.out.println(date.toString() + " - WellCome");
		return "wellcome";
	}
	
	@RequestMapping("/painel")
	public String painel() {
		Date date = new Date();
		System.out.println(date.toString() + " - Painel");
		return "PainelDados";
	}
}