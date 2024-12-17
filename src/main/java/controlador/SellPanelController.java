package main.java.controlador;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.java.aplicacion.Aplicacion;
import main.java.modelo.Producto;
import main.java.modelo.RWProductos;
import main.java.modelo.RWTienda;
import main.java.vista.SelectedProduct;
import main.java.vista.SellPanel;
import main.java.vista.productsPanel;

public class SellPanelController {
    private SellPanel view;
    private ArrayList<Producto> listProducts;
    private DefaultListModel<SelectedProduct> selectedListModel;
    private JList<SelectedProduct> selectedList;
    private Map<String, Integer> productCountMap;
    private int noProducts = 0;
    private double globalPrice = 0.0;

    public SellPanelController(SellPanel view, ArrayList<Producto> listProducts) {
        this.view = view;
        this.listProducts = listProducts;
        this.productCountMap = new HashMap<>();
        this.selectedListModel = new DefaultListModel<>();
        this.selectedList = view.getjList1();
        iniciarGridProductos();
        view.setVisible(true);

    }

    public void iniciarGridProductos(){
        int columnas=3, filas;
        if (Aplicacion.listaProductos.size() > 3) {
            filas = Aplicacion.listaProductos.size() / 3 + 1;
        } else {
            filas = 1;
        }
        view.productsGrid.setLayout(new GridLayout(filas, columnas));
        
        for (Producto producto : this.listProducts) {
            productsPanel productPanel = new productsPanel();
            productPanel.setProductName(producto.getNombre());
            productPanel.setImg(producto.getCodigo());
            productPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    addProduct(producto.getCodigo());
                }
            });
            view.productsGrid.add(productPanel);
        }
    }

    private void addProduct(String productCode) {
        Producto product = getProductByCode(productCode);
        if (product != null && product.getStock() > 0) {
            // Verificar si hay suficiente stock
            if (productCountMap.containsKey(productCode)) {
                int count = productCountMap.get(productCode);
                if (count < product.getStock()) {
                    productCountMap.put(productCode, count + 1);
                } else {
                    JOptionPane.showMessageDialog(view.productsGrid, "No hay suficiente stock para el producto seleccionado.", "Información del producto", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("No hay suficiente stock para este producto.");
                }
            } else {
                productCountMap.put(productCode, 1);
            }
        } else {
            JOptionPane.showMessageDialog(view.productsGrid, "No hay suficiente stock para el producto seleccionado.", "Información del producto", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("No hay suficiente stock para este producto.");
        }
        updateSelectedList();
    }    

    private void updateSelectedList() {
        selectedListModel.clear();
        this.globalPrice = 0;
        this.noProducts = 0;
        for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
            String productCode = entry.getKey();
            Producto product = getProductByCode(productCode); // Obtener el producto por su código
            int quantity = entry.getValue();
            SelectedProduct selectedProduct = new SelectedProduct(product, quantity); // Crear el objeto SelectedProduct
            selectedListModel.addElement(selectedProduct);
            globalPrice += product.getPrecio()*quantity;
            noProducts += quantity;
        }
        view.updateFinalPrice(globalPrice);
        view.updateNoProducts(noProducts);
        // Asegurarse de asignar la lista actualizada al componente JList
        view.getjList1().setModel(selectedListModel);
        
    }

    private Producto getProductByCode(String productCode) {
        for (Producto product : listProducts) {
            if (product.getCodigo().equals(productCode)) {
                return product;
            }
        }
        return null; // Manejar el caso en que no se encuentre el producto
    }

    public void clearSelectedProducts() {
        // Limpiar el mapa de productos seleccionados
        productCountMap.clear();
        // Actualizar la lista visual de productos seleccionados
        updateSelectedList();
    }

    public void sellSelectProducts(){
        if (noProducts >= 1) {
            String monto = this.noProducts+" producto(s) a $"+this.globalPrice+" MXN";
            int option = JOptionPane.showConfirmDialog(view.productsGrid, "Confirme la venta de:\n"+monto, "Confirmar", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
                    String productCode = entry.getKey();
                    int quantity = entry.getValue();
                    Producto product = getProductByCode(productCode);
                    if (product != null) {
                        // Restar la cantidad vendida del stock del producto
                        product.setStock(product.getStock() - quantity);
                    }
                }
                System.out.println("Vendido");
                // Limpiar la selección de productos después de venderlos
                clearSelectedProducts();
                // Guarda en el archivo la nueva lista
                RWProductos.escribirDatos(listProducts);
                Aplicacion.tienda.setNoClients(Aplicacion.tienda.getNoClients()+1);
                view.updateNoclients(Aplicacion.tienda.getNoClients());
                RWTienda.escribirDatos(Aplicacion.tienda);
            }
        } else {    
            JOptionPane.showMessageDialog(view.productsGrid, "No hay productos seleccionados.", "Información del producto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
