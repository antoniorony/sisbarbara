/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.barbara.Classes;


import Util.HibernateUtil;
import br.com.barbara.models.LogarUsuario;
import java.sql.SQLException;
import org.hibernate.Session;

/**
 *
 * @author anton
 */
public class Main {
    public static void main(String args[]) throws SQLException{
        Clientes clientes = new Clientes();
         clientes.setNome("admin");
        clientes.setApelido("admin");
        clientes.setBairro("admin");
        clientes.setCidade("admin");
        clientes.setCpf("admin");
        clientes.setEstado("admin");
        clientes.setLogradouro("admin");
        clientes.setTelefone("admin");
        clientes.setNumero(57);
                
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(clientes);
        s.getTransaction().commit();
        
        
        /* 
        ATUALIZA DADOS NO BANCO DE DADOS
       
        
        Usuario usuario = new Usuario();
     Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        usuario.setIdUsuario(1);
        usuario.setUsuario("rony");
        usuario.setSenha("rony");
        s.beginTransaction();
        s.update(usuario);
        s.getTransaction().commit();
         */
        
        /*
        EXCLUIR COM HIBERNATE
        Usuario usuario = new Usuario();
     Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        usuario.setIdUsuario(2);
        usuario.setUsuario("admin");
        usuario.setSenha("admin");
        s.beginTransaction();
        s.delete(usuario);
        s.getTransaction().commit();
        
        */
        
        /*
        
        PESQUISA COM HIBERNATE
        
        Session pesquisa = HibernateUtil.getSessionFactory().getCurrentSession();
        pesquisa.beginTransaction();
        List<Usuario> lista = (List<Usuario>)pesquisa.createQuery("From Usuario").list();
        
        for (Usuario u : lista) {
            System.out.println("Usuario: "+u.getUsuario());
            System.out.println("Senha: "+u.getSenha());
        }
        pesquisa.getTransaction().commit();
        
        */
        
        /*
        
        CÓDIGO PARA SALVAR DADOS NO BANCO COM HIBERNATE
        
        usuario.setUsuario("admin");
        usuario.setSenha("admin");
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(usuario);
        s.getTransaction().commit();
    
        */

    }
}
