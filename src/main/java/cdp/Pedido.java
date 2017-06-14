package cdp;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean
 */
public class Pedido extends ObjetoAbstract{
    private String codigo="";
    private String data="";
    private List<Produto> itens=null;
    public Pedido(){
        itens = new ArrayList<>();
    }
    public boolean adicionaItem(Produto item){
        return itens.add(item);
    }
    
    public List<Produto> listarItens(){
        return itens;
    }
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String[] getAtributos() {
        String vetor[] = {"codigo_pedido","data_pedido"};
        return vetor;
    }
    @Override
    public String toString(){
        return codigo+" "+" "+data;
    }
    
   
    
}
