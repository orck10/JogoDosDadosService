package com.example.demo.utils;

import org.springframework.http.HttpHeaders;

public class CriaHeaders {
	
	public static HttpHeaders criaHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "*");
		headers.add("Access-Control-Allow-Headers", "*");
		headers.add("Access-Control-Max-Age", "86400");
		return headers;
	}
}
