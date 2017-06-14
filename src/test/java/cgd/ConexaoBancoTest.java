/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Fornecedor;
import org.junit.Test;

/**
 *
 * @author jean
 */
public class ConexaoBancoTest {
    
    public ConexaoBancoTest() {
    }

    /**
     * Test of executar method, of class Persistencia.
     */
    @Test
    public void testObterColunas() {
        
        String comando ="Select cnpj from produto where cpng='fdsafdsa'";
        
    }

    /**
     * Test of executarSelecao method, of class Persistencia.
     */
    @Test
    public void testExecutarSelecao() {
         Persistencia conexao = new Persistencia();
         Fornecedor fo = new Fornecedor();
         fo.setCnpj("123412341234");
         String comando=" SELECT cnpj FROM FORNECEDOR where cnpj = '"+fo.getCnpj()+"'";
         String[] result = conexao.executarSelecao(comando).split(";");
         for(String res:result){
             System.out.println(res);
         }
    }
    
}
