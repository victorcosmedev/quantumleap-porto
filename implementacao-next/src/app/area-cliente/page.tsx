export default function AreaCliente() {
  return (
    <main className="w-full lg:py-[25vh] lg:px-[15vw] lg:text-lg sm:py-[10vh] sm:px-[15vw] sm:text-base">
      <div className="w-full">
        <div className="flex lg:gap-3 lg:mb-3 lg:text-xl sm:gap-3 sm:mb-3 sm:text-base">
          <div className="rounded-md lg:py-1 lg:px-3 font-semibold bg-azul-escuro text-white sm:py-2 sm:px-2">
            Área do cliente
          </div>
          <div className="rounded-md font-semibold bg-slate-200 text-slate-300 lg:py-1 lg:px-3 sm:py-2 sm:px-2">
            Cadastro de veículo
          </div>
        </div>
        <div className="bg-slate-300 grid lg:grid-cols-2 sm:grid-cols-1 lg:px-[3.5%] lg:py-4 lg:rounded-md lg:gap-3 sm:px-[5%] sm:py-3 sm:rounded-md sm:gap-3">
          {/* <div className="lg:text-sm sm:col-span-2 lg:col-span-1 sm:text-sm flex flex-col sm:gap-2">
            <p className="lg:mb-3"><span className="font-semibold">Nome: </span>Eduardo Pereira Rodrigues</p>
            <p className="lg:mb-3"><span className="font-semibold">Telefone: </span>(11) 12345-6789</p>
            <p className="lg:mb-3"><span className="font-semibold">Email: </span>email@dominio.com</p>
            <p className="lg:mb-3"><span className="font-semibold">Endereço: </span>Avenida Paulista, 1313, Bela Vista - SP</p>
            <p className="lg:mb-3"><span className="font-semibold">Cliente Porto: </span>Sim</p>
          </div> */}
          <form>
            <fieldset className="grid grid-cols-2 grid-rows-3 lg:gap-x-2 sm:gap-x-2">
              <div className="w-full lg:py-2 sm:py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Montadora
                </label>
                <input
                  type="text"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: Honda"
                />
              </div>
              <div className="w-full py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Modelo
                </label>
                <input
                  type="text"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: Accord"
                />
              </div>
              <div className="w-full py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Ano
                </label>
                <input
                  type="number"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: 2010"
                />
              </div>
              <div className="w-full py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Placa do veículo
                </label>
                <input
                  type="text"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: ABC-1A34"
                />
              </div>
              <div className="w-full py-2">
                <label htmlFor="" className="lg:text-base sm:text-sm">
                  Quilometragem
                </label>
                <input
                  type="text"
                  className="w-full rounded-md lg:text-base sm:text-sm border border-slate-400 py-1 sm:px-1 lg:px-2"
                  placeholder="Ex.: 2.000"
                />
              </div>
            </fieldset>
              <button type="submit" className="bg-azul-escuro text-white lg:font-semibold lg:text-base lg:px-3 lg:py-1 lg:rounded-md sm:font-semibold sm:text-xs sm:px-3 sm:py-1 sm:rounded-md">Enviar</button>
              <p></p>
          </form>
          <div className="bg-slate-50 lg:px-2 lg:py-2 rounded-md lg:text-sm sm:text-base w-full sm:col-span-2 lg:col-span-1 sm:px-2 sm:py-2 flex flex-col sm:gap-2">
            <h1 className="font-semibold lg:mb-1 lg:text-base sm:text-sm">
              Veículos Cadastrados
            </h1>
            <div className="sm:text-sm">
              <h2 className="font-semibold">Honda Accord | ABC-12D3</h2>
              <h3>2024</h3>
            </div>
            <div className="sm:text-sm">
              <h2 className="font-semibold">Honda Accord | ABC-12D3</h2>
              <h3>2024</h3>
            </div>
            <div className="sm:text-sm">
              <h2 className="font-semibold">Honda Accord | ABC-12D3</h2>
              <h3>2024</h3>
            </div>
          </div>
        </div>
      </div>
    </main>
  );
}
