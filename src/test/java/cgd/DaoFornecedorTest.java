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
    private final Fabrica fabrica = Fabrica.make(fornecedor);
    private final Dao dao = fabrica.criaDao();
    private int codigo=0;
  
    @Test
    public void testListar() {
        for(Objeto objeto: dao.listar()){
            System.out.println(objeto.toString());
        }
    }
    @Test
    public void testBuscar(){
        Fornecedor objeto = (Fornecedor) fabrica.criaObjeto();
        objeto.setCnpj("2");
        Fornecedor resultado = (Fornecedor) dao.buscar(objeto);
        assertEquals(objeto.getCnpj(), resultado.getCnpj());
    }
    @Test
    public void testExiste(){
        Fornecedor fornecedor = (Fornecedor) fabrica.criaObjeto();
        fornecedor.setCnpj("1");
        assertTrue(dao.existe(fornecedor));
    }
   

    /**
     * Test of cadastrar method, of class DaoFornecedor.
     */
    @Test
    public void testCadastrar() {
        Fornecedor fornecedor = (Fornecedor) fabrica.criaObjeto();
        fornecedor.setEmail("teste@gmail.com");
        fornecedor.setEndereco("Rua teste");
        fornecedor.setNome("Teste");
        fornecedor.setTelefone("33413212");
        codigo = dao.maiorCodigo();
        for(int indice=codigo+1;indice<100;indice++){
            fornecedor.setCnpj(""+indice);
            if(!dao.existe(fornecedor)){
                dao.cadastrar(fornecedor);
                break;
            }
        }
    }
    

    /**
     * Test of excluir method, of class DaoFornecedor.
     */
    @Test
    public void testExcluir() {
        Fornecedor fornecedor = (Fornecedor) fabrica.criaObjeto();
        fornecedor.setEmail("teste@gmail.com");
        fornecedor.setEndereco("Rua teste");
        fornecedor.setNome("Teste");
        fornecedor.setTelefone("33413212");
        codigo = dao.maiorCodigo();
        for(int indice=3;indice<=codigo;indice++){
            fornecedor.setCnpj(""+indice);
            if(dao.existe(fornecedor)){
                dao.excluir(fornecedor);
            }else{
                break;
            }
        }
    }
    
}
