/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Objeto;
import cdp.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class DaoProdutoTest {
    private final Fabrica fabrica = Fabrica.make(produto);
    
    @Test
    public void testListar() {
        Dao dao = fabrica.criaDao();
        for(Objeto item:dao.listar()){
            //System.out.println(item.toString());
        }
    }

    /**
     * Test of cadastrar method, of class DaoProduto.
     */
    @Test
    public void testCadastrar() {
    }
    @Test
    public void testBuscar(){
        Dao dao = fabrica.criaDao();
        Produto objeto = (Produto) fabrica.criaObjeto();
        objeto.setCodigo_produto("1");
        Produto result = (Produto) dao.buscar(objeto);
        System.out.println(result.toString());
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
    
    @Test
    public void testMaiorCodigo(){
        Dao dao = fabrica.criaDao();
        System.out.println(dao.maiorCodigo());
    }
}
