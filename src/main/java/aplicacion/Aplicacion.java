package main.java.aplicacion;

import java.util.ArrayList;
import main.java.controlador.DashboardController;
import main.java.controlador.LoginController;
import main.java.controlador.LoginListener;
import main.java.modelo.Producto;
import main.java.modelo.RWProductos;
import main.java.modelo.RWTienda;
import main.java.modelo.RWUsers;
import main.java.modelo.Tienda;
import main.java.modelo.Usuario;
import main.java.vista.Dashboard;
import main.java.vista.Login;

public class Aplicacion {
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Producto> listaProductos = new ArrayList<>();
    public static Usuario usuario;
    public static Tienda tienda;
    public static void main(String[] args) {
        listaProductos = RWProductos.leerDatos();
        listaUsuarios = RWUsers.leerDatos();
        tienda = RWTienda.leerDatos();
        
        LoginController controller = new LoginController(listaUsuarios, new Login(), new LoginListener() {
            @Override
            public void onLoginSuccess() {
                DashboardController dashboard = new DashboardController(new Dashboard(usuario), usuario);
                /*
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                */
            }

            @Override
            public void onLoginFailure() {
                
            }
        });
        // Mostrar la interfaz de usuario
        controller.showLoginGUI();
    }
}