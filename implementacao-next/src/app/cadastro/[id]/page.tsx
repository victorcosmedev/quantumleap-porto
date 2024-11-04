"use client";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { TipoCliente } from "@/types/types";

export default function EditarCadastro({ params }: { params: { id: number }}) {
  const [msgStatusEnvio, setMsgStatusEnvio] = useState("");
  const [classeMensagem, setClasseMensagem] = useState("");
  const router = useRouter();

  const [cliente, setCliente] = useState<TipoCliente>({
    idCliente: 0,
    nomeCliente: "",
    emailCliente: "",
    telefoneCliente: "",
    senhaCliente: "",
    clientePorto: false,
    localizacaoCliente: ""
  });

  const handleSubmit = async(event: React.FormEvent<HTMLFormElement>) => {
    console.log("Objeto postado: ", cliente);
    // Observação: Verificando se os campos estão vazios
    event.preventDefault();
    try{
      const response = await fetch(`http://localhost:8080/clientes/atualizarCliente/${params.id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        // Fazendo o destructuring do cliente, pois o método POST não exige idCliente, que está presente em tipoCliente
        body: JSON.stringify(cliente),
      })


      if(response.ok){
        setMsgStatusEnvio("Cadastro realizado com sucesso!");
        setClasseMensagem("sucesso");

        setTimeout(() => {
          router.push("/");
        }, 3500);

      } else {
        setClasseMensagem("erro");
        setMsgStatusEnvio("Preencha todos os campos!");
      }
    } catch(error){
      console.error(error);
    }
  };

  useEffect(() => {
    console.log(`http://localhost:8080/clientes/${params.id}`);
    if(params.id){
        const buscaDadosUsuario = async () => {
            try{
                const response = await fetch(`http://localhost:8080/clientes/${params.id}`);
                if(response.ok){
                    const dadosUsuario = await response.json();
                    setCliente(dadosUsuario);
                    setTimeout(() => {
                        console.log(dadosUsuario);
                    }, 2000)
                }
            } catch(error){
                console.log("Ocorreu um erro ao buscar os dados do usuário.", error);
            }
        }
        buscaDadosUsuario();
    }
    
  }, [params])

  return (
    <main className="lg:py-[20vh] lg:px-[25vw]">
      <form
        className="border lg:border-slate-400 bg-slate-100 flex justify-center lg:rounded-2xl lg:py-8 lg:px-9 lg:h-fit sm:py-8 sm:px-[10vw] sm:h-[80vh] items-center"
        onSubmit={handleSubmit}
      >
        <fieldset className="w-full flex flex-col lg:gap-3 lg:text-lg lg:font-medium sm:gap-5 sm:text-lg sm:font-medium">
          <div className="text-center">
            <h1 className="lg:font-semibold lg:text-xl sm:font-semibold sm:text-xl">
              Edite seus dados
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
              value={cliente.nomeCliente}
              onChange={(event) => setCliente({...cliente, nomeCliente: event.target.value})}
              placeholder="Nome"
              minLength={3}
              required
            />
          </div>
          <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
            <label htmlFor="cpf">
              Telefone<span>*</span>
            </label>
            <input
              id="telefone"
              className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
              type="text"
              name="telefone"
              placeholder="1123456789"
              minLength={11}
              value={cliente.telefoneCliente}
              onChange={(event) => setCliente({...cliente, telefoneCliente: event.target.value})}
              required
            />
          </div>
          <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
            <label htmlFor="email">
              Endereço<span>*</span>
            </label>
            <input
              id="endereco"
              className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
              type="text"
              name="endereco"
              value={cliente.localizacaoCliente}
              onChange={(event) => setCliente({...cliente, localizacaoCliente: event.target.value})}
              placeholder="Insira seu endereço completo"
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
              value={cliente.emailCliente}
              onChange={(event) => setCliente({...cliente, emailCliente: event.target.value})}
              placeholder="Insira seu endereço completo"
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
              value={cliente.senhaCliente}
              onChange={(event) => setCliente({...cliente, senhaCliente: event.target.value})}
              minLength={8}
              required
            />
          </div>
          <button className="justify-self-start w-fit text-white bg-azul-escuro lg:text-sm lg:py-1 lg:px-4 lg:rounded-md sm:text-sm sm:py-1 sm:px-4 sm:rounded-md" type="submit">
            Editar
          </button>
          <p className={`${
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