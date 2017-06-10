/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cih;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jean
 */
public class TelaControleProdutos extends TelaAbstract{
    
    
  public void montahead(PrintWriter pw, String titulo){
        pw.println(" <head>");
        pw.println(" <meta charset='utf-8'>");
        pw.println(" <meta name='viewport' content='width=device-width, initial-scale=1'>");
        pw.println(" <title>"+titulo+"</title>");
        
        pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
        pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>");
        pw.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
        
        pw.println("<link rel='stylesheet' href='css/style.css'/>");
        pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>");
        pw.println("<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>");
        pw.println("<link rel='icon' href='img/icon.png'>");
        pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js'></script>");
        pw.println(" </head>");
    }
    
  @Override
  public void montabody(PrintWriter pw, String titulo){
        pw.println("<body>");
        montamenu(pw);
        montacampos(pw,titulo);
        montaTabela(pw);
        montarodape(pw);
        pw.println("</body>");
  }
  
  @Override
  public void montamenu(PrintWriter pw){
        pw.println("<header class='cabecalho container'>");
        pw.println("<a href='index.html'><h1 class='logo'> SISclientes</h1></a>");
        pw.println("<button class='btn-menu bg-gradient'><i class='fa fa-bars fa-lg'></i></button>");
        pw.println("<nav class='menu' id='close1'>");
        pw.println("<a class='btn-close'><i class='fa fa-times'></i></a>");
        pw.println("<ul>");
        criaItemMenu(pw, "home", "index.jsp", "Produtos");
        criaItemMenu(pw, "home", "acesso.jsp", "Logout");
        pw.println("</ul>");
        pw.println("</nav>");
        pw.println("</header>");
  }
  @Override
  public void montacampos(PrintWriter pw, String titulo){
      pw.println("<section class='newsletter container bg-grey'>");
        pw.println("<h1 class='bg-titulo'>"+titulo+"</h1>");
        pw.println("<form method='post' action='Controlador'>");
        criaCampoOculto(pw, "sistema", "1");
        criaCampo(pw, "nome", "Nome do produto");
        criaCampo(pw, "descricao", "Descricao do produto");
        criaCampo(pw, "preco", "Preco do produto");
        criaCampo(pw, "marca", "Marca do produto");
        criaCampoSenha(pw, "quantidade", "Quantidade");
        criaCampoOculto(pw, "tipo", "produto");
        criaCampoOculto(pw, "operacao", "cadastro");
        criaBotao(pw, "Cadastrar Clientes");
        pw.println("</form>");
        pw.println("</section>");
  }
  @Override
    public void montapagina(HttpServletResponse response){
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.println(" <!DOCTYPE html>");
            pw.println(" <html lang='pt-br'>");
            montahead(pw, "CONTROLE DE PRODUTOS");
            montabody(pw, "CONTROLE DE PRODUTOS");
            montarodape(pw);
            pw.println("</html>");
        } catch (IOException ex) {
            
        } finally {
            pw.close();
        }
    }
}
