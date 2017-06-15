/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cdp.Cotacao;
import cdp.Fornecedor;
import cdp.Objeto;
import cgt.InterfaceControlar;
import cih.TelaAbstract;
import cih.TelaControleFornecedor;
import cih.TelaControleProdutos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import padroes.Tipo;
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
        geraCotacao(request,response);
        
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("operacao").equals("cadastro")) {
            if (TelaAbstract.valida(request, item.getAtributos())) {
                item = getItem(request);
                api.cadastrar(item);
            }
        }
    }

//    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.getParameter("operacao").equals("exclusao")) {
//            if (TelaAbstract.valida(request, item.getAtributos())) {
//                item = getItem(request);
//                
//            }
//        }
//    }

//    private void autentica(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.getParameter("operacao").equals("autenticacao")) {
//            Fornecedor item1 = (Fornecedor) fabrica.criaObjeto();
//            TelaAbstract tela = new TelaControleProdutos();
//            if (api.existe(item1)) {
//                tela.montapagina(response);
//            }
//
//        }
//    }

//    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.getParameter("operacao").equals("listar")) {
//            item = fabrica.criaObjeto();
//            if (TelaAbstract.valida(request, item.getAtributos())) {
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
        return item;
    }

    public void geraCotacao(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("operacao").equals("cotacao")) {
            TelaAbstract tela = new TelaControleFornecedor();
            Cotacao cotacao = new Cotacao();
            PrintWriter pw = response.getWriter();
            tela.inicioHtml(response);
            tela.montahead(pw, "Controle De Registro de clientes");
            tela.inicioBody(pw);
            tela.montamenu(pw);
            tela.montacampos(pw, "Controle De Registro de Clientes", "controle");
            tela.topoTabela(pw, "Tabela de clientes");

            tela.titulosTabela(pw, Arrays.asList(getAtributos()));
            tela.inicioConteudo(pw);
            tela.abreLinha(pw);
            cotacao.processa();
            tela.abreFormulario(pw, "Controlador", "");
            tela.criaCampoTabela(pw, cotacao.getNomeFornecedor());
            tela.criaCampoTabela(pw, cotacao.getTelefoneFornecedor());
            tela.criaCampoTabela(pw, cotacao.getEmailFornecedor());
            tela.criaCampoTabela(pw, cotacao.getNumero());
            tela.criaCampoTabela(pw, "" + cotacao.getValor_total());
            tela.criaCampoTabela(pw, cotacao.getFormaPagamento1());
            tela.criaCampoTabela(pw, cotacao.getFormaPagamento2());
            tela.criaCampoTabela(pw, cotacao.getValidadeProposta());
            tela.criaCampoTabela(pw, cotacao.getCodigoPedido());
            tela.criaCampoTabela(pw, cotacao.getDataPedido());

            tela.fechaFormulario(pw);
            tela.fechaLinha(pw);

            tela.finalConteudo(pw);
            tela.abreFormulario(pw, "Controlador", "");
            tela.criaCampoOculto(pw, "fornecedor", "confirmado");
            tela.criaBotao(pw, "Confirmar", "campo1");
            tela.fechaFormulario(pw);
            tela.abreFormulario(pw, "Controlador", "");
            tela.criaCampoOculto(pw, "fornecedor", "cancelado");
            tela.criaBotao(pw, "Cancelar", "campo1");
            tela.fechaFormulario(pw);
            tela.montarodape(pw);
            tela.fimBody(pw);
            tela.fimHtml(pw);
        }

    }

    public String[] getAtributos() {
        String[] vetor = {};
        return vetor;
    }
}
