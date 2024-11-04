"use client"
import { signIn } from "next-auth/react";
import { useRouter } from "next/navigation";
import Link from "next/link";
import { SyntheticEvent, useState } from "react";

export default function Login(){


    const router = useRouter();
    const [email, setEmail] = useState<string>('')
    const [senha, setSenha] = useState<string>('')

    async function handleSubmit(event: SyntheticEvent){
        event.preventDefault()
        const result = await signIn('credentials', {
            email,
            senha,
            redirect: false
        })

        if (result?.error) {
            console.log(result)
            return
        }
        router.replace('/area-cliente')
    }
    
  return(
    <main className="lg:py-[20vh] lg:px-[25vw]">
      <form className="border lg:border-slate-400 bg-slate-100 flex justify-center lg:rounded-2xl lg:py-8 lg:px-9 lg:h-fit sm:py-8 sm:px-[10vw] sm:h-[80vh] items-center" onSubmit={handleSubmit}>
          <fieldset className="w-full flex flex-col lg:gap-3 lg:text-lg lg:font-medium sm:gap-5 sm:text-lg sm:font-medium">
              <div className="text-center">
                <h1 className="lg:font-semibold lg:text-xl sm:font-semibold sm:text-xl">Acessar Conta</h1>
                <p className="lg:text-base sm:text-base">Não tem cadastro? <Link href="/cadastro">Cadastre-se já!</Link></p>
              </div>
              
              <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
                  <label htmlFor="email">Email</label>
                  <input
                  id="email"
                  className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
                  type="text"
                  name="email"
                  placeholder="Email"
                  onChange={(e) => setEmail(e.target.value)}
                  required
                  />
              </div>
              <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
                  <label htmlFor="senha">Senha</label>
                  <input
                  id="senha"
                  className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
                  type="password"
                  name="senha"
                  placeholder="Senha"
                  onChange={(e) => setSenha(e.target.value)}
                  required
                  />
              </div>
              <button className="justify-self-start w-fit text-white bg-azul-escuro lg:text-sm lg:py-1 lg:px-4 lg:rounded-md sm:text-sm sm:py-1 sm:px-4 sm:rounded-md" type="submit">Enviar</button>
            
          </fieldset>
      </form>
    </main>
  );
} 