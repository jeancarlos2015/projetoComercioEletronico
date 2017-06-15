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
import padroes.Tipo;
import static padroes.Tipo.pedido;

/**
 *
 * @author jean
 */
public class DaoPedido implements Dao {

    private final Fabrica fabrica = Fabrica.make(pedido);
    private final Persistencia conexao;

    public DaoPedido() {
        conexao = fabrica.criaPersistencia();
    }

    @Override
    public List<Objeto> listar() {
        String comando = " SELECT *FROM PEDIDO";
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

    @Override
    public boolean cadastrar(Objeto objeto) {
        Pedido pedido = (Pedido) objeto;
        String comando = "INSERT INTO PEDIDO(codigo_pedido, codigo_produto, data_pedido) VALUES('" + pedido.getCodigo_pedido() + "','" + pedido.getCodigo_produto() + "','" + pedido.getData() + "')";
        return conexao.executar(comando);
    }

    @Override
    public boolean excluir(Objeto objeto) {
        Pedido pedido = (Pedido) objeto;
        String comando = "DELETE FROM PEDIDO WHERE codigo_pedido='" + pedido.getCodigo_pedido() + "'";
        return conexao.executar(comando);
    }

    @Override
    public boolean existe(Objeto objeto) {
        Pedido pedido = (Pedido) objeto;
        String comando = " SELECT codigo_pedido FROM PEDIDO where codigo_pedido = '" + pedido.getCodigo_pedido() + "'";
        String result = conexao.executarSelecao(comando);
        String[] res = result.split(";");
        for (String str : res) {
            if (pedido.getCodigo_pedido().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Objeto buscar(Objeto objeto) {
        Pedido pedido_objeto = (Pedido) objeto;
        String comando = " SELECT *FROM PEDIDO where codigo_pedido = '" + pedido_objeto.getCodigo_pedido() + "'";
        String result = conexao.executarSelecao(comando);
        String[] res = result.split(";");
        Pedido pedido = (Pedido) fabrica.criaObjeto();
        for (String str : res) {
            String[] item = str.split(",");
            pedido.setCodigo_pedido(item[0]);
            pedido.setCodigo_produto(item[1]);
            pedido.setData(item[2]);
        }
        return pedido;
    }

    @Override
    public List<Objeto> listar(Objeto objeto) {

        if (objeto.getTipo().equals("produto")) {
            Produto produto = (Produto) objeto;
            String comando = " SELECT *FROM PEDIDO where codigo_produto = '"+produto.getCodigo_produto()+"'";
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
                list.add(resultado);
            }
            return list;
        }
        return null;
    }

}
