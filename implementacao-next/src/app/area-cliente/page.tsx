

export default function AreaCliente() {
  return (
    <main className="w-full py-[25vh] px-[15vw] lg:text-lg">
      <div className="w-full">
        <div className="flex gap-3 lg:mb-3">
          <div className="rounded-md lg:py-1 lg:px-3 font-semibold bg-azul-escuro text-white lg:text-xl">Hello World</div>
          <div className="rounded-md lg:py-1 lg:px-3 font-semibold bg-azul-escuro text-white lg:text-xl">Hello World</div>
        </div>
        <div className="bg-slate-300 flex lg:px-[5%] lg:py-5 lg:rounded-md lg:flex-row lg:justify-between lg:gap-3">
          <div className="lg:text-sm">
            <p className="lg:mb-3"><span className="font-semibold">Nome: </span>Eduardo Pereira Rodrigues</p>
            <p className="lg:mb-3"><span className="font-semibold">Telefone: </span>(11) 12345-6789</p>
            <p className="lg:mb-3"><span className="font-semibold">Email: </span>email@dominio.com</p>
            <p className="lg:mb-3"><span className="font-semibold">Endereço: </span>Avenida Paulista, 1313, Bela Vista - SP</p>
            <p className="lg:mb-3"><span className="font-semibold">Cliente Porto: </span>Sim</p>
          </div>
          <div className="bg-slate-50 lg:px-2 lg:py-2 rounded-md lg:text-sm">
            <h1 className="font-semibold lg:mb-1 lg:text-base">Veículos Cadastrados</h1>
            <div className="border">
              <h2 className="font-semibold">Honda Accord | ABC-12D3</h2>
              <h3>2024</h3>
            </div>
            <div className="border">
              <h2 className="font-semibold">Honda Accord | ABC-12D3</h2>
              <h3>2024</h3>
            </div>
            <div className="border">
              <h2 className="font-semibold">Honda Accord | ABC-12D3</h2>
              <h3>2024</h3>
            </div>
          </div>
        </div>
      </div>
    </main>
  )
}
