let d = new Date();
console.log("de dentro do arquivo: " +  d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds());

var conta=0;
function avanca_imagem(){
    if (conta == 2) 
        conta = 0;
    else {
        conta++;
    }
    img = document.getElementById("img_ativa");
    img.setAttribute('src', "./img/supermercado_"+(conta+1)+".jpg");
    console.log("conta: "+ conta);    
}

function retrocede_imagem(){
    if (conta == 0) 
        conta = 2;
    else {
        conta--;
    }
    img = document.getElementById("img_ativa");
    img.setAttribute('src', "./img/supermercado_"+(conta+1)+".jpg");
    console.log("conta: "+ conta);    
    
}