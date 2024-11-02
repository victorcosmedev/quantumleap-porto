import NextAuth from "next-auth";

declare module "next-auth" {
  interface Session {
    idCliente: number;
    nomeCliente: string;
    emailCliente: string;
    telefoneCliente: string;
    senhaCliente: string;
    clientePorto: boolean;
    localizacaoCliente: string;
  }
}
