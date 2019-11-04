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
    private enum Tipo{Cocina,Bar,Parrilla};
    private Tipo tipo; 

    public UnidadProcesadoradePedido(Tipo tipo) {
        this.tipo = tipo;
        this.pedidos= new ArrayList<Pedido>();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
