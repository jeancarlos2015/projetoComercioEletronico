/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;



import cci.ControlePedido;
import cdp.Objeto;
import cdp.Pedido;
import cgd.Dao;
import cgd.DaoPedido;
import cgd.Persistencia;
import cgt.ControlarPedidos;
import cgt.InterfaceControlar;
import javax.servlet.http.HttpServlet;


/**
 *
 * @author jean
 */
public class FabricaPedido extends Fabrica{
    @Override
    public Objeto criaObjeto(){return new Pedido();}
    
    @Override
    public Dao criaDao(){return new DaoPedido();}
    
    @Override
    public HttpServlet criaControle(){return new ControlePedido();}
    
    @Override
    public InterfaceControlar criaApi(){return new ControlarPedidos();}
    
}
