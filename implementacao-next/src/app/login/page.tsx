"use client"
import { useRouter } from "next/compat/router";
import Link from "next/link";
import { useState } from "react";

export default function Login(){

    const [msgStatusEnvio, setMsgStatusEnvio] = useState("");
    const [classeMensagem, setClasseMensagem] = useState("");
    const router = useRouter();

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

            const registroUsuario = buscaRegistroUsuario(cpf);


            if(registroUsuario.senha == senha){
                setClasseMensagem("sucesso");
                setMsgStatusEnvio("Logado com sucesso! Estamos te redirecionando à página principal");

                sessionStorage.setItem('usuarioAutenticado', 'true');
                sessionStorage.setItem('registroUsuario', JSON.stringify(registroUsuario));

                setTimeout(() => {
                    router?.push('/');
                }, 5000);

                setTimeout(() => {
                    window.location.reload();
                  }, 5000);
            } else {
                setClasseMensagem("erro");
		        setMsgStatusEnvio("A senha que você inseriu está incorreta.");
            }

        } else {
            setClasseMensagem("erro");
		    setMsgStatusEnvio("Você não está cadastrado no sistema! Estamos te redirecionando ao cadastro...");

            setTimeout(() => {
				router?.push('/cadastro/');
			}, 5000);
        }
    }
    
  return(
    <main className="lg:py-[20vh] lg:px-[25vw]">
      <form className="border lg:border-slate-400 bg-slate-100 flex justify-center lg:rounded-2xl lg:py-8 lg:px-9 lg:h-fit sm:py-8 sm:px-[10vw] sm:h-[80vh] items-center" onSubmit={envioFormulario}>
          <fieldset className="w-full flex flex-col lg:gap-3 lg:text-lg lg:font-medium sm:gap-5 sm:text-lg sm:font-medium">
              <div className="text-center">
                <h1 className="lg:font-semibold lg:text-xl sm:font-semibold sm:text-xl">Acessar Conta</h1>
                <p className="lg:text-base sm:text-base">Não tem cadastro? <Link href="/cadastro">Cadastre-se já!</Link></p>
              </div>
              
              <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
                  <label htmlFor="cpf">CPF</label>
                  <input
                  id="cpf"
                  className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
                  type="text"
                  name="cpf"
                  placeholder="CPF / CNPJ"
                  minLength={8}
                  required
                  />
              </div>
              <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
                  <label htmlFor="senha">Senha</label>
                  <input
                  id="senha"
                  className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
                  type="password"
                  name="senha"
                  placeholder="Senha"
                  required
                  />
              </div>
              <button className="justify-self-start w-fit text-white bg-azul-escuro lg:text-sm lg:py-1 lg:px-4 lg:rounded-md sm:text-sm sm:py-1 sm:px-4 sm:rounded-md" type="submit">Enviar</button>
              <p className={`${classeMensagem === "sucesso" ? "text-green-600" : "text-red-700"}`}>{msgStatusEnvio}</p>
          </fieldset>
      </form>
    </main>
  );
} 