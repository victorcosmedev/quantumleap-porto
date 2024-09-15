import { useState } from "react";
import style from "./Cadastro.module.css";
import { useNavigate } from "react-router-dom";

interface Usuario {
  nome: string;
  email: string;
  senha: string;
  cpf: string;
  id?: string; // `id` é opcional inicialmente
}

export default function Cadastro(){

  const [msgStatusEnvio, setMsgStatusEnvio] = useState("");
  const [classeMensagem, setClasseMensagem] = useState("");
  const navigate = useNavigate();

//   const testeVictor: Usuario = {
//     nome: "Victor",
//     email: "victorcosme.profissional@gmail.com",
//     senha: "123456789",
//     cpf: "43476250814",
//   }
//   testeVictor.id = "usuario_" + testeVictor.cpf;

//   const testeGui: Usuario = {
//     nome: "Gui",
//     email: "gui.profissional@gmail.com",
//     senha: "123456789",
//     cpf: "11122233344",
//   }
//   testeGui.id = "usuario_" + testeGui.cpf;


//   localStorage.setItem(testeVictor.id, JSON.stringify(testeVictor));

//   localStorage.setItem(testeGui.id, JSON.stringify(testeGui));
  // console.log(localStorage.length);
  
//   const testeLocalStorage = (cpfInserido:string) => {
//     for (let i: number = 0; i < localStorage.length; i++) {  // Note a alteração aqui
//       const chave: string | null = localStorage.key(i);
//       const valor:string = chave ? localStorage.getItem(chave) : null;

//       const usuarioExtraido = JSON.parse(valor) as Usuario;
//       const cpfUsuarioExtraido = usuarioExtraido.cpf;
      
      
      
//       console.log(`Chave: ${chave}, Valor: ${valor}`);
//     }
//   }

  
  const envioFormulario = (event) => {
    event.preventDefault();

    const nome = event.target.nome.value;
    const email = event.target.email.value;
    const senha = event.target.senha.value;
    const cpf = event.target.cpf.value;

    
    // Observação: Verificando se os campos estão vazios
	if(nome && cpf && email && senha){
      
		for (let i: number = 0; i < localStorage.length; i++) {  // Note a alteração aqui
			const chave: string | null = localStorage.key(i);
			const valor:string | null = chave ? localStorage.getItem(chave) : null;
	
			const usuarioExtraido = JSON.parse(valor) as Usuario;
			const cpfUsuarioExtraido = usuarioExtraido.cpf;

			if(cpf == cpfUsuarioExtraido){
			setClasseMensagem("erro");
			setMsgStatusEnvio("Você já está cadastrado. Estamos te redirecionando ao login...");

			setTimeout(() => {
				navigate('/login/');
			}, 5000);

			} else {

				const objetoUsuario:Usuario = {
					nome: nome,
					email: email,
					senha: senha,
					cpf: cpf
				}

				objetoUsuario.id = "user_" + objetoUsuario.cpf;

				localStorage.setItem(objetoUsuario.id, JSON.stringify(objetoUsuario))
			
				setMsgStatusEnvio("Cadastro realizado com sucesso!");
				setClasseMensagem("sucesso");
			
				setTimeout(() => {
					navigate('/');
				}, 5000);
			}
		}
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
              
            />
          </div>
          <button className={style.enviar} type="submit">Enviar</button>
          <p className={`${classeMensagem === "sucesso" ? style.sucesso : style.erro}`}>{msgStatusEnvio}</p>
        </fieldset>
      </form>
    </main>
  );
}
