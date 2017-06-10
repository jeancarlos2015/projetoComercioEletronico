/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;


import cci.ControleProduto;
import cdp.Objeto;
import cdp.Produto;
import cgd.Dao;
import cgd.DaoProduto;
import cgd.Persistencia;
import cgt.ControlarProdutos;
import cgt.InterfaceControlar;
import javax.servlet.http.HttpServlet;


/**
 *
 * @author jean
 */
public class FabricaProduto extends Fabrica{
    @Override
    public Objeto criaObjeto(){return new Produto();}
    
    @Override
    public Dao criaDao(){return new DaoProduto();}
    
    @Override
    public Persistencia criaPersistencia(){return new Persistencia();}
    
    @Override
    public HttpServlet criaControle(){return new ControleProduto();}
    
    @Override
    public InterfaceControlar criaApi(){return new ControlarProdutos();}
}
