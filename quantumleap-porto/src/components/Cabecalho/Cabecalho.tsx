import { DivLogoHeader, Header, LogoPorto } from "../../style/style";
import Menu from "./Menu";


export default function Cabecalho(){
    return (
        <Header>
            <DivLogoHeader>
                <LogoPorto src="./../../../public/img/logo-porto.png" alt="Logo Porto Seguro"/>   
            </DivLogoHeader>
            <Menu/>
        </Header>
    );
}