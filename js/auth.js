

// Função para verificar se o usuário está logado
function verificarUsuarioLogado() {
    // Verifica se há um usuário logado no localStorage
    const usuarioLogado = JSON.parse(localStorage.getItem("usuario-logado"));
    if (usuarioLogado) {
        // Exibe uma mensagem junto com o nome do usuário
        const mensagem = "Olá, ";
        const userNameElement = document.getElementById("user-name");
        userNameElement.textContent = mensagem + usuarioLogado.nomeUsuario;
        
        const userInfoElement = document.getElementById("user-info");
        userInfoElement.style.display = "block";

        // Altera o link de login para logout
        const loginLink = document.querySelector(".links-direita .login-link");
        loginLink.innerHTML = "<a href='#' onclick='deslogarUsuario()'>Logout</a>";
    } else {
       
        const userInfoElement = document.getElementById("user-info");
        userInfoElement.style.display = "none";

        // Restaura o link de login
        const loginLink = document.querySelector(".links-direita .login-link");
        loginLink.innerHTML = "<a href='./paginas/login.html'>Login</a>";
    }
}

// Função para deslogar o usuário
function deslogarUsuario() {
    
    localStorage.removeItem("usuario-logado");
    sessionStorage.removeItem("token");
    
    verificarUsuarioLogado();
}


document.addEventListener("DOMContentLoaded", verificarUsuarioLogado);
