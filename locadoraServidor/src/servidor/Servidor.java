/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controller.Implementacao;
import controller.Interface;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Rafael
 */
public class Servidor {
    public static void main(String[] args) {
        try{
            Interface objetoRemoto = new Implementacao();
            //InterfaceProduto objetoRemotoProduto = new ImplementacaoProduto();
            Registry conexao = LocateRegistry.createRegistry(1500);
            System.out.println("Servidor conectado!");
            conexao.bind("chave", objetoRemoto);
            //conexao.bind("chaveProduto", objetoRemotoProduto);
        }catch(RemoteException e){
            System.out.println(e.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
