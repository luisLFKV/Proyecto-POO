package main.java.modelo;

import java.io.Serializable;

/**
 * @author Jorge Olvera
 */
public class Producto implements Serializable{
    //Atributos
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String codigo;
    private Proveedor proveedor;
    
    //Constructor
    public Producto(String nombre, String descripcion, double precio, int stock, String codigo, Proveedor proveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.codigo = codigo;
        this.proveedor = proveedor;
    }
    
    //metodos getter
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public String getCodigo() {
        return codigo;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    
    //metodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }    
    
    @Override
    public String toString() {
        return "Nombre: "+getNombre()+"\nCódigo: "+getCodigo()+"\nDescripción: "+getDescripcion()+"\nPrecio: "+getPrecio()+"\tStock: "+getStock()+"\nProvedor:\n"+getProveedor();
    }
}
