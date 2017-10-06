/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Cliente;


/**
 *
 * @author Cris
 */
public interface Interface extends Remote{
    public String inserirCliente(Cliente c) throws RemoteException;
    public String removerCliente(Cliente c) throws RemoteException;
    
}