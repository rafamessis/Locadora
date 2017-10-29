/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Cliente;
import model.Funcionarios;


/**
 *
 * @author Cris
 */
public interface Interface extends Remote{
    public String inserirCliente(Cliente c) throws RemoteException;
    public String atualizaCliente (Cliente clientes, int id) throws RemoteException;
    public String removerCliente(int id) throws RemoteException;
    public List<Cliente> listaClientes() throws RemoteException;
    public String inserirFuncionario(Funcionarios f) throws RemoteException;
}