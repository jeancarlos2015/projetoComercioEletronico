/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cdp.Objeto;
import cdp.Produto;
import cgt.InterfaceControlar;
import cih.Tela;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
@WebServlet(name = "CadastroProduto", urlPatterns = {"/CadastroProduto"})
public class ControleProduto extends HttpServlet {

    private Fabrica fabrica = Fabrica.make(produto);
    private InterfaceControlar api = fabrica.criaApi();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        cadastrar(request, response);
    }

    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("operacao").equals("cadastro")) {
            Objeto item = getItem(request);
            api.cadastrar(item);
            request.setAttribute("mensagem", "Produto Cadastrado Com sucesso");
            RequestDispatcher rd = request.getRequestDispatcher("/cadastroProdutos.jsp");
            rd.forward(request, response);

        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("operacao").equals("exclusao")) {
            Objeto item = fabrica.criaObjeto();
            if (Tela.valida(request, item.getAtributos())) {
                api = fabrica.criaApi();
                item = getItem(request);
                if (api.excluir(item)) {

                }
            }
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("operacao").equals("listar")) {
            Objeto item = fabrica.criaObjeto();
            if (Tela.valida(request, item.getAtributos())) {

            }
        }
    }

    public Objeto getItem(HttpServletRequest request) {
        
            Produto item = (Produto) fabrica.criaObjeto();
            item.setNome(request.getParameter("nome"));
            item.setDescricao(request.getParameter("descricao"));
            item.setPreco(request.getParameter("preco"));
            item.setMarca(request.getParameter("marca"));
            item.setQuantidade_unit(request.getParameter("quantidade_unitaria"));
            item.setQuantidade_estoq(request.getParameter("quantidade_estoque"));
            item.setTipoProduto(request.getParameter("optradio"));
            return item;
    }
    
    public void testa(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter pw = response.getWriter();
//        pw.println(request.setAttribute("", pw))
    }
}
