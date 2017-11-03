/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Interface;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Cliente;
import model.Filmes;
import model.Funcionarios;
import model.Locacao;

/**
 *
 * @author Hudson
 */
public class Locacaoview extends javax.swing.JInternalFrame {

    /**
     * Creates new form Locacaoview
     */
    
    List<Locacao> locacoes = null;
    int codigoAtual = 0;
    private Filmes filme = new Filmes();
    private Cliente cliente = new Cliente();
    private Funcionarios funcionario = new Funcionarios();
    
    
    public Locacaoview() {
        initComponents();
        preencheTabela();
    }

    
    public void preencheTabela(){
        
        try{
        Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
        Interface objetoRemoto = (Interface) conexao.lookup("chave");
        
        DefaultTableModel tabela = (DefaultTableModel)tabelaLocacao.getModel();
        tabelaLocacao.setRowSorter(new TableRowSorter(tabela));
        tabela.setNumRows(0);
        locacoes = objetoRemoto.listaLocacao();
        for(int i=0;i<locacoes.size();i++){
            tabela.addRow(new Object[]{locacoes.get(i).getCodigo(),objetoRemoto.pegaFilmes(locacoes.get(i).getFilme()),objetoRemoto.pegaCliente(locacoes.get(i).getCliente()),locacoes.get(i).getDataLoc().toString()});
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        codigoFilme = new javax.swing.JTextField();
        codigoCliente = new javax.swing.JTextField();
        codigoFuncionario = new javax.swing.JTextField();
        dataLocacao = new org.jdesktop.swingx.JXDatePicker();
        botaoConsultaFilme = new javax.swing.JButton();
        botaoConsultaCliente = new javax.swing.JButton();
        botaoConsultaFuncionario = new javax.swing.JButton();
        nomeFilme = new javax.swing.JTextField();
        nomeCliente = new javax.swing.JTextField();
        nomeFuncionario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLocacao = new javax.swing.JTable();
        botaoSalvar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Inclusão de Locações");

        jLabel1.setText("Código:");

        jLabel2.setText("Filme:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Funcionário:");

        jLabel5.setText("Data:");

        campoCodigo.setEnabled(false);

        codigoFilme.setEnabled(false);
        codigoFilme.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFilmeFocusLost(evt);
            }
        });

        codigoCliente.setEnabled(false);
        codigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoClienteFocusLost(evt);
            }
        });

        codigoFuncionario.setEnabled(false);
        codigoFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFuncionarioFocusLost(evt);
            }
        });

        dataLocacao.setEnabled(false);

        botaoConsultaFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PesquisarPequeno.png"))); // NOI18N
        botaoConsultaFilme.setEnabled(false);
        botaoConsultaFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultaFilmeActionPerformed(evt);
            }
        });

        botaoConsultaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PesquisarPequeno.png"))); // NOI18N
        botaoConsultaCliente.setEnabled(false);
        botaoConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultaClienteActionPerformed(evt);
            }
        });

        botaoConsultaFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/PesquisarPequeno.png"))); // NOI18N
        botaoConsultaFuncionario.setEnabled(false);
        botaoConsultaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultaFuncionarioActionPerformed(evt);
            }
        });

        nomeFilme.setEditable(false);
        nomeFilme.setEnabled(false);

        nomeCliente.setEditable(false);
        nomeCliente.setEnabled(false);

        nomeFuncionario.setEditable(false);
        nomeFuncionario.setEnabled(false);

        tabelaLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Filme", "Cliente", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLocacao.getTableHeader().setReorderingAllowed(false);
        tabelaLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLocacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaLocacao);

        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/GravarPequeno.png"))); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setEnabled(false);
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigoFilme, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoConsultaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoConsultaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeFilme))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 76, Short.MAX_VALUE)
                        .addComponent(botaoNovo)
                        .addGap(18, 18, 18)
                        .addComponent(botaoSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCancelar)
                        .addGap(65, 65, 65)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(codigoFilme)
                                .addComponent(jLabel2))
                            .addComponent(botaoConsultaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(codigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoConsultaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoNovo)
                    .addComponent(botaoCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLocacaoMouseClicked
        // TODO add your handling code here:
        
        Locacao locacao = locacoes.get(tabelaLocacao.getSelectedRow());
           
        campoCodigo.setText(String.valueOf(locacao.getCodigo()));
        codigoFilme.setText(String.valueOf(locacao.getFilme()));
        codigoCliente.setText(String.valueOf(locacao.getCliente()));
        codigoFuncionario.setText(String.valueOf(locacao.getFuncionario()));
        dataLocacao.setDate(locacao.getDataLoc());
        
        codigoAtual = locacao.getCodigo();
        
        campoCodigo.setEnabled(false);
        codigoFilme.setEnabled(true);
        codigoCliente.setEnabled(true);
        codigoFuncionario.setEnabled(true);
        nomeFilme.setEnabled(true);
        nomeCliente.setEnabled(true);
        nomeFuncionario.setEnabled(true);
        dataLocacao.setEnabled(true);
        botaoConsultaFilme.setEnabled(true);
        botaoConsultaCliente.setEnabled(true);
        botaoConsultaFuncionario.setEnabled(true);
        
        botaoSalvar.setEnabled(true);
        botaoExcluir.setEnabled(true);
        botaoCancelar.setEnabled(true);
        
        codigoFilme.requestFocus();
        codigoCliente.requestFocus();
        codigoFuncionario.requestFocus();
        botaoSalvar.requestFocus();
        
    }//GEN-LAST:event_tabelaLocacaoMouseClicked

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        // TODO add your handling code here:
        
        campoCodigo.setEnabled(false);
        codigoFilme.setEnabled(true);
        codigoCliente.setEnabled(true);
        codigoFuncionario.setEnabled(true);
        nomeFilme.setEnabled(true);
        nomeCliente.setEnabled(true);
        nomeFuncionario.setEnabled(true);
        dataLocacao.setEnabled(true);
        botaoConsultaFilme.setEnabled(true);
        botaoConsultaCliente.setEnabled(true);
        botaoConsultaFuncionario.setEnabled(true);
        
        campoCodigo.setText("");
        codigoFilme.setText("");
        codigoCliente.setText("");
        codigoFuncionario.setText("");
        //dataLocacao.setDate("");
        nomeFilme.setText("");
        nomeCliente.setText("");
        nomeFuncionario.setText("");
        
        codigoAtual=0;
        
        botaoNovo.setEnabled(false);
        botaoSalvar.setEnabled(true);
        botaoExcluir.setEnabled(false);
        botaoCancelar.setEnabled(true);
        
        tabelaLocacao.setVisible(false);
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        // TODO add your handling code here:
        
        if (!(codigoFilme.getText()).isEmpty() && !(codigoCliente.getText()).isEmpty() && !(codigoFuncionario.getText()).isEmpty() && !(dataLocacao.getDate() == null)){
            
            Locacao locacao = new Locacao();

            locacao.setFilme(Integer.parseInt(codigoFilme.getText()));
            locacao.setCliente((Integer.parseInt(codigoCliente.getText())));
            locacao.setFuncionario(Integer.parseInt(codigoFuncionario.getText()));
            locacao.setDataLoc(dataLocacao.getDate());
            

            try {
                Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
                Interface objetoRemoto = (Interface) conexao.lookup("chave");
                if(codigoAtual > 0){
                    JOptionPane.showMessageDialog(this,objetoRemoto.atualizaLocacao(locacao,codigoAtual));
                }else{
                    JOptionPane.showMessageDialog(this,objetoRemoto.inserirLocacao(locacao));
                }
                campoCodigo.setEnabled(false);
                codigoFilme.setEnabled(false);
                codigoCliente.setEnabled(false);
                codigoFuncionario.setEnabled(false);
                nomeFilme.setEnabled(false);
                nomeCliente.setEnabled(false);
                nomeFuncionario.setEnabled(false);
                dataLocacao.setEnabled(false);
                botaoConsultaFilme.setEnabled(false);
                botaoConsultaCliente.setEnabled(false);
                botaoConsultaFuncionario.setEnabled(false);

                campoCodigo.setText("");
                codigoFilme.setText("");
                codigoCliente.setText("");
                codigoFuncionario.setText("");
                //dataLocacao.setDate("");
                nomeFilme.setText("");
                nomeCliente.setText("");
                nomeFuncionario.setText("");
                
                codigoAtual=0;
                
                botaoNovo.setEnabled(true);
                botaoSalvar.setEnabled(false);
                botaoExcluir.setEnabled(false);
                botaoCancelar.setEnabled(false);
                
                tabelaLocacao.setVisible(true);
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

            JOptionPane.showMessageDialog(this,objetoRemoto.removerLocacao(codigoAtual));
            campoCodigo.setEnabled(false);
            codigoFilme.setEnabled(false);
            codigoCliente.setEnabled(false);
            codigoFuncionario.setEnabled(false);
            nomeFilme.setEnabled(false);
            nomeCliente.setEnabled(false);
            nomeFuncionario.setEnabled(false);
            dataLocacao.setEnabled(false);
            botaoConsultaFilme.setEnabled(false);
            botaoConsultaCliente.setEnabled(false);
            botaoConsultaFuncionario.setEnabled(false);

            campoCodigo.setText("");
            codigoFilme.setText("");
            codigoCliente.setText("");
            codigoFuncionario.setText("");
            //dataLocacao.setDate("");
            nomeFilme.setText("");
            nomeCliente.setText("");
            nomeFuncionario.setText("");
            
            codigoAtual=0;
            
            botaoSalvar.setEnabled(false);
            botaoExcluir.setEnabled(false);
            botaoCancelar.setEnabled(false);
            
            preencheTabela();

        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // TODO add your handling code here:
        
        campoCodigo.setEnabled(false);
        codigoFilme.setEnabled(false);
        codigoCliente.setEnabled(false);
        codigoFuncionario.setEnabled(false);
        nomeFilme.setEnabled(false);
        nomeCliente.setEnabled(false);
        nomeFuncionario.setEnabled(false);
        dataLocacao.setEnabled(false);
        botaoConsultaFilme.setEnabled(false);
        botaoConsultaCliente.setEnabled(false);
        botaoConsultaFuncionario.setEnabled(false);

        campoCodigo.setText("");
        codigoFilme.setText("");
        codigoCliente.setText("");
        codigoFuncionario.setText("");
        //dataLocacao.setDate("");
        nomeFilme.setText("");
        nomeCliente.setText("");
        nomeFuncionario.setText("");
        
        codigoAtual=0;
        
        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoCancelar.setEnabled(false);
        
        tabelaLocacao.setVisible(true);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void codigoFilmeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFilmeFocusLost
        // TODO add your handling code here:
        if(!(codigoFilme.getText()).isEmpty()){
            try{
                Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
                Interface objetoRemoto = (Interface) conexao.lookup("chave");
                if( objetoRemoto.pegaFilmes(Integer.parseInt(codigoFilme.getText())) != null){
                    nomeFilme.setText(objetoRemoto.pegaFilmes(Integer.parseInt(codigoFilme.getText())));
                }else{
                    nomeFilme.setText("");
                    JOptionPane.showMessageDialog(null,"Código de filme não localizado");
                    codigoFilme.requestFocus();
                }
            } catch (RemoteException ex) {
                System.out.println(ex.getMessage());
            } catch (NotBoundException ex) {
                System.out.println(ex.getMessage());
            }
            
        }else{
            nomeFilme.setText("");
        }
        
    }//GEN-LAST:event_codigoFilmeFocusLost

    private void codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoClienteFocusLost
        // TODO add your handling code here:
        if(!(codigoCliente.getText()).isEmpty()){
            try{
                Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
                Interface objetoRemoto = (Interface) conexao.lookup("chave");
                if( objetoRemoto.pegaCliente(Integer.parseInt(codigoCliente.getText())) != null){
                    nomeCliente.setText(objetoRemoto.pegaCliente(Integer.parseInt(codigoCliente.getText())));
                }else{
                    nomeCliente.setText("");
                    JOptionPane.showMessageDialog(null,"Código de cliente não localizado");
                    codigoCliente.requestFocus();
                }
            } catch (RemoteException ex) {
                System.out.println(ex.getMessage());
            } catch (NotBoundException ex) {
                System.out.println(ex.getMessage());
            }
            
        }else{
            nomeCliente.setText("");
        }
        
    }//GEN-LAST:event_codigoClienteFocusLost

    private void codigoFuncionarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFuncionarioFocusLost
        // TODO add your handling code here:
        if(!(codigoFuncionario.getText()).isEmpty()){
            try{
                Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
                Interface objetoRemoto = (Interface) conexao.lookup("chave");
                if( objetoRemoto.pegaFuncionario(Integer.parseInt(codigoFuncionario.getText())) != null){
                    nomeFuncionario.setText(objetoRemoto.pegaFuncionario(Integer.parseInt(codigoFuncionario.getText())));
                }else{
                    nomeFuncionario.setText("");
                    JOptionPane.showMessageDialog(null,"Código de funcionário não localizado");
                    codigoFuncionario.requestFocus();
                }
            } catch (RemoteException ex) {
                System.out.println(ex.getMessage());
            } catch (NotBoundException ex) {
                System.out.println(ex.getMessage());
            }
            
        }else{
            nomeFuncionario.setText("");
        }
        
    }//GEN-LAST:event_codigoFuncionarioFocusLost

    private void botaoConsultaFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultaFilmeActionPerformed
        // TODO add your handling code here:
        
        ConsultaFilme consultafilme = new ConsultaFilme(filme);
        
        consultafilme.addWindowListener(new WindowListener() {
           @Override
           public void windowOpened(WindowEvent e) {
           }

           @Override
           public void windowClosing(WindowEvent e) {
           }

           @Override
           public void windowClosed(WindowEvent e) {
               
                filme = consultafilme.GetFilme();
                
                if(filme.getCodigo() > 0){
                    String dados;
                    try{
                        Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
                        Interface objetoRemoto = (Interface) conexao.lookup("chave");
                        dados = objetoRemoto.pegaFilmes(filme.getCodigo());
                        if( dados != null){
                        nomeFilme.setText(dados);
                        codigoFilme.setText(Integer.toString(filme.getCodigo()));
                        }else{
                        nomeFilme.setText("");
                        JOptionPane.showMessageDialog(null,"Código de filme não localizado");
                        }
                        
                    } catch (RemoteException ex) {
                        System.out.println(ex.getMessage());
                    } catch (NotBoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
               
           }

           @Override
           public void windowIconified(WindowEvent e) {
           }

           @Override
           public void windowDeiconified(WindowEvent e) {
           }

           @Override
           public void windowActivated(WindowEvent e) {
           }

           @Override
           public void windowDeactivated(WindowEvent e) {
           }
       });
       consultafilme.setVisible(true);
        
    }//GEN-LAST:event_botaoConsultaFilmeActionPerformed

    private void botaoConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultaClienteActionPerformed
        // TODO add your handling code here:
        
        ConsultaCliente consultacliente = new ConsultaCliente(cliente);
        
        consultacliente.addWindowListener(new WindowListener() {
           @Override
           public void windowOpened(WindowEvent e) {
           }

           @Override
           public void windowClosing(WindowEvent e) {
           }

           @Override
           public void windowClosed(WindowEvent e) {
               
                cliente = consultacliente.GetCliente();
                
                if(cliente.getCodigo() > 0){
                    String dados;
                    try{
                        Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
                        Interface objetoRemoto = (Interface) conexao.lookup("chave");
                        dados = objetoRemoto.pegaCliente(cliente.getCodigo());
                        if( dados != null){
                        nomeCliente.setText(dados);
                        codigoCliente.setText(Integer.toString(cliente.getCodigo()));
                        }else{
                        nomeCliente.setText("");
                        JOptionPane.showMessageDialog(null,"Código de cliente não localizado");
                        }
                        
                    } catch (RemoteException ex) {
                        System.out.println(ex.getMessage());
                    } catch (NotBoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
               
           }

           @Override
           public void windowIconified(WindowEvent e) {
           }

           @Override
           public void windowDeiconified(WindowEvent e) {
           }

           @Override
           public void windowActivated(WindowEvent e) {
           }

           @Override
           public void windowDeactivated(WindowEvent e) {
           }
       });
       consultacliente.setVisible(true);
        
    }//GEN-LAST:event_botaoConsultaClienteActionPerformed

    private void botaoConsultaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultaFuncionarioActionPerformed
        // TODO add your handling code here:
        
        ConsultaFuncionario consultafuncionario = new ConsultaFuncionario(funcionario);
        
        consultafuncionario.addWindowListener(new WindowListener() {
           @Override
           public void windowOpened(WindowEvent e) {
           }

           @Override
           public void windowClosing(WindowEvent e) {
           }

           @Override
           public void windowClosed(WindowEvent e) {
               
                funcionario = consultafuncionario.GetFuncionario();
                
                if(funcionario.getCodigo() > 0){
                    String dados;
                    try{
                        Registry conexao = LocateRegistry.getRegistry("127.0.0.1",1500);
                        Interface objetoRemoto = (Interface) conexao.lookup("chave");
                        dados = objetoRemoto.pegaFuncionario(funcionario.getCodigo());
                        if( dados != null){
                        nomeFuncionario.setText(dados);
                        codigoFuncionario.setText(Integer.toString(funcionario.getCodigo()));
                        }else{
                        nomeFuncionario.setText("");
                        JOptionPane.showMessageDialog(null,"Código de funcionário não localizado");
                        }
                        
                    } catch (RemoteException ex) {
                        System.out.println(ex.getMessage());
                    } catch (NotBoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
               
           }

           @Override
           public void windowIconified(WindowEvent e) {
           }

           @Override
           public void windowDeiconified(WindowEvent e) {
           }

           @Override
           public void windowActivated(WindowEvent e) {
           }

           @Override
           public void windowDeactivated(WindowEvent e) {
           }
       });
       consultafuncionario.setVisible(true);
        
    }//GEN-LAST:event_botaoConsultaFuncionarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConsultaCliente;
    private javax.swing.JButton botaoConsultaFilme;
    private javax.swing.JButton botaoConsultaFuncionario;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField codigoCliente;
    private javax.swing.JTextField codigoFilme;
    private javax.swing.JTextField codigoFuncionario;
    private org.jdesktop.swingx.JXDatePicker dataLocacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTextField nomeFilme;
    private javax.swing.JTextField nomeFuncionario;
    private javax.swing.JTable tabelaLocacao;
    // End of variables declaration//GEN-END:variables
}
