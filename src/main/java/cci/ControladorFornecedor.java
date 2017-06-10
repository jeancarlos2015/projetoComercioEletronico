/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;


import cdp.Fornecedor;
import cdp.Objeto;
import cgt.InterfaceControlar;
import cih.TelaAbstract;
import cih.TelaControleProdutos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import padroes.Tipo;


/**
 *
 * @author jean
 */
public class ControladorFornecedor extends HttpServlet{

    private final Fabrica fabrica = Fabrica.make(Tipo.fornecedor);
    private InterfaceControlar api;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            cadastrar(request, response);
            excluir(request, response);
            listar(request, response);
            autentica(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("cadastro")){
            Objeto item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                item = getItem(request);
                api.cadastrar(item);
            }
        } 
    }
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("exclusao")){
            Objeto item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                item = getItem(request);
                api.cadastrar(item);
                
            }
        } 
    }
    private void autentica(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("autenticacao")){
            Fornecedor item = (Fornecedor)fabrica.criaObjeto();
            api = fabrica.criaApi();
            
            TelaAbstract tela = new TelaControleProdutos();
            if(api.existe(item)){
                tela.montapagina(response);
            }
            
        } 
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("listar")){
            Objeto item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
               
            }
        }
    }
    
    private Objeto getItem(HttpServletRequest request) {
        Fornecedor item = (Fornecedor) fabrica.criaObjeto();
        
        return item;
    }
}
