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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.Categoria;
import model.Distribuidora;
import model.Filmes;
import model.Genero;
import model.Locacao;
import model.TipoMidia;

/**
 *
 * @author Rafael
 */
public class Implementacao extends UnicastRemoteObject implements Interface{
    
    public Implementacao()throws RemoteException{}
    
    DateFormat dataFormatada = new SimpleDateFormat("yyMMdd");
    
    //
    //CATEGORIA
    //
    
    @Override
    public String inserirCategoria(Categoria categoria){
        
        try {
            String sql = ("INSERT INTO categoria (nomeCat,valorLoc) VALUES (?, ?)");
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            
            ps.setString(1,categoria.getNome());
            ps.setDouble(2, categoria.getValorLoc());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir categoria: "+ex.getMessage());
        }
        return "Categoria inserido Com sucesso !";
    }
    
    @Override
    public String atualizaCategoria (Categoria categoria, int id) {
          
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement("update categoria set nomeCat = ?, valorLoc = ? where idcategoria = ?");
           stmt.setString(1, categoria.getNome());
           stmt.setDouble(2, categoria.getValorLoc());
           stmt.setInt(3, id);
           
           stmt.executeUpdate();
           return "Categoria Atualizada !";
            
           } catch (SQLException ex) {
            System.out.println("Erro ao atualizar categoria: "+ex.getMessage());
        }finally{
           Conexao.closeConnection(con, stmt);
        }         
        return null;
      }
    
    @Override
    public String removerCategoria(int id){
        try {
            Conexao conexao = new Conexao();
            String sql = "delete from categoria where idcategoria = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();

            return "Categoria excluído com sucesso !";
        } catch (SQLException ex) {
            System.out.println(" Erro ao excluir categoria!"+ex.getMessage());
        }        
        return null;
        
    
    }
    
    @Override
    public List<Categoria> listaCategoria(){
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            List<Categoria> categorias = new ArrayList<>();
        
            try {
                stmt = con.prepareStatement("select * from categoria");
                rs = stmt.executeQuery();
              
                while(rs.next()){
                    Categoria categoria = new Categoria();  
                    categoria.setCodigo(rs.getInt("idcategoria"));
                    categoria.setNome(rs.getString("nomeCat"));
                    categoria.setValorLoc(rs.getDouble("valorLoc"));
                    
                    categorias.add(categoria);
                  
             }
             
           } catch (SQLException ex) {
              System.out.println(" Erro ao consultar categorias: "+ ex);
          }finally{
           Conexao.closeConnection(con, stmt,rs);
        }
         
          return categorias;
         
      }
    
    //
    //CLIENTES
    //
    
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
    
    //
    // DISTRIBUIDORA
    //
    
    @Override
    public String inserirDistribuidora(Distribuidora distribuidora){
        
        try {
            String sql = ("INSERT INTO distribuidora (nome) VALUES (?)");
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(1,distribuidora.getNome());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir distribuidora: "+ex.getMessage());
        }
        return "Distribuidora inserido Com sucesso !";
    }
    
    @Override
    public String atualizaDistribuidora (Distribuidora distribuidora, int id) {
          
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement("update distribuidora set nome = ? where iddistribuidora = ?");
           stmt.setString(1, distribuidora.getNome());
           stmt.setInt(2, id);
           
           stmt.executeUpdate();
           return "Distribuidora Atualizada !";
            
           } catch (SQLException ex) {
            System.out.println("Erro ao atualizar distribuidora: "+ex.getMessage());
        }finally{
           Conexao.closeConnection(con, stmt);
        }         
        return null;
      }
    
    @Override
    public String removerDistribuidora(int id){
        try {
            Conexao conexao = new Conexao();
            String sql = "delete from distribuidora where iddistribuidora = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();

            return "Distribuidora excluído com sucesso !";
        } catch (SQLException ex) {
            System.out.println(" Erro ao excluir distribuidora!"+ex.getMessage());
        }        
        return null;
        
    
    }
    
    @Override
    public List<Distribuidora> listaDistribuidoras(){
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            List<Distribuidora> distribuidoras = new ArrayList<>();
        
            try {
                stmt = con.prepareStatement("select * from distribuidora");
                rs = stmt.executeQuery();
              
                while(rs.next()){
                    Distribuidora distribuidora = new Distribuidora();  
                    distribuidora.setCodigo(rs.getInt("iddistribuidora"));
                    distribuidora.setNome(rs.getString("nome"));
                    
                    distribuidoras.add(distribuidora);
                  
             }
             
           } catch (SQLException ex) {
              System.out.println(" Erro ao consultar distribuidora: "+ ex);
          }finally{
           Conexao.closeConnection(con, stmt,rs);
        }
         
          return distribuidoras;
         
      }
    
    //
    // FILMES
    //
    
    @Override
    public String inserirFilmes(Filmes filmes){
        
        try {
            //Conexao conexao = new Conexao();
            String sql = ("INSERT INTO filmes (nomeFilme,qntdDiscos,categoria,genero,"
                    + "tipoMidia,distribuidora, atoresPrinc, sinopse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            
            ps.setString(1,filmes.getNome());
            ps.setInt(2, filmes.getQtdDiscos());
            ps.setInt(3, filmes.getCategoria());
            ps.setInt(4, filmes.getGenero());
            ps.setInt(5, filmes.getTipoMidia());
            ps.setInt(6, filmes.getDistribuidora());
            ps.setString(7, filmes.getAtores());
            ps.setString(8, filmes.getSinopse());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir filme: "+ex.getMessage());
        }
        return "Filme inserido Com sucesso !";
    }
    
    @Override
    public String atualizaFilmes (Filmes filmes, int id) {
          
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update filmes set nomeFilme = ?, qntdDiscos = ?,"
                    + " categoria = ?, genero = ?, tipoMidia = ?, distribuidora = ?, atoresPrinc = ?, sinopse = ? where idFilmes = ?");
            stmt.setString(1,filmes.getNome());
            stmt.setInt(2, filmes.getQtdDiscos());
            stmt.setInt(3, filmes.getCategoria());
            stmt.setInt(4, filmes.getGenero());
            stmt.setInt(5, filmes.getTipoMidia());
            stmt.setInt(6, filmes.getDistribuidora());
            stmt.setString(7, filmes.getAtores());
            stmt.setString(8, filmes.getSinopse());
            stmt.setInt(9, id);
           
           stmt.executeUpdate();
           return "Filme Atualizado !";
            
           } catch (SQLException ex) {
            System.out.println("Erro ao atualizar filme: "+ex.getMessage());
        }finally{
           Conexao.closeConnection(con, stmt);
        }         
        return null;
      }
    
    @Override
    public String removerFilme(int id){
        try {
            Conexao conexao = new Conexao();
            String sql = "delete from filmes where idFilmes = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();

            return "Filme excluído com sucesso !";
        } catch (SQLException ex) {
            System.out.println(" Erro ao excluir filme!"+ex.getMessage());
        }        
        return null;
        
    
    }
    
    @Override
    public List<Filmes> listaFilmes(){
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            List<Filmes> filmes = new ArrayList<>();
        
            try {
                stmt = con.prepareStatement("select * from filmes");
                rs = stmt.executeQuery();
              
                while(rs.next()){
                    Filmes filme = new Filmes();  
                    filme.setCodigo(rs.getInt("idFilmes"));
                    filme.setNome(rs.getString("nomeFilme"));
                    filme.setQtdDiscos(rs.getInt("qntdDiscos"));
                    filme.setCategoria(rs.getInt("categoria"));
                    filme.setGenero(rs.getInt("genero"));
                    filme.setTipoMidia(rs.getInt("tipoMidia"));
                    filme.setDistribuidora(rs.getInt("distribuidora"));
                    filme.setAtores(rs.getString("atoresPrinc"));
                    filme.setSinopse(rs.getString("sinopse"));
                    
                    filmes.add(filme);
                  
             }
             
           } catch (SQLException ex) {
              System.out.println(" Erro ao consultar filmes: "+ ex);
          }finally{
           Conexao.closeConnection(con, stmt,rs);
        }
         
          return filmes;
         
      }
    
    //
    // FUNCIONARIO
    //
    
    @Override
    public String inserirFuncionario(Funcionarios funcionario){
        
        try {
            
            String sql = ("INSERT INTO funcionario (nomeFuncionario,cpfFuncionario) VALUES (?, ?)");
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            
            ps.setString(1,funcionario.getNome());
            ps.setInt(2, funcionario.getCpf());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir funcionário: "+ex.getMessage());
        }
        return "Funcionario inserido Com sucesso !";
    }
    
    @Override
    public String atualizaFuncionario (Funcionarios funcionario, int id) {
          
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement("update funcionario set nomeFuncionario = ?, cpfFuncionario = ? where idFuncionario = ?");
           stmt.setString(1, funcionario.getNome());
           stmt.setInt(2, funcionario.getCpf());
           stmt.setInt(3, id);
           
           stmt.executeUpdate();
           return "Funcionario Atualizado !";
            
           } catch (SQLException ex) {
            System.out.println("Erro ao atualizar funcionario: "+ex.getMessage());
        }finally{
           Conexao.closeConnection(con, stmt);
        }         
        return null;
      }
    
    @Override
    public String removerFuncionario(int id){
        try {
            Conexao conexao = new Conexao();
            String sql = "delete from funcionario where idFuncionario = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();

            return "Funcionario excluído com sucesso !";
        } catch (SQLException ex) {
            System.out.println(" Erro ao excluir funcionario!"+ex.getMessage());
        }        
        return null;
        
    
    }
    
    @Override
    public List<Funcionarios> listaFuncionario(){
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            List<Funcionarios> funcionarios = new ArrayList<>();
        
            try {
                stmt = con.prepareStatement("select * from funcionarios");
                rs = stmt.executeQuery();
              
                while(rs.next()){
                    Funcionarios funcionario = new Funcionarios();  
                    funcionario.setCodigo(rs.getInt("idFuncionario"));
                    funcionario.setNome(rs.getString("nomeFuncionario"));
                    funcionario.setCpf(rs.getInt("cpfFuncionario"));
                    
                    funcionarios.add(funcionario);
                  
             }
             
           } catch (SQLException ex) {
              System.out.println(" Erro ao consultar funcionarios: "+ ex);
          }finally{
           Conexao.closeConnection(con, stmt,rs);
        }
         
          return funcionarios;
         
      }
    
    
    /*@Override
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
    }*/
    
    //
    // GENERO
    //
    
    @Override
    public String inserirGenero(Genero genero){
        
        try {
            
            String sql = ("INSERT INTO genero (nomeGenero) VALUES (?)");
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(1,genero.getNome());
                        
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir gênero: "+ex.getMessage());
        }
        return "Gênero inserido Com sucesso !";
    }
    
    @Override
    public String atualizaGenero (Genero genero, int id) {
          
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement("update genero set nomeGenero = ? where idgenero = ?");
           stmt.setString(1, genero.getNome());
           stmt.setInt(2, id);
           
           stmt.executeUpdate();
           return "Gênero Atualizado !";
            
           } catch (SQLException ex) {
            System.out.println("Erro ao atualizar gênero: "+ex.getMessage());
        }finally{
           Conexao.closeConnection(con, stmt);
        }         
        return null;
      }
    
    @Override
    public String removerGenero(int id){
        try {
            Conexao conexao = new Conexao();
            String sql = "delete from genero where idgenero = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();

            return "Gênero excluído com sucesso !";
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir gênero !"+ex.getMessage());
        }        
        return null;
        
    
    }
    
    @Override
    public List<Genero> listaGeneros(){
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            List<Genero> generos = new ArrayList<>();
        
            try {
                stmt = con.prepareStatement("select * from genero");
                rs = stmt.executeQuery();
              
                while(rs.next()){
                    Genero genero = new Genero();  
                    genero.setCodigo(rs.getInt("idgenero"));
                    genero.setNome(rs.getString("nomeGenero"));
                    
                    generos.add(genero);
                  
             }
             
           } catch (SQLException ex) {
              System.out.println(" Erro ao consultar gêneros: "+ ex);
          }finally{
           Conexao.closeConnection(con, stmt,rs);
        }
         
          return generos;
         
      }
    
    //
    // LOCACAO
    //
    
    @Override
    public String inserirLocacao(Locacao locacao){
        
        try {
            
            String sql = ("INSERT INTO locacao (idfilmeLocado,idClienteLocado,idFuncionarioLocado,datalocado) VALUES (?, ?, ?, ?)");
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,locacao.getFilme());
            ps.setInt(2, locacao.getCliente());
            ps.setInt(3, locacao.getFuncionario());
            ps.setString(4,dataFormatada.format(locacao.getDataLoc()));
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao registrar locação: "+ex.getMessage());
        }
        return "Locação registrada com sucesso !";
    }
    
    @Override
    public String atualizaLocacao (Locacao locacao, int id) {
          
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement("update locacao set idfilmeLocado = ?, idClienteLocado = ?,"
                   + " idFuncionarioLocado = ?, datalocado = ? where idLocacao = ?");
           stmt.setInt(1,locacao.getFilme());
           stmt.setInt(2, locacao.getCliente());
           stmt.setInt(3, locacao.getFuncionario());
           stmt.setString(4,dataFormatada.format(locacao.getDataLoc()));
           stmt.setInt(5, id);
           
           stmt.executeUpdate();
           return "Locação Atualizada !";
            
           } catch (SQLException ex) {
            System.out.println("Erro ao atualizar locação: "+ex.getMessage());
        }finally{
           Conexao.closeConnection(con, stmt);
        }         
        return null;
      }
    
    @Override
    public String removerLocacao(int id){
        try {
            Conexao conexao = new Conexao();
            String sql = "delete from locacao where idLocacao = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();

            return "Locação excluída com sucesso !";
        } catch (SQLException ex) {
            System.out.println(" Erro ao excluir locação!"+ex.getMessage());
        }        
        return null;
        
    
    }
    
    @Override
    public List<Locacao> listaLocacao(){
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            List<Locacao> locacoes = new ArrayList<>();
        
            try {
                stmt = con.prepareStatement("select * from locacao");
                rs = stmt.executeQuery();
              
                while(rs.next()){
                    Locacao locacao = new Locacao();  
                    locacao.setCodigo(rs.getInt("idLocacao"));
                    locacao.setFilme(rs.getInt("idfilmeLocado"));
                    locacao.setCliente(rs.getInt("idClienteLocado"));
                    locacao.setFuncionario(rs.getInt("idFuncionarioLocado"));
                    locacao.setDataLoc(rs.getDate("datalocado"));
                    
                    locacoes.add(locacao);
                  
             }
             
           } catch (SQLException ex) {
              System.out.println(" Erro ao consultar locacões: "+ ex);
          }finally{
           Conexao.closeConnection(con, stmt,rs);
        }
         
          return locacoes;
         
      }
    
    //
    // TIPO MIDIA
    //
    
    @Override
    public String inserirTipoMidia(TipoMidia tipoMidia){
        
        try {
            
            String sql = ("INSERT INTO tipomidia (nomeTipo) VALUES (?)");
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(1, tipoMidia.getNome());
                        
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir típo de Midia: "+ex.getMessage());
        }
        return "Tipo de mídia inserido Com sucesso !";
    }
    
    @Override
    public String atualizaTipoMidia (TipoMidia tipoMidia, int id) {
          
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement("update tipomidia set nomeTipo = ? where idtipoMidia = ?");
           stmt.setString(1, tipoMidia.getNome());
           stmt.setInt(2, id);
           
           stmt.executeUpdate();
           return "Tipo de Mídia Atualizado !";
            
           } catch (SQLException ex) {
            System.out.println("Erro ao atualizar tipo de Mídia: "+ex.getMessage());
        }finally{
           Conexao.closeConnection(con, stmt);
        }         
        return null;
      }
    
    @Override
    public String removerTipoMidia(int id){
        try {
            Conexao conexao = new Conexao();
            String sql = "delete from tipomidia where idtipoMidia = ?";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            
            ps.execute();

            return "Tipo de Mídia excluído com sucesso !";
        } catch (SQLException ex) {
            System.out.println(" Erro ao excluir tipo de mídia!"+ex.getMessage());
        }        
        return null;
        
    
    }
    
    @Override
    public List<TipoMidia> listaTipoMidias(){
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            List<TipoMidia> tipos = new ArrayList<>();
        
            try {
                stmt = con.prepareStatement("select * from tipomidia");
                rs = stmt.executeQuery();
              
                while(rs.next()){
                    TipoMidia tipo = new TipoMidia();  
                    tipo.setCodigo(rs.getInt("idtipoMidia"));
                    tipo.setNome(rs.getString("nomeTipo"));
                    
                    tipos.add(tipo);
                  
             }
             
           } catch (SQLException ex) {
              System.out.println(" Erro ao consultar tipos de mídia: "+ ex);
          }finally{
           Conexao.closeConnection(con, stmt,rs);
        }
         
          return tipos;
         
      }
   
}

