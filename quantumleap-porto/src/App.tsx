import { Outlet } from "react-router-dom";
import Cabecalho from "./components/Cabecalho/Cabecalho";
import Rodape from "./components/Rodape/Rodape";
import styles from "./App.module.css";

function App(){
  return (
    <div className={styles.parent}>
      <Cabecalho/>
      <Rodape/>
    </div>
  );
} 

export default App;