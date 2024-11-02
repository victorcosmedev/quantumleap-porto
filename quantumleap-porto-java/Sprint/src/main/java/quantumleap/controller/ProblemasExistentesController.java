package quantumleap.controller;

import quantumleap.dominio.ProblemasExistentes;
import quantumleap.infra.dao.ProblemasExistentesDAO;
import quantumleap.service.ProblemasExistentesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("problemasExistentes")
public class ProblemasExistentesController {

    private ProblemasExistentesDAO problemasExistentesDAO;
    private ProblemasExistentesService problemasExistentesService;

    public ProblemasExistentesController() {
        problemasExistentesDAO = new ProblemasExistentesDAO();
        problemasExistentesService = new ProblemasExistentesService(problemasExistentesDAO);
    }

    @POST
    public Response adicionaProblema(ProblemasExistentes problemasExistentes){
        try {
            problemasExistentesService.adicionarProblema(problemasExistentes);
            return Response.status(Response.Status.CREATED).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscandoPorID(@PathParam("id")long id){
        try {
            ProblemasExistentes problemasExistentes = problemasExistentesService.buscarProblemaPorID(id);
            return Response.status(Response.Status.OK).entity(problemasExistentes).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizaProblema/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarProblema(@PathParam("id")long id, ProblemasExistentes problemasExistentes){
        try {
            problemasExistentesService.atualizarProblema(id, problemasExistentes);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaProblemas(){
        try {
            ArrayList<ProblemasExistentes> problemasExistentes = problemasExistentesService.retornaProblemas();
            return Response.status(Response.Status.OK).entity(problemasExistentes).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @DELETE
    @Path("/deletar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarProblema(@PathParam("id")long id){
        try {
            problemasExistentesService.deletarProblemas(id);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
