/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

/**
 *
 * @author jean
 */
public abstract class Objeto {
    private String tipo;
    public Objeto(String tipo){
        this.tipo = tipo;
    }
    public String getTipoProduto(){
        return tipo;
    }
    public abstract String[] getAtributos();
}
