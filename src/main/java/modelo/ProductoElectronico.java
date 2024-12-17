package main.java.modelo;

/**
 *
 * @author Jorge Olvera
 */
public class ProductoElectronico extends Producto {
    
    //Atributos
    private String modelo;
    
    //Constructor

    public ProductoElectronico(String modelo, String nombre, String descripcion, double precio, int stock, String codigo, Proveedor proveedor) {
        super(nombre, descripcion, precio, stock, codigo, proveedor);
        this.modelo = modelo;
    }
    
    //metodo get

    public String getModelo() {
        return modelo;
    }
    
    //metodo set

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    @Override
    public String toString() {
        return super.toString()+"\nModelo: "+getModelo();
    }
}
