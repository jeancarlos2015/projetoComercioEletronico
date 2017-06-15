/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Fornecedor;
import cdp.Objeto;
import cdp.Produto;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import padroes.Tipo;
import static padroes.Tipo.fornecedor;

/**
 *
 * @author jean
 */
public class DaoFornecedor implements Dao {

    private final Fabrica fabrica = Fabrica.make(fornecedor);
    private Persistencia conexao;

    public DaoFornecedor() {
        conexao = new Persistencia();
    }

    @Override
    public List<Objeto> listar() {
        String comando = " SELECT *FROM FORNECEDOR";
        String result = conexao.executarSelecao(comando);
        String[] res = result.split(";");
        List<Objeto> lista = new ArrayList<>();
        for (String str : res) {
            String[] item = str.split(",");
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCnpj(item[0]);
            fornecedor.setNome(item[1]);
            fornecedor.setEndereco(item[2]);
            fornecedor.setEmail(item[3]);
            fornecedor.setTelefone(item[4]);
            lista.add(fornecedor);
        }
        return lista;
    }

    @Override
    public boolean cadastrar(Objeto objeto) {
        Fornecedor fornecedor = (Fornecedor) objeto;
        String comando = "INSERT INTO FORNECEDOR(cnpj, nome, endereco, email) VALUES('" + fornecedor.getCnpj() + "','" + fornecedor.getNome() + "','" + fornecedor.getEndereco() + "','" + fornecedor.getEmail() + "')";
        return conexao.executar(comando);
    }

    @Override
    public boolean excluir(Objeto objeto) {
        Fornecedor fornecedor = (Fornecedor) objeto;
        String comando = "DELETE FROM FORNECEDOR WHERE cnpj='" + fornecedor.getCnpj() + "'";
        return conexao.executar(comando);
    }

    @Override
    public boolean existe(Objeto objeto) {
        Fornecedor fornecedor = (Fornecedor) objeto;
        String comando = " SELECT cnpj FROM FORNECEDOR where cnpj = '" + fornecedor.getCnpj() + "'";
        String result = conexao.executarSelecao(comando);
        String[] res = result.split(";");
        for (String str : res) {
            if (fornecedor.getCnpj().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Objeto buscar(Objeto objeto) {
        Fornecedor fornecedor_entrada = (Fornecedor) objeto;
        String comando = " SELECT *FROM FORNECEDOR where cnpj = '" + fornecedor_entrada.getCnpj() + "'";
        String result = conexao.executarSelecao(comando);
        String[] res = result.split(";");
        Fornecedor fornecedor = (Fornecedor) fabrica.criaObjeto();
        for (String str : res) {
            String[] item = str.split(",");
            fornecedor.setCnpj(item[0]);
            fornecedor.setNome(item[1]);
            fornecedor.setEndereco(item[2]);
            fornecedor.setEmail(item[3]);
            fornecedor.setTelefone(item[4]);
        }
        return fornecedor;
    }

    @Override
    public List<Objeto> listar(Objeto objeto) {
        if (objeto.getTipo().equals("produto")) {
            Produto produto = (Produto) objeto;
            String comando = " SELECT *FROM FORNECEDOR cnpj = '"+produto.getCnpj()+"'";
            String result = conexao.executarSelecao(comando);
            String[] res = result.split(";");
            List<Objeto> lista = new ArrayList<>();
            for (String str : res) {
                String[] item = str.split(",");
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCnpj(item[0]);
                fornecedor.setNome(item[1]);
                fornecedor.setEndereco(item[2]);
                fornecedor.setEmail(item[3]);
                fornecedor.setTelefone(item[4]);
                lista.add(fornecedor);
            }
            return lista;
        }
        

        return null;
    }

}
