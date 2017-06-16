/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cdp.Cotacao;
import cdp.Objeto;
import cdp.Pedido;
import cdp.Produto;
import cgt.InterfaceControlar;
import cih.Tela;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import static padroes.Tipo.fornecedor;
import static padroes.Tipo.pedido;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class ControlePedido extends HttpServlet {

    private final Fabrica fabrica = Fabrica.make(pedido);
    private final InterfaceControlar api = fabrica.criaApi();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cadastrar(request, response);
        geraCotacao(request, response);
    }

    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("operacao").equals("cotacao")) {
            String[] dado= request.getParameterValues("tipo1");
            if (dado!=null) {
                Objeto item = fabrica.criaObjeto();
                item = getItem(request);
                api.cadastrar(item);
                
            } else {
                request.setAttribute("mensagem", "Deve selecionar algum produto!!!");
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("operacao").equals("exclusao")) {
            Objeto item = fabrica.criaObjeto();
            if (Tela.valida(request, item.getAtributos())) {
                item = getItem(request);
                if (api.excluir(item)) {

                } else {

                }
            }
        }
    }

    public Objeto getItem(HttpServletRequest request) {
        Pedido item = (Pedido) fabrica.criaObjeto();
        Fabrica fab = Fabrica.make(produto);
        String[] parametros = request.getParameterValues("tipo1");
        for (String codigo : parametros) {
            Produto p = (Produto) fab.criaObjeto();
            p.setCodigo_produto(codigo);
            item.adicionaItem(p);
        }

        return item;
    }

    public void geraCotacao(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("operacao").equals("cotacao")) {
            String classe = "table-condensed";
            Tela tela = fabrica.criaTela();
            PrintWriter pw = response.getWriter();
            tela.inicioHtml(response);
            tela.montahead(pw, "Cotacao");
            tela.inicioBody(pw);
            tela.abreMenu(pw);
            tela.criaItemMenu(pw, "index.jsp", "Pedidos");
            tela.criaItemMenu(pw, "cadastroProdutos.jsp", "Produtos");
            tela.criaItemMenu(pw, "cadastroFornecedor.jsp", "Fornecedor");
            tela.fechaMenu(pw);

            /*Tabela 1*/
            tela.topoTabela(pw, "COTACAO", classe);
            tela.titulosTabela(pw, Arrays.asList(getAtributos1()));
            tela.inicioConteudo(pw);
            tela.abreLinha(pw);
            tela.criaCampoTabela(pw, "Joao");
            tela.criaCampoTabela(pw, "0000-0000");
            tela.criaCampoTabela(pw, "joao@gmail.com");
            tela.fechaLinha(pw);

            tela.titulosTabela(pw, Arrays.asList(getAtributos2()));
            tela.inicioConteudo(pw);
            tela.abreLinha(pw);
            tela.criaCampoTabela(pw, "123");
            tela.criaCampoTabela(pw, "A vista");
            tela.criaCampoTabela(pw, "10x Sem Juros");
            tela.fechaLinha(pw);

            tela.titulosTabela(pw, Arrays.asList(getAtributos3()));
            tela.inicioConteudo(pw);
            tela.abreLinha(pw);
            tela.criaCampoTabela(pw, "10/12/2017");
            tela.criaCampoTabela(pw, "12");
            tela.criaCampoTabela(pw, "10/10/2017");
            tela.fechaLinha(pw);

            tela.titulosTabela(pw, Arrays.asList(getAtributos4()));
            tela.inicioConteudo(pw);
            tela.abreLinha(pw);
            tela.criaCampoTabela(pw, "50.00");
            tela.fechaLinha(pw);
            tela.finalConteudo(pw);
            /*Fim da tabela*/

            tela.abreFormulario(pw, "Controlador");
            tela.criaCampoOculto(pw, "tipo", "pedido");
            tela.criaCampoOculto(pw, "operacao", "confirmacao");
            tela.criaBotao(pw, "Confirmar", "btn btn-default");
            tela.fechaFormulario(pw);
            tela.abreFormulario(pw, "index.jsp");
            tela.criaBotao(pw, "Cancelar", "btn btn-default");
            tela.fechaFormulario(pw);
            tela.fimBody(pw);
            tela.fimHtml(pw);
        }

    }

    public String[] getAtributos1() {
        String[] vetor = {"Fornecedor", "Telefone", "Email"};
        return vetor;
    }

    public String[] getAtributos2() {
        String[] vetor = {"Numero Da Cotacao", "Forma De Pagamento 1", "Forma De Pagamento 2"};
        return vetor;
    }

    public String[] getAtributos3() {
        String[] vetor = {"Vencimento", "Codigo Do Pedido", "Data Do Pedido"};
        return vetor;
    }

    public String[] getAtributos4() {
        String[] vetor = {"Valor Total Da Compra"};
        return vetor;
    }
}
