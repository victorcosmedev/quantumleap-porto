package quantumleap.controller;

import quantumleap.dominio.Oficina;
import quantumleap.infra.dao.OficinaDAO;
import quantumleap.service.OficinaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("oficinas")
public class OficinaController {

    private OficinaDAO oficinaDAO;
    private OficinaService oficinaService;

    public OficinaController(){
        oficinaDAO = new OficinaDAO();
        oficinaService = new OficinaService(oficinaDAO);
    }

    @POST
    public Response adicionarOficina(Oficina oficina){
        try{
            oficinaService.adicionar(oficina);
            return Response.status(Response.Status.CREATED).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listandoOficinas(){
        try {
            ArrayList<Oficina> oficinas = oficinaService.listarTodasOficinas();
            return Response.status(Response.Status.OK).entity(oficinas).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscandoPorId(@PathParam("id") Long id){
        try{
            Oficina oficina = oficinaService.buscarOficinaPorId(id);
            return Response.status(Response.Status.OK).entity(oficina).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizarOficina/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarOficina(@PathParam("id")Long id, Oficina oficina){
        try{
            oficinaService.atualizarOficina(id, oficina);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/excluirOficina/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirOficina(@PathParam("id")Long id){
        try{
            oficinaService.excluirOficina(id);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
