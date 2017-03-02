/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class DaoPedido implements Dao{
    private Pedido p;
    private ConexaoBanco conexao;
    
    public DaoPedido(){
        conexao = new ConexaoBanco();
    }
    @Override
    public List<Pedido> listar() {
        String comando=" SELECT *FROM PEDIDO";
         String result = conexao.executarSelecao(comando);
         String[] res = result.split(";");
         List<Pedido> list = new ArrayList<>();
         for(String str:res){
             String[] item  = str.split(",");
             list.add(new Pedido(item[1],item[2] , Integer.parseInt(item[3]), Integer.parseInt(item[0])));
         }
         return list;
    }

    @Override
    public void inserir() {
        String comando = "INSERT INTO PEDIDO (CODIGO, DESCR, MARCA, QUANTIDADE) "
                + "VALUES("+p.getCodigo()+",'"+p.getDescr()+"','"+p.getMarca()+"',"+p.getQuantidade()+");";
        conexao.executar(comando);
    }

    @Override
    public void deletar() {
        String comando = "DELETE FROM PEDIDO WHERE CODIGO="+p.getCodigo();
        conexao.executar(comando);
    }

    
    @Override
    public void set(Object objeto){
        p= (Pedido)objeto;
    }
}
