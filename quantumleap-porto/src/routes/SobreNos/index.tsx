import style from "./SobreNos.module.css";
import fotoArthur from "../../img/foto-arthur.png";
import fotoLucas from "../../img/foto-lucas.jpg";
import fotoVictor from "../../img/foto-victor.jpeg"

export default function SobreNos() {
    return (
        <main>
            <section className={style.conteudoSobreNos}>
                <h1>Sobre nós</h1>
                <div>
                    <img
                        className={style.fotoIntegrante}
                        src={fotoArthur}
                        alt="foto arthur"
                    />
                    <div className={style.descricaoIntegrante}>
                        <h2>Arthur Eduardo Luna Pulini - Turma 1TDSPY</h2>
                        <h4>RM 554848</h4>
                    </div>
                </div>
                <div>
                    <img
                        className={style.fotoIntegrante}
                        src={fotoLucas}
                        alt="foto lucas"
                    />
                    <div className={style.descricaoIntegrante}>
                        <h2>Lucas Almeida Fernandes de Moraes - Turma 1TDSPY</h2>
                        <h4>RM 557569</h4>
                    </div>
                </div>
                <div>
                    <img
                        className={style.fotoIntegrante}
                        src={fotoVictor}
                        alt="foto victor"
                    />
                    <div className={style.descricaoIntegrante}>
                        <h2>Victor Nascimento Cosme - Turma 1TDSPY</h2>
                        <h4>RM 558856</h4>
                    </div>
                </div>
                <nav className={style.linkRepositorio}>
                    <ul>
                        <li>
                            <a href="https://github.com/victorcosmedev/quantumleap-porto">
                                Link para o repositório
                            </a>
                        </li>
                    </ul>
                </nav>
            </section>
        </main>
    );
}
