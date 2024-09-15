import { useNavigate } from "react-router-dom";
import style from "./Login.module.css";
import { useState } from "react";

export default function Login(){

    const [msgStatusEnvio, setMsgStatusEnvio] = useState("");
    const [classeMensagem, setClasseMensagem] = useState("");
    const navigate = useNavigate();
  

    const verificaCadastroUsuario = (cpf: string): boolean => {
		for (let i: number = 0; i < localStorage.length; i++) {
			const chave: string | null = localStorage.key(i);
			const valor = chave ? localStorage.getItem(chave) : null;
			const usuarioExtraido = JSON.parse(valor) as Usuario;
			const cpfUsuarioExtraido = usuarioExtraido.cpf;

			if(cpf == cpfUsuarioExtraido){
				return true;
			}
		}
		
		return false;
	}

    const buscaRegistroUsuario = (cpf: string): boolean => {
        for (let i: number = 0; i < localStorage.length; i++) {
            const chave: string | null = localStorage.key(i);
			const valor = chave ? localStorage.getItem(chave) : null;
			const usuarioExtraido = JSON.parse(valor) as Usuario;
			const cpfUsuarioExtraido = usuarioExtraido.cpf;

            if(cpf == cpfUsuarioExtraido){
                return usuarioExtraido;
            }
        }
    }

    const envioFormulario = (event) => {
        event.preventDefault();
        const cpf = event.target.cpf.value;
        const form = event.currentTarget;
        const senha = (form.elements.namedItem('senha') as HTMLInputElement).value;
        
        
        if(verificaCadastroUsuario(cpf) == true){
            console.log("existe");
            console.log(buscaRegistroUsuario(cpf));
            const registroUsuario = buscaRegistroUsuario(cpf);
            console.log("senha inserida " + senha);
            console.log("senha guardada no banco: " + registroUsuario.senha);

            if(registroUsuario.senha == senha){
                setClasseMensagem("sucesso");
                setMsgStatusEnvio("Logado com sucesso! Estamos te redirecionando à página principal");

                setTimeout(() => {
                    navigate('/');
                }, 5000);
            } else {
                setClasseMensagem("erro");
		        setMsgStatusEnvio("A senha que você inseriu está incorreta.");
            }

        } else {
            setClasseMensagem("erro");
		    setMsgStatusEnvio("Você não está cadastrado no sistema! Estamos te redirecionando ao cadastro...");

            setTimeout(() => {
				navigate('/cadastro/');
			}, 5000);
        }
    }
    



    return(
        <main className={style.containerForm}>
        <form className={style.formulario} onSubmit={envioFormulario}>
            <fieldset className={style.quadrado}>
                <h1>Acessar Conta</h1>
                <p>Preencha seus dados de acesso para continuar.</p>
                
                <div className={style.divCampo}>
                    <label htmlFor="cpf">CPF</label>
                    <input
                    id="cpf"
                    className={style.formatacaoEntradaCampo}
                    type="text"
                    name="cpf"
                    placeholder="CPF / CNPJ"
                    minLength={8}
                    required
                    />
                </div>
                <div className={style.divCampo}>
                    <label htmlFor="senha">Senha</label>
                    <input
                    id="senha"
                    className={style.formatacaoEntradaCampo}
                    type="password"
                    name="senha"
                    placeholder="Senha"
                    required
                    />
                </div>
                <button className={style.enviar} type="submit">Enviar</button>
                <p className={`${classeMensagem === "sucesso" ? style.sucesso : style.erro}`}>{msgStatusEnvio}</p>
            </fieldset>
        </form>
        </main>
    );
}