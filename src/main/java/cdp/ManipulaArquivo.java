package cdp;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jean
 */
public class ManipulaArquivo {

    public boolean salvar(Pedido pedido,String arquivo) {
        JSONObject jsonObject = new JSONObject();
        FileWriter writeFile = null;
        //Armazena dados em um Objeto JSON
        jsonObject.put("codigo", pedido.getCodigo());
        jsonObject.put("descricao", pedido.getDescr());
        jsonObject.put("marca", pedido.getMarca());
        jsonObject.put("quantidade", pedido.getQuantidade());

        try {
            writeFile = new FileWriter(arquivo,true);
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }
    public void copiar(){
        
    }
    public boolean salvar(String conteudo, String nome) throws IOException {
        try {

            //Specify the file name and path here
            File file = new File(nome);

            /* This logic is to create the file if the
    	 * file is not already present
             */
            if (!file.exists()) {
                file.createNewFile();
            }

            //Here true is to append the content to file
            FileWriter fw = new FileWriter(file, true);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            String newLine = System.getProperty("line.separator");
            bw.write(conteudo + newLine);
            //Closing BufferedWriter Stream
            bw.close();
            fw.close();
            return true;
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.getMessage());
            return false;
        }

    }

    public void deletar() {

        File file = new File("teste.txt");
        file.setWritable(true);
        file.delete();

    }

    public String Ler(String path) {
        File dir = new File(path);
        String result = "";
        if (dir.exists()) {
            try {
                FileReader fileReader = new FileReader(dir);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linha = "";

                while ((linha = bufferedReader.readLine()) != null) {
                    System.out.println(linha);
                    result += linha;
                }
                //liberamos o fluxo dos objetos ou fechamos o arquivo
                fileReader.close();
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                return null;
            } catch (IOException ex) {
                return null;
            }

        }
        return result;
    }
}
