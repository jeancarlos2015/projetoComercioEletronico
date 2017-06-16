/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Pedido;
import cdp.Produto;
import cgd.Dao;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;
import static padroes.Tipo.pedido;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class ControlarPedidosTest {
    
    public ControlarPedidosTest() {
    }

    /**
     * Test of cadastrar method, of class ControlarPedidos.
     */
    @Test
    public void testCadastrar() {
        Fabrica fabPedido = Fabrica.make(pedido);
        Fabrica fabProduto = Fabrica.make(produto);
        
        Dao dao = fabPedido.criaDao();
        Pedido pedido = (Pedido) fabPedido.criaObjeto();
        pedido.setCodigo_pedido("10");
        pedido.setCodigo_produto("1");
        pedido.setData("10/10/2010");
        for(int indice=1;indice<6;indice++){
            Produto p = (Produto) fabProduto.criaObjeto();
            p.setPreco("2");
            p.setCodigo_produto(""+indice);
            pedido.adicionaItem(p);
        }
        int index=10;
        for(Produto p2:pedido.listarItens()){
            Pedido pedido2 = (Pedido) fabPedido.criaObjeto();
            pedido2.setCodigo_pedido(pedido.getCodigo_pedido());
            pedido2.setCodigo_produto(p2.getCodigo_produto());
            pedido2.setData(pedido.getData());
            pedido2.setCodigo_pedido(""+index);
            System.out.println(dao.cadastrar(pedido2));
            index++;
        }
    }
    
}
