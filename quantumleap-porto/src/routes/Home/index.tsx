import style from "./Home.module.css";
import motoristaAzul from "../../img/motorista-azul.jpeg";
import caminhaoPorto from "../../img/caminhao-porto.jpeg";
import { Link } from "react-router-dom";

export default function Home() {
    return (
        <main>
            <div className={style.gridMain}>
                <div className={style.boxBannerCadastro}>
                    <div>
                        <h1>Problemas com seu carro?</h1>
                        <h2>Nós temos a solução</h2>
                        <Link to="/cadastro" className={style.botaoCadastro}>Cadastre-se já</Link>
                    </div>
                </div>
                <div className={style.boxImgMotorista}>
                    <img src={motoristaAzul} alt="" />
                </div>
                <div className={style.descricaoQuickfix}>
                    <h1>O que é o QuickFix?</h1>
                    <p>
                        O QuickFix foi criado para facilitar o diagnóstico de problemas no seu veículo, seja você cliente da Porto ou não.
                    </p> <br />  

                    <p>
                        Acesse nossa plataforma, cadastre-se e registre seu automóvel. Em seguida, você será guiado por um robô inteligente que fará perguntas sobre o problema. Com base nas suas respostas, ele gera um diagnóstico preciso.
                    </p><br />

                    <p>
                        Além disso, o QuickFix sugere as peças necessárias e calcula um orçamento transparente, com base nos preços de peças e mão de obra. Tudo isso de forma online, sem precisar de um especialista no local. E o melhor: depois do diagnóstico, indicamos a oficina mais próxima para resolver o problema.
                    </p><br />

                    <p>
                        O QuickFix agiliza o processo de diagnóstico e orçamento, garantindo mais confiança e previsibilidade nos serviços automotivos.
                    </p><br />

                </div>
                <div className={style.boxListaProblemas}>
                    <div>
                        <h2>Problemas como:</h2>
                        <nav className={style.listaProblemas}>
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
                <div className={style.boxImgCaminhao}>
                    <img src={caminhaoPorto} alt="" />
                </div>
                <div className={style.boxIniciarChat}>
                    <h1>Precisa de ajuda? Fale conosco!</h1>
                    <a className={style.botaoIniciarChat} href="./paginas/chat.html">Iniciar Chat</a>
                </div>
                
            </div>
        </main>
    );
}
