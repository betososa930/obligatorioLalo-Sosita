/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Modelo.*;

/**
 *
 * @author Usuario
 */
public class MapeadorUsuarioMozo implements Mapeador{

    Usuario usuario;
    
    public MapeadorUsuarioMozo(){}
    
    public MapeadorUsuarioMozo(Usuario u){
        this.usuario = u;
    }
    
    public void setUsuario(Usuario u){
        this.usuario = u;
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
    
    @Override
    public int getOid() {
        return this.getUsuario().getOid();
    }

    @Override
    public void setOid(int oid) {
        this.getUsuario().setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlsInsertar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add( "INSERT INTO usuariomozo values (" + getOid() + ",'" + this.getUsuario().getUser()+ "','" +
                                                 this.getUsuario().getPassword() + "','" + this.getUsuario().getFullName() + "')");
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlsActualizar() {
        ArrayList<String> sqls =new ArrayList();
        sqls.add("UPDATE usuariomozo SET user='" + this.getUsuario().getUser()
                     + "', password='" + this.getUsuario().getPassword()
                     + "', nombrecompleto='" + this.getUsuario().getFullName()
                     + " WHERE oid=" + getOid());
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlsBorrar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add( "DELETE FROM usuariomozo WHERE oid = " + getOid());
        return sqls;
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM usuariomozo ";
    }

    @Override
    public void crearNuevo() {
    }

    @Override
    public void leer(ResultSet rs) throws SQLException {
        this.getUsuario().setUser(rs.getString("user"));
        this.getUsuario().setPassword(rs.getString("password"));  
        this.getUsuario().setFullName(rs.getString("fullname"));
   }

    @Override
    public Object getObjeto() {
        return this.getUsuario();
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
