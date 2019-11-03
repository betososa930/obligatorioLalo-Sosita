/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Vistas.IVistaLogin;
import Exception.InvalidUserException;
import Modelo.Fachada;
import Modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class ControladorLogin {
    private IVistaLogin vista;
    private Fachada instancia;
    
    public ControladorLogin(IVistaLogin vista){
        this.vista = vista;
        this.instancia = Fachada.getInstancia();
    }
    
    public Fachada getInstancia(){
        return this.instancia;
    }
    
    public IVistaLogin getVista(){
        return this.vista;
    }
    
    public void login(String user, String password){
        Usuario usuario = null;
            this.getVista().error("Error inesperado en el sistema");
            /*
        try{
            usuario = this.getInstancia().Login(user, password);
            this.getVista().login(usuario);
        }catch(InvalidUserException iue){
        }catch (Exception e){
            this.getVista().error("Error inesperado en el sistema");
        }*/
    }
}
