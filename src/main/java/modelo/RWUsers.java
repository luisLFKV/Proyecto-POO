package main.java.modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RWUsers {
    public static void escribirDatos(ArrayList<Usuario> listaUsuarios){
        try (FileOutputStream archivo = new FileOutputStream("src/resources/datos/Usuarios.dat");
        ObjectOutputStream salida = new ObjectOutputStream(archivo)) {
            salida.writeObject(listaUsuarios);
        } catch (IOException e1) {
            System.out.println("Imposible abrir el archivo para escribir");
        }   
    }

    public static ArrayList<Usuario> leerDatos(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        
        try (FileInputStream archivo = new FileInputStream("src/resources/datos/Usuarios.dat");
        ObjectInputStream entrada = new ObjectInputStream(archivo)){
            listaUsuarios = (ArrayList<Usuario>) entrada.readObject();
        }
        catch(IOException e1){
            System.out.println("Imposible abrir el archivo para leer");
        }
        catch(ClassNotFoundException e2){
            System.out.println("El objeto leido no corresponde a la clase convertida");            
        }
        return listaUsuarios;
    }
}
