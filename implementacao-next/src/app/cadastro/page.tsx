"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";

interface Usuario {
  nome: string;
  email: string;
  senha: string;
  cpf: string;
  id?: string; // `id` é opcional inicialmente
  veiculos: [];
}

export default function Cadastro() {
  const [msgStatusEnvio, setMsgStatusEnvio] = useState("");
  const [classeMensagem, setClasseMensagem] = useState("");
  const router = useRouter();

  const validaCpf = (cpf: string): boolean => {
    for (let i: number = 0; i < localStorage.length; i++) {
      const chave: string | null = localStorage.key(i);
      const valor = chave ? localStorage.getItem(chave) : null;
      const usuarioExtraido = JSON.parse(valor) as Usuario;
      const cpfUsuarioExtraido = usuarioExtraido.cpf;

      if (cpf == cpfUsuarioExtraido) {
        return false;
      }
    }

    return true;
  };

  const envioFormulario = (event) => {
    event.preventDefault();

    // Recebendo todos os valores do form
    const nome = event.target.nome.value;
    const email = event.target.email.value;
    const senha = event.target.senha.value;
    const cpf = event.target.cpf.value;

    // Observação: Verificando se os campos estão vazios
    if (nome && cpf && email && senha) {
      // validando a unicidade do usuário via CPF
      if (validaCpf(cpf)) {
        const objetoUsuario: Usuario = {
          nome: nome,
          email: email,
          senha: senha,
          cpf: cpf,
          veiculos: [],
        };

        objetoUsuario.id = "user_" + objetoUsuario.cpf;
        localStorage.setItem(objetoUsuario.id, JSON.stringify(objetoUsuario));

        setMsgStatusEnvio("Cadastro realizado com sucesso!");
        setClasseMensagem("sucesso");

        setTimeout(() => {
          router.push("/");
        }, 5000);
      } else {
        setClasseMensagem("erro");
        setMsgStatusEnvio(
          "Você já está cadastrado. Estamos te redirecionando ao login..."
        );

        setTimeout(() => {
          router.push("/login/");
        }, 5000);
      }
    } else {
      setClasseMensagem("erro");
      setMsgStatusEnvio("Preencha todos os campos!");

      setTimeout(() => {
        window.location.reload();
      }, 5000);
    }
  };

  return (
    <main className="lg:py-[20vh] lg:px-[25vw]">
      <form
        className="border lg:border-slate-400 bg-slate-100 flex justify-center lg:rounded-2xl lg:py-8 lg:px-9 lg:h-fit sm:py-8 sm:px-[10vw] sm:h-[80vh] items-center"
        onSubmit={envioFormulario}
      >
        <fieldset className="w-full flex flex-col lg:gap-3 lg:text-lg lg:font-medium sm:gap-5 sm:text-lg sm:font-medium">
          <div className="text-center">
            <h1 className="lg:font-semibold lg:text-xl sm:font-semibold sm:text-xl">
              Crie sua conta
            </h1>
            <p className="lg:text-base sm:text-base">
              Preencha seus dados de acesso para continuar.
            </p>
          </div>
          <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
            <label htmlFor="nome">
              Nome<span>*</span>
            </label>
            <input
              id="nome"
              className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
              type="text"
              name="nome"
              placeholder="Nome"
              minLength={3}
              required
            />
          </div>
          <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
            <label htmlFor="cpf">
              CPF<span>*</span>
            </label>
            <input
              id="cpf"
              className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
              type="text"
              name="cpf"
              placeholder="CPF/CNPJ"
              minLength={11}
              required
            />
          </div>
          <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
            <label htmlFor="email">
              Email<span>*</span>
            </label>
            <input
              id="email"
              className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
              type="text"
              name="email"
              placeholder="Email"
              required
            />
          </div>
          <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
            <label htmlFor="senha">
              Senha<span>*</span>
            </label>
            <input
              id="senha"
              className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
              type="password"
              name="senha"
              placeholder="Senha"
              minLength={8}
              required
            />
          </div>
          <button className="justify-self-start w-fit text-white bg-azul-escuro lg:text-sm lg:py-1 lg:px-4 lg:rounded-md sm:text-sm sm:py-1 sm:px-4 sm:rounded-md" type="submit">
            Enviar
          </button>
          <p
            className={`${
              classeMensagem === "sucesso" ? "text-green-600" : "text-red-600"
            }`}
          >
            {msgStatusEnvio}
          </p>
        </fieldset>
      </form>
    </main>
  );
}
