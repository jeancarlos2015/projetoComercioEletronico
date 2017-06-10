/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;


import cdp.Objeto;
import cgd.Dao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public abstract class  Controlar implements InterfaceControlar{
    protected final  Dao dao;
    protected final Fabrica fabrica;
    protected HttpServletRequest request;
    
    public Controlar(Fabrica f){
        dao = f.criaDao();
        fabrica = f;
    }
    
    @Override
    public boolean cadastrar(Objeto item) {
        return dao.cadastrar(item);   
    }
    
    @Override
    public boolean excluir(Objeto item) {
        return dao.excluir(item);
    }
    
    

    @Override
    public boolean existe(Objeto item){
        return dao.existe(item);
    }
    
    @Override
    public boolean atender(Objeto item){return false;}
    
    @Override
    public List<Objeto> consultar(Objeto item){return null;}
  
    
    
    
   
    
}
