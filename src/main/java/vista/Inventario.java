package main.java.vista;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import main.java.aplicacion.Aplicacion;
import main.java.modelo.RWUsers;
import main.java.modelo.TbInventario;
import main.java.vista.cell.TableActionCellEditor;
import main.java.vista.cell.TableActionCellRender;
import main.java.vista.cell.TableActionEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author kumul
 */
public class Inventario extends javax.swing.JPanel {

    /**
     * Creates new form Inventario
     */
    public Inventario() {
        initComponents();
        TbInventario.inicializarTabla(tableProducts);
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                addProduct addProduct = new addProduct(row);
                addProduct.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (tableProducts.isEditing()) {
                    tableProducts.getCellEditor().stopCellEditing();
                }
                int option = JOptionPane.showConfirmDialog(tableProducts, "¿Estás seguro de eliminar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    Aplicacion.listaProductos.remove(row);
                    DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
                    model.removeRow(row);
                    RWUsers.escribirDatos(Aplicacion.listaUsuarios);
                }

            }

            @Override
            public void onView(int row) {
                JOptionPane.showMessageDialog(tableProducts, Aplicacion.listaProductos.get(row), "Información del producto", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        tableProducts.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        tableProducts.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        tableProducts.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabelTxt = new javax.swing.JLabel();
        scrollTableProducts = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        descLabelTxt = new javax.swing.JLabel();
        newProductBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(244, 245, 251));
        setPreferredSize(new java.awt.Dimension(1300, 674));

        titleLabelTxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabelTxt.setForeground(new java.awt.Color(0, 177, 157));
        titleLabelTxt.setText("Productos");

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Id", "Precio unitario", "Descripción", "Cantidad", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProducts.setRowHeight(40);
        scrollTableProducts.setViewportView(tableProducts);

        jSeparator1.setForeground(new java.awt.Color(244, 245, 251));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        descLabelTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descLabelTxt.setForeground(new java.awt.Color(102, 102, 102));
        descLabelTxt.setText("Lista de los productos registrados en el almacén");

        newProductBtn.setBackground(new java.awt.Color(0, 177, 157));
        newProductBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        newProductBtn.setText("+ Nuevo Producto");
        newProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductBtnActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(244, 245, 251));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleLabelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descLabelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 621, Short.MAX_VALUE)
                                .addComponent(newProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollTableProducts))
                        .addGap(58, 58, 58))
                    .addComponent(jSeparator2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabelTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descLabelTxt))
                    .addComponent(newProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(scrollTableProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductBtnActionPerformed
        addProduct addProduct = new addProduct();
        addProduct.setVisible(true);
        TbInventario.inicializarTabla(tableProducts);
    }//GEN-LAST:event_newProductBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descLabelTxt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton newProductBtn;
    private javax.swing.JScrollPane scrollTableProducts;
    private javax.swing.JTable tableProducts;
    private javax.swing.JLabel titleLabelTxt;
    // End of variables declaration//GEN-END:variables
}
