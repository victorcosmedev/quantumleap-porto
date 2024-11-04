import NextAuth, { NextAuthOptions } from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";

const nextAuthOptions: NextAuthOptions = {
    providers: [
        CredentialsProvider({
            name: 'credentials',
            credentials: {
                email: { label: 'email', type: 'text' },
                senha: { label: 'senha', type: 'password' }
            },
            async authorize(credentials) {
                const response = await fetch('http://localhost:8080/clientes/login', {
                    method: "POST",
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        email: credentials?.email,
                        senha: credentials?.senha 
                    }),
                });

                const user = await response.json();

                if (user && response.ok) {
                    return user; 
                }
                return null; 
            }
        })
    ],
    pages: {
        signIn: '/area-cliente'
    },
    callbacks: {
		async jwt({ token, user }) {
			if (user) {
                token.user = user;
            }
            return token;
		},
		async session({ session, token }){
			session = token.user as any
			return session
		}
	}
}
;

const handler = NextAuth(nextAuthOptions);
export { handler as GET, handler as POST, nextAuthOptions }; 