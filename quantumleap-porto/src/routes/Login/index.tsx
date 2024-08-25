import styles from "./Login.module.css";

export default function Login(){
    return(
        <main className={styles.containerForm}>
        <form className={styles.formulario}>
            <fieldset className={styles.quadrado}>
            <h1>Acessar Conta</h1>
            <p>Preencha seus dados de acesso para continuar.</p>
            <div className="div-campo">
                <label htmlFor="cpf">Email</label>
                <input
                id="cpf"
                className="formatacao-entrada-campo"
                type="password"
                name="senha"
                placeholder="CPF / CNPJ"
                />
            </div>
            <div className="div-campo">
                <label htmlFor="senha">Senha</label>
                <input
                id="senha"
                className="formatacao-entrada-campo"
                type="password"
                name="senha"
                placeholder="Senha"
                />
            </div>
            <button className="enviar" type="submit">Enviar</button>
            </fieldset>
        </form>
        </main>
    );
}