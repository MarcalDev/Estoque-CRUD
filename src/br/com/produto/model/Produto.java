package br.com.produto.model;
/**
 *
 * @author MarcalDev
 */

// Classe "Produto"
public class Produto {
    public int codigo_produto;
    public String nm_produto;
    public int quantidade;
    public double valor;
    public boolean ativo;
    public String data_inclusao;

    public int getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getNm_produto() {
        return nm_produto;
    }

    public void setNm_produto(String nm_produto) {
        this.nm_produto = nm_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getData_inclusao() {
        return data_inclusao;
    }

    public void setData_inclusao(String data_inclusao) {
        this.data_inclusao = data_inclusao;
    }
    
    
}
