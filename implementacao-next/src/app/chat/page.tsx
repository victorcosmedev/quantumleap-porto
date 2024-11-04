"use client"

import { Problema } from "@/types/types";
import Link from "next/link";
import { useState } from "react"

export default function Chat() {
  const [problemaEnviado, setProblemaEnviado] = useState<Problema>({
    problema: ""
  });

  const [diagnostico, setDiagnostico] = useState("")
  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log(problemaEnviado);
    try {
      const response = await fetch("http://127.0.0.1:5000/predict",{
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(problemaEnviado),
      })
      
      if(response.ok){
        const data = await response.json();
        setDiagnostico(data);
      }
    } catch(error){
      console.log(error);
    }
    
  }


  return (
    <main className="w-full flex flex-col justify-center items-center px-[15vw] py-[20vh] ">
      <form
      className="border lg:border-slate-400 bg-slate-100 flex justify-center lg:rounded-2xl lg:py-8 lg:px-9 lg:h-fit sm:py-8 sm:px-[10vw] sm:h-[80vh] items-center"
      onSubmit={handleSubmit}
    >
      <fieldset className="w-full flex flex-col lg:gap-3 lg:text-lg lg:font-medium sm:gap-5 sm:text-lg sm:font-medium">
        <div className="text-center">
          <h1 className="lg:font-semibold lg:text-xl sm:font-semibold sm:text-xl">
            Chatbot
          </h1>
          <p className="lg:text-base sm:text-base">
            Descreva seu problema abaixo para que o chatbot realize o diagnóstico.
          </p>
        </div>
        <div className="flex flex-col w-full lg:gap-1 sm:gap-1">
          <label htmlFor="nome">
            Mensagem<span></span>
          </label>
          <input
            id="mensagem"
            className="border rounded-md lg:py-1 lg:px-3 lg:text-sm sm:py-1 sm:px-3 sm:text-sm"
            type="text"
            name="mensagem"
            value={problemaEnviado.problema}
            onChange={(e) => setProblemaEnviado({ problema: e.target.value })}
            placeholder="Mensagem"
            minLength={3}
            required
          />
        </div>

        <button className="justify-self-start w-fit text-white bg-azul-escuro lg:text-sm lg:py-1 lg:px-4 lg:rounded-md sm:text-sm sm:py-1 sm:px-4 sm:rounded-md" type="submit">
          Enviar
        </button>
      </fieldset>
    </form>
    <div className="flex flex-col sm:gap-3 lg:gap-10 sm:text-sm lg:text-xl mt-6">
        <h1 className="sm:font-semibold lg:text-3xl sm:text-lg lg:font-bold">Resposta da IA</h1>
        <div className="rounded-md bg-gray-400 lg:py-3 lg:px-5 sm:py-3 sm:px-5">
          <h2 className="lg:mb-3 lg:font-bold sm:font-semibold sm:mb-1">
            De acordo com o que você inseriu, seu problema é: 
          </h2>
          <p>{ diagnostico }</p>
        </div>
          
        </div>
    </main>
  )
}