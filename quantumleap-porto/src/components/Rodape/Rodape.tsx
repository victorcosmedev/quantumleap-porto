import style from "./Rodape.module.css";
import TwitterLogo from "../../img/twitter-logo.png";
import FacebookLogo from "../../img/facebook-logo.png";
import InstagramLogo from "../../img/instagram-logo.png";
import LinkedinLogo from "../../img/linkedin-logo.png";
import YoutubeLogo from "../../img/youtube-logo.png";
import TiktokLogo from "../../img/tiktok-logo.png";
import PlayStoreIcon from "../../img/google-play-icone.png";
import AppleStoreIcon from "../../img/apple-store-icone.png";
import LogoPorto from "../../img/logo-porto.png";

export default function Rodape(){
    return(
    <footer className={style.rodape}>
      <nav className={style.LinksRodape}>
        <ul className={style.LinksRedes}>
          <li>
            <a href="https://twitter.com/portoseguro" target="_blank"
              ><img
                src={TwitterLogo}
                alt="logo do twitter"
                className={style.LogoRedes}
              />
            </a>
          </li>
          <li>
            <a href="https://www.facebook.com/porto/" target="_blank"
              ><img
                src={FacebookLogo}
                alt="logo do facebook"
                className={style.LogoRedes}
              />
            </a>
          </li>
          <li>
            <a href="https://www.instagram.com/porto/" target="_blank"
              ><img
                src={InstagramLogo}
                alt="logo do instagram"
                className={style.LogoRedes}
              />
            </a>
          </li>
          <li>
            <a href="https://www.linkedin.com/company/porto/" target="_blank"
              ><img
                src={LinkedinLogo}
                alt="logo do linkedin"
                className={style.LogoRedes}
              />
            </a>
          </li>
          <li>
            <a href="https://www.youtube.com/portoseguro" target="_blank"
              ><img
                src={YoutubeLogo}
                alt="logo do youtube"
                className={style.LogoRedes}
              />
            </a>
          </li>
          <li>
            <a href="https://www.tiktok.com/@porto" target="_blank"
              ><img
                src={TiktokLogo}
                alt="logo do tiktok"
                className={style.LogoRedes}
              />
            </a>
          </li>
        </ul>
        <ul className={style.DownloadApp}>
          <li>
            <a
              href="https://apps.apple.com/us/app/porto-seguro-residencial-e/id1511026277"
              target="_blank"
              ><img
                src={AppleStoreIcon}
                alt="baixar app via apple store"
              />
            </a>
          </li>
          <li>
            <a
              href="https://play.google.com/store/apps/details?id=br.com.portoseguro.experienciacliente.mundoporto&pcampaignid=web_share"
              target="_blank"
            >
              <img
                src={PlayStoreIcon}
                alt="baixar app via google play store"
              />
            </a>
          </li>
        </ul>
      </nav>
      <img
        className={style.LogoPorto}
        src={LogoPorto}
        alt="logo da porto seguro"
      />
    </footer>
    )
}