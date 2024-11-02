package quantumleap.controller;

import quantumleap.infra.dao.ClienteDAO;
import quantumleap.dominio.Cliente;
import quantumleap.service.ClienteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Path("clientes")
public class ClienteController {

    private ClienteDAO clienteDAO;
    private ClienteService clienteService;

    public ClienteController(){
        clienteDAO = new ClienteDAO();
        clienteService = new ClienteService(clienteDAO);

    }

    @POST
    public Response salvarCliente(Cliente cliente){
        try{
            clienteService.adicionar(cliente);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaClientes(){
        try {
            ArrayList<Cliente> clientes = clienteService.listarTodosClientes();
            return Response.status(Response.Status.OK).entity(clientes).build();
        } catch (RuntimeException e ){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarClientePorId(@PathParam("id") Long id){
        try {
            Cliente cliente = clienteService.buscarClientePorId(id);
            return Response.status(Response.Status.OK).entity(cliente).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizarCliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarCliente(@PathParam("id") Long id, Cliente cliente){
        try{
            clienteService.atualizarCliente(id, cliente);
            return Response.status(Response.Status.OK).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @DELETE
    @Path("/deletarCliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarCliente(@PathParam("id") Long id){
        try{
            clienteService.removerCliente(id);
            return Response.status(Response.Status.OK).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Map<String, String> loginData) {
        String email = loginData.get("email");
        String senha = loginData.get("senha");

        try {
            Cliente cliente = clienteService.authenticateAndRetrieve(email, senha);

            if (cliente != null) {
                return Response.status(Response.Status.OK).entity(cliente).build();
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("status", "fail");
                response.put("message", "Email ou senha incorretos");
                return Response.status(Response.Status.UNAUTHORIZED).entity(response).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Erro ao processar o login");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }

    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }




}
