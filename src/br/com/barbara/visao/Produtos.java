/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.barbara.visao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author anton
 */
@Entity
@Table(name = "produtos", catalog = "i9_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByIdProduto", query = "SELECT p FROM Produtos p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produtos.findByUnidadeCompra", query = "SELECT p FROM Produtos p WHERE p.unidadeCompra = :unidadeCompra"),
    @NamedQuery(name = "Produtos.findByUnidadeVenda", query = "SELECT p FROM Produtos p WHERE p.unidadeVenda = :unidadeVenda"),
    @NamedQuery(name = "Produtos.findByIdFornecedor", query = "SELECT p FROM Produtos p WHERE p.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "Produtos.findByIdMarca", query = "SELECT p FROM Produtos p WHERE p.idMarca = :idMarca")})
public class Produtos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "unidadeCompra")
    private String unidadeCompra;
    @Basic(optional = false)
    @Column(name = "unidadeVenda")
    private String unidadeVenda;
    @Basic(optional = false)
    @Column(name = "idFornecedor")
    private int idFornecedor;
    @Basic(optional = false)
    @Column(name = "IdMarca")
    private int idMarca;

    public Produtos() {
    }

    public Produtos(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produtos(Integer idProduto, String descricao, String unidadeCompra, String unidadeVenda, int idFornecedor, int idMarca) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.unidadeCompra = unidadeCompra;
        this.unidadeVenda = unidadeVenda;
        this.idFornecedor = idFornecedor;
        this.idMarca = idMarca;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        Integer oldIdProduto = this.idProduto;
        this.idProduto = idProduto;
        changeSupport.firePropertyChange("idProduto", oldIdProduto, idProduto);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public String getUnidadeCompra() {
        return unidadeCompra;
    }

    public void setUnidadeCompra(String unidadeCompra) {
        String oldUnidadeCompra = this.unidadeCompra;
        this.unidadeCompra = unidadeCompra;
        changeSupport.firePropertyChange("unidadeCompra", oldUnidadeCompra, unidadeCompra);
    }

    public String getUnidadeVenda() {
        return unidadeVenda;
    }

    public void setUnidadeVenda(String unidadeVenda) {
        String oldUnidadeVenda = this.unidadeVenda;
        this.unidadeVenda = unidadeVenda;
        changeSupport.firePropertyChange("unidadeVenda", oldUnidadeVenda, unidadeVenda);
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        int oldIdFornecedor = this.idFornecedor;
        this.idFornecedor = idFornecedor;
        changeSupport.firePropertyChange("idFornecedor", oldIdFornecedor, idFornecedor);
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        int oldIdMarca = this.idMarca;
        this.idMarca = idMarca;
        changeSupport.firePropertyChange("idMarca", oldIdMarca, idMarca);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.barbara.visao.Produtos[ idProduto=" + idProduto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
