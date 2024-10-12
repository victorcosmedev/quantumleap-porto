import type { Metadata } from "next";


export const metadata: Metadata = {
  title: "QuantumLeap - Porto Seguro",
  description: "QuantumLeap - Porto Seguro",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-br">
      <body>
        {children}
      </body>
    </html>
  );
}
