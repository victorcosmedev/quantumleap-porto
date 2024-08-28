import { Link } from "react-router-dom";
import { ItemMenu, NavHeader, UlLinkHome, UlMenu } from "../../style/style";

export default function Menu(){
    return(
        <NavHeader>
            <UlMenu>
                <ItemMenu><Link to="/"><UlLinkHome>Home</UlLinkHome></Link></ItemMenu>
            </UlMenu>
            <UlMenu>

            </UlMenu>
        </NavHeader>
    );
}