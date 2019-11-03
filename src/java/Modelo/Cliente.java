/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author pc
 */
public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private Ibeneficio beneficio;

    public Cliente(int id, String nombre, String email, Ibeneficio beneficio) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.beneficio = beneficio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ibeneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Ibeneficio beneficio) {
        this.beneficio = beneficio;
    }

   
    
    
}
