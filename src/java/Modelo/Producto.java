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
public class Producto {
    private int codigo;
    private String nombre;
    private double precioUnitario;
    private int stock;
    private UnidadProcesadoradePedido unidad;

    public Producto(int codigo, String nombre, double precioUnitario, int stock, UnidadProcesadoradePedido unidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.unidad = unidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public UnidadProcesadoradePedido getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadProcesadoradePedido unidad) {
        this.unidad = unidad;
    }
    
    
            
}
