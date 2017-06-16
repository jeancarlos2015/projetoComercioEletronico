/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Objeto;
import cdp.Pedido;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;
import static padroes.Tipo.pedido;

/**
 *
 * @author jean
 */
public class DaoPedidoTest {
    private Fabrica fabrica = Fabrica.make(pedido);
    public DaoPedidoTest() {
    }

    /**
     * Test of listar method, of class DaoPedido.
     */
    @Test
    public void testListar() {
        Dao dao = fabrica.criaDao();
        for(Objeto objeto:dao.listar()){
            System.out.println(objeto.toString());
        }
    }

    /**
     * Test of cadastrar method, of class DaoPedido.
     */
    @Test
    public void testCadastrar() {
        Pedido pedido = (Pedido) fabrica.criaObjeto();
        Dao dao = fabrica.criaDao();
        int codigo = dao.maiorCodigo();
        for(int indice=codigo+1;indice<100;indice++){
            pedido.setCodigo_pedido(""+indice);
            pedido.setCodigo_produto("1");
            pedido.setData("12/12/2012");
            if(!dao.existe(pedido)){
                System.out.println(dao.cadastrar(pedido));
                break;
            }
        }
    }

    /**
     * Test of excluir method, of class DaoPedido.
     */
    @Test
    public void testExcluir() {
        Pedido pedido = (Pedido) fabrica.criaObjeto();
        Dao dao = fabrica.criaDao();
        int codigo = dao.maiorCodigo();
        for(int indice=3;indice<=codigo;indice++){
            pedido.setCodigo_pedido(""+indice);
            pedido.setCodigo_produto("1");
            pedido.setData("12/12/2012");
            if(dao.existe(pedido)){
                System.out.println(dao.excluir(pedido));
            }else{
                break;
            }
        }
    }

    
    @Test
    public void testExiste() {
        Pedido pedido = (Pedido) fabrica.criaObjeto();
        Dao dao = fabrica.criaDao();
        pedido.setCodigo_pedido("1");
        assertTrue(dao.existe(pedido));
    }
    
    @Test
    public void testMaiorNumero(){
        Dao dao = fabrica.criaDao();
        System.out.println("maior numero: "+dao.maiorCodigo());
    }
}
