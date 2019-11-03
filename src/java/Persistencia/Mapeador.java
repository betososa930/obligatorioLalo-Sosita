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
 * @author docenteFI
 */
public interface Mapeador {

    public int getOid();
    
    public void setOid(int oid);

    public ArrayList<String> getSqlsInsertar();

    public ArrayList<String> getSqlsActualizar();

    public ArrayList<String> getSqlsBorrar();

    public String getSqlSeleccionar();

    public void crearNuevo();

    public void leer(ResultSet rs) throws SQLException;

    public Object getObjeto();

    public void leerComponente(ResultSet rs) throws SQLException;

    
    
}
