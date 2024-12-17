package main.java.modelo;

import java.io.Serializable;

/**
 *
 * @author Jorge Olvera
 */
public class Tienda implements Serializable{
    //Atributos
    private String nombre;
    private int idTienda;
    private String direccion;
    private int noClients;

    public Tienda(String nombre, int idTienda, String direccion, int noClients) {
        this.nombre = nombre;
        this.idTienda = idTienda;
        this.direccion = direccion;
        this.noClients = noClients;
    }
    
    //metodos getter
    public String getNombre() {
        return nombre;
    }
    public int getIdTienda() {
        return idTienda;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getNoClients() {
        return noClients;
    }

    //metodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setNoClients(int noClients) {
        this.noClients = noClients;
    }
}
