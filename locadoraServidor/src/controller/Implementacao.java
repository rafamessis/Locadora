/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.Cliente;
import model.Funcionarios;

/**
 *
 * @author Rafael
 */
public abstract class Implementacao extends UnicastRemoteObject implements Interface{
    
    public Implementacao()throws RemoteException{}
    
    
    @Override
    public String inserirCliente(Cliente cliente){
        try {
            //Conexao conexao = new Conexao();
            String sql = "INSERT INTO cliente (nomeCliente,cpfCliente,telefoneCliente,emailCliente"
                    + "enderecoCliente,numeroCliente,bairroCliente) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4,cliente.getEmail());
            ps.setString(5,cliente.getEndereco());
            ps.setInt(6,cliente.getNumero());
            ps.setString(7,cliente.getBairro());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro"+ex.getMessage());
        }
        return "Inserido Com sucesso!";
    }
    
    public String removerCliente(Cliente cliente){
        try {
         Conexao conexao = new Conexao();
         String sql = "delete from produto where idProduto = ?";
         PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
         ps.setInt(1,cliente.getCodigo());
         
          JOptionPane.showMessageDialog(null," Exclusão realizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Erro ao excluir!"+ ex);
        }        
        return null;
        
    
    }
    public String inserirFuncionario(Funcionarios funcionarios){
        try {
            Conexao conexao = new Conexao();
            String sql = "INSERT INTO Pessoa (nomeFuncionario,cpfFuncionario,telefoneFuncionario"
                    + "salarioFuncionario,cargahorararia) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setString(1, funcionarios.getNome());
            ps.setInt(2, funcionarios.getCpf());
            ps.setString(3, funcionarios.getTelefone());
            ps.setFloat(4,funcionarios.getSalario());
            ps.setString(5,funcionarios.getCargahoraria());
            
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "Inserido Com sucesso!";
    }
}

