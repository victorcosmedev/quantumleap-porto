import { Outlet } from "react-router-dom";
import Cabecalho from "./components/Cabecalho/Cabecalho";
import Rodape from "./components/Rodape/Rodape";
import styles from "./App.module.css";
import { MainContent } from "./style/style";

function App(){
  return (
    <div className={styles.parent}>
      <Cabecalho/>
    </div>
  );
} 

export default App;