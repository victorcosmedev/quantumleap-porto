import { useNavigate } from "react-router-dom";
import styles from "./Chat.module.css";
import { useState } from "react";

export default function Chat(){

    const [usuarioLogado, setUsuarioLogado] = useState(sessionStorage.getItem('usuarioAutenticado'));
    const navigate = useNavigate();


    const renderizaAreaChat = () => {
        if (usuarioLogado === null) {
            setTimeout(() => {
                navigate("/login");
            }, 5000);
            return (
                <main className={styles.containerChatErro}>
                    <h2>Você não está logado! Estamos te redirecionando para a página de login...</h2>
                </main>
            );
        } else {
            return (
                <main className={styles.containerChat}>
                    <div className={styles.divBackgroundColor}>
                        <div className={styles.divChat}>
                            <h1>QuickFix - Chatbot</h1>
                            <div className={styles.mensagens}>
                                <div className={styles.chatLine}>
                                    <div className={styles.chatBox}>
                                        <p>Olá! Meu carro quebrou e preciso de ajuda</p>
                                    </div>
                                </div>
                                <div className={styles.chatLine}>
                                    <div className={styles.chatBox}>
                                        <p>Claro! Qual o sintoma o seu carro apresentou?</p>
                                    </div>
                                </div>
                                <div className={styles.chatLine}>
                                    <div className={styles.chatBox}>
                                        <p>Está saindo uma fumaça branca do capô dele, o que pode ser?</p>
                                    </div>
                                </div>
                                <div className={styles.chatLine}>
                                    <div className={styles.chatBox}>
                                        <p>Muito provavelmente seu carro ferveu por falta de água no sistema de arrefecimento</p>
                                    </div>
                                </div>
                                <div className={styles.chatLine}>
                                    <div className={styles.chatBox}>
                                        <p>Quanto isso vai me custar?</p>
                                    </div>
                                </div>
                                <div className={styles.chatLine}>
                                    <div className={styles.chatBox}>
                                        <p>Inicialmente, nada. Você precisa colocar água no reservatório de água, só espere o carro esfriar pois você pode se machucar.</p>
                                    </div>
                                </div>
                            </div>

                            <form action="#">
                                <fieldset className={styles.customFieldset}>
                                    <div className={styles.enviarResposta}>
                                        <input
                                            type="text"
                                            name="resposta"
                                            id="resposta"
                                            placeholder="Digite sua resposta"
                                        />
                                    </div>
                                    <div className={styles.botaoEnviar}>
                                        <button type="submit">
                                            <img src="../img/botao-enviar.png" alt="botão de enviar" />
                                        </button>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </main>
            )
        }
    }
    
    return (
        <>
            {renderizaAreaChat()};
        </>
    )
}