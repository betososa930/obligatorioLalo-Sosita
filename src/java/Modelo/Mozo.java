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
public class Mozo extends Usuario {

    private ArrayList<Mesa> mesas;
    
    public Mozo(int oid, String user, String password, String nombreCompleto) {
        super(oid, user, password, nombreCompleto);
    }

    public void setMesas(ArrayList<Mesa> mesas){
        this.mesas = mesas;
    }
    
    public ArrayList<Mesa> getMesas(){
        return this.mesas;
    }
    
    
    @Override
    public String toString() {
        return "Mozo{" + '}';
    }

    @Override
    public Usuario login(String user, String password) {
        if(this.getUser().equals(user) && this.getPassword().equals(password))
            return this;
        return null;
    }

}
