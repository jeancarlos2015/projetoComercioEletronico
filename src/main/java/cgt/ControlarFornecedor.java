/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Cotacao;
import cdp.Fornecedor;
import cdp.Pedido;
import padroes.Fabrica;
import static padroes.Tipo.fornecedor;

/**
 *
 * @author jean
 */
public class ControlarFornecedor extends Controlar{
    
    public ControlarFornecedor() {
        super(fornecedor);
    }
    @Override
    public Cotacao geraCotacao(){
        Cotacao cotacao = new Cotacao();
        cotacao.setForma_pagamento_a("A vista");
        cotacao.setForma_pagamento_b("10x Sem Juros");
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("teste cnpj");
        fornecedor.setEmail("teste@gmail.com");
        fornecedor.setEndereco("Rua teste teste");
        fornecedor.setNome("Senhor Teste");
        fornecedor.setTelefone("0000-0000");
        cotacao.setFornecedor(fornecedor);
        Pedido pedido = new Pedido();
        pedido.setCodigo_pedido("1");
        pedido.setCodigo_produto("12");
        pedido.setData("00/00/0000");
        cotacao.setPedido(pedido);
        cotacao.setVencimento("00/00/00");
        return cotacao;
    }
}
