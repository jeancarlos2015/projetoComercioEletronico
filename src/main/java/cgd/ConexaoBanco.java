/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jean
 */
public class ConexaoBanco {

    private String url, usuario, senha;

    public ConexaoBanco() {
        url = "jdbc:postgresql://localhost:5432/bancoPedidos";
        usuario = "postgres";
        senha = "ifes";
    }

    public void executar(String comando) {
        try {

            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(url, usuario, senha);

            Statement stm = con.createStatement();

            // stm.executeQuery("INSERT INTO teste VALUES (1,'Cynthia')");  
            stm.executeUpdate(comando);
            //Editado 21/09/2011 para correção: executeQuery é usado para pesquisa, executeUpdate deve ser usado para inserir  
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String executarSelecao(String comando) {
        try {

            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(url, usuario, senha);

            Statement stm = con.createStatement();

            // stm.executeQuery("INSERT INTO teste VALUES (1,'Cynthia')");  
            ResultSet rs = stm.executeQuery(comando);
            String result="";
            while (rs.next()) {
                int codigo = rs.getInt("CODIGO");
                String descr = rs.getString("DESCR");
                String marca = rs.getString("MARCA");
                int quantidade = rs.getInt("quantidade");
                result += codigo+","+descr+","+marca+","+quantidade+";";
                
            }
            rs.close();
            stm.close();

            //Editado 21/09/2011 para correção: executeQuery é usado para pesquisa, executeUpdate deve ser usado para inserir  
            con.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
