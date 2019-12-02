/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.barbara.models;

import Util.HibernateUtil;
import br.com.barbara.Classes.Produtos;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Antonio Rony
 */
public class SalvaProduto {
      private Session sessao;
    private Transaction trans;
    
     public void salvaProduto(Produtos produto){
        try{
            
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.save(produto);
        trans.commit();
        
            JOptionPane.showMessageDialog(null, produto.getDescricao()+" CADASTRADO COM SUCESSO");
        
        }catch(Exception e){
            System.out.println("------------"+e+"------------");
        }finally{
            sessao.close();
        }
        
        
    }
}
