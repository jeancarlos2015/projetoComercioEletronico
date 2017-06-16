/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;


import cdp.Objeto;
import cdp.Produto;
import java.util.ArrayList;
import java.util.List;
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
        Persistencia conexao = new Persistencia();
        String comando ="Select max(preco) as preco from produto";
        String[] result = conexao.executarSelecao(comando).split(";");
        System.out.println(result[0].trim());
    }

    /**
     * Test of executarSelecao method, of class Persistencia.
     */
    @Test
    public void testExecutarSelecao() {
         Persistencia conexao = new Persistencia();
         String comando=" SELECT *FROM PRODUTO";
         String[] result = conexao.executarSelecao(comando).split(";");
         List<Objeto> lista = new ArrayList();
         for(String res:result){
             System.out.println(res);
             String[] dado = res.split(",");
             Produto p = new Produto();
             p.setCodigo_produto(dado[0]);
             p.setCnpj(dado[1]);
             p.setDescricao(dado[2]);
             p.setNome(dado[3]);
             p.setQuantidade_unit(dado[4]);
             p.setQuantidade_estoq(dado[5]);
             p.setMarca(dado[6]);
             p.setPreco(dado[7]);
             lista.add(p);
         }
         
         for(Objeto o:lista){
             System.out.println(o.toString());
         }
    }
    
}
