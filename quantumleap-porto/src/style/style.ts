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


// FORMATAÇÃO DO HEADER
export const Header = styled.header`
    display: flex;
    align-items: center;
    width: 100%;
    @media screen and (min-width: 1200px){
        padding: 1.5vh 13vw;
        justify-content: space-between;
        border: 2px solid red;  
    }

    @media screen and (min-width: 992px) and (max-width: 1199px) {
        padding: 1.5vh 13vw;
        justify-content: space-between;
        border: 2px solid red;
    }

    @media screen and (min-width: 768px) and (max-width: 991px){
        padding: 1.5vh 13vw;
        justify-content: space-between;
        border: 2px solid red;
    }

    @media screen and (min-width: 576px) and (max-width: 767px){
        padding: 1.5vh 13vw;
        justify-content: space-between;
        border: 2px solid red;
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

    @media screen and (min-width: 992px) and (max-width: 1199px) {
        height: 100%;
        width: 20%;
        border: 2px solid black;
        display: flex;
        align-items: center;
    }

    @media screen and (min-width: 768px) and (max-width: 991px) {
        height: 100%;
        width: 20%;
        border: 2px solid black;
        display: flex;
        align-items: center;
    }

    @media screen and (min-width: 576px) and (max-width: 767px) {
        height: 100%;
        width: 25%;
        border: 2px solid black;
        display: flex;
        align-items: center;
    }
`

export const LogoPorto = styled.img`
    width: 100%;
    height: auto;
    max-width: 100px;
    display: flex;
    @media screen and (min-width: 1200px){
        width: 100%;
        height: auto;
        max-width: 100px;
        display: flex;
    }

    @media screen and (min-width: 992px) and (max-width: 1199px) {
        width: 100%;
        height: auto;
        max-width: 100px;
        display: flex; 
    }

    @media screen and (min-width:768px) and (max-width: 992px){
        width: 100%;
        height: auto;
        max-width: 100px;
        display: flex;
    }

    @media screen and (min-width:576px) and (max-width: 767px){
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
    border: 2px solid blue;

    @media screen and (min-width: 1200px){
        width: 100%;
        margin-left: 5%;
        font-weight: 600;
    }

    @media screen and (min-width: 992px) and (max-width: 1199px) {
        width: 100%;
        margin-left: 5%;
        font-weight: 400;
    }

    @media screen and (min-width: 768px) and (max-width: 991px) {
        width: 100%;
        margin-left: 5%;
        font-weight: 400;
    }

    @media screen and (min-width: 576px) and (max-width: 767px) {
        width: 100%;
        margin-left: 5%;
        font-weight: 400;
    }
`

export const UlMenu = styled.ul`
    display: flex;
    list-style-type: none;
    margin: 0;
    padding: 0;
    justify-content: space-between;

    @media screen and (min-width: 1200px){
        gap: 2vw;
    }

    @media screen and (min-width: 992px) and (max-width: 1199px) {
        gap: 2vw;
    }

    @media screen and (min-width: 768px) and (max-width: 991px) {
        gap: 2vw;
    }

    @media screen and (min-width: 576px) and (max-width: 767px) {
        gap: 2vw;
        font-size: 1.3rem;
    }
` 

export const ItemMenu = styled.li`
    font-size: inherit;
    @media screen and (min-width: 1200px) {
        
    }

    @media screen and (min-width: 992px) and (max-width: 1199px) {
        font-weight: 600;
    }

    @media screen and (min-width: 768px) and (max-width: 991px) {
        font-weight: 600;
    }

    @media screen and (min-width: 576px) and (max-width: 767px) {
        font-weight: 600;
    }
`

export const LinkPadrao = styled(Link)`
    text-decoration: none;
    color: black;
`

export const BotaoMenu = styled.button`
    border: none;
    font-weight: inherit;
    background-color: #0046C7;
    color: white;
    font-size: inherit;   

    @media screen and (min-width: 1200px){
        padding: 1vh 1.5vw;
        font-weight: 600;
        border-radius: 5px;
    }

    @media screen and (min-width: 992px) and (max-width: 1199px) {
        padding: 1vh 1.5vw;
        border-radius: 5px;
        font-weight: 500;
    }

    @media screen and (min-width: 768px) and (max-width: 991px) {
        padding: 1vh 1.5vw;
        border-radius: 3px;
        font-weight: 500;   
    }

    @media screen and (min-width: 576px) and (max-width: 767px) {
        padding: 1vh 1.5vw;
        border-radius: 3px;
        font-weight: 500;   
    }
`