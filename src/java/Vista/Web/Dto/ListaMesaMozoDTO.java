/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Web.Dto;

import Modelo.Mesa;

/**
 *
 * @author Usuario
 */
public class ListaMesaMozoDTO {
    private int numero;
    private boolean abierta;
    
    public ListaMesaMozoDTO(Mesa mesa){
        this.numero = mesa.getNumero();
        this.abierta = mesa.EstaAbierta();
    }
    
    public int getNumero(){
        return this.getNumero();
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public boolean getAbierta(){
        return this.abierta;
    }
    
    public void setAbierta(boolean abierta){
        this.abierta = abierta;
    }
}
