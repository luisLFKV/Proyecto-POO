package main.java.modelo;

import java.awt.Color;

import javax.swing.JOptionPane;

import main.java.controlador.LoginListener;
import main.java.vista.Login;

public class LoginController {
    private Login view;
    private LoginListener listener;

    public LoginController(Login view, LoginListener listener) {
        this.view = view;
        this.listener = listener;
        this.view.loginButton.addActionListener((e) -> loginActionPerformed());
    }

    private void loginActionPerformed() {
        // Obtener el nombre de usuario y la contraseña de los campos de texto
        String username = "admin";//view.userIn.getText();
        String password = "admin123";//String.valueOf(view.passwordIn.getPassword());
        
        // Verificar la autenticación (aquí puedes realizar la lógica de autenticación según tus requisitos)
        if (username.equals("admin") && password.equals("admin123")) {
            // Si la autenticación es exitosa, mostrar un mensaje de éxito
            listener.onLoginSuccess();
            view.dispose();
            System.out.println("Login successful!");
        } else {
            // Si la autenticación falla, mostrar un mensaje de error
            listener.onLoginFailure();
            view.userIn.setForeground(Color.red);
            view.passwordIn.setForeground(Color.RED);
            JOptionPane.showMessageDialog(view, "Credenciales incorrectas");
            System.out.println("Invalid username or password.");
        }
    }

    public void showLoginGUI() {
        view.setVisible(true);
    }
    

}
