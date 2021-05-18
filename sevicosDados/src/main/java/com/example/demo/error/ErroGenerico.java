package com.example.demo.error;

public class ErroGenerico extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ErroGenerico() {
        super();
    }
    public ErroGenerico(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    public ErroGenerico(String mensagem) {
        super(mensagem);
    }
    public ErroGenerico(Throwable causa) {
        super(causa);
    }
}
