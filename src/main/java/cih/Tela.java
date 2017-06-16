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
public class Tela {
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
        pw.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        pw.println(" <meta name='viewport' content='width=device-width, initial-scale=1'>");
        pw.println(" <title>"+titulo+"</title>");
        pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
        pw.println("<script src='js/funcoes.js'></script>");
        pw.println("<link href='css/bootstrap.min.css' rel='stylesheet'>");
        pw.println("<link href='css/bootstrap.css' rel='stylesheet'>");
        pw.println("<link href='css/bootstrap-theme.css' rel='stylesheet'>");
        pw.println("<link href='css/estilo.css' rel='stylesheet'>");
        pw.println(" </head>");
    }
      public void topoTabela(PrintWriter pw, String titulo, String classe){
          pw.println("<h4>"+titulo+"</h4>");
          pw.println("<table class='table "+classe+"'>");
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
      }
      public void abreLinha(PrintWriter pw){
          pw.println("<tr>");
      }
      
      public void fechaLinha(PrintWriter pw){
          pw.println("</tr>");
      }
      public void finalTabela(PrintWriter pw){
          pw.println("</table>");
      }
      public void finalConteudo(PrintWriter pw){
          pw.println("</tbody>");
          pw.println("</table>");
      }
      public void inicioBody(PrintWriter pw){
          pw.println("<body>");
      }
      
      public void fimBody(PrintWriter pw){
          pw.println("</body>");
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
    public void criaItemMenu(PrintWriter pw,String url, String item){
        pw.println("<li role='presentation' ><a href='"+url+"'>"+item+"</a></li>");
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
    public void abreFormulario(PrintWriter pw, String controlador){
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
    public static boolean validaOpt(HttpServletRequest request, String[] atributos){
        for(String atributo:atributos){
            if(request.getParameter(atributo)!=null){
                return true;
            }
        }
        return false;
    }
    public void inicioHtml(HttpServletResponse response) throws IOException{
        PrintWriter pw = response.getWriter();
            pw.println("<!DOCTYPE html>");
            pw.println(" <html lang='pt-br'>");
    }
   public void fimHtml(PrintWriter pw){
       pw.println("</html>");
   }
    public void abreMenu(PrintWriter pw){
        pw.println("<nav class='navbar navbar-inverse'>");
        pw.println("<ul class='nav nav-pills'>");
    }
    
    public void fechaMenu(PrintWriter pw){
        pw.println("</ul>");
        pw.println("</nav>");
    }
    public void montapagina(HttpServletResponse response){}
    public void montamenu(PrintWriter pw) {}
    public void montacampos(PrintWriter pw, String titulo, String tipo){}
    public void montabody(PrintWriter pw, String titulo){
        
    }
    
      
}
