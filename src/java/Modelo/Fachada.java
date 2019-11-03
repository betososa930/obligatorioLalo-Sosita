/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.CargarDatos;
import Exception.InvalidUserException;
import Exception.NotFoundUserException;
import Sistemas.SistemasUsuarios;

/**
 *
 * @author Usuario
 */
public class Fachada {
    private SistemasUsuarios su;
    private static Fachada instancia;
    
    private Fachada(){
        this.su = new SistemasUsuarios();
    }
    
    public SistemasUsuarios getSistemasUsuarios(){
        return this.su;
    }
    
    public static Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
            CargarDatos.CargarDatos();
        }
        
        return instancia;
    }
    
    public Usuario Login(String user, String password) throws InvalidUserException, NotFoundUserException{
        return su.Login(user, password);
    }
    
    public void AgregarUsuario(Usuario usuario){
        SistemasUsuarios su = this.getSistemasUsuarios();
        su.AgregarUsuario(usuario);
        su.getUsuarios();
    }
}
