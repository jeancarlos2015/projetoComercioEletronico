/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;


import cdp.Objeto;
import cdp.Produto;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class ControlarProdutos extends Controlar{

    public ControlarProdutos() {
        super(produto);
    }
@Override
    public boolean cadastrar(Objeto item) {
        Produto produto = (Produto) item;
        produto.setCodigo_produto(""+(dao.maiorCodigo()+1));
        return dao.cadastrar(produto);   
    }
    
}
