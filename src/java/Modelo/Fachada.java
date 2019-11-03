/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Exception.InvalidUserException;
import Exception.NotFoundUserException;
import Sistemas.SistemasUsuarios;

/**
 *
 * @author Usuario
 */
public class Fachada {
    SistemasUsuarios su = SistemasUsuarios.getInstancia();
    
    private static Fachada instancia;
    
    private Fachada(){}
    
    public static Fachada getInstancia(){
        if(Fachada.instancia == null)
            Fachada.instancia = new Fachada();
        
        return Fachada.instancia;
    }
    
    public Usuario Login(String user, String password) throws InvalidUserException, NotFoundUserException{
        return su.Login(user, password);
    }
}
