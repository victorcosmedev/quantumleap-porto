"use client"
export default function Chat() {
  const handleSubmit = () => {
    console.log("teste");
  }

  return (
    <main className="w-full flex justify-center items-center px-[15vw] py-[20vh] ">
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
    </main>
  )
}