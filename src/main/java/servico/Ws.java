/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import cdp.Objeto;
import cdp.Produto;
import cgd.Dao;
import com.google.gson.Gson;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
@WebService(serviceName = "Ws")
public class Ws {
    class ProdutoBuffer{
        private String nome;
        private float preco;
        private String tipo;

        /**
         * @return the nome
         */
        public String getNome() {
            return nome;
        }

        /**
         * @param nome the nome to set
         */
        public void setNome(String nome) {
            this.nome = nome;
        }

        /**
         * @return the preco
         */
        public float getPreco() {
            return preco;
        }

        /**
         * @param preco the preco to set
         */
        public void setPreco(float preco) {
            this.preco = preco;
        }

        /**
         * @return the tipo
         */
        public String getTipo() {
            return tipo;
        }

        /**
         * @param tipo the tipo to set
         */
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        
    }
    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "listarTodos")
    public String listarTodos() {
        Fabrica fabrica = Fabrica.make(produto);
        Dao dao = fabrica.criaDao();
        List<Objeto> lista = dao.listar();
        for(Objeto objeto:lista){
            Produto produto= (Produto) objeto;
            ProdutoBuffer prod = new ProdutoBuffer();
            prod.setNome(produto.getNome());
            prod.setPreco(produto.getPreco());
            prod.setTipo(produto.getTipoProduto());
        }
        Gson gson = new Gson();
        return gson.toJson(lista);
    }

    
}
