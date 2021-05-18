package com.example.demo.dto;

public class ErrorResponse {
	private Integer status;
	private String mensagem;
	
	public ErrorResponse(Integer status, String mensagem) {
		super();
		this.status = status;
		this.mensagem = mensagem;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
