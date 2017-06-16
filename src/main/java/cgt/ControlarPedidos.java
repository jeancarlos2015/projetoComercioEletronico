/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;


import cdp.Objeto;
import cdp.Pedido;
import cdp.Produto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.pedido;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class ControlarPedidos extends Controlar{
    
    public ControlarPedidos() {
        super(pedido);
    }
    
    @Override
    public boolean cadastrar(Objeto item) {
        Pedido pedido = (Pedido) item;
        int codigo = dao.maiorCodigo()+1;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	String data = dateFormat.format(date);
        pedido.setData(data);
        for(Produto p2:pedido.listarItens()){
            Pedido pedido2 = (Pedido) fabrica.criaObjeto();
            pedido2.setCodigo_pedido(pedido.getCodigo_pedido());
            pedido2.setCodigo_produto(p2.getCodigo_produto());
            pedido2.setData(pedido.getData());
            pedido2.setCodigo_pedido(""+codigo);
            if(!dao.cadastrar(pedido2)){
                return false;
            }
            codigo++;
        }
        return true;
    }
}
