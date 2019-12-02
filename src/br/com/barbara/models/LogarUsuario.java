/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.barbara.models;


import Util.HibernateUtil;
import br.com.barbara.Classes.Produtos;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author anton
 */
public class LogarUsuario {
  
    public static void main(String args[]){
     
        
      
        
    }
    
    
      
    
 /*  
      private Session sessao;
    private Transaction trans;
    
public java.util.List<Usuario> getLista() throws SQLException {
    Session pesquisa = HibernateUtil.getSessionFactory().getCurrentSession();
        pesquisa.beginTransaction();
     Iterable<Usuario> lista; 
lista = pesquisa.createQuery("From Usuario").list();
       
        
        for (Usuario u : lista) {
            System.out.println("Usuario: "+u.getUsuario());
            System.out.println("Senha: "+u.getSenha());
        }
        pesquisa.getTransaction().commit(); 
        
        return (java.util.List<Usuario>) lista;
}


       
    
    public void salvaUsuario(Usuario usuario){
        try{
            
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.save(usuario);
        trans.commit();
        }catch(Exception e){
            System.out.println("------------"+e+"------------");
        }finally{
            sessao.close();
        }
        
        
    }
    
      public void excluiUsuario(Usuario usuario){
        try{
            
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.delete(usuario);
        trans.commit();
        }catch(Exception e){
            System.out.println("------------"+e+"------------");
        }finally{
            sessao.close();
        }
        
        
    }
      public void atualizarUsuario(Usuario usuario){
        try{
            
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        sessao.update(usuario);
        trans.commit();
        }catch(Exception e){
            System.out.println("------------"+e+"------------");
        }finally{
            sessao.close();
        }
        
        
    }
   
    */

     
}
