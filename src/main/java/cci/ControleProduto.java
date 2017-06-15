/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;


import cdp.Objeto;
import cdp.Produto;
import cgt.InterfaceControlar;
import cih.TelaAbstract;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import padroes.Tipo;


/**
 *
 * @author jean
 */
@WebServlet(name = "CadastroProduto", urlPatterns = {"/CadastroProduto"})
public class ControleProduto extends HttpServlet {
    private final Fabrica fabrica = Fabrica.make(Tipo.produto);
    private InterfaceControlar api;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            cadastrar(request, response);
            excluir(request, response);
            listar(request, response);
    }
    
    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("cadastro")){
            Objeto item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                item = getItem(request);
                api.cadastrar(item);
            }
        } 
    }
    
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("exclusao")){
            Objeto item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                item = getItem(request);
                if(api.excluir(item)){
                    
                }
            }
        } 
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("listar")){
            Objeto item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                
                
                
            }
        }
    }
    
    public Objeto getItem(HttpServletRequest request) {
        Produto item = (Produto) fabrica.criaObjeto();
        item.setCodigo_produto("codigo");
        item.setNome(request.getParameter("nome"));
        item.setDescricao(request.getParameter("descricao"));
        item.setPreco(request.getParameter("preco"));
        item.setMarca(request.getParameter("marca"));
        item.setQuantidade_unit(request.getParameter("quantidade_unitaria"));
        item.setQuantidade_estoq(request.getParameter("quantidade_estoque"));
        return item;
    }
}
