/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cih;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jean
 */
public abstract class TelaAbstract {
      
      
      public void montahead(PrintWriter pw, String titulo){
        
    }
    
      public void montaTabela(PrintWriter pw){
          
          
      }
      public void montarodape(PrintWriter pw) {
        
    }
    protected void criaItemMenu(PrintWriter pw,String classe, String url, String item){
        
    }
    protected void criaCampo(PrintWriter pw, String nome, String placeholder){
        
    }
    protected void criaCampoSenha(PrintWriter pw, String nome, String placeholder){
        
    }
    protected void criaCampoOculto(PrintWriter pw, String tipo, String value){
        
    }
    protected void criaBotao(PrintWriter pw, String descricao){
        
    }
    
    public static boolean valida(HttpServletRequest request, String[] atributos){
        
        for(String atributo:atributos){
            if(!atributo.equals("codigo")){
                if(request.getParameter(atributo)==null){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void montapagina(HttpServletResponse response){}
    
    public void montamenu(PrintWriter pw) {}
    public void montacampos(PrintWriter pw, String titulo){}
    public void montabody(PrintWriter pw, String titulo){}
      
      
}
