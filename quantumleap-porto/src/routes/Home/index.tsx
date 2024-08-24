export default function Home(){
    return(
        <main>
        <div className="grid-main">
          <div className="box-banner-cadastro">
            <div>
              <h1>Problemas com seu carro?</h1>
              <h2>Nós temos a solução</h2>
              <a className="botao-cadastro" href="./paginas/cadastro.html">Cadastre-se já</a>
            </div>
          </div>
          <div className="box-img-motorista">
            <img src="./img/motorista-azul.jpeg" alt="" />
          </div>
          <div className="box-lista-problemas">
            <div>
              <h2>Problemas como:</h2>
              <nav className="lista-problemas">
                <ul>
                  <li>Alinhamento</li>
                  <li>Ar-condicionado</li>
                  <li>Arrefecimento</li>
                  <li>Balanceamento e Geometria</li>
                  <li>Correias</li>
                  <li>Discos e Pastilhas de Freio</li>
                  <li>Embreagens</li>
                  <li>Filtros</li>
                  <li>Velas de Ignição</li>
                </ul>
              </nav>
            </div>
          </div>
          <div className="box-img-caminhao">
            <img src="./img/caminhao-porto.jpeg" alt="" />
          </div>
          <div className="box-iniciar-chat">
            <h1>Precisa de ajuda? Fale conosco!</h1>
            <a className="botao-iniciar-chat" href="./paginas/chat.html">Iniciar Chat</a>
          </div>
        </div>
      </main>
    );
}