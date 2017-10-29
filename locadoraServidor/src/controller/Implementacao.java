/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;

import model.Cliente;
import model.Funcionarios;
import controller.Conexao;

/**
 *
 * @author Rafael
 */
public class Implementacao extends UnicastRemoteObject implements Interface{
    
    public Implementacao()throws RemoteException{}
    
    
    @Override
    public String inserirCliente(Cliente cliente){
        
        try {
            //Conexao conexao = new Conexao();
            String sql = ("INSERT INTO cliente (nomeCliente,cpfCliente,telefoneCliente,emailCliente,"
                    + "enderecoCliente,cidadeCliente) VALUES (?, ?, ?, ?, ?, ?)");
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            
            ps.setString(1,cliente.getNome());
            
            ps.setInt(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4,cliente.getEmail());
            ps.setString(5,cliente.getEndereco());
            ps.setString(6,cliente.getCidade());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir: "+ex.getMessage());
        }
        return "Inserido Com sucesso !";
    }
    
    @Override
    public String atualizaCliente (Cliente clientes, int id) {
          
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement("update cliente set nomeCliente = ?, cpfCliente = ?,"
                   + " telefoneCliente = ?, emailCliente = ?, enderecoCliente = ?, cidadeCliente = ? where idCliente = ?");
           stmt.setString(1, clientes.getNome() );
           stmt.setInt(2, clientes.getCpf());
           stmt.setString(3, clientes.getTelefone());
           stmt.setString(4,clientes.getEmail());
           stmt.setString(5, clientes.getEndereco());
           stmt.setString(6, clientes.getCidade());
           stmt.setInt(7, id);
           
           stmt.executeUpdate();
           return " Cliente Atualizado !";
            
           } catch (SQLException ex) {
            System.out.println("Erro ao atualizar: "+ex.getMessage());
        }finally{
           Conexao.closeConnection(con, stmt);
        }         
        return null;
      }
    
    @Override
    public String removerCliente(int id){
        try {
            Conexao conexao = new Conexao();
            String sql = "delete from cliente where idCliente = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();

            return "Excluído com sucesso !";
        } catch (SQLException ex) {
            System.out.println(" Erro ao excluir!"+ex.getMessage());
        }        
        return null;
        
    
    }
    
    @Override
    public List<Cliente> listaClientes(){
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            List<Cliente> clientes = new ArrayList<>();
        
            try {
                stmt = con.prepareStatement("select * from cliente");
                rs = stmt.executeQuery();
              
                while(rs.next()){
                    Cliente cliente = new Cliente();  
                    cliente.setCodigo(rs.getInt("idCliente"));
                    cliente.setNome(rs.getString("nomeCliente"));
                    cliente.setCpf(rs.getInt("cpfCliente"));
                    cliente.setTelefone(rs.getString("telefoneCliente"));
                    cliente.setEmail(rs.getString("emailCliente"));
                    cliente.setEndereco(rs.getString("enderecoCliente"));
                    cliente.setCidade(rs.getString("cidadeCliente"));
                    
                    clientes.add(cliente);
                  
             }
             
           } catch (SQLException ex) {
              System.out.println(" Erro ao consultar clientes: "+ ex);
          }finally{
           Conexao.closeConnection(con, stmt,rs);
        }
         
          return clientes;
         
      }
    
    @Override
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

