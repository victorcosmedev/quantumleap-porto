import style from "./Login.module.css";

export default function Login(){
    return(
        <main className={style.containerForm}>
        <form className={style.formulario}>
            <fieldset className={style.quadrado}>
                <h1>Acessar Conta</h1>
                <p>Preencha seus dados de acesso para continuar.</p>
                
                <div className={style.divCampo}>
                    <label htmlFor="cpf">Email</label>
                    <input
                    id="cpf"
                    className={style.formatacaoEntradaCampo}
                    type="password"
                    name="senha"
                    placeholder="CPF / CNPJ"
                    />
                </div>
                <div className={style.divCampo}>
                    <label htmlFor="senha">Senha</label>
                    <input
                    id="senha"
                    className={style.formatacaoEntradaCampo}
                    type="password"
                    name="senha"
                    placeholder="Senha"
                    />
                </div>
                <button className={style.enviar} type="submit">Enviar</button>
            </fieldset>
        </form>
        </main>
    );
}