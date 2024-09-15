import style from "./Menu.module.css";

export default function Menu(){
    return (
        <nav className={style.containerMenu}>
            <ul className={style.botoes}>
                <li>
                    <a href="../index.html" className={style.botaoMenu}>Home</a>
                    <a href="../paginas/sobre-nos.html">Sobre nós</a>
                    <a href="../paginas/login.html">Login</a>
                    <a href="../paginas/cadastro.html">Cadastro</a>
                </li>
            </ul>
            <ul className={style.botaoVoltar}>
                <li>
                    <a href="../index.html"><img src="../img/icone-voltar.png" alt="" /></a>
                </li>
            </ul>
        </nav>
    );
}