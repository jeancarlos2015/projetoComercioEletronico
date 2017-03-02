/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.pedidowebservice;

import cdp.Pedido;
import cdp.Pedidos;
import cgd.Dao;
import cgd.DaoPedido;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jean
 */
@Path("Pedido")
public class PedidoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PedidoResource
     */
    public PedidoResource() {
    }

    /**
     * Retrieves representation of an instance of com.webservice.pedidowebservice.PedidoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Teste/teste")
    public String getJson() {
        return "testando webservice";
    }

    /**
     *
     * @return
     */
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
    /**
     * PUT method for updating or creating an instance of PedidoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String pedido) {
        
    }
}
