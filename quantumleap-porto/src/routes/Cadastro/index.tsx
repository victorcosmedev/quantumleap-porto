import { useState } from "react";
import style from "./Cadastro.module.css";
import { useNavigate } from "react-router-dom";

interface Usuario {
  nome: string;
  email: string;
  senha: string;
  cpf: string;
  id?: string; // `id` é opcional inicialmente
  veiculos: [];
}

export default function Cadastro(){

  const [msgStatusEnvio, setMsgStatusEnvio] = useState("");
  const [classeMensagem, setClasseMensagem] = useState("");
  const navigate = useNavigate();

	const validaCpf = (cpf: string): boolean => {
		for (let i: number = 0; i < localStorage.length; i++) {
			const chave: string | null = localStorage.key(i);
			const valor = chave ? localStorage.getItem(chave) : null;
			const usuarioExtraido = JSON.parse(valor) as Usuario;
			const cpfUsuarioExtraido = usuarioExtraido.cpf;

			if(cpf == cpfUsuarioExtraido){
				return false;
			}
		}
		
		return true;
	}

  
  const envioFormulario = (event) => {
    event.preventDefault();

	// Recebendo todos os valores do form
    const nome = event.target.nome.value;
    const email = event.target.email.value;
    const senha = event.target.senha.value;
    const cpf = event.target.cpf.value;

    
    // Observação: Verificando se os campos estão vazios
	if(nome && cpf && email && senha){
      
		// validando a unicidade do usuário via CPF
		if(validaCpf(cpf)){
			
			const objetoUsuario:Usuario = {
				nome: nome,
				email: email,
				senha: senha,
				cpf: cpf,
        veiculos: []
			}

			objetoUsuario.id = "user_" + objetoUsuario.cpf;
			localStorage.setItem(objetoUsuario.id, JSON.stringify(objetoUsuario))
		
			setMsgStatusEnvio("Cadastro realizado com sucesso!");
			setClasseMensagem("sucesso");
		
			setTimeout(() => {
				navigate('/');
			}, 5000);

		} else {
			setClasseMensagem("erro");
			setMsgStatusEnvio("Você já está cadastrado. Estamos te redirecionando ao login...");

			setTimeout(() => {
				navigate('/login/');
			}, 5000);
		}
	} else {
		setClasseMensagem("erro");
		setMsgStatusEnvio("Preencha todos os campos!");

		setTimeout(() => {
			window.location.reload();
		  }, 5000);
		  
	}
  }


  return(
      <main className={style.containerForm}>
      <form className={style.formulario} onSubmit={envioFormulario}>
        <fieldset className={style.quadrado}>
          <h1>Crie sua conta</h1>
          <p>Preencha seus dados de acesso para continuar.</p>
          <div className={style.divCampo}>
            <label htmlFor="nome">Nome<span>*</span></label>
            <input
              id="nome"
              className={style.formatacaoEntradaCampo}
              type="text"
              name="nome"
              placeholder="Nome"
              minLength={3}
			  required
            />
          </div>
          <div className={style.divCampo}>
            <label htmlFor="cpf">CPF<span>*</span></label>
            <input
              id="cpf"
              className={style.formatacaoEntradaCampo}
              type="text"
              name="cpf"
              placeholder="CPF/CNPJ"
              minLength={11}
              required
            />
          </div>
          <div className={style.divCampo}>
            <label htmlFor="email">Email<span>*</span></label>
            <input
              id="email"
              className={style.formatacaoEntradaCampo}
              type="text"
              name="email"
              placeholder="Email" 
              required
            />
          </div>
          <div className={style.divCampo}>
            <label htmlFor="senha">Senha<span>*</span></label>
            <input
              id="senha"
              className={style.formatacaoEntradaCampo}
              type="password"
              name="senha"
              placeholder="Senha"
              minLength={8}
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
