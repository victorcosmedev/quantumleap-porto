import { Link } from "react-router-dom";
import { BotaoMenu, ItemMenu, LinkPadrao, NavHeader, UlLinkHome, UlMenu } from "../../style/style";
import Hamburguer from "./Hamburguer";

export default function Menu(){
    return(
        <NavHeader>
            <UlMenu>
                <ItemMenu><LinkPadrao to="/">Home</LinkPadrao></ItemMenu>
                <ItemMenu><LinkPadrao to="/">Sobre nós</LinkPadrao></ItemMenu>
            </UlMenu>
            <UlMenu>
                <ItemMenu>
                    <BotaoMenu>
                        Entrar
                    </BotaoMenu>
                </ItemMenu>
            </UlMenu>
            <Hamburguer/>
        </NavHeader>
    );
}