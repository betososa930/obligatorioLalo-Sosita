/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author pc
 */
public class Mesa {
    
    private int numero;
    private Mozo mozo;
    private Servicio servicio;

    public Mesa(int numero, Mozo mozo) {
        this.numero = numero;
        this.mozo = mozo;
        this.servicio = null;
    }

    public Mesa(int numero, Mozo mozo, Servicio servicio) {
        this.numero = numero;
        this.mozo = mozo;
        this.servicio = servicio;
    }

    public Servicio getServicio(){
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio){
        this.servicio = servicio;
    }
    
    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public int getNumero() {
        return numero;
    }
 
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public boolean EstaAbierta() {
        return this.getServicio() != null;
    }
}
