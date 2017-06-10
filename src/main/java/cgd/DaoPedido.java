/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Fornecedor;
import cdp.Objeto;
import cdp.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class DaoPedido  implements Dao{
    private Persistencia conexao;
    private Pedido p;
    @Override
    public List<Objeto> listar() {
        String comando=" SELECT *FROM PEDIDO";
         String result = conexao.executarSelecao(comando);
         String[] res = result.split(";");
         List<Objeto> list = new ArrayList<>();
         for(String str:res){
             String[] item  = str.split(",");
             Fornecedor f = new Fornecedor();
             f.setCnpj(item[0].trim());
             f.setNome(item[1]);
             f.setEndereco(item[2]);
             list.add(f);
         }
         return list;
    }

    @Override
    public boolean cadastrar(Objeto objeto) {
        p = (Pedido) objeto;
        String comando = "INSERT INTO PEDIDO(codigo_pedido, cnpj, data_produto, valor_total) VALUES('"+p.getCodigo()+"','"+p.getCnpj()+"','"+p.getData()+"',"+p.getValor_total()+")";    
        return conexao.executar(comando);
    }

    @Override
    public boolean excluir(Objeto objeto) {
        p = (Pedido) objeto;
        String comando = "DELETE FROM PEDIDO WHERE cnpj='"+p.getCnpj()+"'";
        return conexao.executar(comando);
    }

    
   

    @Override
    public boolean existe(Objeto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
