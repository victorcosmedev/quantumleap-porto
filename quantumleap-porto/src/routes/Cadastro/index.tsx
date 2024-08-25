import style from "./Cadastro.module.css";

export default function Cadastro(){
    return(
        <main className={style.containerForm}>
        <form className={style.formulario} action="#">
          <fieldset className={style.quadrado}>
            <h1>Crie sua conta</h1>
            <p>Preencha seus dados de acesso para continuar.</p>
            <div className={style.divCampo}>
              <label htmlFor="nome">Nome<span>*</span></label>
              <input
                id="nome"
                className={style.formatacaoEntradaCampo}
                type="text"
                name="nome"
                placeholder="Nome"
              />
            </div>
            <div className={style.divCampo}>
              <label htmlFor="cpf">CPF<span>*</span></label>
              <input
                id="cpf"
                className={style.formatacaoEntradaCampo}
                type="text"
                name="cpf"
                placeholder="CPF/CNPJ"
              />
            </div>
            <div className={style.divCampo}>
              <label htmlFor="email">Email<span>*</span></label>
              <input
                id="email"
                className={style.formatacaoEntradaCampo}
                type="text"
                name="email"
                placeholder="Email"
              />
            </div>
            <div className={style.divCampo}>
              <label htmlFor="senha">Senha<span>*</span></label>
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
