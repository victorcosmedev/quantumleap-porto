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

  const acaoBotao = () => {
    const usuarioLogado = sessionStorage.getItem('usuarioAutenticado');
    if(usuarioLogado){
      sessionStorage.removeItem('usuarioAutenticado');
      
      
      navigate("/");
      window.location.reload();
      
    } else {
      navigate("/login");
    }
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
        </ul>
        <div className={styles.linksdireita}>
          <div className={styles.link}>
            <button className={styles.cadastreSe} onClick={acaoBotao}>{conteudoBotao}</button>
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