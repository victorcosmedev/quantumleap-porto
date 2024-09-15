import { Link } from "react-router-dom";
import style from "./Menu.module.css";

export default function Menu(){
    return (
        <nav className={style.containerMenu}>
            <ul className={style.botoes}>
                <li>
                    <Link to="/" className={style.botaoMenu}>Home</Link>
                    <Link to="/sobre-nos" className={style.botaoMenu}>Sobre nós</Link>
                    <Link to="/login" className={style.botaoMenu}>Login</Link>
                    <Link to="/cadastro" className={style.botaoMenu}>Cadastro</Link>
                </li>
            </ul>
        </nav>
    );
}