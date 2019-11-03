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
public abstract class Usuario {
    private int oid;
    private String user;
    private String password;
    private String fullName;

    public int getOid(){
        return this.oid;
    }
    
    public void setOid(int oid){
        this.oid = oid;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Usuario() {}

    public Usuario(int oid, String user, String password, String fullName) {
        this.user = user;
        this.password = password;
        this.fullName = fullName;
        this.oid = oid;
    }

    public abstract Usuario login(String user, String password);
    
    @Override
    public String toString() {
        return "Usuario{" + "user=" + this.getUser() + ", password=" + this.getPassword() + ", nombreCompleto=" + this.getFullName() + '}';
    }
    
    
}
