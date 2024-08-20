export default function Cabecalho (){
    return(
        <header id="cabecalho">
      <img
        className="logo"
        src="./img/logo-porto.png"
        alt="Logo da Porto Seguro"
        width="200"
        height="100"
      />
      <nav>
        <ul className="hamburguer">
          <li>
            <a href="./paginas/menu.html"
              ><img
                src="./img/icone-hamburguer.png"
                alt="menu com mais opções"
                className="icone-hamburguer"
              />
            </a>
          </li>
        </ul>
        <ul className="links-esquerda">
          <li className="link"><a href="./index.html">Home</a></li>
          <li className="link"><a href="./paginas/sobre-nos.html">Sobre nós</a></li>
        </ul>
        <ul className="links-direita">
          <li className="link"><a href="./paginas/login.html">Login</a></li>
        </ul>
      </nav>
    </header>

    )
}