package quantumleap.controller;

import quantumleap.dominio.Diagnostico;
import quantumleap.infra.DiagnosticoDAO;
import quantumleap.service.DiagnosticoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("diagnosticos")
public class DiagnosticosController {
    private DiagnosticoDAO diagnosticoDAO;
    private DiagnosticoService diagnosticoService;

    public DiagnosticosController(){
        diagnosticoDAO = new DiagnosticoDAO();
        diagnosticoService = new DiagnosticoService(diagnosticoDAO);
    }

    @POST
    public Response salvarDiagnostico(Diagnostico diagnostico){
        try {
            diagnosticoService.adicionarDiagostico(diagnostico);
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
    public Response buscarPorId(@PathParam("id")long id){
        try {
            Diagnostico diagnostico = diagnosticoService.buscarPorID(id);
            return Response.status(Response.Status.OK).entity(diagnostico).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizarDiagnostico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarDiagnostico(@PathParam("id") long id, Diagnostico diagnostico){
        try {
            diagnosticoService.atualizarDiagnostico(id, diagnostico);
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
            ArrayList<Diagnostico> diagnosticos = diagnosticoService.listarDiagnoticos();
            return Response.status(Response.Status.OK).entity(diagnosticos).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/deletarDiagnostico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarDiagnostico(@PathParam("id")long id){
        try {
            diagnosticoService.deletarDiagnostico(id);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
