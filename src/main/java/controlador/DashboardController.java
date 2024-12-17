package main.java.controlador;

import main.java.modelo.Usuario;
import main.java.vista.Dashboard;
import main.java.vista.SellPanel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class DashboardController {
    private Dashboard view;

    public DashboardController(Dashboard dashboard, Usuario usuario) {
        this.view = dashboard;
        view.setController(this);
        //this.view.customBtn.addActionListener((e) -> loginActionPerformed());
        onOpen();
    }
    
    private void onOpen(){
        showContent("Facturar", new SellPanel());
        this.view.setVisible(true);
    }

    public void showContent(String titulo, JPanel content){
        this.view.setTxtMenuTxt(titulo);
        this.view.content.setSize(1300, 674);
        this.view.content.setLocation(0, 0);
        this.view.content.removeAll();
        this.view.content.setLayout(new BorderLayout());
        this.view.content.add(content, BorderLayout.CENTER);
        this.view.content.revalidate();
        this.view.content.repaint();
        
    }
}
