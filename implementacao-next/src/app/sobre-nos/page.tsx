import Image from "next/image";
import fotoArthur from "@/img/foto-arthur.png";
import fotoLucas from "@/img/foto-lucas.jpg";
import fotoVictor from "@/img/foto-victor.jpg"

export default function SobreNos() {
    return (
        <main className="container mx-auto lg:px-[15%] md:px-[10%] sm:px-[10%] py-8">
            <section className="flex flex-col gap-8">
                <h1 className="lg:text-4xl md:text-2xl font-bold sm:text-2xl">Sobre nós</h1>
                <div className="flex w-full items-center md:flex-row sm:flex-col sm:items-center">
                    <Image
                        className="rounded-full h-full w-auto mr-8"
                        src={fotoArthur}
                        alt="foto arthur"
                        width={100}
                        height={100}
                    />
                    <div className="font-black flex sm:flex-col sm:items-center sm:text-xs sm:text-center md:items-start md:text-base md:text-start">
                        <h2>Arthur Eduardo Luna Pulini - Turma 1TDSPY</h2>
                        <h4 className="text-slate-500">RM 554848</h4>
                    </div>
                </div>
                <div className="flex w-full items-center md:flex-row sm:flex-col sm:items-center">
                    <Image
                        className="rounded-full h-full w-auto mr-8"
                        src={fotoLucas}
                        alt="foto lucas"
                        width={100}
                        height={100}
                    />
                    <div className="font-black flex sm:flex-col sm:items-center sm:text-xs sm:text-center md:items-start md:text-base md:text-start">
                        <h2>Lucas Almeida Fernandes de Moraes - Turma 1TDSPY</h2>
                        <h4 className="text-slate-500">RM 557569</h4>
                    </div>
                </div>
                <div className="flex w-full items-center md:flex-row sm:flex-col sm:items-center">
                    <Image
                        className="rounded-full h-full w-auto mr-8"
                        src={fotoVictor}
                        alt="foto victor"
                        width={100}
                        height={100}
                    />
                    <div className="font-black flex sm:flex-col sm:items-center sm:text-xs sm:text-center md:items-start md:text-base md:text-start">
                        <h2>Victor Nascimento Cosme - Turma 1TDSPY</h2>
                        <h4 className="text-slate-500">RM 558856</h4>
                    </div>
                </div>

                <nav className="">
                    <ul className="list-disc">
                        <li>
                            <a href="https://github.com/victorcosmedev/quantumleap-porto" className="underline text-blue-600 underline-offset-2">
                                Link para o repositório
                            </a>
                        </li>
                    </ul>
                </nav>
            </section>
        </main>
    );
}
