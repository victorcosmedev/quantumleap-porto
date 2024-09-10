import { useRef } from "react";
import styles from "./AreaCliente.module.css";

export default function AreaCliente(){
    const btnCadastroVeiculo = useRef(null);

    const handleClick = () => {
        console.log(btnCadastroVeiculo.current);
    }

    console.log(btnCadastroVeiculo);

    return(
        <main className={styles.containerAreaCliente}>
            <div className={styles.seletorBox}>
                <button className={styles.buttonSelected}>Área do Cliente</button>
                <button onClick={handleClick}>
                    Cadastro de Veículo
                </button>
            </div>
            <div className={styles.cardUsuario}>
                <div className={styles.dadosUsuario}>
                    <ul>
                        <li><span>Nome: </span> Eduardo Pereira Rodrigues</li>
                        <li><span>Telefone: </span> (11) 0000-0000</li>
                        <li><span>Email: </span> email@dominio.com</li>
                        <li><span>Endereço: </span> Rua dos Cravos, 555, Jd. das Dores - SP</li>
                        <li><span>Cliente Porto: </span> Sim</li>
                    </ul>
                    <button className={styles.editarDados}>Editar dados</button>
                </div>
                

                <div className={styles.divVeiculos}>
                    <h3>Veículos Cadastrados</h3>
                    <ul>
                        <li className={styles.veiculo}>Honda Accord | ABC-12D3<br/><span>2024</span></li>
                        <li className={styles.veiculo}>Volvo V60 | ABC-12D3<br/><span>2024</span></li>
                        <li className={styles.veiculo}>Volkswagen Passat | ABC-12D3<br/><span>2024</span></li>
                    </ul>
                </div>
            </div>
        </main>
    )
}