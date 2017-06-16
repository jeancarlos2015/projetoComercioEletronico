/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cdp.Fornecedor;
import cdp.Objeto;
import cgt.InterfaceControlar;
import cih.Tela;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import static padroes.Tipo.fornecedor;

/**
 *
 * @author jean
 */
public class ControladorFornecedor extends HttpServlet {

    private final Fabrica fabrica = Fabrica.make(fornecedor);
    private final InterfaceControlar api = fabrica.criaApi();
    private Objeto item = fabrica.criaObjeto();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        cadastrar(request, response);

    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("operacao").equals("cadastro")) {
            if (Tela.valida(request, item.getAtributos())) {
                item = getItem(request);
                if(!api.existe(item)){
                    api.cadastrar(item);
                    request.setAttribute("mensagem", "Fornecedor Cadastrado Com sucesso");
                    RequestDispatcher rd = request.getRequestDispatcher("/cadastroFornecedor.jsp");
                    rd.forward(request, response);
                }else{
                    request.setAttribute("mensagem", "Existe um cadastro com esse fornecedor");
                    RequestDispatcher rd = request.getRequestDispatcher("/cadastroFornecedor.jsp");
                    rd.forward(request, response);
                }
                
            }
        }
    }

//    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.getParameter("operacao").equals("exclusao")) {
//            if (Tela.valida(request, item.getAtributos())) {
//                item = getItem(request);
//                
//            }
//        }
//    }
//    private void autentica(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.getParameter("operacao").equals("autenticacao")) {
//            Fornecedor item1 = (Fornecedor) fabrica.criaObjeto();
//            Tela tela = new TelaControleProdutos();
//            if (api.existe(item1)) {
//                tela.montapagina(response);
//            }
//
//        }
//    }
//    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.getParameter("operacao").equals("listar")) {
//            item = fabrica.criaObjeto();
//            if (Tela.valida(request, item.getAtributos())) {
//                api = fabrica.criaApi();
//
//            }
//        }
//    }
    private Objeto getItem(HttpServletRequest request) {
        Fornecedor item1 = (Fornecedor) fabrica.criaObjeto();
        item1.setCnpj(request.getParameter("cnpj"));
        item1.setEmail(request.getParameter("email"));
        item1.setEndereco(request.getParameter("endereco"));
        item1.setNome(request.getParameter("nome"));
        item1.setTelefone(request.getParameter("telefone"));
        return item1;
    }

    
}
