package br.com.barbara.Classes;
// Generated 14/12/2018 16:05:11 by Hibernate Tools 4.3.1



/**
 * Saidas generated by hbm2java
 */
public class Saidas  implements java.io.Serializable {


     private Integer idSaidas;
     private int idProduto;
     private float quantidade;
     private float preco;
     private Integer idCliente;
     private String data;
     private String pagamento;
     private String observacao;
     private int pg;
     private int numvenda;
    public Saidas() {
    }

	
    public Saidas(int idProduto, float quantidade, float preco, String data, String pagamento, int pg, int numvenda) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.data = data;
        this.pagamento = pagamento;
        this.pg = pg;
        this.numvenda = numvenda;
    }
    public Saidas(int idProduto, float quantidade, float preco, Integer idCliente, String data, String pagamento, String observacao, int pg, int numvenda) {
       this.idProduto = idProduto;
       this.quantidade = quantidade;
       this.preco = preco;
       this.idCliente = idCliente;
       this.data = data;
       this.pagamento = pagamento;
       this.observacao = observacao;
       this.pg = pg;
       this.numvenda = numvenda;
    }

    public int getNumvenda() {
        return numvenda;
    }

    public void setNumvenda(int numvenda) {
        this.numvenda = numvenda;
    }
   
    public Integer getIdSaidas() {
        return this.idSaidas;
    }
    
    public void setIdSaidas(Integer idSaidas) {
        this.idSaidas = idSaidas;
    }
    public int getIdProduto() {
        return this.idProduto;
    }
    
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public float getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    public float getPreco() {
        return this.preco;
    }
    
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    public String getPagamento() {
        return this.pagamento;
    }
    
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    public String getObservacao() {
        return this.observacao;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public int getPg() {
        return this.pg;
    }
    
    public void setPg(int pg) {
        this.pg = pg;
    }




}

