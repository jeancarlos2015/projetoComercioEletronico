/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

/**
 *
 * @author jean
 */
public class Cotacao{

    private Fornecedor fornecedor;
    private String forma_pagamento_a="A vista";
    private String forma_pagamento_b="3x Sem juros";
    private String vencimento;
    private Pedido pedido;

    
    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the forma_pagamento_a
     */
    public String getForma_pagamento_a() {
        return forma_pagamento_a;
    }

    /**
     * @param forma_pagamento_a the forma_pagamento_a to set
     */
    public void setForma_pagamento_a(String forma_pagamento_a) {
        this.forma_pagamento_a = forma_pagamento_a;
    }

    /**
     * @return the forma_pagamento_b
     */
    public String getForma_pagamento_b() {
        return forma_pagamento_b;
    }

    /**
     * @param forma_pagamento_b the forma_pagamento_b to set
     */
    public void setForma_pagamento_b(String forma_pagamento_b) {
        this.forma_pagamento_b = forma_pagamento_b;
    }

    /**
     * @return the vencimento
     */
    public String getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the pedido
     */
    

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

  
    
    
    public String getNomeFornecedor(){
        return fornecedor.getNome();
    }
    public String getCnpjFornecedor(){
        return fornecedor.getCnpj();
    }
    public String getEmailFornecedor(){
        return fornecedor.getEmail();
    }
    public String getEnderecoFornecedor(){
        return fornecedor.getEndereco();
    }
    public String getTelefoneFornecedor(){
        return fornecedor.getTelefone();
    }
    
    
    
    public String getDataPedido(){
        return pedido.getData();
    }
    
    public String getCodigoPedido(){
        return pedido.getCodigo_pedido();
    }
    
    public float getValor_total(){
        return pedido.getValor_total();
    }
    
        


    public String getNumero() {
        return pedido.getCodigo_pedido();
    }

   

   
    public String getFormaPagamento1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFormaPagamento2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getValidadeProposta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void processa() {
        
    }
    
}
