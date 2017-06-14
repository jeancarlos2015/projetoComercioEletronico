/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Objeto;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class DaoProdutoTest {
    private Fabrica f = Fabrica.make(produto);
    public DaoProdutoTest() {
    }

    /**
     * Test of listar method, of class DaoProduto.
     */
    @Test
    public void testListar() {
        Dao dao = f.criaDao();
        for(Objeto objeto: dao.listar()){
            System.out.println(objeto.toString());
        }
    }

    /**
     * Test of cadastrar method, of class DaoProduto.
     */
    @Test
    public void testCadastrar() {
    }

    /**
     * Test of excluir method, of class DaoProduto.
     */
    @Test
    public void testExcluir() {
    }

    /**
     * Test of existe method, of class DaoProduto.
     */
    @Test
    public void testExiste() {
    }
    
}
