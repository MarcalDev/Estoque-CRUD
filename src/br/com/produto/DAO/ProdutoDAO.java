package br.com.produto.DAO;

import br.com.produto.factory.ConnectionFactory;
import br.com.produto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MarcalDev
 */

public class ProdutoDAO extends Produto{
    
    // Método que adiciona produtos no banco de dados
    public void createProdutos(Produto produto){
        
        try{
            
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement("INSERT INTO Produto (Codigo_Produto, Nm_Produto, Quantidade, Valor, Ativo, Data_Inclusao) VALUES(?,?,?,?,?,?)");
            
            
            smt.setInt(1,produto.codigo_produto);
            smt.setString(2,produto.nm_produto);
            smt.setInt(3, produto.quantidade);
            smt.setDouble(4, produto.valor);
            smt.setBoolean(5, produto.ativo);
            smt.setString(6, produto.data_inclusao);
            
            int k = smt.executeUpdate();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
    // Método que que retorna lista de dados dos produtos
    public List<Produto> readProdutos(){
        
        List<Produto> produtos = new ArrayList<Produto>();
        
        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement("SELECT * FROM Produto");
            ResultSet rset = smt.executeQuery();
            
            while (rset.next()){
                Produto p = new Produto();
                
                p.setCodigo_produto(rset.getInt("codigo_produto"));
                p.setNm_produto(rset.getString("nm_produto"));
                p.setQuantidade(rset.getInt("quantidade"));
                p.setValor(rset.getDouble("valor"));
                p.setAtivo(rset.getBoolean("ativo"));
                p.setData_inclusao(rset.getString("data_inclusao"));
                
                produtos.add(p);
            }
            rset.close();
            smt.close();
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return produtos;
    }
    
    // Método que atualiza os dados do produto
    public void updateProdutos(Produto produto){
        
    try{
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement smt = con.prepareStatement("UPDATE Produto SET Nm_Produto = ?, Quantidade = ?, Valor = ?, Ativo = ?, Data_Inclusao = ? WHERE Codigo_Produto = ?");
        
        
        smt.setString(1, produto.nm_produto);
        smt.setInt(2, produto.quantidade);
        smt.setDouble(3, produto.valor);
        smt.setBoolean(4, produto.ativo);
        smt.setString(5, produto.data_inclusao);
        smt.setInt(6, produto.codigo_produto);
        
        int k = smt.executeUpdate();
        
    }catch(SQLException e){
        throw new RuntimeException(e);
    }
    }
    
    // Método que exclui produtos do banco de dados
    public void deleteProdutos(Produto produto){
        try{
           Connection con = new ConnectionFactory().getConnection();
           PreparedStatement smt = con.prepareStatement("DELETE FROM Produto WHERE (Codigo_Produto = ?)");
           smt.setInt(1, produto.codigo_produto);
           
           int k = smt.executeUpdate();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
