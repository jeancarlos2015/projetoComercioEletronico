package cdp;


import com.google.gson.Gson;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean
 */
public class Pedido {
    private String descr, marca;
    private int quantidade,codigo;
    
    public Pedido(String descr, String marca, int quantidade, int codigo){
        this.descr = descr;
        this.marca = marca;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    /**
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * @param descr the descr to set
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
  
    
    @Override
    public String toString(){
        return ""+codigo+" "+descr+" "+marca+" "+ quantidade;
    }
}
