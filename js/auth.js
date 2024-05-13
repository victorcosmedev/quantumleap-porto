// Verifica se há um usuário logado no localStorage
const usuarioLogado = JSON.parse(localStorage.getItem("usuario-logado"));
if (usuarioLogado) {
    // Exibe uma mensagem junto com o nome do usuário
    const mensagem = "Olá, ";
    const userNameElement = document.getElementById("user-name");
    userNameElement.textContent = mensagem + usuarioLogado.nomeUsuario;
    // Exibe o elemento onde o nome do usuário está contido
    const userInfoElement = document.getElementById("user-info");
    userInfoElement.style.display = "block";
}
