import { Link } from "react-router-dom";
import style from "./Menu.module.css";

export default function Menu(){

    const botaoChamarGuincho = () => {
        alert("Aguarde, estamos enviando um guincho para sua localização");
    }
    return (
        <nav className={style.containerMenu}>
            <ul className={style.botoes}>
                <li>
                    <Link to="/" className={style.botaoMenu}>Home</Link>
                    <Link to="/sobre-nos" className={style.botaoMenu}>Sobre nós</Link>
                    <Link to="/login" className={style.botaoMenu}>Login</Link>
                    <Link to="/cadastro" className={style.botaoMenu}>Cadastro</Link>
                    <Link onClick={botaoChamarGuincho}></Link>
                </li>
            </ul>
        </nav>
    );
}