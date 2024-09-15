
import { useState } from "react";
import styles from "./AreaCliente.module.css";

export default function AreaCliente(){
    const [usuarioLogado, setUsuarioLogado] = useState(sessionStorage.getItem('usuarioAutenticado'));
    const navigate = useNavigate();


    const renderizaAreaCliente = () => {
        if(usuarioLogado === null ){

            setTimeout(() => {
      navigate("/login");
                }, 5000);
            return <h2>Você não está logado! Estamos te redirecionando para a página de login</h2>
        } else {
            console.log("Usuário logado");
        }
    }
    
    return(
        <main className={styles.containerAreaCliente}>

            <div className={styles.seletorBox}>
                <button className={styles.buttonSelected}>Área do Cliente</button>
                <button>
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

                <form action="" className={styles.formCadastroVeiculo}>
                    <fieldset>
                        {/* <div className={styles.campos}>

                        </div> */}
                        <div className={styles.campo}>
                            <label htmlFor="montadora:">Montadora</label>
                            <select className={`${styles.selectMontadoras} ${styles.conteudoCardUsuarioNome}`} id="montadoras" name="montadoras">
                                <option value="" disabled>Selecione uma opção</option>
                                <option value="chevrolet">Chevrolet</option>
                                <option value="fiat">Fiat</option>
                                <option value="ford">Ford</option>
                                <option value="honda">Honda</option>
                                <option value="hyundai">Hyundai</option>
                                <option value="jeep">Jeep</option>
                                <option value="nissan">Nissan</option>
                                <option value="renault">Renault</option>
                                <option value="toyota">Toyota</option>
                                <option value="volkswagen">Volkswagen</option>
                            </select>
                        </div>
                        <div className={styles.campo}>
                            <label htmlFor="modelo">Modelo</label>
                            <input type="text" id="modelo" name="modelo" placeholder="Ex.: Accord"/>
                        </div>
                        <div className={styles.campo}>
                            <label htmlFor="ano">Ano</label>
                            <input type="text" id="ano" name="ano" placeholder="Ex.: 2002"/>
                        </div>
                        <div className={styles.campo}>
                            <label htmlFor="km">Quilometragem</label>
                            <input type="text" id="ano" name="ano" placeholder="Ex.: 100.000"/>
                        </div>
                        <div className={styles.campo}>
                            <label htmlFor="placa">Placa do veículo</label>
                            <input type="text" id="placa" name="placa" placeholder="Ex.: ABC1D23 ou ABC1234"/>
                        </div>
                        <button>Enviar</button>
                    </fieldset>                    
                </form>
                

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