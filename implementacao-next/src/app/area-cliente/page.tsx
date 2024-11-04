"use client";

import { useState, useEffect } from "react";
import { signOut, useSession } from "next-auth/react";
import { TipoCliente, TipoVeiculo } from "@/types/types";
import { useRouter } from "next/navigation";
import { render } from "react-dom";
import Link from "next/link";

export default function AreaCliente() {
  const { data: session } = useSession();
  const [classeBotaoAreaDoCliente, setClasseBotaoAreaDoCliente] = useState(
    "text-white bg-azul-escuro"
  );
  const [listaDeVeiculos, setListaDeVeiculos] = useState<TipoVeiculo[]>([]);
  const [cliente, setCliente] = useState<TipoCliente>({
    idCliente: 0,
    nomeCliente: "",
    emailCliente: "",
    telefoneCliente: "",
    senhaCliente: "",
    clientePorto: false,
    localizacaoCliente: "",
  });
  const router = useRouter();

  useEffect(() => {
    if (session) {
      const buscaVeiculos = async () => {
        try {
          const response = await fetch(
            `http://localhost:8080/veiculos/buscarVeiculoCliente/${session.idCliente}`,
            {
              method: "GET",
              credentials: "include",
              headers: {
                "Content-Type": "application/json",
              },
            }
          );
          if (!response.ok) {
            throw new Error("Usuário não tem veículo");
          }
          const data = await response.json();
          setListaDeVeiculos(data);

          setTimeout(() => {
            console.log(listaDeVeiculos);
          }, 2000);
        } catch (error) {
          console.error("Erro ao buscar veículos do cliente:", error);
        }
      };

      buscaVeiculos();
      const buscaUsuario = async (idCliente: number) => {
        console.log(`http://localhost:8080/clientes/${idCliente}`);
        try {
          const response = await fetch(
            `http://localhost:8080/clientes/${idCliente}`,
            {
              method: "GET",
            }
          );
          const dadosUsuario = await response.json();
          setCliente(dadosUsuario);
        } catch (error) {
          console.log("Não foi possível carregar os dados do usuário.", error);
        }
      };

      buscaUsuario(session.idCliente);
    } else {
      router.push("/");
    }
  }, [session, router]);

  const [exibirDadosUsuario, setExibirDadosUsuario] = useState(true);

  useEffect(() => {
    renderizaAreaUsuario();
  }, [exibirDadosUsuario])  

  const deletarUsuario = () => {
    // console.log(`http://localhost:8080/clientes/deletarCliente/${cliente.idCliente}`);
    try {
      const response = fetch(`http://localhost:8080/clientes/deletarCliente/${cliente.idCliente}`, {
        method: "DELETE",
      })

      logout();

    } catch(error){
      console.log("Não foi possível deletar o usuário.", error);
    }
  }

  async function logout() {
    await signOut({
      redirect: false,
    });
    router.replace("/");
  }

  const renderizaAreaUsuario = () => {
    if (exibirDadosUsuario) {
      return(
        <div className="border border-red-600">
          <ul className="mb-3">
            <li>
              <span className="font-semibold">Nome: </span>
              {cliente.nomeCliente}
            </li>
            <li>
              <span className="font-semibold">Email: </span>{" "}
              {cliente.emailCliente}
            </li>
            <li>
              <span className="font-semibold">Telefone: </span>
              {cliente.telefoneCliente}
            </li>
            <li>
              <span className="font-semibold">Cliente Porto: </span>
              {cliente.clientePorto ? "Sim" : "Não"}
            </li>
            <li>
              <span className="font-semibold">Localização: </span>
              {cliente.localizacaoCliente}
            </li>
          </ul>
          <div className="flex gap-2">
            <Link href={`/cadastro/${session?.idCliente}`}
              className="bg-azul-escuro text-white lg:font-semibold lg:text-base lg:px-3 lg:py-1 lg:rounded-md sm:font-semibold sm:text-xs sm:px-3 sm:py-1 sm:rounded-md me-3"
            >
              Editar dados
            </Link>
            <Link href={"/"}
            onClick={() => deletarUsuario()}
            className="bg-red-600 text-white lg:font-semibold lg:text-base lg:px-3 lg:py-1 lg:rounded-md sm:font-semibold sm:text-xs sm:px-3 sm:py-1 sm:rounded-md me-3"
          >
            Excluir usuário
          </Link>
          </div>
        </div>
      )
    } else {
      return(
        <form onSubmit={handleSubmit}>
            <fieldset className="grid grid-cols-2 grid-rows-3 lg:gap-x-2 sm:gap-x-2">
              <div className="w-full lg:py-2 sm:py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Montadora
                </label>
                <input
                  type="string"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: Honda"
                  name="montadoraVeiculo"
                  value={veiculo.montadoraVeiculo}
                  onChange={(event) => setVeiculo({...veiculo,montadoraVeiculo:event.target.value})}
                />
              </div>
              <div className="w-full py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Modelo
                </label>
                <input
                  type="string"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  name='modeloVeiculo'
                  placeholder="Ex.: Accord"
                  value={veiculo.modeloVeiculo}
                  onChange={(event) => setVeiculo({...veiculo,modeloVeiculo:event.target.value})}
                />
              </div>
              <div className="w-full py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Ano
                </label>
                <input
                  type="number"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: 2010"
                  name="anoVeiculo"
                  value={veiculo.anoVeiculo}
                  onChange={(event) => setVeiculo({...veiculo,anoVeiculo: parseFloat(event.target.value)})}
               
                />
              </div>
              <div className="w-full py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Placa do veículo
                </label>
                <input
                  type="string"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: ABC-1A34"
                  name="placaVeiculo"
                  value={veiculo.placaVeiculo}
                  onChange={(event) => setVeiculo({...veiculo,placaVeiculo: event.target.value})}
               
                />
              </div>
              <div className="w-full py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Quilometragem
                </label>
                <input
                  type="number"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: 2.000"
                  name="quantidadeQuilometros"
                  value={veiculo.quantidadeQuilometros}
                  onChange={(event) => setVeiculo({...veiculo,quantidadeQuilometros: parseFloat(event.target.value)})}
               
                />
              </div>
            </fieldset>
            <button
              type="submit"
              className="bg-azul-escuro text-white lg:font-semibold lg:text-base lg:px-3 lg:py-1 lg:rounded-md sm:font-semibold sm:text-xs sm:px-3 sm:py-1 sm:rounded-md me-3"
            >
              Enviar
            </button>

            <button
              type="button"
              className="bg-orange-500 text-black lg:font-semibold lg:text-base lg:px-3 lg:py-1 lg:rounded-md sm:font-semibold sm:text-xs sm:px-3 sm:py-1 sm:rounded-md"
              onClick={() => handleUpdate()}
            >
              Editar
            </button>
          </form>
      )
    }
  }

  const [veiculo, setVeiculo] = useState<TipoVeiculo>({
    idVeiculo: 0,
    montadoraVeiculo: "",
    modeloVeiculo: "",
    anoVeiculo: 0.0,
    quantidadeQuilometros: 0.0,
    placaVeiculo: "",
    nomeCliente: session?.nomeCliente ?? "",
    idCliente: session?.idCliente ?? 0,
  });

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/veiculos", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(veiculo),
      });

      if (response.ok) {
        alert("Veículo cadastrado com sucesso!");
        setVeiculo({
          idVeiculo: 0,
          montadoraVeiculo: "",
          modeloVeiculo: "",
          anoVeiculo: 0.0,
          quantidadeQuilometros: 0.0,
          placaVeiculo: "",
          nomeCliente: session?.nomeCliente ?? "",
          idCliente: session?.idCliente ?? 0,
        });
        window.location.reload();
      }
    } catch (error) {
      console.error("Erro ao cadastrar veículo:", error);
    }
  };

  const buscarVeiculoParaEditar = (idVeiculo: number) => {
    const veiculoSelecionado: TipoVeiculo = listaDeVeiculos.find(
      (veiculo) => veiculo.idVeiculo == idVeiculo
    );
    console.log(veiculoSelecionado);
    setVeiculo(veiculoSelecionado);
  };

  const handleDelete = async (idVeiculo: number) => {
    try {
      const response = await fetch(
        `http://localhost:8080/veiculos/deletarVeiculo/${idVeiculo}`,
        {
          method: "DELETE",
        }
      );

      if (response.ok) {
        alert("Veículo deletado com sucesso!");
        window.location.reload();
      }
    } catch (error) {
      console.log("Não foi possível cadastrar o veículo.", error);
    }
  };

  const handleUpdate = async () => {
    console.log(veiculo);
    try {
      const response = await fetch(
        `http://localhost:8080/veiculos/atualizarVeiculo/${veiculo.idVeiculo}`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(veiculo),
        }
      );

      if (response.ok) {
        alert("Veículo atualizado com sucesso!");
        window.location.reload();
      }
    } catch (error) {
      console.log("Não foi possível atualizar o usuário.", error);
    }
  };

  return (
    <main className="w-full lg:py-[25vh] lg:px-[15vw] lg:text-lg sm:py-[10vh] sm:px-[15vw] sm:text-base">
      <div className="w-full">
        <div className="flex lg:gap-3 lg:mb-3 lg:text-xl sm:gap-3 sm:mb-3 sm:text-base items-center">
          <button className="rounded-md lg:py-1 lg:px-3 font-semibold bg-azul-escuro text-white sm:py-2 sm:px-2" onClick={() => setExibirDadosUsuario(true)}>
            Área do cliente
          </button>
          <button className="rounded-md lg:py-1 lg:px-3 font-semibold bg-azul-escuro text-white sm:py-2 sm:px-2" onClick={() => setExibirDadosUsuario(false)}>
            Cadastro de veículo
          </button>
          <h1>Olá, {session?.nomeCliente}</h1>
        </div>
        <div className="bg-slate-300 grid 2xl:grid-cols-2 sm:grid-cols-1 lg:px-[3.5%] lg:py-4 lg:rounded-md lg:gap-3 sm:px-[5%] sm:py-3 sm:rounded-md sm:gap-3">

          { renderizaAreaUsuario() }

          <div className="bg-slate-50 lg:px-2 lg:py-2 rounded-md lg:text-sm sm:text-base w-full sm:col-span-2 2xl:col-span-1 sm:px-2 sm:py-2 flex flex-col sm:gap-2">
            <h1 className="font-semibold lg:mb-1 lg:text-base sm:text-sm">
              Veículos Cadastrados
            </h1>
            <table className="table auto">
              <thead>
                <tr>
                  <th className="bg-slate-400">Montadora</th>
                  <th className="bg-slate-400">Modelo</th>
                  <th className="bg-slate-400">Ano Veiculo</th>
                  <th className="bg-slate-400">Placa</th>
                  <th className="bg-slate-400">Editar/ Excluir</th>
                </tr>
              </thead>
              <tbody>
                {listaDeVeiculos.map((veiculo) => (
                  <tr key={veiculo.idVeiculo}>
                    <td className="font-semibold text-center border">
                      {veiculo.montadoraVeiculo}
                    </td>
                    <td className="text-center border">
                      {veiculo.modeloVeiculo}
                    </td>
                    <td className="text-center border">{veiculo.anoVeiculo}</td>
                    <td className="text-center border">
                      {veiculo.placaVeiculo}
                    </td>
                    <td className="text-center border">
                      <button
                        onClick={() =>
                          buscarVeiculoParaEditar(veiculo.idVeiculo)
                        }
                      >
                        Editar
                      </button>{" "}
                      |{" "}
                      <button onClick={() => handleDelete(veiculo.idVeiculo)}>
                        Excluir
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </main>
  );
}