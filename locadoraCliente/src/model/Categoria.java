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
public class Categoria implements Serializable{
    protected String nome;
    protected int codigo;
    protected double valorLoc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValorLoc() {
        return valorLoc;
    }

    public void setValorLoc(double valorLoc) {
        this.valorLoc = valorLoc;
    }
    
    
    
}
