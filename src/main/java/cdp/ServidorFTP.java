package cdp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean
 */
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.net.ftp.FTPClient;


public class ServidorFTP implements Servidor{
    
    @Override
    public void enviar(String nome){
        try {
            FTPClient ftp = new FTPClient();
            
            ftp.connect( "ftp.webcindario.com" );
            ftp.login( "jotac891", "asnaeb" );
            FileInputStream arqEnviar =
                    new FileInputStream(nome);
            if (ftp.storeFile (nome, arqEnviar))
                System.out.println("Arquivo armazenado com sucesso!");
            else
                System.out.println ("Erro ao armazenar o arquivo.");
            arqEnviar.close();
            ftp.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(ServidorFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    @Override
    public void recebe(String nome){
        try {
            FTPClient ftp = new FTPClient();
            
            ftp.connect( "ftp.webcindario.com" );

            ftp.login( "jotac891", "asnaeb" );

            ftp.changeWorkingDirectory ("grdt_websigem");

            String[] arq = ftp.listNames();

            FileOutputStream fos =

                    new FileOutputStream( nome );

            if (ftp.retrieveFile(nome, fos ))
                
                System.out.println("Download efetuado com sucesso!");
            
            else
                
                System.out.println ("Erro ao efetuar download do arquivo.");
            fos.close();
            //ftp.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(ServidorFTP.class.getName()).log(Level.SEVERE, null, ex);
        }

      
   
    }
}


