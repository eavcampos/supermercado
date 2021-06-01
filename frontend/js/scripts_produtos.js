function executaGet(url) {
let request = new XMLHttpRequest();
request.open("GET", url, false);
request.send();
return request.responseText;

}



function executaPost(url, dados) {
    let request = new XMLHttpRequest();
    request.open("POST", url, true);

    request.setRequestHeader("Content-type", "application/json");
    request.send(JSON.stringify(dados));

    request.onload = function() {
        console.log(this.responseText);
    }

    return request.responseText;
    
    }
    



function principal() {

let dados_retornados = executaGet("http://localhost:8080/produtos");
let produtos = JSON.parse(dados_retornados);

let tb = document.getElementById("tabela_produtos");

produtos.forEach(element => {

    linha = document.createElement("tr");

    tdId = document.createElement("td");
    tdDescricao = document.createElement("td");
    tdQtdEstoque = document.createElement("td");
    tdPrecoVenda = document.createElement("td");

    tdId.innerHTML = element.id;
    tdDescricao.innerHTML = element.descricao;
    tdQtdEstoque.innerHTML = element.qtdEstoque;
    tdPrecoVenda.innerHTML = element.precoVenda;

    linha.appendChild(tdId);
    linha.appendChild(tdDescricao);
    linha.appendChild(tdQtdEstoque);
    linha.appendChild(tdPrecoVenda);

    tb.appendChild(linha);
    
});

}


function cadastrarProduto() {
event.preventDefault();
let url = "http://localhost:8080/produtos";
let descricao = document.getElementById("descricao").value;
let qtdEstoque=  document.getElementById("qtdEstoque").value;
let precoVenda=  document.getElementById("precoVenda").value;

dados ={ 
    "descricao": descricao,
    "qtdEstoque": qtdEstoque,
    "precoVenda": precoVenda
}
 executaPost(url, dados);

}

principal()