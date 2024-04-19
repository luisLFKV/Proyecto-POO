package main.java.controlador;

import main.java.vista.Dashboard;
import main.java.vista.SellPanel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Image;

public class DashboardController {
    private Dashboard view;

    public DashboardController(Dashboard dashboard) {
        this.view = dashboard;
        onOpen();
    }
    
    public void onOpen(){
        showContent("Facturar", new SellPanel());
        System.out.println("ancho: "+view.userImg.getWidth()+"\nalto: "+view.userImg.getHeight());
        ImageIcon icon = new ImageIcon("src/resources/images/defaultProfileImg.jpg");
        // Escala la imagen al tamaño del JLabel
        Image image = icon.getImage().getScaledInstance(view.userImg.getWidth(), view.userImg.getHeight(), Image.SCALE_SMOOTH);
        // Asigna la imagen al JLabel
        view.userImg.setText("");
        view.userImg.setIcon(new ImageIcon(image));
        view.setVisible(true);
    }

    public void showContent(String titulo, JPanel content){
        view.menuTxt.setText(titulo);
        view.content.setSize(1300, 674);
        view.content.setLocation(0, 0);
        view.content.removeAll();
        view.content.setLayout(new BorderLayout());
        view.content.add(content, BorderLayout.CENTER);
        view.content.revalidate();
        view.content.repaint();
        
    }
}
