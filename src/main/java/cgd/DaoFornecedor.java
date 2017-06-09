/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Fornecedor;
import cdp.Objeto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class DaoFornecedor implements Dao{
    private Fornecedor f;
    private ConexaoBanco conexao;
    
    public DaoFornecedor(){
        conexao = new ConexaoBanco();
    }
    
    @Override
    public List<Objeto> listar() {
         String comando=" SELECT *FROM FORNECEDOR";
         String result = conexao.executarSelecao(comando);
         String[] res = result.split(";");
         List<Objeto> list = new ArrayList<>();
         for(String str:res){
             String[] item  = str.split(",");
             Fornecedor f = new Fornecedor();
             f.setCnpj(item[0].trim());
             f.setNome(item[1]);
             f.setEndereco(item[2]);
             list.add(f);
         }
         return list;
    }

    @Override
    public boolean inserir() {
        String comando = "INSERT INTO FORNECEDOR(cnpj, nome, endereco) VALUES('"+f.getCnpj()+"','"+f.getNome()+"','"+f.getEndereco()+"')";    
        return conexao.executar(comando);
    }

    @Override
    public boolean deletar() {
        String comando = "DELETE FROM FORNECEDOR WHERE cnpj='"+f.getCnpj()+"'";
        return conexao.executar(comando);
    }

    
    @Override
    public void set(Objeto objeto){
        f = (Fornecedor) objeto;
    }

    @Override
    public boolean existe(Objeto objeto) {
         Fornecedor fo = (Fornecedor) objeto;
         String comando=" SELECT cnpj FROM FORNECEDOR where cnpj = '"+fo.getCnpj()+"'";
         String result = conexao.executarSelecao(comando);
         String[] res = result.split(";");
         for(String str:res){
             if(fo.getCnpj().equals(str)){
                 return true;
             }
         }
         return false;
    }

}
