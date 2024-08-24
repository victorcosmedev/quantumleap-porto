import styles from "./Cabecalho.module.css";
import logo from "../../img/logo-porto.png";
import hamburguer from "../../img/icone-hamburguer.png";

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
              <a href="./paginas/menu.html"
                ><img
                  src={hamburguer}
                  alt="menu com mais opções"
                  className={styles.iconehamburguer}
                />
              </a>
            </li>
          </ul>
          <ul className={styles.linksesquerda}>
            <li className={styles.link}><a href="./index.html">Home</a></li>
            <li className={styles.link}><a href="./paginas/sobre-nos.html">Sobre nós</a></li>
          </ul>
          <ul className={styles.linksdireita}>
            <li className={styles.link}><a href="./paginas/login.html">Login</a></li>
          </ul>
        </nav>
      </header>
    )
}