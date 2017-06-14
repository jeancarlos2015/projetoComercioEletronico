/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;


import cdp.Cotacao;
import cdp.Fornecedor;
import cdp.Objeto;
import cdp.Vendedor;
import cgd.Dao;
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
            geraCotacao(response);
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
    
    private void geraCotacao(HttpServletResponse response) throws IOException {

        TelaAbstract tela = new TelaControleFornecedor();
        Objeto item = fabrica.criaObjeto();
        Dao dao = fabrica.criaDao();
        Cotacao cotacao = new Cotacao();
        PrintWriter pw = response.getWriter();
        tela.inicioHtml(response);
        tela.montahead(pw, "Controle De Registro de clientes");
        tela.inicioBody(pw);
        tela.montamenu(pw);
        tela.montacampos(pw, "Controle De Registro de Clientes","controle");
        tela.topoTabela(pw, "Tabela de clientes");
        
        tela.titulosTabela(pw,Arrays.asList(getAtributos()));
        tela.inicioConteudo(pw);
        tela.abreLinha(pw);
        
        tela.abreFormulario(pw, "Controlador","");
        tela.criaCampoTabela(pw, cotacao.getVendedor().getNome());
        tela.criaCampoTabela(pw, cotacao.getVendedor().getTelefone());
        tela.criaCampoTabela(pw, cotacao.getVendedor().getEmail());
        tela.criaCampoTabela(pw, cotacao.getNumero());
        tela.criaCampoTabela(pw, cotacao.getValor_total());
        tela.criaCampoTabela(pw, cotacao.getFormaPagamento1());
        tela.criaCampoTabela(pw, cotacao.getFormaPagamento2());
        tela.criaCampoTabela(pw, cotacao.getValidadeProposta());
        tela.criaCampoTabela(pw, cotacao.getPedido().getCodigo());
        tela.criaCampoTabela(pw, cotacao.getPedido().getData());
        
        tela.fechaFormulario(pw);
        tela.fechaLinha(pw);
        
        tela.finalConteudo(pw);
        tela.abreFormulario(pw, "Controlador","");
        tela.criaCampo(pw, "cpf", "Digite o cpf do cliente","campo1");
        tela.criaBotao(pw, "Excluir","campo1");
        tela.fechaFormulario(pw);
        tela.montarodape(pw);
        tela.fimBody(pw);
        tela.fimHtml(pw);
    }
    
    public String[] getAtributos(){
        String[] vetor={};
        return vetor;
    }
}
