package main.java.aplicacion;

import main.java.controlador.DashboardController;
import main.java.controlador.LoginListener;
import main.java.modelo.LoginController;
import main.java.modelo.Usuario;
import main.java.vista.Dashboard;
import main.java.vista.Login;

public class Aplicacion {
    private Usuario usuario;
    public static void main(String[] args) {
        
        // Crear una instancia del controlador y pasarle la vista
        LoginController controller = new LoginController(new Login(), new LoginListener() {
            @Override
            public void onLoginSuccess() {
                // Acciones a realizar después de un inicio de sesión exitoso
                System.out.println("Inicio de sesión exitoso. Ejecutando otras acciones...");
                // Aquí puedes llamar a métodos o iniciar acciones adicionales
                DashboardController dashBoard = new DashboardController(new Dashboard());
                /*
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                */
            }

            @Override
            public void onLoginFailure() {
                // Acciones a realizar después de un inicio de sesión fallido
                System.out.println("Inicio de sesión fallido. No se pueden ejecutar otras acciones.");
                // Aquí puedes manejar el inicio de sesión fallido
            }
        });
        // Mostrar la interfaz de usuario
        controller.showLoginGUI();
    }
}