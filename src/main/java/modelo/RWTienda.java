package main.java.modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RWTienda {
    public static void escribirDatos(Tienda tienda) {
        try (FileOutputStream archivo = new FileOutputStream("src/resources/datos/Tienda.dat");
             ObjectOutputStream salida = new ObjectOutputStream(archivo)) {
            salida.writeObject(tienda);
        } catch (IOException e) {
            System.err.println("Error al escribir datos en el archivo:");
            e.printStackTrace();
        }
    }

    public static Tienda leerDatos() {
        Tienda tienda = null;
        try (FileInputStream archivo = new FileInputStream("src/resources/datos/Tienda.dat");
             ObjectInputStream entrada = new ObjectInputStream(archivo)) {
            tienda = (Tienda) entrada.readObject();
        } catch (IOException e) {
            System.err.println("Error al leer datos desde el archivo:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada al leer el archivo:");
            e.printStackTrace();
        }
        return tienda;
    }
}
