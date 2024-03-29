/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.barbara.visao;

import Util.HibernateUtil;
import br.com.barbara.Classes.Clientes;
import br.com.barbara.Classes.Parcela;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import br.com.barbara.visao.Parcelamentos;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author anton
 */
public class DebitoCliente extends javax.swing.JDialog {
private  DefaultTableModel tmResultSet = new DefaultTableModel(null, new String[]{"ID","NOME","TELEFONE", "STATUS"});;
   
java.util.List<Clientes> resultado;  
      private ListSelectionModel lsmResult;
      private DefaultTableModel tabela;
    /**
     * Creates new form DebitoCliente
     */
    public DebitoCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupCliente = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jTPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENTES EM DEBITO - SCE - TEC.INOVA");

        jPanel1.setBackground(new java.awt.Color(254, 131, 159));

        jTPesquisa.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPesquisaKeyPressed(evt);
            }
        });

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(tmResultSet);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);          lsmResult = jTable1.getSelectionModel();          lsmResult.addListSelectionListener(new ListSelectionListener() {               public void valueChanged(ListSelectionEvent e) {                                        if (! e.getValueIsAdjusting()){                           jTTabelaLinhaSelecionada(jTable1);                       }                                    }          });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(754, 512));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisaKeyPressed
        
        if (evt.getKeyCode() == evt.VK_SPACE) {
    jPopupCliente.removeAll();
        
        pesquisaSelecionadaCliente(jTPesquisa.getText());
            jTPesquisa.add(jPopupCliente);
            jTPesquisa.setComponentPopupMenu(jPopupCliente);
            try {
                int dotPosition = jTPesquisa.getCaretPosition();
                Rectangle popupLocation = jTPesquisa.modelToView(dotPosition);
                jPopupCliente.show(jTPesquisa, popupLocation.x, popupLocation.y+30);
                jTPesquisa.setFocusable(true);
            } catch (BadLocationException badLocationException) {
                System.out.println("Oops");
            }   
 }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTPesquisaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

  mostraPesquisa();
 
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DebitoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DebitoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DebitoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DebitoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DebitoCliente dialog = new DebitoCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTPesquisa;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


private void pesquisaSelecionadaCliente(String text) {
Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Criteria crit = sesion.createCriteria(Clientes.class);
        crit.add(Restrictions.like("nome",text+"%"));
        java.util.List results = crit.list();
        for (Iterator iterator = results.iterator(); iterator.hasNext();){
        Clientes Sal = (Clientes) iterator.next();  
        
        
         JMenuItem item = new JMenuItem(Sal.getIdCliente()+","+Sal.getNome());
          item.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent arg0){
             String mods = item.getText();
             String campos[] = mods.split(",");
          
             jTPesquisa.setText(campos[1]);
          
         
           }});
          jPopupCliente.add(item);
             }

         

}
private void mostraPesquisa() {
         tabela = (DefaultTableModel)jTable1.getModel();
        tabela.setNumRows(0);
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Criteria crit = sesion.createCriteria(Clientes.class);
        Criteria crit2 = sesion.createCriteria(Parcela.class);
        //crit.add(Restrictions.like("descricao",text+"%"));
        java.util.List results = crit.list();
        
         java.util.List results2 = crit2.list();
       int cond = 0;
       String pagamento = null;
       
       
        for (Iterator iterator = results.iterator(); iterator.hasNext();){
        Clientes Sal = (Clientes) iterator.next(); 
        int idClienteC = Sal.getIdCliente();
         for (Iterator iterator2 = results2.iterator(); iterator2.hasNext();){
             br.com.barbara.Classes.Parcela Sal2 = (br.com.barbara.Classes.Parcela) iterator2.next(); 
             if(Sal2.getIdcliente() == idClienteC && Sal2.getPago()==0){
                 cond = Sal2.getIdcliente();
                 pagamento =  "EM ABERTO";
             }
        }
        if(cond == idClienteC){ 
        tmResultSet.addRow(new Object[]{
            //`enter code here`columns
            Sal.getIdCliente(),
            Sal.getNome(),
          //  Sal.getApelido(),
           // Sal.getCpf(),
            Sal.getTelefone(),
          //  Sal.getLogradouro(),
           // Sal.getNumero(),
          //  Sal.getBairro(),
          //  Sal.getCidade(),
           // Sal.getEstado(),
            pagamento
            
        });
        }
        }
        
        
 
      }

/*FAZER UM FOR PARA A TABELA PARCELA PARA VERIFICAR SE O CLIENTE POSSUI ALGUMA
PARCELA EM ABERTO, SE SIM ENTÃO MOSTRA NA TABELA;
        */


/*
private void mostraPesquisaFiltro(String text) {
 tabela = (DefaultTableModel)jTable1.getModel();
        tabela.setNumRows(0);
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Criteria crit = sesion.createCriteria(Clientes.class);
        crit.add(Restrictions.like("nome",text+"%"));
        java.util.List results = crit.list();
        for (Iterator iterator = results.iterator(); iterator.hasNext();){
        Clientes Sal = (Clientes) iterator.next(); 
        tmResultSet.addRow(new Object[]{
            //`enter code here`columns
            Sal.getIdCliente(),
            Sal.getNome(),
            Sal.getApelido(),
            Sal.getCpf(),
            Sal.getTelefone(),
            Sal.getLogradouro(),
            Sal.getNumero(),
            Sal.getBairro(),
            Sal.getCidade(),
            Sal.getEstado()
            
        });
        }    }
*/

private void jTTabelaLinhaSelecionada(JTable tabela) {
        if (jTable1.getSelectedRow()!= -1) {     
          int cod = Integer.parseInt((jTable1.getValueAt(jTable1.getSelectedRow(),0)).toString());
          String nomeForn = (jTable1.getValueAt(jTable1.getSelectedRow(),1)).toString();
                Parcelamentos parcelamentos = new Parcelamentos(null, true);
                parcelamentos.recebe(cod, nomeForn);
                parcelamentos.setVisible(true);
                
        }
     }
}
