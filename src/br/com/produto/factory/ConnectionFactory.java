package br.com.produto.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MarcalDev
 */

public class ConnectionFactory {
    
    // Conexão com o Banco de Dados SQL
    public Connection getConnection(){
        try{
            // Tentativa de conexão com o endereço informado
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Estoque;user=root;password=");
        
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
