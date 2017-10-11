/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rafael
 */
public class Pessoa {
    String nome,telefone,bairro,dataNasc,dataCadastro;
    int cpf,codigo,numero,rg;

    public Pessoa(String nome, String telefone, String bairro, String dataNasc, int cpf, int codigo, int numero, int rg,String dataCadastro) {
        this.nome = nome;
        this.telefone = telefone;
        this.bairro = bairro;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.codigo = codigo;
        this.numero = numero;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }


   

   public Pessoa(){
       
   }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }
   
   public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
    
    
}
