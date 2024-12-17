package main.java.modelo;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.java.aplicacion.Aplicacion;

public class TbUsuarios {
    public static void inicializarTabla(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object> > datos = new Vector<Vector<Object>>();
        
        //Añadimos titulos
        titulos.add("Nombre");
        titulos.add("ID");
        titulos.add("Nivel de privilegio");
        titulos.add("Rol");
        titulos.add("Turno");
        titulos.add("Acciones");
        
        //Añadimos los datos
        for(int i=0 ; i <Aplicacion.listaUsuarios.size(); i++){
            Vector<Object> filas = new Vector<Object>();
            
            filas.add(Aplicacion.listaUsuarios.get(i).getNombres()+" "+Aplicacion.listaUsuarios.get(i).getApellidoP()+" "+Aplicacion.listaUsuarios.get(i).getApellidoM());
            filas.add(Aplicacion.listaUsuarios.get(i).getId());
            filas.add(Aplicacion.listaUsuarios.get(i).getPrivilegio());
            filas.add(Aplicacion.listaUsuarios.get(i).getRol());
            filas.add(Aplicacion.listaUsuarios.get(i).getTurno());
            //filas.add("");
            
            datos.add(filas);
            
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        
        tabla.setModel(modelo);
    }
}
