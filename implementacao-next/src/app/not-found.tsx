import Image from "next/image";


export default function NotFound() {
  return (
    <div>
      <h1>Pagina nao encontrada</h1>
      <Image src="/public/img/242683-P3BXMN-354.jpg" alt="Página de Erro" width={200} height={50} placeholder="blur" blurDataURL="/blur.jpg" layout="responsive"/>
      <h2>Teste</h2>
    </div>
  )
}
