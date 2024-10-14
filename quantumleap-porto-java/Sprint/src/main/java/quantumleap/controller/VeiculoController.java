package quantumleap.controller;

import quantumleap.dominio.Cliente;
import quantumleap.dominio.Veiculo;
import quantumleap.infra.VeiculoDAO;
import quantumleap.service.VeiculoService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("veiculos")
public class VeiculoController {

    private VeiculoDAO veiculoDAO;
    private VeiculoService veiculoService;

    public VeiculoController(){
        veiculoDAO = new VeiculoDAO();
        veiculoService = new VeiculoService(veiculoDAO);
    }

    //NÃO ESTA FUNCIONANDO

    @POST
    public Response salvarVeiculo(Veiculo veiculo, Cliente cliente){
        try{
            veiculoService.adicionar(cliente, veiculo);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
