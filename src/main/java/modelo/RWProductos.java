package main.java.modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RWProductos {
    public static void escribirDatos(ArrayList<Producto> listaProductos){
        try (FileOutputStream archivo = new FileOutputStream("src/resources/datos/Productos.dat");
        ObjectOutputStream salida = new ObjectOutputStream(archivo)) {
            salida.writeObject(listaProductos);
        } catch (IOException e1) {
            System.out.println("Imposible abrir el archivo para escribir");
        }   
    }

    public static ArrayList<Producto> leerDatos(){
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        try (FileInputStream archivo = new FileInputStream("src/resources/datos/Productos.dat");
        ObjectInputStream entrada = new ObjectInputStream(archivo)){
            listaProductos = (ArrayList<Producto>) entrada.readObject();
        }
        catch(IOException e1){
            System.out.println("Imposible abrir el archivo para leer");
        }
        catch(ClassNotFoundException e2){
            System.out.println("El objeto leido no corresponde a la clase convertida");            
        }
        return listaProductos;
    }
}
