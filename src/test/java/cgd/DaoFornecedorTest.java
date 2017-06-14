/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Fornecedor;
import cdp.Objeto;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;
import static padroes.Tipo.fornecedor;

/**
 *
 * @author jean
 */
public class DaoFornecedorTest {
    private Fabrica f = Fabrica.make(fornecedor);
    public DaoFornecedorTest() {
    }

    /**
     * Test of listar method, of class DaoFornecedor.
     */
    @Test
    public void testListar() {
        Dao dao = f.criaDao();
        for(Objeto objeto: dao.listar()){
            System.out.println(objeto.toString());
        }
    }
    @Test
    public void testExiste(){
        Dao dao = f.criaDao();
        Fornecedor fornecedor = (Fornecedor) f.criaObjeto();
        fornecedor.setCnpj("12341234124");
        assertTrue(dao.existe(fornecedor));
    }
    /**
     * Test of inserir method, of class DaoFornecedor.
     */
    @Test
    public void testInserir() {
    }

    /**
     * Test of deletar method, of class DaoFornecedor.
     */
    @Test
    public void testDeletar() {
    }

    /**
     * Test of set method, of class DaoFornecedor.
     */
    @Test
    public void testSet() {
    }
    
}
