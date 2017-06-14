/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cih;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jean
 */
public abstract class TelaAbstract {
      
      private List<String> titulos = new ArrayList<>();

    /**
     * @return the titulos
     */
    public List<String> getTitulos() {
        return titulos;
    }

    /**
     * @param titulos the titulos to set
     */
    public void setTitulos(List<String> titulos) {
        this.titulos = titulos;
    }
      
      public void montahead(PrintWriter pw, String titulo){
        pw.println(" <head>");
        pw.println(" <meta charset='utf-8'>");
        pw.println(" <meta name='viewport' content='width=device-width, initial-scale=1'>");
        pw.println(" <title>"+titulo+"</title>");
        pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>");
        pw.println("<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>");
        pw.println("<link rel='icon' href='img/icon.png'>");
        pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js'></script>");
        pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
        pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>");
        pw.println("<link rel='stylesheet' href='css/style.css'/>");
        pw.println(" </head>");
    }
      public void topoTabela(PrintWriter pw, String titulo){
          pw.println("<section class='newsletter container bg-white'>");
          pw.println("<div class='panel panel-default'>");
          pw.println("<div class='panel-heading'><h1 class='bg-titulo'>"+titulo+"</h1></div>");
          pw.println("<div class='panel-body'>");
          pw.println("</div>");
          pw.println("<table class='table table-responsive'>");
      }
      public void abreThread(PrintWriter pw){
          pw.println("<thread>");
      }
      
      public void fechaThread(PrintWriter pw){
          pw.println("</thread>");
      }
      public void titulosTabela(PrintWriter pw, List<String> titulos){
          abreThread(pw);
          pw.println("<tr>");
          for(String titulo:titulos){
              pw.println("<th>"+titulo.toUpperCase()+"</th>");
          }
          pw.println("</tr>");
          fechaThread(pw);
      }
      
      public void criaCampoTabela(PrintWriter pw, String valor){
          pw.println("<td>"+valor+"</td>");
      }
      public void criaBotaoCampoTabela(PrintWriter pw, String valor){
          pw.println("<td><button class='botao-teste'>"+valor+"<button></td>");
      }
      
      public void inicioConteudo(PrintWriter pw){
          pw.println("<tbody>");
          pw.println("<tr>");
          pw.println("<th scope='row'>1</th>");
      }
      public void abreLinha(PrintWriter pw){
          pw.println("<tr>");
      }
      
      public void fechaLinha(PrintWriter pw){
          pw.println("</tr>");
      }
      public void finalConteudo(PrintWriter pw){
          pw.println("</tr>");
          pw.println("</tbody>");
          pw.println("</table>");
          pw.println("</div>");
          pw.println("</section>");
      }
      public void inicioBody(PrintWriter pw){
          pw.println("<body>");
      }
      
      public void fimBody(PrintWriter pw){
          pw.println("</body>");
      }
      public void montaTabela(PrintWriter pw, String titulo){
          
          topoTabela(pw, titulo);
          titulosTabela(pw, getTitulos());
          inicioConteudo(pw);
          pw.println("<td>Feijao</td>");
          pw.println("<td>Rio Doce</td>");
          pw.println("<td>Preco</td>");
          finalConteudo(pw);
          
          
      }
      
      
      public void montarodape(PrintWriter pw) {
        pw.println("<footer class='rodape container bg-gradient'>");
        pw.println("<div class='social-icons'>");
        pw.println("<a href='#'><i class='fa fa-facebook'></i></a>");
        pw.println("<a href='#'><i class='fa fa-twitter'></i></a>");
        pw.println("<a href='#'><i class='fa fa-google'></i></a>");
        pw.println("<a href='#'><i class='fa fa-instagram'></i></a>");
        pw.println("<a href='#'><i class='fa fa-envelope'></i></a>");
        pw.println("</div>");
        pw.println("<p class='copyright'>");
        pw.println("Copyright © SisPedidos 2016. Todos os direitos reservados - Desenvolvido Por Jean Carlos Penas.");
        pw.println("</footer>");
        pw.println("<script>");
        pw.println("$('.btn-menu').click(function(){");
        pw.println("$('.menu').show();");
        pw.println("});");
        pw.println("$('.btn-close').click(function(){");
        pw.println("$('.menu').hide();");
        pw.println("});");
        pw.println("</script>"); 
    }
    public void criaItemMenu(PrintWriter pw,String classe, String url, String item){
        pw.println("<li class='"+classe+"'><a href='"+url+"'>"+item+"</a></li>");
    }
    public void criaCampo(PrintWriter pw, String nome, String placeholder,String classe){
        pw.println("<input class='"+classe+"' type='text'  name='"+nome+"' placeholder='"+placeholder+"' required>");
    }
    public void criaCampoSenha(PrintWriter pw, String nome, String placeholder,String classe){
        pw.println("<input class='"+classe+"' type='password'  name='"+nome+"' placeholder='"+placeholder+"' required>");
    }
    public void criaCampoOculto(PrintWriter pw, String tipo, String value){
        pw.println("<input class='oculto' type='text' value='"+value+"'  name='"+tipo+"'>");
    }
    public void abreFormulario(PrintWriter pw, String controlador, String titulo){
        pw.println("<form method='post' class='newsletter' action='"+controlador+"'>");
    }
    public void fechaFormulario(PrintWriter pw){
        pw.println("</form>");
    }
    public void criaBotao(PrintWriter pw, String descricao, String classe){
        pw.println("<button type='submit' class='"+classe+"'> "+descricao+"</button>");
    }
  
    public static void alert(String msg, PrintWriter pw){
        pw.println("<script> alert("+msg+");<script>");
    }
    public static boolean valida(HttpServletRequest request, String[] atributos){
        for(String atributo:atributos){
            if(request.getParameter(atributo)==null){
                return false;
            }
        }
        return true;
    }
    public void inicioHtml(HttpServletResponse response) throws IOException{
        PrintWriter pw = response.getWriter();
            pw.println("<!DOCTYPE html>");
            pw.println(" <html lang='pt-br'>");
    }
   public void fimHtml(PrintWriter pw){
       pw.println("</html>");
   }
    public void montapagina(HttpServletResponse response){}
    public void montamenu(PrintWriter pw) {}
    public void montacampos(PrintWriter pw, String titulo, String tipo){}
    public void montabody(PrintWriter pw, String titulo){
        
    }
      
}
