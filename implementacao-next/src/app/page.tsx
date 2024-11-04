import motoristaAzul from "@/img/motorista-azul.jpeg";
import caminhaoPorto from "@/img/caminhao-porto.jpeg";
import Link from "next/link";
import Image from "next/image";

export default function Home() {
  return (
    <main className="font-sans grid grid-cols-2">
      <div className="sm:bg-motorista-azul sm:col-span-2 lg:bg-none lg:col-span-1">
        <div className="flex h-full justify-start items-center lg:bg-gray-200 lg:bg-none sm:bg-gray-950/[0.65] sm:text-white lg:text-black md:px-[5vw] md:py-[10vh] sm:px-[5vw] sm:py-[8vh]">
          <div className="md:font-semibold md:text-xl sm:font-semibold sm:text-base">
            <h1 className="md:font-bold md:text-2xl sm:font-bold sm:text-lg">
              Problemas com seu carro?
            </h1>
            <h2 className="mb-4">Nós temos a solução</h2>
            <Link
              href="/cadastro"
              className="rounded-md lg:border-2 sm:border-0 lg:border-azul-claro lg:text-azul-claro sm:text-white lg:bg-inherit sm:bg-azul-claro md:px-3 md:py-1 sm:px-3 sm:py-1"
            >
              Cadastre-se já
            </Link>
          </div>
        </div>
      </div>

      <div className="sm:col-span-2 lg:col-span-1 sm:hidden lg:block ">
        <Image src={motoristaAzul} alt="" className="h-full w-full" />
      </div>
      <div className="col-span-2 text-sm lg:px-[5vw] lg:py-[10vh] sm:px-[7vw] sm:py-[8vh] ">
        <h1 className="font-bold text-2xl text-azul-claro mb-3">
          O que é o QuickFix?
        </h1>
        <p>
          O QuickFix foi criado para facilitar o diagnóstico de problemas no seu
          veículo, seja você cliente da Porto ou não.
        </p>
        <br />
        <p>
          Acesse nossa plataforma, cadastre-se e registre seu automóvel. Em
          seguida, você será guiado por um robô inteligente que fará perguntas
          sobre o problema. Com base nas suas respostas, ele gera um diagnóstico
          preciso.
        </p>
        <br />
        <p>
          Além disso, o QuickFix sugere as peças necessárias e calcula um
          orçamento transparente, com base nos preços de peças e mão de obra.
          Tudo isso de forma online, sem precisar de um especialista no local. E
          o melhor: depois do diagnóstico, indicamos a oficina mais próxima para
          resolver o problema.
        </p>
        <br />
        <p>
          O QuickFix agiliza o processo de diagnóstico e orçamento, garantindo
          mais confiança e previsibilidade nos serviços automotivos.
        </p>
        <br />
      </div>
      <div className="flex items-center text-white bg-azul-claro lg:justify-start sm:col-span-2 lg:col-span-1 lg:px-[5vw] lg:py-[8vh] sm:px-[6vw] sm:py-[8vh]">
        <div className="h-fit">
          <h2 className="font-bold mb-3 lg:text-2xl sm:text-xl">Problemas como:</h2>
          <nav className="">
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
      <div className="col-span-1 sm:col-span-2 lg:col-span-1 sm:hidden lg:block">
        <Image src={caminhaoPorto} alt="" className="h-full w-full" />
      </div>
      <div className="col-span-2 flex flex-col items-center bg-gray-200 lg:px-[5vh] lg:py-[10vh] lg:gap-10 sm:px-[6vw] sm:py-[8vh] sm:gap-7">
        <h1 className="sm:text-lg sm:font-semibold lg:text-3xl lg:font-bold">
          Precisa de ajuda? Fale conosco!
        </h1>
        <Link
          href="/chat"
          className="bg-azul-escuro text-white rounded-md sm:text-base sm:font-semibold lg:font-semibold lg:text-lg lg:px-[3vw] lg:py-3 sm:px-[3vw] sm:py-2"
        >
          Iniciar Chat
        </Link>

        <div className="flex flex-col sm:gap-7 lg:gap-10 sm:text-sm lg:text-xl">
          <h1 className="sm:font-semibold lg:text-3xl sm:text-lg lg:font-bold">Dúvidas frequentes</h1>
          <div className="rounded-md bg-gray-400 lg:py-3 lg:px-5 sm:py-3 sm:px-5">
            <h2 className="lg:mb-3 lg:font-bold sm:font-semibold sm:mb-1">
              Preciso estar logado para utilizar o chatbot?
            </h2>
            <p>Sim, é necessário estar logado para utilizar o chatbot.</p>
          </div>
          <div className="rounded-md bg-gray-400 lg:py-3 lg:px-5 sm:py-3 sm:px-5">
            <h2 className="lg:mb-3 lg:font-bold sm:font-semibold sm:mb-1">
              Não entendo nada de mecânica. Ainda assim consigo usar o QuickFix?
            </h2>
            <p>
              Sim! O QuickFix foi pensado justamente para pessoas que não têm
              conhecimento aprofundado em mecânica mas desejam manter a
              manutenção do seu veículo em dia.
            </p>
          </div>

          <div className="rounded-md bg-gray-400 lg:py-3 lg:px-5 sm:py-3 sm:px-5">
            <h2 className="lg:mb-3 lg:font-bold sm:font-semibold sm:mb-1">
              Como posso me cadastrar no QuickFix?
            </h2>
            <p>
              Para cadastrar-se no QuickFix, basta{" "}
              <Link href="/cadastro"> clicar aqui.</Link>
            </p>
          </div>
        </div>
      </div>
    </main>
  );
}
