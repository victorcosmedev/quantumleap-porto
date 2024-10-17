package quantumleap.controller;

import quantumleap.dominio.Agendamento;
import quantumleap.infra.AgendamentoDAO;
import quantumleap.service.AgendamentoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("agendamentos")
public class AgendamentoController {

    private AgendamentoDAO agendamentoDAO;
    private AgendamentoService agendamentoService;

    public AgendamentoController(){
        agendamentoDAO = new AgendamentoDAO();
        agendamentoService = new AgendamentoService(agendamentoDAO);
    }

    @POST
    public Response salvarAgendamento(Agendamento agendamento){
        try {
            agendamentoService.adicionar(agendamento);
            return Response.status(Response.Status.CREATED).build();
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorID(@PathParam("id")long id){
        try {
            Agendamento agendamento = agendamentoService.buscarPorId(id);
            return Response.status(Response.Status.CREATED).entity(agendamento).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizarAgendamento/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarAgendamento(@PathParam("id") long id, Agendamento agendamento){
        try {
            agendamentoService.atualizarAgendamento(id, agendamento);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaAgendamentos(){
        try {
            ArrayList<Agendamento>agendamentos = agendamentoService.listarAgendamentos();
            return Response.status(Response.Status.OK).entity(agendamentos).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/deletarAgendamento/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarAgendamento(@PathParam("id")long id){
        try {
            agendamentoService.deletarAgendamento(id);
            return Response.status(Response.Status.OK).build();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
