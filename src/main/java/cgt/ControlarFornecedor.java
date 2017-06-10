/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import padroes.Fabrica;
import static padroes.Tipo.fornecedor;

/**
 *
 * @author jean
 */
public class ControlarFornecedor extends Controlar{
    
    public ControlarFornecedor() {
        super(Fabrica.make(fornecedor));
    }
    
}
