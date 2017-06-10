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

/**
 *
 * @author jean
 */
public class DaoProduto implements Dao{
    private Produto p;
    private Persistencia conexao;
    @Override
    public List<Objeto> listar() {
        String comando=" SELECT *FROM PRODUTO";
         String result = conexao.executarSelecao(comando);
         String[] res = result.split(";");
         List<Objeto> list = new ArrayList<>();
         for(String str:res){
             String[] item  = str.split(",");
             Produto p1 = new Produto();
             p1.setCodigo_produto(item[0]);
             p1.setCodigo_pedido(item[1]);
             p1.setCnpj(item[2]);
             p1.setDescricao(item[3]);
             p1.setNome(item[4]);
             p1.setMarca(item[5]);
             p1.setQuantidade_unit(item[6]);
             p1.setQuantidade_estoq(item[7]);
             p1.setPreco(item[8]);
             list.add(p1);
         }
         return list;
    }

    @Override
    public boolean cadastrar(Objeto objeto) {
        p = (Produto) objeto;
        String comando = "INSERT INTO PEDIDO(codigo_produto,codigo_pedido, cnpj, descricao, nome, marca, quantidade_unit, quantidade_estoq, preco) VALUES('"+p.getCodigo_produto()+"','"+p.getCodigo_pedido()+"','"+p.getCnpj()+"','"+p.getDescricao()+"','"+p.getNome()+"','"+p.getMarca()+"',"+p.getQuantidade_unit()+","+p.getQuantidade_estoq()+")";    
        return conexao.executar(comando);
    }

    @Override
    public boolean excluir(Objeto objeto) {
        p = (Produto) objeto;
        String comando = "DELETE FROM PEDIDO WHERE cnpj='"+p.getCnpj()+"'";
        return conexao.executar(comando);
    }

    

    @Override
    public boolean existe(Objeto objeto) {
         Produto fo = (Produto) objeto;
         String comando=" SELECT codigo_produto FROM PRODUTO where codigo_produto = '"+fo.getCodigo_produto()+"'";
         String result = conexao.executarSelecao(comando);
         String[] res = result.split(";");
         for(String str:res){
             if(fo.getCodigo_produto().equals(str)){
                 return true;
             }
         }
         return false;
    }
    
}
