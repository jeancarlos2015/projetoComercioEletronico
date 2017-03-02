package cdp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cgd.Dao;
import cgd.DaoPedido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.File;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author jean
 */
public class CodServidor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigo = request.getParameter("codigo");
        String marca = request.getParameter("marca");
        String descricao = request.getParameter("descricao");
        String quantidade = request.getParameter("quantidade");
        Pedido p = new Pedido(descricao, marca, Integer.parseInt(quantidade.trim()), Integer.parseInt(codigo));
        //ManipulaArquivo persistencia = new ManipulaArquivo();
        //Servidor servidor = new ServidorFTP();
        //servidor.recebe("teste.json");
        //persistencia.salvar(new Pedido(descricao, marca, Integer.parseInt(quantidade.trim()), Integer.parseInt(codigo)), "teste.json");
        //servidor.enviar("teste.json");
        Dao dao = new DaoPedido();
        dao.set(p);
        dao.inserir();
        //persistencia.deletar();
        RequestDispatcher acesso = request.getRequestDispatcher("/index.html");
        acesso.forward(request, response);
        
    }
}
