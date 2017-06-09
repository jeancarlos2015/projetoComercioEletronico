/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Objeto;
import cdp.Pedido;
import java.util.List;

/**
 *
 * @author jean
 */
public interface Dao {
    public List<Objeto> listar();
    public boolean inserir();
    public boolean deletar();
    public boolean existe(Objeto objeto);
    public void set(Objeto objeto);
}
