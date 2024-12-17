package main.java.vista;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import main.java.aplicacion.Aplicacion;
import main.java.modelo.RWUsers;
import main.java.modelo.TbUsuarios;
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
public class PanelUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form Inventario
     */
    public PanelUsuarios() {
        initComponents();
        TbUsuarios.inicializarTabla(tableUsers);
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                addUser addUser = new addUser(row);
                addUser.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (tableUsers.isEditing()) {
                    tableUsers.getCellEditor().stopCellEditing();
                }
                int option = JOptionPane.showConfirmDialog(tableUsers, "¿Estás seguro de eliminar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    Aplicacion.listaUsuarios.remove(row);
                    DefaultTableModel model = (DefaultTableModel) tableUsers.getModel();
                    model.removeRow(row);
                    RWUsers.escribirDatos(Aplicacion.listaUsuarios);
                }

            }

            @Override
            public void onView(int row) {
                JOptionPane.showMessageDialog(tableUsers, Aplicacion.listaUsuarios.get(row), "Información del usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        tableUsers.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        tableUsers.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        tableUsers.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
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
        tableUsers = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        descLabelTxt = new javax.swing.JLabel();
        newUserBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(244, 245, 251));
        setPreferredSize(new java.awt.Dimension(1300, 674));

        titleLabelTxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabelTxt.setForeground(new java.awt.Color(0, 177, 157));
        titleLabelTxt.setText("Usuarios");

        tableUsers.setAutoCreateRowSorter(true);
        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Id", "Edad", "Nivel de privilegio", "Rol", "Turno", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUsers.setRowHeight(40);
        scrollTableProducts.setViewportView(tableUsers);

        jSeparator1.setForeground(new java.awt.Color(244, 245, 251));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        descLabelTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descLabelTxt.setForeground(new java.awt.Color(102, 102, 102));
        descLabelTxt.setText("Lista de los usuarios registrados en esta terminal");

        newUserBtn.setBackground(new java.awt.Color(0, 177, 157));
        newUserBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        newUserBtn.setText("+ Nuevo Usuario");
        newUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserBtnActionPerformed(evt);
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
                                .addComponent(newUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(newUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(scrollTableProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserBtnActionPerformed
        addUser addUser = new addUser();
        addUser.setVisible(true);
    }//GEN-LAST:event_newUserBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descLabelTxt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton newUserBtn;
    private javax.swing.JScrollPane scrollTableProducts;
    private javax.swing.JTable tableUsers;
    private javax.swing.JLabel titleLabelTxt;
    // End of variables declaration//GEN-END:variables
}
