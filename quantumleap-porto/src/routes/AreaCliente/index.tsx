import styles from "./AreaCliente.module.css";

export default function AreaCliente(){
    return(
        <main className={styles.containerAreaCliente}>
            <div className={styles.seletorBox}>
                <button className={styles.buttonSelected}>Área do Cliente</button>
                <button>
                    Cadastro de Veículo
                </button>
            </div>
            <div className={styles.cardUsuario}>
                <ul>
                    <li><span>Nome: </span> Eduardo Pereira Rodrigues</li>
                    <li><span>Telefone: </span> (11) 0000-0000</li>
                    <li><span>Email: </span> email@dominio.com</li>
                    <li><span>Endereço: </span> Rua dos Cravos, 555, Jd. das Dores - SP</li>
                    <li><span>Cliente Porto: </span> Sim</li>
                </ul>
                <div className={styles.divVeiculos}>
                    <h3>Veículos Cadastrados</h3>
                    <ul>
                        <li className={styles.veiculo}>Honda Accord | ABC-12D3<br/><span>2024</span></li>
                    </ul>
                </div>
            </div>
        </main>
    )
}