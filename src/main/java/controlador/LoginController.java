package main.java.controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.java.aplicacion.Aplicacion;
import main.java.modelo.Usuario;
import main.java.vista.Login;

public class LoginController {
    private Login view;
    private LoginListener listener;
    private ArrayList<Usuario> listaUsuarios;

    public LoginController(ArrayList<Usuario> listaUsuarios, Login view, LoginListener listener) {
        this.listaUsuarios = listaUsuarios;
        this.view = view;
        this.listener = listener;
        this.view.loginButton.addActionListener((e) -> loginActionPerformed());
    }

    private void loginActionPerformed() {
        boolean verificar = false;
        // Obtener el nombre de usuario y la contraseña de los campos de texto
        String username = view.userIn.getText();
        String password = String.valueOf(view.passwordIn.getPassword());
        
        for (Usuario usuario : listaUsuarios) {
            String username1 = usuario.getNombres()+usuario.getApellidoP()+usuario.getApellidoM();
            if (username1.equals(username) && password.equals(usuario.getPassword())) {
                verificar = true;
                Aplicacion.usuario = usuario;
            }
        }

        //TODO Verificar los datos recibidos con los que se tienen guardados
        if (verificar) {
            // Si la autenticación es exitosa, mostrar un mensaje de éxito
            System.out.println("Login successful!");
            view.dispose();
            listener.onLoginSuccess();
        } else {
            // Si la autenticación falla, mostrar un mensaje de error
            System.out.println("Invalid username or password.");
            listener.onLoginFailure();
            view.passwordIn.setText("");
            JOptionPane.showMessageDialog(view, "Credenciales incorrectas");
            
        }
    }

    public void showLoginGUI() {
        view.setVisible(true);
    }
    

}
