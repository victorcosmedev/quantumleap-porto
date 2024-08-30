import { Link } from "react-router-dom";
import { ItemMenu, LinkPadrao, NavHeader, UlLinkHome, UlMenu } from "../../style/style";

export default function Menu(){
    return(
        <NavHeader>
            <UlMenu>
                <ItemMenu><LinkPadrao to="/">Home</LinkPadrao></ItemMenu>
                <ItemMenu><LinkPadrao to="/">Sobre nós</LinkPadrao></ItemMenu>
            </UlMenu>
            <UlMenu>
                <ItemMenu><LinkPadrao to="/">Login</LinkPadrao></ItemMenu>
            </UlMenu>
        </NavHeader>
    );
}