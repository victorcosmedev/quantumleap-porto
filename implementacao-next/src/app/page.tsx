import motoristaAzul from "@/img/motorista-azul.jpeg";
import caminhaoPorto from "@/img/caminhao-porto.jpeg";
import Link from "next/link";
import Image from "next/image";

export default function Home() {
    return (
        <main className="font-sans grid grid-cols-2">
          <div className="sm:col-span-2 lg:col-span-1 flex justify-start items-center md:px-[5vw] md:py-[10vh] bg-gray-200">
              <div className="md:font-semibold md:text-xl">
                  <h1 className="md:font-bold md:text-2xl">Problemas com seu carro?</h1>
                  <h2 className="mb-4">Nós temos a solução</h2>
                  <Link href="/cadastro" className="border-2 border-azul-claro md:px-3 md:py-1 rounded-md text-azul-claro">Cadastre-se já</Link>
              </div>
          </div>
          <div className="sm:col-span-2 lg:col-span-1">
              <Image src={motoristaAzul} alt="" className="h-full w-full"/>
          </div>
          <div className="col-span-2 md:px-[5vw] md:py-[10vh] text-sm">
              <h1 className="font-bold text-2xl text-azul-claro mb-3">O que é o QuickFix?</h1>
              <p>
                  O QuickFix foi criado para facilitar o diagnóstico de problemas no seu veículo, seja você cliente da Porto ou não.
              </p> <br />  

              <p>
                  Acesse nossa plataforma, cadastre-se e registre seu automóvel. Em seguida, você será guiado por um robô inteligente que fará perguntas sobre o problema. Com base nas suas respostas, ele gera um diagnóstico preciso.
              </p><br />

              <p>
                  Além disso, o QuickFix sugere as peças necessárias e calcula um orçamento transparente, com base nos preços de peças e mão de obra. Tudo isso de forma online, sem precisar de um especialista no local. E o melhor: depois do diagnóstico, indicamos a oficina mais próxima para resolver o problema.
              </p><br />

              <p>
                  O QuickFix agiliza o processo de diagnóstico e orçamento, garantindo mais confiança e previsibilidade nos serviços automotivos.
              </p><br />

          </div>
          <div className="flex align-middle justify-start col-span-1 sm:col-span-2 lg:col-span-1 md:px-[5vw] md:py-[8vh] text-white bg-azul-claro">
              <div className="">
                  <h2 className="font-bold text-2xl mb-3">Problemas como:</h2>
                  <nav>
                      <ul className="list-disc list-inside">
                          <li>Alinhamento</li>
                          <li>Ar-condicionado</li>
                          <li>Arrefecimento</li>
                          <li>Balanceamento e Geometria</li>
                          <li>Correias</li>
                          <li>Discos e Pastilhas de Freio</li>
                          <li>Embreagens</li>
                          <li>Filtros</li>
                          <li>Velas de Ignição</li>
                      </ul>
                  </nav>
              </div>
          </div>
          <div className="col-span-1 sm:col-span-2 lg:col-span-1">
              <Image src={caminhaoPorto} alt="" className="h-full w-full"/>
          </div>
          <div className="col-span-2 flex flex-col items-center md:px-[5vh] md:py-[8vh] md:gap-10 bg-gray-200">
              <h1 className="md:text-3xl font-semibold">Precisa de ajuda? Fale conosco!</h1>
              <Link href="/chat" className="bg-azul-escuro text-white md:rounded-md md:px-[3vw] md:py-3 font-semibold text-lg">Iniciar Chat</Link>

              <div className="flex flex-col md:gap-10">
                  <h1 className="md:text-3xl md:font-bold">Dúvidas frequentes</h1>
                  <div className="md:rounded-md md:py-3 md:px-5 bg-gray-400">
                      <h2 className="md:mb-3 md:text-xl md:font-bold">Preciso estar logado para utilizar o chatbot?</h2>
                      <p>Sim, é necessário estar logado para utilizar o chatbot.</p>
                  </div>
                  <div className="md:rounded-md md:py-3 md:px-5 bg-gray-400">
                      <h2 className="md:mb-3 md:text-xl md:font-bold">Não entendo nada de mecânica. Ainda assim consigo usar o QuickFix?</h2>
                      <p>Sim! O QuickFix foi pensado justamente para pessoas que não têm conhecimento aprofundado em mecânica mas desejam manter a manutenção do seu veículo em dia.</p>
                  </div>

                  <div className="md:rounded-md md:py-3 md:px-5 bg-gray-400">
                      <h2 className="md:mb-3 md:text-xl md:font-bold">Como posso me cadastrar no QuickFix?</h2>
                      <p>Para cadastrar-se no QuickFix, basta <Link href="/cadastro"> clicar aqui.</Link></p>
                  </div>
              </div>
          </div>
        </main>
    );
}
