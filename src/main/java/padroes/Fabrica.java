/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import cci.Controlador;
import cdp.Objeto;
import cgd.Dao;
import cgd.Persistencia;
import cgt.InterfaceControlar;



import javax.servlet.http.HttpServlet;


/**
 *
 * @author jean
 */
public abstract class Fabrica {
    public static Fabrica make(Tipo tipo){
        switch(tipo){
            case fornecedor:
                return new FabricaFornecedor();
            case produto:
                return new FabricaProduto();
            case pedido:
                return new FabricaPedido();
            default:
                return null;
        }
    }
    public static Fabrica make(String tipo){
        switch(tipo){
            case "fornecedor":
                return new FabricaFornecedor();
            case "produto":
                return new FabricaProduto();
            case "pedido":
                return new FabricaPedido();
            default:
                return null;
        }
    }
    public abstract Objeto criaObjeto();
    public abstract Dao criaDao();
    public Persistencia criaPersistencia(){return new Persistencia();}
    public abstract HttpServlet criaControle();
    public abstract InterfaceControlar criaApi();
}
