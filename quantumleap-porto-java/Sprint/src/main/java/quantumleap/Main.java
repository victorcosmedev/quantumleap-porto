package quantumleap;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
//    public static void main(String[] args) throws ParseException {
//        Scanner sc = new Scanner(System.in);
//
//        ClienteDAO clienteDAO = new ClienteDAO();
//        VeiculoDAO veiculoDAO = new VeiculoDAO();
//
//        PecaDAO pecaDAO = new PecaDAO();
//        ProblemasExistentesDAO problemasExistentesDAO = new ProblemasExistentesDAO();
//
//        GuinchoDAO guinchoDAO = new GuinchoDAO();
//        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
//
//        OficinaDAO oficinaDAO = new OficinaDAO();
//        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
//
//
//
//
//        Guincho guincho1 = new Guincho("123", 250, 100000);
//        Peca peca = new Peca("vira", 500.00, "Cotinental", "modelo1");
//        Peca peca2 = new Peca("Vela", 250.00, "bosch", "modelo2");
//
//        pecaDAO.adicionaPeca(peca);
//        pecaDAO.adicionaPeca(peca2);
//        pecaDAO.fechar();
//
//        Long idPecaExistente = 1L;
//        Peca pecaExistente = pecaDAO.buscarPecaPorId(idPecaExistente);
//        Long idPecaExistente2 = 2L;
//        Peca pecaExistente2 = pecaDAO.buscarPecaPorId(idPecaExistente2);
//
//        Oficina oficina = new Oficina("oficina", "São Paulo", "11111111111", "oficina@gmail.com");
//
//        ProblemasExistentes problema1 = new ProblemasExistentes("Embreagem dura", "descrição1", 500.00, 3, pecaExistente);
//        ProblemasExistentes problema2 = new ProblemasExistentes("Barulho no motor", "descrição2", 1000.00, 1, pecaExistente2);
//        ArrayList<ProblemasExistentes> problemas = new ArrayList<ProblemasExistentes>();
//        problemas.add(problema1);
//        problemas.add(problema2);
//
//
//
//        Veiculo veiculo = new Veiculo("Fiat", "Palio", DateUtil.parseYear("2005"), 100000.00, "EFG4H56");
//        Cliente cliente = new Cliente("Arthur", "Arthur@gmail.com", "111111111", "senha", true, "Rio Paulo");
//        Diagnostico diag1 = new Diagnostico(cliente, veiculo, problema1,guincho1);
//        Agendamento ag1 = new Agendamento(diag1, "12/12/2024", "12:30", oficina);
//
//        Veiculo veiculo2 = new Veiculo("Fiat", "Palio", DateUtil.parseYear("2005"), 100000.00, "ABC1D23");
//        Cliente cliente2 = new Cliente("Lucas", "Lucas@gmail.com", "111111111", "senha", false, "São Paulo");
//        Diagnostico diag2 = new Diagnostico(cliente2, veiculo, problema2, guincho1);
//        Agendamento ag2 = new Agendamento(diag2, "13/12/2024", "12:30", oficina);
//
//
//        ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
//        agendamentos.add(ag1);
//        agendamentos.add(ag2);
//
//        //Inserts
//        clienteDAO.adicionarCliente(cliente);
//        clienteDAO.adicionarCliente(cliente2);
//        veiculoDAO.adicionarVeiculo(cliente, veiculo);
//        veiculoDAO.adicionarVeiculo(cliente2, veiculo2);
//        problemasExistentesDAO.adicionarProblemaExistente(problema1);
//        problemasExistentesDAO.adicionarProblemaExistente(problema2);
//        guinchoDAO.adicionaGuincho(guincho1);
//        diagnosticoDAO.adicionarDiagnostico(diag1);
//        diagnosticoDAO.adicionarDiagnostico(diag2);
//        oficinaDAO.adicionarOficina(oficina);
//        agendamentoDAO.adicionarAgendamento(ag1);
//        agendamentoDAO.adicionarAgendamento(ag2);
//
//        //Programa Principal
//        System.out.println("Bem vindo(a) ao Canal Porto Seguro!!!");
//        System.out.println("Por favor, inseira seu nome: ");
//        String nomeCliente = sc.nextLine();
//        System.out.println("Insira seu email: ");
//        String emailCliente = sc.nextLine();
//        System.out.println("Insira seu senha: ");
//        String senhaCliente = sc.nextLine();
//        System.out.println("Insira seu telefone: ");
//        String telefoneCliente = sc.nextLine();
//        System.out.println("Informe se você é cliente Porto Seguro (sim ou não): ");
//        String verificaCliente = sc.nextLine();
//        System.out.println("Qual sua cidade?");
//        String cidadeCliente = sc.nextLine();
//
//        boolean clientePorto = false;
//        if (verificaCliente.equalsIgnoreCase("sim")) {
//            clientePorto = true;
//        }
//
//        Cliente cliente3 = new Cliente(nomeCliente, emailCliente, telefoneCliente, senhaCliente, clientePorto, cidadeCliente);
//        clienteDAO.adicionarCliente(cliente3);
//
//
//
//
//
//        System.out.println("Insira a marca do seu veículo: ");
//        String montadoraVeiculo = sc.nextLine();
//        System.out.println("Insira o modelo do seu veículo: ");
//        String modeloVeiculo = sc.nextLine();
//        System.out.println("Insira o ano do veículo (formato yyyy):");
//        String anoVeiculoStr = sc.nextLine();
//        Date anoVeiculo = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//            anoVeiculo = sdf.parse(anoVeiculoStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Insira a quilometragem: ");
//        double quantidadeQuilometros = sc.nextDouble();
//        sc.nextLine();
//        System.out.println("Insira a placa do veículo");
//        String placaVeiculo = sc.nextLine();
//
//
//
//        Veiculo veiculo3 = new Veiculo(montadoraVeiculo, modeloVeiculo, anoVeiculo, quantidadeQuilometros, placaVeiculo);
//
//        veiculoDAO.adicionarVeiculo(cliente3, veiculo3);
//
//        System.out.println("A partir da lista de problemas, escreva o nome de qual melhor se encaixa no seu.");
//        for (ProblemasExistentes problemasLista : problemas) {
//            String nome = problemasLista.getNomeProblema();
//            System.out.println(nome);
//        }
//        System.out.println("Por favor, escreva o nome igual ao da lista: ");
//        String nome = sc.nextLine();
//
//        ProblemasExistentes problema4 = new ProblemasExistentes();
//
//        for(ProblemasExistentes problemasLista: problemas) {
//            if (problemasLista.getNomeProblema().equals(nome)) {
//                problema4 = problemasLista;
//            }
//        }
//
//        //Fechamendo
//        clienteDAO.fecharConexao();
//        veiculoDAO.fecharConexao();
//        problemasExistentesDAO.fecharConexao();
//        guinchoDAO.fecharConexao();
//        oficinaDAO.fecharConexao();
//
//
//
//
//        Diagnostico diag3 = new Diagnostico(cliente3, veiculo3, problema4, guincho1);
//        diagnosticoDAO.adicionarDiagnostico(diag3);
//        diagnosticoDAO.fecharConexao();
//
//        System.out.println("Você precisa de um Guincho ? (sim ou não)");
//        String verificaGuincho = sc.nextLine();
//        if (verificaGuincho.equalsIgnoreCase("sim")){
//            if (clientePorto){
//                diag3.setOrcamento(0);
//            }else {
//                diag3.setOrcamento(diag3.adicionandoGuincho());
//            }
//        }else if(verificaCliente.equalsIgnoreCase("Não")){
//            if (clientePorto){
//                diag3.setOrcamento(0);
//            }else{
//                diag3.setOrcamento(diag3.orcamentoPadrao());
//            }
//        }
//        System.out.println("Digite o melhor dia para você ir até a oficina: (dd/mm/yyyy) ");
//        String data = sc.nextLine();
//        System.out.println("Digite o melhor horário para você ir até a oficina:");
//        String hora = sc.nextLine();
//
//
//        Agendamento ag3 = new Agendamento(diag3, data, hora, oficina);
//
//        if (agendamentoDAO.verificarConflitoAgendamento(data, hora)) {
//            System.out.println("Já existe um agendamento para essa data e hora.");
//            System.out.println("Horários já ocupados:");
//            ArrayList<Agendamento> age = agendamentoDAO.listarAgendamentos();
//            for (Agendamento ag: age){
//                if (ag.getData().equals(ag3.getData())){
//                    System.out.println(ag.getHora());
//                }
//            }
//            System.out.println("\n");
//            System.out.println("Por favor, escolha outro horário: ");
//            String hora2 = sc.nextLine();
//            Agendamento ag4 = new Agendamento(diag3, data, hora2, oficina);
//            agendamentoDAO.adicionarAgendamento(ag4);
//
//            System.out.println("Olá senhor(a) " + cliente3.getNomeCliente() + ", seu veículo " + veiculo3.getModeloVeiculo() +
//                    " de placa " + veiculo3.getPlacaVeiculo() + " foi agendado. \nVocê deverá levar seu veículo no dia " +
//                    ag4.getData() + " às " + ag4.getHora() + ", o seu orçamento será R$" + diag3.getOrcamento() +
//                    "\nA oficina está localizada na cidade: " + ag4.getOficina().getLocalizacaoOficina() + ". Muito obrigado por escolher a Porto Seguro!!");
//
//
//        } else {
//            agendamentoDAO.adicionarAgendamento(ag3);
//            System.out.println("Agendamento realizado com sucesso!");
//            System.out.println("Olá senhor(a) " + cliente3.getNomeCliente() + ", seu veículo " + veiculo3.getModeloVeiculo() +
//                    " de placa " + veiculo3.getPlacaVeiculo() + " foi agendado. \nVocê deverá levar seu veículo no dia " +
//                    ag3.getData() + " às " + ag3.getHora() + ", o seu orçamento será R$" + diag3.getOrcamento() +
//                    "\nA oficina está localizada na cidade: " + ag3.getOficina().getLocalizacaoOficina() + ". Muito obrigado por escolher a Porto Seguro!!");
//
//        }
//        agendamentoDAO.fecharConexao();
//        System.out.println("\n");
//
//
//        System.out.println("Parte 2: ");
//        System.out.println("\n");
//        ClienteDAO clienteDAO1 = new ClienteDAO();
//        System.out.println("Lista Clientes até agora:");
//        ArrayList<Cliente> listaCliente = clienteDAO1.listarClientes();
//        for (Cliente x : listaCliente) {
//            System.out.println("ID: " + x.getIdCliente());
//            System.out.println("Nome: " + x.getNomeCliente());
//            System.out.println("Email: " + x.getEmailCliente());
//            System.out.println("Telefone: " + x.getTelefoneCliente());
//            System.out.println("Senha: " + x.getSenhaCliente());
//            System.out.println("Cliente Porto: " + (x.getClientePorto() ? "Sim" : "Não"));
//            System.out.println("Localização: " + x.getLocalizacaoCliente());
//            System.out.println("---------------------------");
//        }
//
//        System.out.println("Qual cadastro você gostaria de atualizar ? (Digite o ID) ");
//        long idCliente2 = sc.nextLong();
//        clienteDAO1.buscarClientePorId(idCliente2);
//
//        System.out.println("Novo nome: ");
//        String nomeClienteNovo = sc.nextLine();
//        String nomeClienteNovo2 = sc.nextLine();
//
//        System.out.println("Novo email: ");
//        String emailClienteNovo = sc.nextLine();
//        System.out.println("Nova senha: ");
//        String senhaClienteNovo = sc.nextLine();
//        System.out.println("Novo telefone: ");
//        String telefoneClienteNovo = sc.nextLine();
//        System.out.println("Informe se você é cliente Porto Seguro (sim ou não): ");
//        String verificaClienteNovo = sc.nextLine();
//        System.out.println("Nova cidade: ");
//        String cidadeClienteNovo = sc.nextLine();
//
//        boolean clientePortoNovo = false;
//        if (verificaClienteNovo.equalsIgnoreCase("sim")) {
//            clientePortoNovo = true;
//        }
//        Cliente clienteAtualizado = new Cliente(nomeClienteNovo2, emailClienteNovo, telefoneClienteNovo, senhaClienteNovo, clientePortoNovo, cidadeClienteNovo);
//        clienteDAO1.atualizarCliente(idCliente2, clienteAtualizado);
//
//
//        System.out.println("Lista de Clientes Atualizada:");
//        ArrayList<Cliente> listaCliente2 = clienteDAO1.listarClientes();
//        for (Cliente x : listaCliente2) {
//            System.out.println("ID: " + x.getIdCliente());
//            System.out.println("Nome: " + x.getNomeCliente());
//            System.out.println("Email: " + x.getEmailCliente());
//            System.out.println("Telefone: " + x.getTelefoneCliente());
//            System.out.println("Senha: " + x.getSenhaCliente());
//            System.out.println("Cliente Porto: " + (x.getClientePorto() ? "Sim" : "Não"));
//            System.out.println("Localização: " + x.getLocalizacaoCliente());
//            System.out.println("---------------------------");
//        }
//        System.out.println("\n");
//
//        System.out.println("Parte 3: ");
//        System.out.println("\n");
//        System.out.println("Com os IDs abaixo escolha 1 para apagar: ");
//        ArrayList<Cliente> listaCliente3 = clienteDAO1.listarClientes();
//        for (Cliente x : listaCliente3) {
//            System.out.println("ID: " + x.getIdCliente());
//            System.out.println("Nome: " + x.getNomeCliente());
//            System.out.println("---------------------------");
//        }
//        System.out.println("Digite o ID: ");
//        Long idCliente = sc.nextLong();
//        clienteDAO1.removerCliente(idCliente);
//        System.out.println("\n");
//
//        System.out.println("Lista de Clientes Atualizada sem o ID: " + idCliente);
//        ArrayList<Cliente> listaCliente4 = clienteDAO1.listarClientes();
//        for (Cliente x : listaCliente4) {
//            System.out.println("ID: " + x.getIdCliente());
//            System.out.println("Nome: " + x.getNomeCliente());
//            System.out.println("Email: " + x.getEmailCliente());
//            System.out.println("Telefone: " + x.getTelefoneCliente());
//            System.out.println("Senha: " + x.getSenhaCliente());
//            System.out.println("Cliente Porto: " + (x.getClientePorto() ? "Sim" : "Não"));
//            System.out.println("Localização: " + x.getLocalizacaoCliente());
//            System.out.println("---------------------------");
//        }
//
//        clienteDAO1.fecharConexao();
//        sc.close();
//    }

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig rc = new ResourceConfig().packages("quantumleap.controller");


        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with endpoints available at "
                + "%s%nHit Ctrl-C to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }
}
