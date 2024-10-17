import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        background: "var(--background)",
        foreground: "var(--foreground)",
        "azul-escuro": "#0046C7",
        "azul-claro": "#01A1FD",
      },
      screens: {
        '2xl': "1200px",
        'xl': '992px',
        'lg': '768px',
        'md': '576px',
        'sm': '414px'
      },
      fontFamily: {
        sans: ['var(--font-inter)']
      }
    },
  },
  plugins: [],
};
export default config;
