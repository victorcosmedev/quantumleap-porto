import styles from "./Cabecalho.module.css";
import logo from "../../img/logo-porto.png";
import hamburguer from "../../img/icone-hamburguer.png";
import { Link } from "react-router-dom";

export default function Cabecalho (){
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
              <Link to="./paginas/menu.html"
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
              <Link className={styles.cadastreSe} to="/login">Entrar</Link>
            </div>
            <div>
              <img src="/img/icone-usuario.png" alt="" />
            </div>
          </div>
        </nav>
      </header>
    )
}