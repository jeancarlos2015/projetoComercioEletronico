/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;


import cci.Controlador;
import cdp.Fornecedor;
import cdp.Objeto;
import cgd.Dao;
import cgd.DaoFornecedor;
import cgd.Persistencia;
import cgt.ControlarFornecedor;
import cgt.InterfaceControlar;
import javax.servlet.http.HttpServlet;


/**
 *
 * @author jean
 */
public class FabricaFornecedor extends Fabrica{
    @Override
    public Objeto criaObjeto(){return new Fornecedor();}
    
    @Override
    public Dao criaDao(){return new DaoFornecedor();}
    
    @Override
    public Persistencia criaPersistencia(){return new Persistencia();}
    
    @Override
    public HttpServlet criaControle(){return new Controlador();}
    
    @Override
    public InterfaceControlar criaApi(){return new ControlarFornecedor();}
}
