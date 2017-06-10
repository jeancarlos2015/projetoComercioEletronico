package cci;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    private Fabrica fabrica;
    private HttpServlet controle;
   
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        fabrica = Fabrica.make(request.getParameter("tipo"));
        controle = fabrica.criaControle();
        controle.service(request, response);
    }
 
    
}
