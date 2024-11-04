import Cabecalho from "@/components/Cabecalho/Cabecalho";
import Rodape from "@/components/Rodape/Rodape";
import type { Metadata } from "next";
import { Inter } from "@next/font/google";
import "@/app/globals.css";
import NextAuthSessionProvider from "@/providers/sessionProvider";

export const metadata: Metadata = {
  title: "QuantumLeap - Porto Seguro",
  description: "QuantumLeap - Porto Seguro",
};

const inter = Inter({
  subsets: ["latin"],
  weight: ["400", "500", "600", "700", "800", "900"],
  display: "swap",
  variable: "--font-inter",
});

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-br" className={`${inter.variable}`}>
      <body>
        <NextAuthSessionProvider>
          <Cabecalho />
          {children}
          <Rodape />
        </NextAuthSessionProvider>
      </body>
    </html>
  );
}
