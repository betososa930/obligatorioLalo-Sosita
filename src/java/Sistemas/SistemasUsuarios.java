/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistemas;

import Datos.CargarMozos;
import Exception.InvalidUserException;
import Exception.NotFoundUserException;
import Modelo.Usuario;
import Persistencia.MapeadorUsuarioGestor;
import Persistencia.MapeadorUsuarioMozo;
import Persistencia.Persistencia;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class SistemasUsuarios {

    public SistemasUsuarios getInstancia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private ArrayList<Usuario> usuarios;
    private MapeadorUsuarioMozo mu = new MapeadorUsuarioMozo();
    private MapeadorUsuarioGestor mg = new MapeadorUsuarioGestor();
    
    public SistemasUsuarios(){
        this.usuarios = new ArrayList();
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }
    
    public Usuario Login(String user, String password) throws InvalidUserException, NotFoundUserException{
        if(this.getUsuarios().isEmpty())
            throw new NotFoundUserException("No hay usuarios registrados.");
        else{
            for(Usuario usuario : this.getUsuarios()){
                if(usuario.login(user, password) != null)
                    return usuario;
            }
            return null;
        }
    }
    
    public void CargarUsuario(Usuario usuario){
        this.getUsuarios().add(usuario);
    }
    
    //Carga iniciar
    public void AgregarUsuario(Usuario usuario){
        this.getUsuarios().add(usuario);
//        mu.setUsuario(usuario);
//        Persistencia persistencia = Persistencia.getIntancia();
//        persistencia.guardar(mu);
    }
}
