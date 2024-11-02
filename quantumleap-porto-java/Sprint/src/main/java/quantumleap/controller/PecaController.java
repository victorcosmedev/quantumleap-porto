package quantumleap.controller;


import quantumleap.dominio.Peca;
import quantumleap.infra.dao.PecaDAO;
import quantumleap.service.PecaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("pecas")
public class PecaController {
    private PecaDAO pecaDAO;
    private PecaService pecaService;

    public PecaController() {
        pecaDAO = new PecaDAO();
        pecaService = new PecaService(pecaDAO);
    }

    @POST
    public Response salvarPeca(Peca peca){
        try {
            pecaService.adicionar(peca);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaPecas(){
        try{
            ArrayList<Peca> pecas = pecaService.listarPecas();
            return Response.status(Response.Status.OK).entity(pecas).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornandoPecaPorId(@PathParam("id") Long id){
        try{
            Peca peca = pecaService.buscarPorId(id);
            return Response.status(Response.Status.OK).entity(peca).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizarPeca/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, Peca peca){
        try{
            pecaService.alterarPeca(id, peca);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/deletarPeca/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarPecaPorID(@PathParam("id") Long id){
        try {
            pecaService.removerPeca(id);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


}
