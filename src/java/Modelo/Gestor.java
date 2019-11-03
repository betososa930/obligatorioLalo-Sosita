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
public class Gestor extends Usuario {

    private ArrayList<Pedido> pedidos;
    private UnidadProcesadoradePedido unidadProcPedido;
    
    public Gestor(int oid, String user, String password, String nombreCompleto) {
        super(oid, user, password, nombreCompleto);
    }

    public UnidadProcesadoradePedido getUnidadProcPedido(){
        return this.unidadProcPedido;
    }
    
    public void setUnidadProcPedido(UnidadProcesadoradePedido unidadProcPedido){
        this.unidadProcPedido = unidadProcPedido;
    }
    
    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }
    
    public void setPedidos(ArrayList<Pedido> pedidos){
        this.pedidos = pedidos;
    }
    
    public void tomarPedido(Pedido pedido){
        //Adquirimos el pedido, si se encuentra en espera
        Pedido tomarPedidoUnProc = this.getUnidadProcPedido().tomarPedido(pedido);
        if(tomarPedidoUnProc != null){
            if(this.getPedidos() != null)
                this.getPedidos().add(tomarPedidoUnProc);
            this.setPedidos(new ArrayList<Pedido>());
            this.getPedidos().add(tomarPedidoUnProc);
        }
    }
    
    public void finalizarPedido(Pedido pedido){
        if(this.getPedidos() != null)
            this.getPedidos().remove(pedido);
    }
    
    @Override
    public String toString() {
        return "Gestor{" + '}';
    }

    @Override
    public Gestor login(String user, String password) {
        if(this.getUser().equals(user) && this.getPassword().equals(password))
            return this;
        return null;
    }
    
}
