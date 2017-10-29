/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public class Cliente extends Pessoa implements Serializable{
    String email,endereco;
    
    public Cliente(String email, String endereco, String nome, String telefone, String cidade, String dataNasc, int cpf, int codigo, int numero, int rg, String dataCadastro) {
        super(nome, telefone, cidade, dataNasc, cpf, codigo, numero, rg, dataCadastro);
        this.email = email;
        this.endereco = endereco;
    }
    public Cliente(){
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    
    
}
