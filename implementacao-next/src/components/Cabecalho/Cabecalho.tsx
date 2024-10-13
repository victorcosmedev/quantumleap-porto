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
    <header className="flex border-solid border-2 border-red-600 align-middle justify-between w-100 gap-6 2xl:px-[75px] 2xl:h-[13vh] 2xl:py-3 lg:px-[75px] lg:h-[13vh] lg:py-2">
      <Image src={imgLogo} alt="Logo da Porto Seguro" width="200" height="100" className="border-solid border-2 w-[auto]" layout="intrinsic"/>
      <nav className="border-solid border-2 border-blue-700 flex align-middle justify-between 2xl:w-[100%] lg:w-[100%]">
        <ul className="hamburguer">
          <li>
            <Link href="/">
              <Image
                src={'/'}
                alt="menu com mais opções"
                width={200}
                height={100}
                layout="intrinsic"
              />
            </Link>
          </li>
        </ul>
        <ul className="flex list-none border border-3 border-green-600 items-center links-header 2xl:gap-x-5 2xl:text-xl lg:gap-x-5 lg:text-md md:text-sm sm:gap-x-5 sm:text-md">
          <li className="">
            <Link href={"/"} className="2xl:font-semibold lg:font-semibold">Home</Link>
          </li>
          <li>
            <Link href={"/sobre-nos"} className="2xl:font-semibold lg:font-semibold">Sobre nós</Link>
          </li>
          <li>
            <Link href={"/"} className="2xl:font-semibold lg:font-semibold">Pedir Guincho</Link>
          </li>
        </ul>
        <div className="flex items-center gap-4">
          <div className="">
            <button className="bg-blue-800 rounded-md text-white 2xl:px-3 2xl:py-1 2xl:font-semibold lg:font-semibold lg:px-3 lg:py-0.5 lg:text-sm" onClick={botaoSair}>{conteudoBotao}</button>
          </div>
          <div className="h-full">
            <Link href="/area-cliente">
              <Image src={iconeUsuario} alt="" width={200} height={100} className="2xl:w-auto 2xl:h-full lg:w-auto lg:h-full"/>
            </Link>
          </div>
        </div>
      </nav>
    </header>
  );
}
