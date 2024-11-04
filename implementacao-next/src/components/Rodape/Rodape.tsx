import Image from "next/image";
import logoTwitter from "@/img/twitter-logo.png";
import logoFacebook from "@/img/facebook-logo.png";
import logoInstagram from "@/img/instagram-logo.png";
import logoLinkedin from "@/img/linkedin-logo.png";
import logoYoutube from "@/img/youtube-logo.png";
import logoTiktok from "@/img/tiktok-logo.png";
import logoAppleStore from "@/img/apple-store-icone.png";
import logoPlayStore from "@/img/google-play-icone.png";
import logoPorto from "@/img/logo-porto.png";

export default function Rodape() {
  return (
    <footer className="w-full flex items-center justify-between px-[10vw] md:gap-[40vw] sm:gap-[20vw] py-6  bg-black">
      <nav className="flex gap-2 flex-col sm:w-[25%] md:w-[20%]">
        <ul className="flex gap-3 xl:gap-2 lg:gap-1 md:gap-1 sm:gap-1">
          <li>
            <a href="https://twitter.com/portoseguro" target="_blank"
              ><Image
                src={logoTwitter}
                alt="logo do twitter"
                className="h-auto w-full"
                width={200}
                height={100}
                layout="intrinsic"
              />
            </a>
          </li>
          <li>
            <a href="https://www.facebook.com/porto/" target="_blank"
              ><Image
                src={logoFacebook}
                alt="logo do facebook"
                className="h-full w-auto"
                width={200}
                height={100}
                layout="intrinsic"
              />
            </a>
          </li>
          <li>
            <a href="https://www.instagram.com/porto/" target="_blank"
              ><Image
                src={logoInstagram}
                alt="logo do instagram"
                className="h-full w-auto"
                width={200}
                height={100}
                layout="intrinsic"
              />
            </a>
          </li>
          <li>
            <a href="https://www.linkedin.com/company/porto/" target="_blank"
              ><Image
                src={logoLinkedin}
                alt="logo do linkedin"
                className="h-full w-auto"
                width={200}
                height={100}
                layout="intrinsic"
              />
            </a>
          </li>
          <li>
            <a href="https://www.youtube.com/portoseguro" target="_blank"
              ><Image
                src={logoYoutube}
                alt="logo do youtube"
                className="h-full w-auto"
                width={200}
                height={100}
                layout="intrinsic"
              />
            </a>
          </li>
          <li>
            <a href="https://www.tiktok.com/@porto" target="_blank"
              ><Image
                src={logoTiktok}
                alt="logo do tiktok"
                className="h-full w-auto"
                width={200}
                height={100}
                layout="intrinsic"
              />
            </a>
          </li>
        </ul>
        <ul className="flex gap-3 items-center">
          <li>
            <a
              href="https://apps.apple.com/us/app/porto-seguro-residencial-e/id1511026277"
              target="_blank"
              ><Image
                src={logoAppleStore}
                alt="baixar app via apple store"
                width={200}
                height={100}
                layout="intrinsic"
                className="h-full w-auto"
              />
            </a>
          </li>
          <li>
            <a
              href="https://play.google.com/store/apps/details?id=br.com.portoseguro.experienciacliente.mundoporto&pcampaignid=web_share"
              target="_blank"
            >
              <Image
                src={logoPlayStore}
                alt="baixar app via google play store"
                width={200}
                height={100}
                layout="intrinsic"
                className="h-full w-auto"
              />
            </a>
          </li>
        </ul>
      </nav>
      <Image
        src={logoPorto}
        alt="logo da porto seguro"
        width={200}
        height={100}
        className="h-full md:w-[25%] sm:w-[30%]"
        layout="intrinsic"
      />
    </footer>
  )
}
