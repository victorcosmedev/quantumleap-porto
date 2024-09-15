import { Link } from "react-router-dom";
import style from "./Error.module.css";

export default function Error(){
    return(
        <div className={style.containerErro}>
            <h1>Parece que você se perdeu.</h1><br/>
            <h3><Link to="/">Clique aqui</Link> para voltar à página principal.</h3>
        </div>
    );
}