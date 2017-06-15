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
public class Pedido extends Objeto{
    private String codigo_pedido="";
    private String codigo_produto="";
    private String data="";
    private List<Produto> itens=null;
    public Pedido(){
        super("pedido");
        itens = new ArrayList<>();
    }
    public boolean adicionaItem(Produto item){
        return itens.add(item);
    }
    
    public List<Produto> listarItens(){
        return itens;
    }
    /**
     * @return the codigo_pedido
     */
    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    /**
     * @param codigo_pedido the codigo_pedido to set
     */
    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido.trim();
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
        this.data = data.trim();
    }

    @Override
    public String[] getAtributos() {
        String vetor[] = {"codigo_pedido","codigo_produto","data_pedido"};
        return vetor;
    }
    
    public float getValor_total(){
        float valor=0;
        for(Produto p:itens){
            valor+=p.getPreco();
        }
        
        return valor;
    }
    @Override
    public String toString(){
        return codigo_pedido+" "+codigo_produto+" "+data+" "+itens.toString();
    }

    /**
     * @return the codigo_produto
     */
    public String getCodigo_produto() {
        return codigo_produto;
    }

    /**
     * @param codigo_produto the codigo_produto to set
     */
    public void setCodigo_produto(String codigo_produto) {
        this.codigo_produto = codigo_produto.trim();
    }

    
}
