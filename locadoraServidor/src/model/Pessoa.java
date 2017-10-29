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
public class Pessoa implements Serializable{
    protected String nome,telefone,cidade,dataNasc,dataCadastro;
    protected int cpf,codigo,numero,rg;

    public Pessoa(String nome, String telefone, String cidade, String dataNasc, int cpf, int codigo, int numero, int rg,String dataCadastro) {
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
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
   
   public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    
}
