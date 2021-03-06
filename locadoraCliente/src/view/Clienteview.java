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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Cliente;
/**
 *
 * @author Rafael
 */
public class Clienteview extends javax.swing.JInternalFrame {
    
    
    List<Cliente> clientes = null;
    int codigoAtual = 0;
    
    /**
     * Creates new form Cliente
     */
    public Clienteview() {
        initComponents();
        preencheTabela();
    }
    
    public void preencheTabela(){
        
        try{
        Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
        Interface objetoRemoto = (Interface) conexao.lookup("chave");
        
        DefaultTableModel tabela = (DefaultTableModel)tabelaCliente.getModel();
        tabelaCliente.setRowSorter(new TableRowSorter(tabela));
        tabela.setNumRows(0);
        clientes = objetoRemoto.listaClientes();
        for(int i=0;i<clientes.size();i++){
            tabela.addRow(new Object[]{clientes.get(i).getCodigo(),clientes.get(i).getNome(),
                clientes.get(i).getCpf(),clientes.get(i).getTelefone(),clientes.get(i).getEmail(),
                clientes.get(i).getEndereco(), clientes.get(i).getCidade()});
        }
    } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        codCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cpfCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        telCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        enderecoCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cidCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        emailCliente = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        botaoExcluir = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastro de Clientes");

        jLabel1.setText("Nome:");

        nomeCliente.setEnabled(false);
        nomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo:");

        codCliente.setEnabled(false);

        jLabel4.setText("CPF:");

        cpfCliente.setEnabled(false);

        jLabel7.setText("Telefone:");

        telCliente.setEnabled(false);

        jLabel8.setText("Endereço:");

        enderecoCliente.setEnabled(false);

        jLabel11.setText("Cidade:");

        cidCliente.setEnabled(false);

        jLabel12.setText("E-mail:");

        emailCliente.setEnabled(false);

        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/GravarPequeno.png"))); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setEnabled(false);
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Telefone", "E-mail", "Endereço", "Cidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCliente.getTableHeader().setReorderingAllowed(false);
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ExcluirPequeno.png"))); // NOI18N
        botaoExcluir.setText("Excluir");
        botaoExcluir.setEnabled(false);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/NovoPequeno.png"))); // NOI18N
        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });

        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CancelarPequeno.png"))); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setEnabled(false);
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel3.setText("*somente números");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(codCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(telCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12)
                        .addGap(8, 8, 8)
                        .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(enderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11)
                        .addGap(3, 3, 3)
                        .addComponent(cidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(botaoNovo)
                        .addGap(18, 18, 18)
                        .addComponent(botaoSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCancelar)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(codCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(telCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(enderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(cidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNovo)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoCancelar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeClienteActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
      
      
//    client.setCodigo(Integer.parseInt(codCliente.getText()));
        if (!(nomeCliente.getText()).isEmpty() && !(cpfCliente.getText()).isEmpty() && !(telCliente.getText()).isEmpty() && !(emailCliente.getText()).isEmpty() && !(enderecoCliente.getText()).isEmpty() && !(cidCliente.getText()).isEmpty()){
            
            Cliente cliente = new Cliente();

            cliente.setNome(nomeCliente.getText());
            cliente.setCpf(Integer.parseInt(cpfCliente.getText()));
            cliente.setTelefone(telCliente.getText());
            cliente.setEmail(emailCliente.getText());
            cliente.setEndereco(enderecoCliente.getText());
            cliente.setCidade(cidCliente.getText());

            try {
                Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
                Interface objetoRemoto = (Interface) conexao.lookup("chave");
                if(codigoAtual > 0){
                    JOptionPane.showMessageDialog(this,objetoRemoto.atualizaCliente(cliente,codigoAtual));
                }else{
                    JOptionPane.showMessageDialog(this,objetoRemoto.inserirCliente(cliente));
                }
                codCliente.setEnabled(false);
                nomeCliente.setEnabled(false);
                cpfCliente.setEnabled(false);
                telCliente.setEnabled(false);
                emailCliente.setEnabled(false);
                enderecoCliente.setEnabled(false);
                cidCliente.setEnabled(false);
                codCliente.setText("");
                nomeCliente.setText("");
                cpfCliente.setText("");
                telCliente.setText("");
                emailCliente.setText("");
                enderecoCliente.setText("");
                cidCliente.setText("");
                codigoAtual=0;
                botaoNovo.setEnabled(true);
                botaoSalvar.setEnabled(false);
                botaoExcluir.setEnabled(false);
                botaoCancelar.setEnabled(false);
                tabelaCliente.setVisible(true);
                preencheTabela();

            } catch (RemoteException ex) {
                System.out.println(ex.getMessage());
            } catch (NotBoundException ex) {
                System.out.println(ex.getMessage());
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Preenchimento de todos os campos obrigatório !");
        }
      
      
      
        
        
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        // TODO add your handling code here:
        try {
            Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
            Interface objetoRemoto = (Interface) conexao.lookup("chave");

            JOptionPane.showMessageDialog(this,objetoRemoto.removerCliente(codigoAtual));
            codCliente.setEnabled(false);
            codCliente.setText("");
            nomeCliente.setText("");
            cpfCliente.setText("");
            telCliente.setText("");
            emailCliente.setText("");
            enderecoCliente.setText("");
            cidCliente.setText("");
            codigoAtual=0;
            botaoExcluir.setEnabled(false);
            preencheTabela();

        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        // TODO add your handling code here:
        
        Cliente cliente = clientes.get(tabelaCliente.getSelectedRow());
           
        codCliente.setText(String.valueOf(cliente.getCodigo()));
        nomeCliente.setText(cliente.getNome());
        cpfCliente.setText(String.valueOf(cliente.getCpf()));
        telCliente.setText(cliente.getTelefone());
        emailCliente.setText(cliente.getEmail());
        enderecoCliente.setText(cliente.getEndereco());
        cidCliente.setText(cliente.getCidade());
        
        codigoAtual = cliente.getCodigo();
        
        nomeCliente.setEnabled(true);
        cpfCliente.setEnabled(true);
        telCliente.setEnabled(true);
        emailCliente.setEnabled(true);
        enderecoCliente.setEnabled(true);
        cidCliente.setEnabled(true);
        botaoSalvar.setEnabled(true);
        botaoExcluir.setEnabled(true);
        botaoCancelar.setEnabled(true);
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        // TODO add your handling code here:
        codCliente.setEnabled(false);
        nomeCliente.setEnabled(true);
        cpfCliente.setEnabled(true);
        telCliente.setEnabled(true);
        emailCliente.setEnabled(true);
        enderecoCliente.setEnabled(true);
        cidCliente.setEnabled(true);
        codCliente.setText("");
        nomeCliente.setText("");
        cpfCliente.setText("");
        telCliente.setText("");
        emailCliente.setText("");
        enderecoCliente.setText("");
        cidCliente.setText("");
        codigoAtual=0;
        botaoNovo.setEnabled(false);
        botaoSalvar.setEnabled(true);
        botaoExcluir.setEnabled(false);
        botaoCancelar.setEnabled(true);
        tabelaCliente.setVisible(false);
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // TODO add your handling code here:
        codCliente.setEnabled(false);
        nomeCliente.setEnabled(false);
        cpfCliente.setEnabled(false);
        telCliente.setEnabled(false);
        emailCliente.setEnabled(false);
        enderecoCliente.setEnabled(false);
        cidCliente.setEnabled(false);
        codCliente.setText("");
        nomeCliente.setText("");
        cpfCliente.setText("");
        telCliente.setText("");
        emailCliente.setText("");
        enderecoCliente.setText("");
        cidCliente.setText("");
        codigoAtual=0;
        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoCancelar.setEnabled(false);
        tabelaCliente.setVisible(true);
    }//GEN-LAST:event_botaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField cidCliente;
    private javax.swing.JTextField codCliente;
    private javax.swing.JTextField cpfCliente;
    private javax.swing.JTextField emailCliente;
    private javax.swing.JTextField enderecoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField telCliente;
    // End of variables declaration//GEN-END:variables

    
}
