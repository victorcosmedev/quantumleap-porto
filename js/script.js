let listaUsuarios = [
    {emailUsuario:"arthur@email.com",nomeUsuario:"Arthur",senhaUsuario:"554848"},
    {emailUsuario:"lucas@email.com",nomeUsuario:"Lucas",senhaUsuario:"557569"},
    {emailUsuario:"victor@email.com",nomeUsuario:"Victor",senhaUsuario:"558856"},
    {nomeUsuario:"9027908",senhaUsuario:"017972b8d104efcf41a8f034d3"},
];


function validaCampos(input1,input2) {
   
    //Recuperando o elemento da msg do usuario.
    const elMsg = document.querySelector(".quadrado");
    
    for (let x = 0; x < listaUsuarios.length; x++) {
        if((listaUsuarios[x].emailUsuario == input1.value) && (listaUsuarios[x].senhaUsuario == input2.value)){

            //Criando um objeto no localStorage
            localStorage.setItem("usuario-logado", JSON.stringify(listaUsuarios[x]));

            //Criando o token de autenticação do usuário;
            const tokenUser = Math.random().toString(16).substring(2)+Math.random().toString(16).substring(2);
            //Criando o objeto na sessionStorage e guardando o token;
            sessionStorage.setItem("token", tokenUser);

           

           setTimeout(()=>{
                elMsg.setAttribute("class","quadrado");
                elMsg.innerText = "";
                window.location.href = "../index.html";
           },3000);
            return false; 
        }
    }

    elMsg.setAttribute("class","erro");
    elMsg.innerText = "Nome de usuário ou senha incorretos!";
    setTimeout(()=>{
        elMsg.setAttribute("class","valida");
        elMsg.innerText = "";
        window.location.href = "../status/erro.html";
   },3000);
    return false;
}



const alteraVisao = (inputSenha)=>{
    if(inputSenha.type == "password"){
        inputSenha.setAttribute("type","text");
    }else{
        inputSenha.setAttribute("type","password");
    }
}

let iconEye = document.querySelector("i");
iconEye.addEventListener('click', function(){
    
    let inputSenha = document.querySelector("#idSenha");

    if(this.className == "fa-regular fa-eye-slash" ){
        this.setAttribute("class","fa-regular fa-eye");
        alteraVisao(inputSenha);
    }else{
        this.setAttribute("class","fa-regular fa-eye-slash");
        alteraVisao(inputSenha);
    }
    console.log(iconEye);
});


