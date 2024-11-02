'use client'

import { signOut } from "next-auth/react";
import { useRouter } from 'next/navigation';

export default function ButtonLogout() {
  const router = useRouter();

  async function logout() {
    await signOut({
      redirect: false,
    });
    router.replace("/");
  }

  return ( 
    <button
      onClick={logout}
      className="bg-red-600 rounded-md text-white 2xl:px-3 2xl:py-1 2xl:font-semibold lg:font-semibold lg:px-3 lg:py-0.5 lg:text-sm"
    >
      Deslogar
    </button>
  );
}
