/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Fornecedor;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jean
 */
public class ConexaoBancoTest {
    
    public ConexaoBancoTest() {
    }

    /**
     * Test of executar method, of class ConexaoBanco.
     */
    @Test
    public void testObterColunas() {
        
        String comando ="Select cnpj from produto where cpng='fdsafdsa'";
        
    }

    /**
     * Test of executarSelecao method, of class ConexaoBanco.
     */
    @Test
    public void testExecutarSelecao() {
         ConexaoBanco conexao = new ConexaoBanco();
         Fornecedor fo = new Fornecedor();
         fo.setCnpj("123412341234");
         String comando=" SELECT cnpj FROM FORNECEDOR where cnpj = '"+fo.getCnpj()+"'";
         String[] result = conexao.executarSelecao(comando).split(";");
         for(String res:result){
             System.out.println(res);
         }
    }
    
}
