/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import cdp.Pedido;
import cdp.Pedidos;
import cgd.Dao;
import cgd.DaoPedido;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author jean
 */
@Path("Pedido")
public class WebService {

    @GET
    @Produces("application/json")
    @Path("Pedido/list")
    public String listPedidos() {
        Dao dao = new DaoPedido();
        List<Pedido> pedidos = dao.listar();
        Pedidos pedidos1 = new Pedidos();
        pedidos1.setPedidos(pedidos);
        Gson g = new Gson();
        return g.toJson(pedidos1);
    }
    
  
   
  @PUT
  @Path("Pedido/salvar")
  @Consumes(MediaType.APPLICATION_JSON)
  public void salvar(String pedido){
      Gson g = new Gson();
      Pedido p = g.fromJson(pedido,Pedido.class);
      Dao dao = new DaoPedido();
      dao.set(p);
      dao.inserir();
  }
  
  @POST
  @Path("Pedido/VerficaID")
  @Consumes(MediaType.APPLICATION_JSON)
  public String getDados(@QueryParam("id_pedido") int id_pedido){
      Dao dao = new DaoPedido();
      List<Pedido> pedidos = dao.listar();
      Gson g = new Gson();
      for(Pedido p:pedidos){
          if(p.getCodigo()==id_pedido){
              return g.toJson(p);
          }
      }
      return g.toJson(null);
  }
  
  
}
