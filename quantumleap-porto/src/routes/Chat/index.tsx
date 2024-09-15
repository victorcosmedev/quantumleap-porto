export default function Chat(){
    return (
        <main class="container-chat">
      <div class="div-background-color">
        <div class="div-chat">
          <h1>QuickFix - Chatbot</h1>
          <div class="mensagens">
            <div class="chatline">
              <div class="chatbox">
                <p>Olá! Meu carro quebrou e preciso de ajuda</p>
              </div>
            </div>
            <div class="chatline">
              <div class="chatbox">
                <p>Claro! Qual o sintoma o seu carro apresentou?</p>
              </div>
            </div>
            <div class="chatline">
              <div class="chatbox">
                <p>
                  Está saindo uma fumaça branca do capô dele, o que pode ser?
                </p>
              </div>
            </div>
            <div class="chatline">
              <div class="chatbox">
                <p>
                  Muito provavelmente seu carro ferveu por falta de água no
                  sistema de arrefecimento
                </p>
              </div>
            </div>
            <div class="chatline">
              <div class="chatbox">
                <p>Quanto isso vai me custar?</p>
              </div>
            </div>
            <div class="chatline">
              <div class="chatbox">
                <p>
                  Inicialmente, nada. Você precisa colocar água no reservatório
                  de água, só espere o carro esfriar pois você pode se machucar.
                </p>
              </div>
            </div>
          </div>

          <form action="#">
            <fieldset class="custom-fieldset">
              <div class="enviar-resposta">
                <input
                  type="text"
                  name="resposta"
                  id="resposta"
                  placeholder="Digite sua resposta"
                />
              </div>
              <div class="botao-enviar">
                <button type="submit">
                  <img src="../img/botao-enviar.png" alt="botao de enviar" />
                </button>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </main>
    )
}