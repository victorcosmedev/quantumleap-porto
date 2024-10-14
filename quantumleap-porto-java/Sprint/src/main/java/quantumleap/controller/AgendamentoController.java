package quantumleap.controller;

import quantumleap.dominio.Agendamento;
import quantumleap.infra.AgendamentoDAO;
import quantumleap.service.AgendamentoService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

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

}
