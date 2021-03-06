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
public class Produto extends Objeto{
    private String codigo_produto="";
    private String cnpj="";
    private String descricao="";
    private String nome="";
    private int quantidade_unit=0;
    private int quantidade_estoq=0;
    private String marca="";
    private float preco=0;
    private String tipoProduto="";

    public Produto() {
        super("produto");
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the quantidade_unit
     */
    public int getQuantidade_unit() {
        return quantidade_unit;
    }

    /**
     * @param quantidade_unit the quantidade_unit to set
     */
    public void setQuantidade_unit(int quantidade_unit) {
        this.quantidade_unit = quantidade_unit;
    }
    
    public void setQuantidade_unit(String quantidade_unit) {
        this.quantidade_unit = Integer.parseInt(quantidade_unit.trim());
    }
    /**
     * @return the quantidade_estoq
     */
    public int getQuantidade_estoq() {
        return quantidade_estoq;
    }

    /**
     * @param quantidade_estoq the quantidade_estoq to set
     */
    public void setQuantidade_estoq(int quantidade_estoq) {
        this.quantidade_estoq = quantidade_estoq;
    }
    
    public void setQuantidade_estoq(String quantidade_estoq) {
        this.quantidade_estoq = Integer.parseInt(quantidade_estoq.trim());
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String[] getAtributos() {
        String vetor[] = {"codigo_produto","cnpj","descricao",
                           "nome","quantidade_unit","quantidade_estoq","marca","preco","tipo"};
        return vetor;
    }
    @Override
    public String toString(){
        return codigo_produto+" "+cnpj+" "+descricao+" "+nome+" "+marca+" "+quantidade_unit+" "+quantidade_estoq+" "+preco+" "+tipoProduto;
    }
    /**
     * @return the codigo_produto
     */
    public String getCodigo_produto() {
        return codigo_produto;
    }

    /**
     * @param codigo_produto the codigo_produto to set
     */
    public void setCodigo_produto(String codigo_produto) {
        this.codigo_produto = codigo_produto.trim();
    }

    
    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj.trim();
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
    public void setPreco(String preco) {
        this.preco = Float.parseFloat(preco.trim());
    }

    /**
     * @return the tipoProduto
     */
    @Override
    public String getTipoProduto() {
        return tipoProduto;
    }

    /**
     * @param tipoProduto the tipoProduto to set
     */
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    
}
