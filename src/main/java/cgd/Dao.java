/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Objeto;
import java.util.List;

/**
 *
 * @author jean
 */
public interface Dao {
    public List<Objeto> listar();
    public List<Objeto> listar(Objeto objeto);
    public boolean cadastrar(Objeto objeto);
    public boolean excluir(Objeto objeto);
    public boolean existe(Objeto objeto);
    public Objeto buscar(Objeto objeto);
}
