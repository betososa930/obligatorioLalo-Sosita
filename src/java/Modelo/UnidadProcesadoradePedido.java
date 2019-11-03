/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class UnidadProcesadoradePedido {
    private ArrayList<Pedido> pedidos;
    
    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }
    
    public Pedido tomarPedido(Pedido p){
        Pedido retorno = null;
        int cantidad = this.getPedidos() != null ? this.getPedidos().size() : 0;
        int iterator = 0;
        while(retorno == null && iterator < cantidad){
            //Consultamos si es el pedido buscado
            if(this.getPedidos().get(iterator).equals(p)){
                retorno = this.getPedidos().get(iterator);//Establecemos el retorno
                this.getPedidos().remove(iterator);//Quitamos el pedido de la lista de espera
            }
            iterator++;
        }
        return retorno;
    }
}
