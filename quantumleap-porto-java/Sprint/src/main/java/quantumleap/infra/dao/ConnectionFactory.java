package quantumleap.infra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {

        //Banco Oficial
        String urlDeConexao = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        String login = "RM557569";
        String senha = "110602";

        //Banco de teste
//        String urlDeConexao = "jdbc:oracle:thin:@localhost:1521:xe";
//        String login = "system";
//        String senha = "system";

        try {
            return DriverManager.getConnection(urlDeConexao, login, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao abrir conexão com o banco de dados", e);
        }
    }
}
