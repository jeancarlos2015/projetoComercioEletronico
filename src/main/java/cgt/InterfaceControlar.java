/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;


import cdp.Objeto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jean
 */
public interface InterfaceControlar {
    
    public boolean cadastrar(Objeto item);
    public boolean excluir(Objeto item);
    public boolean atender(Objeto item);
    public boolean existe(Objeto item);
    public List<Objeto> consultar(Objeto item);
    
}
