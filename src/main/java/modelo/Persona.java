package main.java.modelo;

import java.io.Serializable;

/**
 *
 * @author Jorge Olvera
 */
public class Persona implements Serializable{
    //Atributos
    private String nombres;
    private String apellidoM;
    private String apellidoP;
    private int edad;
    
    //Constructor
    public Persona() {
        
    }
    public Persona(String nombres, String apellidoP, String apellidoM) {
        this.nombres = nombres;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
    }

    //metodos getter
    public String getNombres() {
        return nombres;
    }
    public String getApellidoM() {
        return apellidoM;
    }
    public String getApellidoP() {
        return apellidoP;
    }
    public int getEdad() {
        return edad;
    }
    
    //metodos setter
    public void setNombre(String nombres) {
        this.nombres = nombres;
    }
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
