/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Categoria;
import model.Cliente;
import model.Distribuidora;
import model.Filmes;
import model.Funcionarios;
import model.Genero;
import model.Locacao;
import model.TipoMidia;


/**
 *
 * @author Cris
 */
public interface Interface extends Remote{
    
    public String inserirCategoria(Categoria cat) throws RemoteException;
    public String atualizaCategoria (Categoria cat, int id) throws RemoteException;
    public String removerCategoria(int id) throws RemoteException;
    public List<Categoria> listaCategoria() throws RemoteException;
    
    public String inserirCliente(Cliente c) throws RemoteException;
    public String atualizaCliente (Cliente clientes, int id) throws RemoteException;
    public String removerCliente(int id) throws RemoteException;
    public List<Cliente> listaClientes() throws RemoteException;
    
    public String inserirDistribuidora(Distribuidora dist) throws RemoteException;
    public String atualizaDistribuidora (Distribuidora distribuidoras, int id) throws RemoteException;
    public String removerDistribuidora(int id) throws RemoteException;
    public List<Distribuidora> listaDistribuidoras() throws RemoteException;
    
    public String inserirFilmes(Filmes filme) throws RemoteException;
    public String atualizaFilmes (Filmes filmes, int id) throws RemoteException;
    public String removerFilme(int id) throws RemoteException;
    public List<Filmes> listaFilmes() throws RemoteException;
    
    public String inserirFuncionario(Funcionarios f) throws RemoteException;
    public String atualizaFuncionario (Funcionarios f, int id) throws RemoteException;
    public String removerFuncionario(int id) throws RemoteException;
    public List<Funcionarios> listaFuncionario() throws RemoteException;
    
    public String inserirGenero(Genero generos) throws RemoteException;
    public String atualizaGenero (Genero generos, int id) throws RemoteException;
    public String removerGenero(int id) throws RemoteException;
    public List<Genero> listaGeneros() throws RemoteException;
    
    public String inserirLocacao(Locacao loc) throws RemoteException;
    public String atualizaLocacao(Locacao loc, int id) throws RemoteException;
    public String removerLocacao(int id) throws RemoteException;
    public List<Locacao> listaLocacao() throws RemoteException;
    
    public String inserirTipoMidia(TipoMidia tipo) throws RemoteException;
    public String atualizaTipoMidia (TipoMidia tipo, int id) throws RemoteException;
    public String removerTipoMidia(int id) throws RemoteException;
    public List<TipoMidia> listaTipoMidias() throws RemoteException;
    
    
}