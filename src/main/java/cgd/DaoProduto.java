/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Objeto;
import cdp.Pedido;
import cdp.Produto;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class DaoProduto implements Dao {

    private final Fabrica fabrica = Fabrica.make(produto);
    private final Persistencia conexao = fabrica.criaPersistencia();

    @Override
    public List<Objeto> listar() {
        String comando = " SELECT *FROM PRODUTO";
        String result = conexao.executarSelecao(comando);
        String[] res = result.split(";");
        List<Objeto> list = new ArrayList();
        for (String str : res) {
            String[] dado = str.split(",");
            Produto resultado = new Produto();
            resultado.setCodigo_produto(dado[0]);
            resultado.setCnpj(dado[1]);
            resultado.setDescricao(dado[2]);
            resultado.setNome(dado[3]);
            resultado.setQuantidade_unit(dado[4]);
            resultado.setQuantidade_estoq(dado[5]);
            resultado.setMarca(dado[6]);
            resultado.setPreco(dado[7]);
            resultado.setTipoProduto(dado[8]);
            list.add(resultado);
        }
        return list;
    }

    @Override
    public boolean cadastrar(Objeto objeto) {
        Produto produto = (Produto) objeto;
        String comando = "INSERT INTO PEDIDO(codigo_produto, cnpj, descricao, nome, marca, quantidade_unit, quantidade_estoq, preco, tipo) VALUES('" + produto.getCodigo_produto() + "','" + produto.getCnpj() + "','" + produto.getDescricao() + "','" + produto.getNome() + "','" + produto.getMarca() + "'," + produto.getQuantidade_unit() + "," + produto.getQuantidade_estoq() +"',"+produto.getPreco()+ ",'" + produto.getTipoProduto() + "')";
        return conexao.executar(comando);
    }

    @Override
    public boolean excluir(Objeto objeto) {
        Produto produto = (Produto) objeto;
        String comando = "DELETE FROM PEDIDO WHERE codigo_produto='" + produto.getCodigo_produto() + "'";
        return conexao.executar(comando);
    }

    @Override
    public boolean existe(Objeto objeto) {
        Produto produto = (Produto) objeto;
        String comando = " SELECT codigo_produto FROM PRODUTO where codigo_produto = '" + produto.getCodigo_produto() + "'";
        String resultado_str = conexao.executarSelecao(comando);
        String[] resultado_array = resultado_str.split(";");
        for (String str : resultado_array) {
            if (produto.getCodigo_produto().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Objeto buscar(Objeto objeto) {
        Produto produto = (Produto) objeto;
        String comando = " SELECT *FROM PRODUTO where codigo_produto = '" + produto.getCodigo_produto() + "'";
        String resultado_str = conexao.executarSelecao(comando);
        String[] res = resultado_str.split(";");
        Produto resultado = (Produto) fabrica.criaObjeto();
        for (String str : res) {
            String[] dado = str.split(",");
            resultado.setCodigo_produto(dado[0]);
            resultado.setCnpj(dado[1]);
            resultado.setDescricao(dado[2]);
            resultado.setNome(dado[3]);
            resultado.setQuantidade_unit(dado[4]);
            resultado.setQuantidade_estoq(dado[5]);
            resultado.setMarca(dado[6]);
            resultado.setPreco(dado[7]);
            resultado.setTipoProduto(dado[8]);
        }
        return resultado;
    }

    @Override
    public List<Objeto> listar(Objeto objeto) {
        if (objeto.getTipoProduto().equals("produto")) {
            Produto produto = (Produto) objeto;
            String comando = " SELECT *FROM PEDIDO where codigo_produto = '" + produto.getCodigo_produto() + "'";
            String result = conexao.executarSelecao(comando);
            String[] res = result.split(";");
            List<Objeto> list = new ArrayList<>();
            for (String str : res) {
                String[] item = str.split(",");
                Pedido pedido = (Pedido) fabrica.criaObjeto();
                pedido.setCodigo_pedido(item[0]);
                pedido.setCodigo_produto(item[1]);
                pedido.setData(item[2]);
                list.add(pedido);
            }
            return list;
        }
        return null;
    }

    @Override
    public int maiorCodigo() {
        String comando = "select max(codigo_produto) as codigo_produto from produto";
        String[] result = conexao.executarSelecao(comando).split(";");
        int codigo = Integer.parseInt(result[0].trim());
        return codigo;
    }

}
