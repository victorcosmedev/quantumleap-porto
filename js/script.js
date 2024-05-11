let listaUsuarios = [
    {emailUsuario:"arthur@email.com",nomeUsuario:"Arthur",senhaUsuario:"554848"},
    {emailUsuario:"lucas@email.com",nomeUsuario:"Lucas",senhaUsuario:"557569"},
    {emailUsuario:"victor@email.com",nomeUsuario:"Victor",senhaUsuario:"558856"},
    {nomeUsuario:"9027908",senhaUsuario:"017972b8d104efcf41a8f034d3"},
];

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

console.log("pinto");