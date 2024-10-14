import Image from "next/image";
import fotoArthur from "@/img/foto-arthur.png";
import fotoLucas from "@/img/foto-lucas.jpg";
import fotoVictor from "@/img/foto-victor.jpg"

export default function SobreNos() {
    return (
        <main className="container border-2 border-blue-600 mx-auto px-4 py-8">
            <section className="flex flex-col gap-8">
                <h1 className="text-4xl font-bold">Sobre nós</h1>
                <div className="card-integrante">
                    <Image
                        className=""
                        src={fotoArthur}
                        alt="foto arthur"
                        width={100}
                        height={100}
                        layout="intrinsic"
                    />
                    <div className="">
                        <h2>Arthur Eduardo Luna Pulini - Turma 1TDSPY</h2>
                        <h4>RM 554848</h4>
                    </div>
                </div>
                <div className="card-integrante">
                    <Image
                        className=""
                        src={fotoLucas}
                        alt="foto lucas"
                        width={100}
                        height={100}
                        layout="intrinsic"
                    />
                    <div className="">
                        <h2>Lucas Almeida Fernandes de Moraes - Turma 1TDSPY</h2>
                        <h4>RM 557569</h4>
                    </div>
                </div>
                <div className="card-integrante">
                    <Image
                        className=""
                        src={fotoVictor}
                        alt="foto victor"
                        width={100}
                        height={100}
                        layout="intrinsic"
                    />
                    <div className="">
                        <h2>Victor Nascimento Cosme - Turma 1TDSPY</h2>
                        <h4>RM 558856</h4>
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
