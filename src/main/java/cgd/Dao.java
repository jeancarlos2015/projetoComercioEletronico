/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Pedido;
import java.util.List;

/**
 *
 * @author jean
 */
public interface Dao {
    public List<Pedido> listar();
    public void inserir();
    public void deletar();
    public void set(Object objeto);
}
