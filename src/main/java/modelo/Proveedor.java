package main.java.modelo;

import java.io.Serializable;

/**
 *
 * @author Jorge Olvera
 */
public class Proveedor implements Serializable{
    
    //Atributos
    String nombre;
    String direccion;
    String contacto;
    
    //Constructor

    public Proveedor(String nombre, String direccion, String contacto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
    }
    
    
    //metodos getter

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContacto() {
        return contacto;
    }
    
    //metodos seetter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    //metodo para ver la información

    @Override
    public String toString() {
        return "Nombre del proveedor: " + getNombre() + "\nDireccion: " + getDireccion() + "\nContacto: " + getContacto();
    }
    
}
