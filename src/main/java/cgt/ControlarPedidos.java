/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;


import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.pedido;

/**
 *
 * @author jean
 */
public class ControlarPedidos extends Controlar{

    public ControlarPedidos() {
        super(Fabrica.make(pedido));
    }
    
}
