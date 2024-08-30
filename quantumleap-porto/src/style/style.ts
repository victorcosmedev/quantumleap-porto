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
        padding: 0 13%;
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
    @media screen and (min-width: 1200px){
        border: 2px solid blue;
        width: 100%;
        margin-left: 5%;
        display: flex;
        justify-content: space-between;
    }
`

export const UlMenu = styled.ul`
    @media screen and (min-width: 1200px){
        display: flex;
        list-style-type: none;
        margin: 0;
        padding: 0;
        border: 2px solid green;
        gap: 1%;
    }
` 

export const ItemMenu = styled.li`
    @media screen and (min-width: 1200px) {
        font-weight: 700;
    }
`

export const LinkPadrao = styled(Link)`
    text-decoration: none;
    color: inherit;
`