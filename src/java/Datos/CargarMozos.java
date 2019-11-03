/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Fachada;
import Modelo.Mozo;

/**
 *
 * @author Usuario
 */
public class CargarMozos {
    public static void Cargar(){
        Mozo mozo = new Mozo(1, "luis.lerena", "123456", "Luis Lerena");
        Fachada.getInstancia().AgregarUsuario(mozo);
        mozo = new Mozo(2, "alberto.sosa", "123456", "Alberto Sosa");
        Fachada.getInstancia().AgregarUsuario(mozo);
    }
}
