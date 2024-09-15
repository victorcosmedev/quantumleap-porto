import style from "./Login.module.css";

export default function Login(){
    const listaUsuarios = [
        {emailUsuario:"arthur@email.com",nomeUsuario:"Arthur",senhaUsuario:"554848"},
        {emailUsuario:"lucas@email.com",nomeUsuario:"Lucas",senhaUsuario:"557569"},
        {emailUsuario:"victor@email.com",nomeUsuario:"Victor",senhaUsuario:"558856"},
        {nomeUsuario:"9027908",senhaUsuario:"017972b8d104efcf41a8f034d3"},
    ];
    



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