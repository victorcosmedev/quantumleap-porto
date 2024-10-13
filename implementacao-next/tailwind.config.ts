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
        "bg-blue-800": "#0046C7",
      },
      screens: {
        '2xl': "1200px",
        'xl': '992px',
        'lg': '768px',
        'md': '576px',
        'sm': '0px'
      }
    },
  },
  plugins: [],
};
export default config;
