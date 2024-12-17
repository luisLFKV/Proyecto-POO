package main.java.modelo;

import main.java.aplicacion.Aplicacion;
import main.java.vista.Dashboard;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Olvera
 */
public class TbInventario {
    public static void inicializarTabla(JTable tabla){
        
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object> > datos = new Vector<Vector<Object>>();
        
        //Añadimos titulos
        titulos.add("Nombre");
        titulos.add("ID");
        titulos.add("Precio Unitario");
        titulos.add("Descripción");
        titulos.add("Cantidad");
        titulos.add("Acciones");
        
        //Añadimos los datos
        for(int i=0 ; i <Aplicacion.listaProductos.size(); i++){
            
            Vector<Object> filas = new Vector<Object>();
            
            filas.add(Aplicacion.listaProductos.get(i).getNombre());
            filas.add(Aplicacion.listaProductos.get(i).getCodigo());
            filas.add(Aplicacion.listaProductos.get(i).getPrecio());
            filas.add(Aplicacion.listaProductos.get(i).getDescripcion());
            filas.add(Aplicacion.listaProductos.get(i).getStock());
            
            datos.add(filas);
            
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        
        tabla.setModel(modelo);
    }
}
