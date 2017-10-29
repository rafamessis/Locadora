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
public class Filmes implements Serializable{
    protected String nome, atores, sinopse;
    protected int codigo,qtdDiscos, categoria, genero, tipoMidia, distribuidora;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdDiscos() {
        return qtdDiscos;
    }

    public void setQtdDiscos(int qtdDiscos) {
        this.qtdDiscos = qtdDiscos;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(int tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public int getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(int distribuidora) {
        this.distribuidora = distribuidora;
    }
    
}
