import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import App from './App.tsx';

import { createBrowserRouter, RouterProvider} from 'react-router-dom';
import Home from "./routes/Home/index.tsx";
import Cadastro from "./routes/Cadastro/index.tsx";
import Login from "./routes/Login/index.tsx";
import Error from "./routes/Error/index.tsx";
import SobreNos from './routes/SobreNos/index.tsx';

const routes = createBrowserRouter([
  {path: "/", element: <App/>, errorElement: <Error/>,
    children:[
      {path: "/", element: <Home/>},
      {path: "/cadastro", element: <Cadastro/>},
      {path: "/login", element: <Login/>},
      {path: "/sobre-nos", element: <SobreNos/>}
    ]
  }
]);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={routes}/>
  </StrictMode>,
)
