"use client"

import Image from "next/image";
import Link from "next/link";
import imgLogo from "@/img/logo-porto.png";
import iconeUsuario from "@/img/icone-usuario.png";
import { useEffect, useState } from "react";
import { useRouter } from "next/router";

export default function Cabecalho() {

  const [conteudoBotao, setConteudoBotao] = useState("");
  // const router = useRouter();
  const [usuarioLogado, setUsuarioLogado] = useState(sessionStorage.getItem('usuarioAutenticado'));
  
  useEffect(() => {
    
    console.log("Usuário está logado? " + usuarioLogado);

    if(usuarioLogado !== null){
      setConteudoBotao("Sair");
    } else {
      setConteudoBotao("Entrar");
    }
  }, [usuarioLogado]);

  const botaoSair = () => {
    const usuarioLogado = sessionStorage.getItem('usuarioAutenticado');
    if(usuarioLogado){
      sessionStorage.removeItem('usuarioAutenticado');
      
      
      // router.push("/");
      window.location.reload();
      
    } else {
      // router.push("/login");
    }
  }

  const botaoChamarGuincho = () => {
    alert("Aguarde, estamos enviando um guincho para sua localização");
  }

  return (
    <header className="flex border-solid border-2 border-red-600 align-middle justify-between w-100 px-[75px] h-[13vh] py-3 gap-6">
      <Image src={imgLogo} alt="Logo da Porto Seguro" width="200" height="100" className="border-solid border-2 w-[auto]" layout="intrinsic"/>
      <nav className="border-solid border-2 border-blue-700 flex align-middle justify-between w-[100%]">
        <ul className="hamburguer">
          <li>
            <Link href="/">
              <Image
                src={'/'}
                alt="menu com mais opções"
                width={200}
                height={100}
                layout="intrinsic"
                className="image"
              />
            </Link>
          </li>
        </ul>
        <ul className="flex gap-x-5 list-none border border-3 border-green-600 items-center links-header">
          <li className="">
            <Link href={"/"} className=" font-semibold text-xl">Home</Link>
          </li>
          <li>
            <Link href={"/sobre-nos"} className="font-semibold text-xl">Sobre nós</Link>
          </li>
          <li>
            <Link href={"/"} className="font-semibold text-xl">Pedir Guincho</Link>
          </li>
        </ul>
        <div className="flex items-center gap-4">
          <div className="">
            <button className="bg-blue-800 px-3 py-1 rounded-md text-white font-semibold" onClick={botaoSair}>{conteudoBotao}</button>
          </div>
          <div className="h-full">
            <Link href="/area-cliente">
              <Image src={iconeUsuario} alt="" width={200} height={100} className="w-auto h-full "/>
            </Link>
          </div>
        </div>
      </nav>
    </header>
  );
}
