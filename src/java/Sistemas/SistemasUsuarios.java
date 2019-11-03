/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistemas;

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
    private static SistemasUsuarios instancia;
    private ArrayList<Usuario> usuarios;
    private MapeadorUsuarioMozo mu = new MapeadorUsuarioMozo();
    private MapeadorUsuarioGestor mg = new MapeadorUsuarioGestor();
    
    private SistemasUsuarios(){}
    
    public static SistemasUsuarios getInstancia(){
        if(SistemasUsuarios.instancia == null)
            SistemasUsuarios.instancia = new SistemasUsuarios();
        return SistemasUsuarios.instancia;
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }
    
    public Usuario Login(String user, String password) throws InvalidUserException, NotFoundUserException{
        if(this.getUsuarios().size() == 0)
            throw new NotFoundUserException("No hay usuarios registrados.");
        else{
            for(Usuario usuario : this.getUsuarios()){
                if(usuario.login(user, password) != null)
                    return usuario;
            }
            return null;
        }
    }
    
    //Carga iniciar
    public void PersistirUsuario(Usuario usuario){
        mu.setUsuario(usuario);
        Persistencia persistencia = Persistencia.getIntancia();
        persistencia.guardar(mu);
    }
}
