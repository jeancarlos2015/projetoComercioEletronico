/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;


import cdp.Objeto;
import cdp.Pedido;
import cgt.InterfaceControlar;
import cih.TelaAbstract;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class ControlePedido extends HttpServlet {
    private final Fabrica fabrica = Fabrica.make(Tipo.pedido);
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
                api = fabrica.criaApi();
                
            }
        }
    }
    
    public Objeto getItem(HttpServletRequest request) {
        Pedido item = (Pedido) fabrica.criaObjeto();
        
        List<String> pratos = new ArrayList();
        for(int numero=1;numero<6;numero++){
            pratos.add(request.getParameter("tipo"+numero));
        }
        return item;
    }
}
