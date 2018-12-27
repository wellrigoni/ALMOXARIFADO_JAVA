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
public class Produto {
    private int codProd;
    private  String descricao;
    private String obs;
    private int estoque;

    /**
     * @return the codProd
     */
    
    public Produto() {
    }

    public Produto(int codProd, String descricao) {
        this.codProd = codProd;
        this.descricao = descricao;
    }

    public int getCodProd() {
        return codProd;
    }

    
    /**
     * @param codProd the codProd to set
     */
    
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }
    
    @Override
    public String toString() {
        return "Codigo: "+codProd+" Descricao: "+descricao+" Obs.: "+obs;
    }

    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
