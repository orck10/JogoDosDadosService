var host = window.location.origin;

function getRequest(urlPath, dadosHeader){
    var xmlHttp = new XMLHttpRequest();
    try {
        xmlHttp.open( "GET", urlPath, false );
        if(dadosHeader){
            for(var i = 0; i < dadosHeader.length; i++){
                xmlHttp.setRequestHeader(dadosHeader[i][0], dadosHeader[i][1]);
            }
        }
        xmlHttp.send( null );
    } catch (error) {
        alert("Falha na requisição tente novamente");
        console.log("Erro :"+error);
        return ""
    }
    return xmlHttp.responseText;
};

function getNovoJogo(){
    var nomeResp = document.getElementById("nomeResp").value;
    var url = host+"/api/jogo/novoSoma?nome="+nomeResp;
    if(nomeResp != null && nomeResp != undefined && nomeResp != ""){
        var json = JSON.parse(getRequest(url));
        var id = document.getElementById("idJogo");
        id.value = json.id;
        console.log(json);
    }else{
        alert('Preencha o campo "nome"');
    }
}

function getResultados(){
    var idJogo = document.getElementById("idJogo").value;
    var url = host+"/api/resultado/resultados?id="+idJogo;
    if(idJogo != null && idJogo != undefined && idJogo != ""){
        var json = JSON.parse(getRequest(url));
        montarResultados(json);
    }else{
        alert('Preencha o campo "Id Jogo"');
    }
}

function getJogoResp(){
    var nome = document.getElementById("nomeResp").value;
    var url = host+"/api/jogo/controlador?nome="+nome;
    if(nome != null && nome != undefined && nome != ""){
        var json = JSON.parse(getRequest(url));
        mostarJogos(json)
    }else{
        alert('Preencha o campo "Nome"');
    }
}

function desativaJogo(){
    var idJogo = document.getElementById("idJogo").value;
    var url = host+"/api/jogo/desativar?id="+idJogo;
    if(idJogo != null && idJogo != undefined && idJogo != ""){
        getRequest(url);
        alert('Jogo desativado');
    }else{
        alert('Preencha o campo "Id Jogo"');
    }
}

function mostarCelulasResultados(jsonResultados){
	var nomes = [];
	var r1 = [];
	var r2 = [];
	var r3 = [];
	var r4 = [];
	var r5 = [];
	
	for(var i = 0; i < jsonResultados.length; i++){
		nomes[i] = jsonResultados[i].nome;
		r1[i] = jsonResultados[i].resultados[0];
		r2[i] = jsonResultados[i].resultados[1];
		r3[i] = jsonResultados[i].resultados[2];
		r4[i] = jsonResultados[i].resultados[3];
		r5[i] = jsonResultados[i].resultados[4];
	}
	
	var map = new Map();
	map.set("Nomes",nomes);
	map.set("r1",r1);
	map.set("r2",r2);
	map.set("r3",r3);
	map.set("r4",r4);
	map.set("r5",r5);
	return map;
}

function montarTabela(celulas){
	var colunas = [];
	var tabela = document.createElement("table");
	var rows = [];
	var cabecalho = document.createElement("tr");
	
	celulas.forEach(function(valor, chave, mapa){
		colunas.push(chave);
		var cell = document.createElement("td");
	    var cellText = document.createTextNode(chave);
	    cell.appendChild(cellText);
	    cabecalho.appendChild(cell);
	})
	
	tabela.appendChild(cabecalho);
	
	for(var j = 0; j < celulas.get(colunas[0]).length; j++){
		rows[j] = document.createElement("tr");
		for(var i = 0; i < colunas.length; i++){
			var cell = document.createElement("td");
		    var cellText = document.createTextNode(celulas.get(colunas[i])[j]);
			cell.appendChild(cellText);
		    rows[j].appendChild(cell);
		}
		tabela.appendChild(rows[j]);
	}
	return tabela;
}

function motarCelulasJogos(jsonJogos){
	var ids = [];
	var ativo = [];
	
	for(var i = 0; i < jsonJogos.length; i++){
		ids[i] = jsonJogos[i].id;
		ativo[i] = jsonJogos[i].ativo;
 	}
	
	var map = new Map();
	map.set("Ids",ids);
	map.set("Ativo",ativo);
	
	return map;
}

function montarResultados(jsonResultados){
	var divTabela = document.getElementById("tabelas");
	var celulas = mostarCelulasResultados(jsonResultados);
	
	for (child of divTabela.children){
        child.remove();
    }
	
	divTabela.appendChild(montarTabela(celulas));
}

function mostarJogos(jsonJogos){
	var divTabela = document.getElementById("tabelas");
	var celulas = motarCelulasJogos(jsonJogos);
	
	for (child of divTabela.children){
        child.remove();
    }
	
	divTabela.appendChild(montarTabela(celulas));
}


