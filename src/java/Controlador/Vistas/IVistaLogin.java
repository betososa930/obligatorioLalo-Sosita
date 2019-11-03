/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vistas;

import Modelo.Usuario;

/**
 *
 * @author Usuario
 */
public interface IVistaLogin {
    void login(Usuario usuario);
    void error(String error);
}
