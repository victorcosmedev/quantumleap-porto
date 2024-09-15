import styles from "./Cabecalho.module.css";
import logo from "../../img/logo-porto.png";
import hamburguer from "../../img/icone-hamburguer.png";
import { Link, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

export default function Cabecalho (){

  const [conteudoBotao, setConteudoBotao] = useState("");
  const navigate = useNavigate();
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
      
      
      navigate("/");
      window.location.reload();
      
    } else {
      navigate("/login");
    }
  }

  const botaoChamarGuincho = () => {
    alert("Aguarde, estamos enviando um guincho para sua localização");
  }


  return(
    <header className={styles.cabecalho}>
      <img
        className={styles.logo}
        src={logo}
        alt="Logo da Porto Seguro"
        width="200"
        height="100"
      />
      <nav>
        <ul className={styles.hamburguer}>
          <li>
            <Link to="/menu"
              ><img
                src={hamburguer}
                alt="menu com mais opções"
                className={styles.iconehamburguer}
              />
            </Link>
          </li>
        </ul>
        <ul className={styles.linksesquerda}>
          <li className={styles.link}><Link to="/">Home</Link></li>
          <li className={styles.link}><Link to="/sobre-nos">Sobre nós</Link></li>
          <li className={styles.link}><Link onClick={botaoChamarGuincho}>Pedir Guincho</Link></li>
        </ul>
        <div className={styles.linksdireita}>
          <div className={styles.link}>
            <button className={styles.cadastreSe} onClick={botaoSair}>{conteudoBotao}</button>
          </div>
          <div className={styles.divIconeUsuario}>
            <Link to="/area-cliente">
              <img src="/img/icone-usuario.png" alt="" />
            </Link>
          </div>
        </div>
      </nav>
    </header>
  )
}