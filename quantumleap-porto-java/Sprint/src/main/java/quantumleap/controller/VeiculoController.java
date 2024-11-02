package quantumleap.controller;


import quantumleap.dominio.Veiculo;
import quantumleap.infra.dao.VeiculoDAO;
import quantumleap.service.VeiculoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("veiculos")
public class VeiculoController {

    private VeiculoDAO veiculoDAO;
    private VeiculoService veiculoService;

    public VeiculoController(){
        veiculoDAO = new VeiculoDAO();
        veiculoService = new VeiculoService(veiculoDAO);
    }


    @POST
    public Response salvarVeiculo(Veiculo veiculo){
        try{
            veiculoService.adicionar(veiculo);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaVeiculosPorId(@PathParam("id") long id){
        try {
            Veiculo veiculo = veiculoService.retornaVeiculoPorId(id);
            return Response.status(Response.Status.OK).entity(veiculo).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscarVeiculoCliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarVeiculoCliente(@PathParam("id") long id) {
        try {
            ArrayList<Veiculo> veiculosCliente = veiculoService.buscarVeiculosPorIdCliente(id);
            return Response.status(Response.Status.OK).entity(veiculosCliente).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaVeiculos(){
        try{
            ArrayList<Veiculo> veiculos = veiculoService.listarTodosVeiculos();
            return Response.status(Response.Status.OK).entity(veiculos).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }



    @PUT
    @Path("/atualizarVeiculo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarVeiculo(@PathParam("id") long id, Veiculo veiculo){
        try{
            veiculoService.atualizarVeiculo(id, veiculo);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }



    @DELETE
    @Path("deletarVeiculo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarVeiculo(@PathParam("id")long id){
        try {
            veiculoService.deletarVeiculo(id);
            return Response.status(Response.Status.OK).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
