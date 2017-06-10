/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import cdp.Objeto;
import cgd.Dao;
import cgd.Persistencia;
import cgt.InterfaceControlar;
import com.sistex.cci.Controlador;


import javax.servlet.http.HttpServlet;


/**
 *
 * @author jean
 */
public class Fabrica {
    public static Fabrica make(Tipo tipo){
        switch(tipo){
            case fornecedor:
                return new FabricaFornecedor();
            case produto:
                return new FabricaProduto();
            case pedido:
                return new FabricaPedido();
            default:
                return new Fabrica();
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
                return new Fabrica();
        }
    }
    public Objeto criaObjeto(){return null;}
    public Dao criaDao(){return null;}
    public Persistencia criaPersistencia(){return new Persistencia();}
    public HttpServlet criaControle(){return new Controlador();}
    public InterfaceControlar criaApi(){return null;}
}
