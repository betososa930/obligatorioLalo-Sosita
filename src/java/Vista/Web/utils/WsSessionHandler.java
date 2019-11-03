/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.web.utils;

import java.util.HashMap;
import Modelo.Usuario;

/**
 *
 * @author alumnoFI
 */
public class WsSessionHandler {
    
    private static HashMap<String, Usuario> usuarios = new HashMap<>();
    
    public static void setItem(String clave, Usuario valor){
        usuarios.put(clave, valor);
    }
    
    public static Usuario getItem(String clave){
        return usuarios.get(clave);
    }
}
