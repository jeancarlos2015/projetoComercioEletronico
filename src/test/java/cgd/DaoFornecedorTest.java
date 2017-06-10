/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Fornecedor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class DaoFornecedorTest {
    
    public DaoFornecedorTest() {
    }

    /**
     * Test of listar method, of class DaoFornecedor.
     */
    @Test
    public void testListar() {
        
    }
    @Test
    public void testExiste(){
        Dao dao = new DaoFornecedor();
        Fornecedor f = new Fornecedor();
        f.setCnpj("12341234124");
        assertTrue(dao.existe(f));
    }
    /**
     * Test of inserir method, of class DaoFornecedor.
     */
    @Test
    public void testInserir() {
//        Dao dao = new DaoFornecedor();
//        Fornecedor f = new Fornecedor();
//        f.setCnpj("12341234124");
//        f.setEndereco("Avenida Damiao Pinheira");
//        f.setNome("Casas Bahia");
//        dao.set(f);
//        assertTrue(dao.inserir());
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
