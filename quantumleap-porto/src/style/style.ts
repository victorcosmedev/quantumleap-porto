import { Link } from 'react-router-dom';
import { styled } from 'styled-components';
export const MainContent = styled.main`
    width: 100%;
    height: 100%;
    border: 2px solid red;
    margin: 40px 0;
    padding: 0 16vw;
`

export const TituloXG = styled.h1`
    font-size: 4rem;
    color: #0046C7;
    text-align: center;
`

export const TituloH3 = styled.h3`
    font-size: 2.5rem;
    color: black;
    text-align: center;
`

export const Header = styled.header`
    @media screen and (min-width: 1200px){
        display: flex;
        align-items: center;
        padding: 1.5vh 13vw;
        width: 100%;
        justify-content: space-between;
        border: 2px solid red;  
        align-items: center;
    }
`

export const DivLogoHeader = styled.div`
    @media screen and (min-width: 1200px){
        height: 100%;
        width: 10%;
        border: 2px solid black;
        display: flex;
        align-items: center;
    }
`

export const LogoPorto = styled.img`
    @media screen and (min-width: 1200px){
        width: 100%;
        height: auto;
        max-width: 100px;
        display: flex;
    }
`

export const NavHeader = styled.nav`
    display: flex; 
    justify-content: space-between;
    align-items: center;

    @media screen and (min-width: 1200px){
        border: 2px solid blue;
        width: 100%;
        margin-left: 5%;
        font-weight: 600;
    }
`

export const UlMenu = styled.ul`
    @media screen and (min-width: 1200px){
        display: flex;
        list-style-type: none;
        margin: 0;
        padding: 0;
        justify-content: space-between;
        gap: 2vw;
    }
` 

export const ItemMenu = styled.li`
    @media screen and (min-width: 1200px) {
        font-weight: 700;
    }
`

export const LinkPadrao = styled(Link)`
    text-decoration: none;
    color: black;
`

export const BotaoMenu = styled.button`
    border: none;
    @media screen and (min-width: 1200px){
        padding: 1vh 1.5vw;
        font-weight: 600;
        background-color: #0046C7;
        color: white;
        border-radius: 5px;
        font-size: inherit;
    }
`