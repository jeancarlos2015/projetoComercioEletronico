/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import cdp.Objeto;
import cgd.Dao;
import com.google.gson.Gson;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
@WebService(serviceName = "Ws")
public class Ws {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "listarTodos")
    public String listarTodos() {
        Fabrica fabrica = Fabrica.make(produto);
        Dao dao = fabrica.criaDao();
        List<Objeto> lista = dao.listar();
        Gson gson = new Gson();
        return gson.toJson(lista);
    }

    
}
