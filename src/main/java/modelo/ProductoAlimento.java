package main.java.modelo;

/**
 *
 * @author Jorge Olvera
 */
public class ProductoAlimento extends Producto {
    //Atributo
    private String fechaCaducidad;
    //private String tipo;
    
    //Constructor
    public ProductoAlimento(String fechaCaducidad, String nombre, String descripcion, double precio, int stock, String codigo, Proveedor proveedor) {
        super(nombre, descripcion, precio, stock, codigo, proveedor);
        this.fechaCaducidad = fechaCaducidad;
        //this.tipo = tipo;
    }
    
    //metodos getter
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

   // public String getTipo() {
    //    return tipo;
   // }
    
    //metodos setter
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

   // public void setTipo(String tipo) {
    //    this.tipo = tipo;
    //}
    @Override
    public String toString() {
        return super.toString()+"\nFecha de caducidad: "+getFechaCaducidad();
    }
}
