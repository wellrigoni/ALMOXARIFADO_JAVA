/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author wellington.rigoni
 */
public class Funcionario {
    private int codfunc;
    private String nome;

    public Funcionario(int codfunc, String nome) {
        this.codfunc = codfunc;
        this.nome = nome;
    }

    /**
     * @return the codfunc
     */
    public int getCodfunc() {
        return codfunc;
    }

    /**
     * @param codfunc the codfunc to set
     */
    public void setCodfunc(int codfunc) {
        this.codfunc = codfunc;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
       
    
}
