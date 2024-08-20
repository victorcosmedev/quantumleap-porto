export default function Rodape(){
    return(
    <footer id="rodape">
      <nav className="links-rodape">
        <ul className="links-redes">
          <li>
            <a href="https://twitter.com/portoseguro" target="_blank"
              ><img
                src="./img/twitter-logo.png"
                alt="logo do twitter"
                className="logo-redes"
              />
            </a>
          </li>
          <li>
            <a href="https://www.facebook.com/porto/" target="_blank"
              ><img
                src="./img/facebook-logo.png"
                alt="logo do facebook"
                className="logo-redes"
              />
            </a>
          </li>
          <li>
            <a href="https://www.instagram.com/porto/" target="_blank"
              ><img
                src="./img/instagram-logo.png"
                alt="logo do instagram"
                className="logo-redes"
              />
            </a>
          </li>
          <li>
            <a href="https://www.linkedin.com/company/porto/" target="_blank"
              ><img
                src="./img/linkedin-logo.png"
                alt="logo do linkedin"
                className="logo-redes"
              />
            </a>
          </li>
          <li>
            <a href="https://www.youtube.com/portoseguro" target="_blank"
              ><img
                src="./img/youtube-logo.png"
                alt="logo do youtube"
                className="logo-redes"
              />
            </a>
          </li>
          <li>
            <a href="https://www.tiktok.com/@porto" target="_blank"
              ><img
                src="./img/tiktok-logo.png"
                alt="logo do tiktok"
                className="logo-redes"
              />
            </a>
          </li>
        </ul>
        <ul className="download-app">
          <li>
            <a
              href="https://apps.apple.com/us/app/porto-seguro-residencial-e/id1511026277"
              target="_blank"
              ><img
                src="./img/apple-store-icone.png"
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
                src="./img/google-play-icone.png"
                alt="baixar app via google play store"
              />
            </a>
          </li>
        </ul>
      </nav>
      <img
        className="logo-porto"
        src="./img/logo-porto.png"
        alt="logo da porto seguro"
      />
    </footer>
    )
}