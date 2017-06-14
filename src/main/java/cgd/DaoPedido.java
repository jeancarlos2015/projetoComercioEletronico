/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Objeto;
import cdp.Pedido;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import padroes.Tipo;

/**
 *
 * @author jean
 */
public class DaoPedido  implements Dao{
    private final Fabrica fabrica = Fabrica.make(Tipo.pedido);
    private final Persistencia conexao;
    
    public DaoPedido(){
        conexao = fabrica.criaPersistencia();
    }
    @Override
    public List<Objeto> listar() {
         String comando=" SELECT *FROM PEDIDO";
         String result = conexao.executarSelecao(comando);
         String[] res = result.split(";");
         List<Objeto> list = new ArrayList<>();
         for(String str:res){
             String[] item  = str.split(",");
             Pedido p = (Pedido) fabrica.criaObjeto();
             p.setCodigo(item[0].trim());
             p.setData(item[1]);
             list.add(p);
         }
         return list;
    }

    @Override
    public boolean cadastrar(Objeto objeto) {
        Pedido p = (Pedido) objeto;
        String comando = "INSERT INTO PEDIDO(codigo_pedido, data_pedido) VALUES('"+p.getCodigo()+"','"+p.getData()+")";    
        return conexao.executar(comando);
    }

    @Override
    public boolean excluir(Objeto objeto) {
        Pedido p = (Pedido) objeto;
        String comando = "DELETE FROM PEDIDO WHERE codigo_pedido='"+p.getCodigo()+"'";
        return conexao.executar(comando);
    }

    
   

    @Override
    public boolean existe(Objeto objeto) {
        Pedido p = (Pedido) objeto;
         String comando=" SELECT *FROM PEDIDO where codigo_pedido = "+p.getCodigo();
         String result = conexao.executarSelecao(comando);
         String[] res = result.split(";");
         List<Objeto> list = new ArrayList<>();
         for(String str:res){
             String[] item  = str.split(",");
             
         }
         return false;
    }

    
}
