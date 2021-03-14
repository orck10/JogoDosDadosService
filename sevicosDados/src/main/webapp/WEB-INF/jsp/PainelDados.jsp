<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Painel</title>
		<script src="/js/action.js"></script>
	</head>
	<body>
		<div>
			<label for="nomeResp">Nome  </label>
			<input type="text" id="nomeResp" name="nomeResp"><br><br>
			<label for="idJogo">Id Jogo  </label>
			<input type="text" id="idJogo" name="idJogo" value=""><br><br>
			<input id="novoJogo" type="submit" value="Criar Novo Jogo" onclick="getNovoJogo();">
			<input id="novoJogo" type="submit" value="Criar Novo Jogo Subtração" onclick="getNovoJogoSub();">
			<input id="verJogos" type="submit" value="Ver Jogos" onclick="getJogoResp();">
			<input id="verResultados" type="submit" value="Ver Resultados" onclick="getResultados();">
			<input id="desativarJogo" type="submit" value="Desativar Jogo" onclick="desativaJogo();">
		</div>
		<br>
		<br>
		<div id="tabelas" name="tabelas">
		</div>
	</body>
</html>