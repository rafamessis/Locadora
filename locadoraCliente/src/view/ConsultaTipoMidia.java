/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Interface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Categoria;
import model.TipoMidia;

/**
 *
 * @author Hudson
 */
public class ConsultaTipoMidia extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaTipoMidia
     */
    
    private List<TipoMidia> tiposmidia = new ArrayList<TipoMidia>();
    private TipoMidia tipomidia;
    
    public ConsultaTipoMidia() {
        initComponents();
        
        try{
        Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
        Interface objetoRemoto = (Interface) conexao.lookup("chave");
        
        DefaultTableModel tabela = (DefaultTableModel)tabelaTipoMidia.getModel();
        tabelaTipoMidia.setRowSorter(new TableRowSorter(tabela));
        tabela.setNumRows(0);
        
        tiposmidia = objetoRemoto.listaTipoMidias();
        for(TipoMidia t: tiposmidia){
            tabela.addRow(new Object[]{t.getCodigo(), t.getNome()});
        }
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    
    public ConsultaTipoMidia(TipoMidia tipomidia) {
        this();
        
        this.tipomidia = tipomidia;
    }

    public TipoMidia GetTipoMidia() {
        return tipomidia;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTipoMidia = new javax.swing.JTable();
        botaoSelecionar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta de Tipo de Mídia do Filme");

        tabelaTipoMidia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo Mídia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTipoMidia.getTableHeader().setReorderingAllowed(false);
        tabelaTipoMidia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTipoMidiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaTipoMidia);

        botaoSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/GravarPequeno.png"))); // NOI18N
        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarActionPerformed(evt);
            }
        });

        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CancelarPequeno.png"))); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(botaoSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarActionPerformed
        // TODO add your handling code here:
        
        Filmeview telaFilme = new Filmeview();
        
        if(tabelaTipoMidia.getSelectedRow() == -1)
            return;
                
        
        tipomidia = tiposmidia.get(tabelaTipoMidia.getSelectedRow());
        dispose();
        
    }//GEN-LAST:event_botaoSelecionarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void tabelaTipoMidiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTipoMidiaMouseClicked
        // TODO add your handling code here:
        
        if (evt.getClickCount() == 2)  
        {  
            botaoSelecionar.doClick();
        }
        
    }//GEN-LAST:event_tabelaTipoMidiaMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaTipoMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaTipoMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaTipoMidia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSelecionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaTipoMidia;
    // End of variables declaration//GEN-END:variables
}
