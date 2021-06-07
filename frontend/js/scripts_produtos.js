/*Este método usa a API para buscar todos os produtos cadastrados.
*/
function executaGet(url) {
let request = new XMLHttpRequest();
request.open("GET", url, false);
request.send();
return request.responseText;
}

    
/*
O método excutaPost chama a API para cadastrar um produto sem a imagem
Ela está comentada porque foi substituida pela versão logo abaixo, 
com a qual é possível cadastrar tbm uma imagem para o produto

function executaPost(url, dados) {
    let request = new XMLHttpRequest();

    request.setRequestHeader("Content-type", "application/json");
    request.send(JSON.stringify(dados));
   
    request.onload = function() {
        console.log(this.responseText);
    }

    return request.responseText;

 console.log("dados = " , dados) ;
}
*/

function executaPut(url, dados) {
    let request = new XMLHttpRequest();
    request.open("PUT", url, true);
    request.setRequestHeader("mime-type", "multipart/form-data"); 
    request.send(dados);
    request.onload = function() {
        alert(this.responseText);
    }
    return request.responseText;
}


function executaPost(url, dados) {
    let request = new XMLHttpRequest();
    request.open("POST", url, true);
    request.setRequestHeader("mime-type", "multipart/form-data"); 
    request.send(dados);
    request.onload = function() {
        alert(this.responseText);
    }
    return request.responseText;
}

function montaTabela(produtos){
    let tb = document.getElementById("tabela_produtos");
    let linhas = tb.getElementsByTagName("tr");
    for (var x=linhas.length-1; x>0; x--) {
        tb.removeChild(linhas[x]);
     }
    produtos.forEach(element => {    
        linha = document.createElement("tr");
        tdId = document.createElement("td");
        tdDescricao = document.createElement("td");
        tdQtdEstoque = document.createElement("td");
        tdPrecoVenda = document.createElement("td");
        tdVisualizar = document.createElement("td");
        tdAlterar = document.createElement("td");
        tdExcluir = document.createElement("td");
        tdId.innerHTML = element.id;
        tdDescricao.innerHTML = element.descricao;
        tdQtdEstoque.innerHTML = element.qtdEstoque;
        tdPrecoVenda.innerHTML = element.precoVenda;
        tdVisualizar.innerHTML = "<button type=\"submit\" onclick=\"formVisualizar(" + element.id + ")\">Visualizar</button>";
        tdAlterar.innerHTML = "<button type=\"submit\" onclick=\"formAlterar(" + element.id + ")\">Alterar</button>";
        tdExcluir.innerHTML = "<button type=\"submit\" onclick=\"formExcluir(" + element.id + ")\">Excluir</button>";
        linha.appendChild(tdId);
        linha.appendChild(tdDescricao);
        linha.appendChild(tdQtdEstoque);
        linha.appendChild(tdPrecoVenda);
        linha.appendChild(tdVisualizar);
        linha.appendChild(tdAlterar);
        linha.appendChild(tdExcluir);
        tb.appendChild(linha);
    });
}

function montaListaFornecedores(lista) {
    let dados_retornados = executaGet("http://localhost:8080/fornecedores");
    let fornecedores = JSON.parse(dados_retornados);
    opcoes="";
    fornecedores.forEach(element => {    
         opcoes = opcoes +"<option value=\"" + element.id + "\">"+element.nomeFantasia+ "</option>";
    });
    lista.innerHTML = opcoes;
}


/*O método cadastrarProduto() usa a API para cadastar um novo produto no banco de dados.
Os dados são obtidos do formulário html.
São enviados: descrica, qtdEstoque, precoVenda, nome da imagem (no atributo linkImagem) e uma imagem do produto
*/
function cadastrarProduto() {
    event.preventDefault();
    var dados = new FormData();
    let descricao = document.getElementById("descricao").value;
    let qtdEstoque=  document.getElementById("qtdEstoque").value;
    let precoVenda=  document.getElementById("precoVenda").value;
    let file = document.getElementById("imagem");
    let linkImagem = file.files[0].name;
    let fornec = document.getElementById("fornecedor");
    let idFornecedor = fornec.options[fornec.selectedIndex].value;
    dados.append("descricao", descricao);
    dados.append("qtdEstoque", qtdEstoque);
    dados.append("precoVenda", precoVenda);
    dados.append("linkImagem", linkImagem)
    dados.append("fornecedor", idFornecedor);
    dados.append("imagem", file.files[0]);
    let url = "http://localhost:8080/produtos/insert";
    executaPost(url, dados);
}


function alterarProduto() {
    event.preventDefault();
    var dados = new FormData();
    let id = document.getElementById("id2").value;
    let descricao = document.getElementById("descricao2").value;
    let qtdEstoque=  document.getElementById("qtdEstoque2").value;
    let precoVenda=  document.getElementById("precoVenda2").value;
    let file = document.getElementById("imagem2");
    let linkImagem = file.files[0].name;
    dados.append("id", id);
    dados.append("descricao", descricao);
    dados.append("qtdEstoque", qtdEstoque);
    dados.append("precoVenda", precoVenda);
    dados.append("linkImagem", linkImagem)
    dados.append("imagem", file.files[0]);    
    let url = "http://localhost:8080/produtos/update";
    executaPut(url, dados);
}

function formAlterar(idProduto) {
    event.preventDefault();
    let dados_retornados = executaGet("http://localhost:8080/produtos/"+idProduto);
    let produto = JSON.parse(dados_retornados);
    document.getElementById("id2").value = produto.id;
    document.getElementById("descricao2").value = produto.descricao;
    document.getElementById("qtdEstoque2").value = produto.qtdEstoque;
    document.getElementById("precoVenda2").value = produto.precoVenda;
    document.getElementById("fornecedor2").value = produto.fornecedor.id;
 }

function ordenarPorDescricao() {
    let dados_retornados = executaGet("http://localhost:8080/produtos/orderByDescricaoAsc");
    let produtos = JSON.parse(dados_retornados);
    montaTabela(produtos);
}   

function ordenarPorPreco() {
    let dados_retornados = executaGet("http://localhost:8080/produtos/orderByPrecoVendaDesc");
    let produtos = JSON.parse(dados_retornados);
    montaTabela(produtos);
}

/*O método principal() usa a API para obter a lista de todos os produtos disponiveis no 
estoque e apresenta-los em uma tabela no inicio da tela.
Além dos dados do produto, cada linha da tabela tem links para visualizar o produto; 
alterar o produto e excluir o produto.
*/
function principal() {
    let dados_retornados = executaGet("http://localhost:8080/produtos");
    let produtos = JSON.parse(dados_retornados);
    montaTabela(produtos);
    lista = document.getElementById("fornecedor");
    montaListaFornecedores(lista);
    lista = document.getElementById("fornecedor2");
    montaListaFornecedores(lista);
}

principal()