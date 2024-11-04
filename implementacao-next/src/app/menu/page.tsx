import Link from "next/link";

export default function Menu() {
  return (
    <main className="w-full">
      <ul className="mb-[50vh]">
        <li className="border-b border-b-azul-escuro ps-3 py-3">
          <Link href="/" className="text-decoration-none text-dark">
            Home
          </Link>
        </li>
        <li className="border-b border-b-azul-escuro ps-3 py-3">
          <Link href="/sobre-nos" className="text-decoration-none text-dark">
            Sobre nós
          </Link>
        </li>
        <li className="border-b border-b-azul-escuro ps-3 py-3">
          <Link href="/chat" className="text-decoration-none text-dark">
            Chat
          </Link>
        </li>
        <li className="border-b border-b-azul-escuro ps-3 py-3">
          <Link href="/area-cliente" className="text-decoration-none text-dark">
            Área do usuário
          </Link>
        </li>
      </ul>
    </main>
  );
}
