/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Rafael
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrinciapl
     */
    public TelaPrincipal() {
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

        Pprincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        cadClientes = new javax.swing.JMenuItem();
        cadFuncionarios = new javax.swing.JMenuItem();
        cadCategorias = new javax.swing.JMenuItem();
        cadDistribuidoras = new javax.swing.JMenuItem();
        cadFilmes = new javax.swing.JMenuItem();
        cadGeneros = new javax.swing.JMenuItem();
        cadTiposMidia = new javax.swing.JMenuItem();
        menuLancamentos = new javax.swing.JMenu();
        lancLocacao = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pprincipal.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout PprincipalLayout = new javax.swing.GroupLayout(Pprincipal);
        Pprincipal.setLayout(PprincipalLayout);
        PprincipalLayout.setHorizontalGroup(
            PprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1176, Short.MAX_VALUE)
        );
        PprincipalLayout.setVerticalGroup(
            PprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        menuCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Novo.png"))); // NOI18N
        menuCadastros.setText("Cadastros");
        menuCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrosActionPerformed(evt);
            }
        });

        cadClientes.setText("Clientes");
        cadClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadClientesActionPerformed(evt);
            }
        });
        menuCadastros.add(cadClientes);

        cadFuncionarios.setText("Funcionarios");
        cadFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadFuncionariosActionPerformed(evt);
            }
        });
        menuCadastros.add(cadFuncionarios);

        cadCategorias.setText("Categorias");
        cadCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadCategoriasActionPerformed(evt);
            }
        });
        menuCadastros.add(cadCategorias);

        cadDistribuidoras.setText("Distribuidoras");
        cadDistribuidoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadDistribuidorasActionPerformed(evt);
            }
        });
        menuCadastros.add(cadDistribuidoras);

        cadFilmes.setText("Filmes");
        cadFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadFilmesActionPerformed(evt);
            }
        });
        menuCadastros.add(cadFilmes);

        cadGeneros.setText("Gêneros");
        cadGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadGenerosActionPerformed(evt);
            }
        });
        menuCadastros.add(cadGeneros);

        cadTiposMidia.setText("Tipos de Mídia");
        cadTiposMidia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadTiposMidiaActionPerformed(evt);
            }
        });
        menuCadastros.add(cadTiposMidia);

        jMenuBar1.add(menuCadastros);

        menuLancamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/contract.png"))); // NOI18N
        menuLancamentos.setText("Lançamento");

        lancLocacao.setText("Locação");
        lancLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancLocacaoActionPerformed(evt);
            }
        });
        menuLancamentos.add(lancLocacao);

        jMenuBar1.add(menuLancamentos);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadFuncionariosActionPerformed
       Funcionarioview obj = new Funcionarioview();
       Pprincipal.add(obj);
       obj.setVisible(true);
        
        
    }//GEN-LAST:event_cadFuncionariosActionPerformed

    private void cadClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadClientesActionPerformed
       Clienteview obj = new Clienteview();
       Pprincipal.add(obj);
       obj.setVisible(true);
       
        
        
        
    }//GEN-LAST:event_cadClientesActionPerformed

    private void menuCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrosActionPerformed
        
       
        
    }//GEN-LAST:event_menuCadastrosActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuSairMouseClicked

    private void cadCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadCategoriasActionPerformed
        // TODO add your handling code here:
        Categoriaview obj = new Categoriaview();
        Pprincipal.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_cadCategoriasActionPerformed

    private void cadDistribuidorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadDistribuidorasActionPerformed
        // TODO add your handling code here:
        Distribuidoraview obj = new Distribuidoraview();
        Pprincipal.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_cadDistribuidorasActionPerformed

    private void cadFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadFilmesActionPerformed
        // TODO add your handling code here:
        Filmeview obj = new Filmeview();
        Pprincipal.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_cadFilmesActionPerformed

    private void cadGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadGenerosActionPerformed
        // TODO add your handling code here:
        Generoview obj = new Generoview();
        Pprincipal.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_cadGenerosActionPerformed

    private void cadTiposMidiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadTiposMidiaActionPerformed
        // TODO add your handling code here:
        TipoMidiaview obj = new TipoMidiaview();
        Pprincipal.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_cadTiposMidiaActionPerformed

    private void lancLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lancLocacaoActionPerformed
        // TODO add your handling code here:
        Locacaoview obj = new Locacaoview();
        Pprincipal.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_lancLocacaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pprincipal;
    private javax.swing.JMenuItem cadCategorias;
    private javax.swing.JMenuItem cadClientes;
    private javax.swing.JMenuItem cadDistribuidoras;
    private javax.swing.JMenuItem cadFilmes;
    private javax.swing.JMenuItem cadFuncionarios;
    private javax.swing.JMenuItem cadGeneros;
    private javax.swing.JMenuItem cadTiposMidia;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem lancLocacao;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuLancamentos;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

}
