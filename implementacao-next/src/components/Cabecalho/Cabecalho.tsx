"use client"

import Image from "next/image";
import Link from "next/link";
import imgLogo from "@/img/logo-porto.png";
import iconeUsuario from "@/img/icone-usuario.png";
import iconeMenu from "@/img/icone-hamburguer.png";
import { useEffect, useState } from "react";
import { useRouter } from "next/router";
import { Inter } from "@next/font/google";

const inter = Inter({
  subsets: ['latin'],
  weight: ['400', '500', '600', '700', '800', '900'],
  display: 'swap',
  variable: '--font-inter',
});

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
    <header className="flex justify-between items-center lg:h-[10vh] lg:py-[2vh] lg:px-[5vw] lg:gap-[2vw] sm:h-[10vh] sm:py-[3vh] sm:px-[5vw] sm:gap-[2vw]">
      <Image src={imgLogo} alt="Logo da Porto Seguro" width="200" height="100" className="w-auto h-[6vh]"/>
      <nav className="flex lg:w-full justify-between items-center">
        <ul className="sm:block lg:hidden h-full">
          <li className="h-full">
            <Link href="/" className="w-full h-auto">
              <Image
                src={iconeMenu}
                alt="menu com mais opções"
                width={200}
                height={100}
                className="w-auto h-[5vh]"
              />
            </Link>
          </li>
        </ul>
        <ul className="gap-3 text-base lg:font-semibold lg:flex sm:hidden">
          <li className="">
            <Link href={"/"}>Home</Link>
          </li>
          <li>
            <Link href={"/sobre-nos"}>Sobre nós</Link>
          </li>
          <li>
            <Link href={"/"}>Pedir  Guincho</Link>
          </li>
        </ul>
        <div className="lg:flex sm:hidden items-center justify-between gap-4 h-full">
          <div className="">
            <button className="bg-blue-800 rounded-md text-white 2xl:px-3 2xl:py-1 2xl:font-semibold lg:font-semibold lg:px-3 lg:py-0.5 lg:text-sm" onClick={botaoSair}>{conteudoBotao}</button>
          </div>
          <Link href="/area-cliente" className="block h-full lg:w-[4.5vw]">
            <Image src={iconeUsuario} alt="" width={200} height={100} className="w-auto h-full"/>
          </Link>
        </div>
      </nav>
    </header>
  );
}
