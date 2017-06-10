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
public class TelaControlePedidos extends TelaAbstract{

    /**
     *
     * @param response
     */
    
    @Override
    public void montapagina(HttpServletResponse response){
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.println(" <!DOCTYPE html>");
            pw.println(" <html lang='pt-br'>");
            montahead(pw, "CONTROLE DE PEDIDOS");
            montabody(pw, "CONTROLE DE PEDIDOS");
            montarodape(pw);
            pw.println("</html>");
        } catch (IOException ex) {
            
        } finally {
            pw.close();
        }
    }
    
    
}
