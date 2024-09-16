import { useState, useEffect } from "react";
import styles from "./AreaCliente.module.css";
import { useNavigate } from "react-router-dom";

export default function AreaCliente() {
    const [usuarioLogado, setUsuarioLogado] = useState(sessionStorage.getItem('usuarioAutenticado'));
    const navigate = useNavigate();

    const [classeBotaoAreaDoCliente, setClasseBotaoAreaDoCliente] = useState(styles.buttonSelected);
    const [classeBotaoCadastroDoVeiculo, setClasseBotaoCadastroDoVeiculo] = useState("");
    const [msgStatusEnvio, setMsgStatusEnvio] = useState("");
    const [classeMensagem, setClasseMensagem] = useState(styles.mensagemInfo); // Ajuste a classe conforme necessário
    const [mostrarAreaDoCliente, setMostrarAreaDoCliente] = useState(true);
    const [dadosUsuario, setDadosUsuario] = useState(null);

    useEffect(() => {
        if (usuarioLogado === null) {
            setTimeout(() => {
                navigate("/login");
            }, 5000);
        } else {
            const dados = sessionStorage.getItem("registroUsuario");
            if (dados) {
                setDadosUsuario(JSON.parse(dados));
            }
        }
    }, [usuarioLogado, navigate]);

    const botaoCadastroVeiculoOnClick = () => {
        setClasseBotaoCadastroDoVeiculo(styles.buttonSelected);
        setClasseBotaoAreaDoCliente("");
        setMostrarAreaDoCliente(false);
    };

    const botaoAreaDoClienteOnClick = () => {
        setClasseBotaoCadastroDoVeiculo("");
        setClasseBotaoAreaDoCliente(styles.buttonSelected);
        setMostrarAreaDoCliente(true);
    };

    const validaVeiculo = (placa) => {
        if (!dadosUsuario || !dadosUsuario.veiculos) return true;
        const quantidadeDeVeiculos = dadosUsuario.veiculos.length;
        for (let i = 0; i < quantidadeDeVeiculos; i++) {
            const veiculo = dadosUsuario.veiculos[i];
            if (placa === veiculo.placa) {
                return false;
            }
        }
        return true;
    };

    const envioFormulario = (event) => {
        event.preventDefault();

        const montadora = event.target.montadora.value;
        const modelo = event.target.modelo.value;
        const ano = event.target.ano.value;
        const km = event.target.km.value;
        const placa = event.target.placa.value;

        if (validaVeiculo(placa)) {
            const veiculo = {
                montadora,
                modelo,
                ano,
                km,
                placa
            };

            let veiculosDoUsuario = dadosUsuario.veiculos || [];
            veiculosDoUsuario.push(veiculo);
            dadosUsuario.veiculos = veiculosDoUsuario;

            sessionStorage.setItem("registroUsuario", JSON.stringify(dadosUsuario));
            localStorage.setItem("registroUsuario", JSON.stringify(dadosUsuario));

            setMsgStatusEnvio("Veículo cadastrado com sucesso!");
            setClasseMensagem(styles.sucesso);
        } else {
            setMsgStatusEnvio("Veículo já cadastrado.");
            setClasseMensagem(styles.erro);
        }
    };

    const renderizaAreaCliente = () => {
        if (usuarioLogado === null) {
            setTimeout(() => {
                navigate("/login");
            }, 5000);
            return (
                <main className={styles.containerAreaCliente}>
                    <h2>Você não está logado! Estamos te redirecionando para a página de login</h2>
                </main>
            );
        } else {
            return (
                <main className={styles.containerAreaCliente}>
                    <div className={styles.seletorBox}>
                        <button className={classeBotaoAreaDoCliente} onClick={botaoAreaDoClienteOnClick}>Área do Cliente</button>
                        <button className={classeBotaoCadastroDoVeiculo} onClick={botaoCadastroVeiculoOnClick}>Cadastro de Veículo</button>
                    </div>
                    <div className={styles.cardUsuario}>
                        {mostrarAreaDoCliente ? (
                            <div className={styles.dadosUsuario}>
                                <ul>
                                    {dadosUsuario && (
                                        <>
                                            <li><span>Nome: </span>{dadosUsuario.nome}</li>
                                            <li><span>CPF: </span>{dadosUsuario.cpf}</li>
                                            <li><span>Email: </span>{dadosUsuario.email}</li>
                                        </>
                                    )}
                                </ul>
                            </div>
                        ) : (
                            <form onSubmit={envioFormulario} className={styles.formCadastroVeiculo}>
                                <fieldset>
                                    <div className={styles.campo}>
                                        <label htmlFor="montadora">Montadora</label>
                                        <input type="text" id="montadora" name="montadora" placeholder="Ex.: Honda" required />
                                    </div>
                                    <div className={styles.campo}>
                                        <label htmlFor="modelo">Modelo</label>
                                        <input type="text" id="modelo" name="modelo" placeholder="Ex.: Accord" required />
                                    </div>
                                    <div className={styles.campo}>
                                        <label htmlFor="ano">Ano</label>
                                        <input type="text" id="ano" name="ano" placeholder="Ex.: 2002" required />
                                    </div>
                                    <div className={styles.campo}>
                                        <label htmlFor="km">Quilometragem</label>
                                        <input type="text" id="km" name="km" placeholder="Ex.: 100.000" required />
                                    </div>
                                    <div className={styles.campo}>
                                        <label htmlFor="placa">Placa do veículo</label>
                                        <input type="text" id="placa" name="placa" placeholder="Ex.: ABC1D23 ou ABC1234" required />
                                    </div>
                                    <button type="submit">Enviar</button>
                                    <p className={classeMensagem}>{msgStatusEnvio}</p>
                                </fieldset>
                            </form>
                        )}
                        
                        <div className={styles.divVeiculos}>
                            <h3>Veículos Cadastrados</h3>
                            <ul>
                                {dadosUsuario && dadosUsuario.veiculos && dadosUsuario.veiculos.map((veiculo, index) => (
                                    <li key={index} className={styles.veiculo}>
                                        {`${veiculo.montadora} ${veiculo.modelo} | ${veiculo.placa} | ${veiculo.ano}`}
                                    </li>
                                ))}
                            </ul>
                        </div>
                    </div>
                    
                </main>
            );
        }
    };

    return (
        <>
            {renderizaAreaCliente()}
        </>
    );
}
