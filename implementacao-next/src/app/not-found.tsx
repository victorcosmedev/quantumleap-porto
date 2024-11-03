import Link from "next/link";

export default function NotFound() {
  return (
    <main className="lg:h-[80vh] flex items-center justify-center">
      <div className="border border-red-600 text-center">
        <h1 className="lg:font-bold lg:text-2xl">Opa! Infelizmente <span className="text-azul-escuro">não conseguimos encontrar o que você queria.</span></h1>
        <p className="lg:font-semibold lg:text-lg"><Link href={"/"} className="text-azul-escuro underline underline-offset-3">Clique aqui</Link> para voltar à página inicial.</p>
      </div>
    </main>
  )
}
