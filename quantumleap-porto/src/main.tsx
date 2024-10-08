import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import App from './App.tsx';

import { createBrowserRouter, RouterProvider} from 'react-router-dom';
import Home from "./routes/Home/index.tsx";
import Cadastro from "./routes/Cadastro/index.tsx";
import Login from "./routes/Login/index.tsx";
import Error from "./routes/Error/index.tsx";
import SobreNos from './routes/SobreNos/index.tsx';
import AreaCliente from './routes/AreaCliente/index.tsx';
import Chat from './routes/Chat/index.tsx';
import Menu from './routes/Menu/index.tsx';

const routes = createBrowserRouter([
  {path: "/", element: <App/>, errorElement: <Error/>,
    children:[
      {path: "/", element: <Home/>},
      {path: "/cadastro", element: <Cadastro/>},
      {path: "/login", element: <Login/>},
      {path: "/sobre-nos", element: <SobreNos/>},
      {path: "/area-cliente", element: <AreaCliente/>},
      {path: "/chat", element: <Chat/>},
      {path: "/menu", element: <Menu/>},
    ]
  }
]);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={routes}/>
  </StrictMode>,
)
