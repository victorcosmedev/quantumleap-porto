package quantumleap.controller;

import quantumleap.dominio.Guincho;
import quantumleap.infra.dao.GuinchoDAO;
import quantumleap.service.GuinchoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("guinchos")
public class GuinchoController {
    private GuinchoDAO guinchoDAO;
    private GuinchoService guinchoService;

    public GuinchoController(){
        guinchoDAO = new GuinchoDAO();
        guinchoService = new GuinchoService(guinchoDAO);
    }

    @POST
    public Response adicionar(Guincho guincho){
        try{
            guinchoService.adicionar(guincho);
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
    public Response buscarGuinchoPorId(@PathParam("id") Long id){
        try {
            Guincho guincho = guinchoService.buscarGuinchoPorId(id);
            return Response.status(Response.Status.OK).entity(guincho).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @PUT
    @Path("/atualizarGuincho/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarGuincho(@PathParam("id") long id, Guincho guincho){
        try {
            guinchoService.atualizarGuincho(id, guincho);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaClientes(){
        try {
            ArrayList<Guincho> guinchos = guinchoService.listarGuincho();
            return Response.status(Response.Status.OK).entity(guinchos).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();

        }
    }

    @DELETE
    @Path("/deletarGuincho/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarGuincho(@PathParam("id")long id){
        try {
            guinchoService.deletarGuincho(id);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


}
