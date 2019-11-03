/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alumnoFI
 */
public class Persistencia {
    
    private static Persistencia intancia = new Persistencia();
    
    private BaseDatos base = BaseDatos.getInstancia();
    
    public static Persistencia getIntancia() {
        return intancia;
    }
    private Persistencia() {
    }
    public int proximoOid(){
        ResultSet rs = base.consultar("SELECT valor FROM oid");
        try {
            if(!rs.next()){
                System.out.println("Falta cargar oid inicial!");
                return -1;
            }
            int oid = rs.getInt("valor");
            String sql = "UPDATE oid SET valor=" + (oid+1);
            base.modificar(sql);
            return oid;
        } catch (SQLException ex) {
            System.out.println("Error al obtener el oid:" + ex.getMessage());
            return -1;
        }
    }
    public void guardar(Mapeador obj){
        if(obj.getOid()==0){
            insertar(obj);
        }else{
            actualizar(obj);
        }
    }
    private void insertar(Mapeador obj) {
        int oid = proximoOid();
        obj.setOid(oid);
        if(!base.transaccion(obj.getSqlsInsertar())){
            obj.setOid(0);   
            System.out.println("Error al insertar");
        }
    }
    private void actualizar(Mapeador obj) {
        ArrayList<String> sqls = obj.getSqlsActualizar();
        if(!base.transaccion(sqls)){
            System.out.println("Error al actualizar");
        }
    }
    public void borrar(Mapeador obj){
        ArrayList<String> sqls = obj.getSqlsBorrar();
        if(!base.transaccion(sqls)){
            System.out.println("Error al borrar");
        }else{
            obj.setOid(0);
        }
    }
    public ArrayList<Object> todos(Mapeador obj){
        return buscar(obj,null);
    }
    public ArrayList<Object> buscar(Mapeador obj, String filtro){
        
        ArrayList<Object> lista = new ArrayList();
        
        String sql = obj.getSqlSeleccionar();
        if(filtro!=null) sql += "WHERE " + filtro;
        
        ResultSet rs = base.consultar(sql);
        if(rs==null) return null;
        
        try {
            int oidActual, oidAnterior = -1;
            while(rs.next()){
                oidActual = rs.getInt("oid"); //debe llamarse asi en la tabla
                if(oidActual!=oidAnterior){ //cambió el oid
                   oidAnterior = oidActual;
                   obj.crearNuevo(); //Crear un nuevo objeto / Compuesto
                   obj.setOid(oidActual); 
                   obj.leer(rs); //Lee los datos del objeto / Compuesto
                   lista.add(obj.getObjeto()); //lo guardo
                }
                obj.leerComponente(rs);
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar:" + ex.getMessage());
        }
        return lista;
    }
    
}
