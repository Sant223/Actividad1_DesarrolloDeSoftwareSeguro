package iu_1.formularios;

import iu_1.clases.Funcionario;
import iu_1.interfaces.DAOFuncionario;
import iu_1.interfaces.DAOFuncionarioImpl;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class VistaFuncionarios extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaFuncionarios.class.getName());

    public VistaFuncionarios() {
        initComponents();
        cargarTabla();

        cbTipoDocumento.removeAllItems(); // Limpia por si acaso
        cbTipoDocumento.addItem(new Item(1, "Cédula de Ciudadanía"));
        cbTipoDocumento.addItem(new Item(2, "Cedula de Extranjeria"));
        cbTipoDocumento.addItem(new Item(3, "Pasaporte"));
        cbTipoDocumento.addItem(new Item(4, "Targeta de identidad"));

        cbEstadoCivil.addItem(new Item(1, "Soltero(a)"));
        cbEstadoCivil.addItem(new Item(2, "Casado(a)"));
        cbEstadoCivil.addItem(new Item(3, "Unión Libre"));
        cbEstadoCivil.addItem(new Item(4, "Divorciado(a)"));

        tbFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tbFuncionarios.getSelectedRow();
                if (fila != -1) {
                    
                    funcionarioIdSeleccionado = Integer.parseInt(tbFuncionarios.getValueAt(fila, 0).toString());

                    
                    txtDocumento.setText(tbFuncionarios.getValueAt(fila, 1).toString());
                    txtNombres.setText(tbFuncionarios.getValueAt(fila, 2).toString());
                    txtApellidos.setText(tbFuncionarios.getValueAt(fila, 3).toString());
                    txtFecha_Nacimiento.setText(tbFuncionarios.getValueAt(fila, 4).toString());

                    
                    txtDireccion.setText(tbFuncionarios.getValueAt(fila, 5).toString());
                    txtTelefono.setText(tbFuncionarios.getValueAt(fila, 6).toString());

               
                    int idTipoDoc = Integer.parseInt(tbFuncionarios.getValueAt(fila, 7).toString());
                    int idEstadoCivil = Integer.parseInt(tbFuncionarios.getValueAt(fila, 8).toString());

                    seleccionarItemPorId(cbTipoDocumento, idTipoDoc);
                    seleccionarItemPorId(cbEstadoCivil, idEstadoCivil);
                }
            }
        });
        limpiarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtFecha_Nacimiento = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cbTipoDocumento = new javax.swing.JComboBox<>();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();
        botonGuardar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Crud Funcionarios"));

        jLabel1.setText("documento");

        jLabel2.setText("nombres");

        jLabel3.setText("apellidos");

        jLabel4.setText("fecha nacimiento");

        jLabel5.setText("direccion");

        jLabel6.setText("id tipo documento");

        jLabel7.setText("telefono");

        jLabel8.setText("id estado civil");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDocumento)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(txtDireccion)
                            .addComponent(txtFecha_Nacimiento)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombres)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoDocumento, 0, 235, Short.MAX_VALUE)
                            .addComponent(cbEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbFuncionarios);

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(this::botonGuardarActionPerformed);

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(this::botonModificarActionPerformed);

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(this::botonEliminarActionPerformed);

        jLabel9.setText("*Click para seleccionar el registro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonGuardar)
                            .addComponent(botonModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminar)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        try {
            if (txtDocumento.getText().trim().isEmpty() || txtNombres.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El documento y los nombres son obligatorios");
                return;
            }

            Funcionario f = new Funcionario();
            f.setDocumento(Integer.parseInt(txtDocumento.getText()));
            f.setNombres(txtNombres.getText());
            f.setApellidos(txtApellidos.getText());
            try {
                LocalDate fecha = LocalDate.parse(txtFecha_Nacimiento.getText());
                f.setFecha_nacimiento(fecha);
            } catch (java.time.format.DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use AAAA-MM-DD");
                return;
            }
            f.setDireccion(txtDireccion.getText());
            f.setTelefono(txtTelefono.getText());
            Item tipoDoc = (Item) cbTipoDocumento.getSelectedItem();
            f.setId_tipo_documento(tipoDoc.id);

            Item estCivil = (Item) cbEstadoCivil.getSelectedItem();
            f.setId_estado_civil(estCivil.id);

            dao.registrar(f);
            JOptionPane.showMessageDialog(this, "Funcionario registrado con éxito");
            cargarTabla();
            limpiarCampos();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if (funcionarioIdSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un funcionario de la tabla para modificar");
            return;
        }

        try {
            if (txtDocumento.getText().trim().isEmpty() || txtNombres.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El documento y los nombres son obligatorios");
                return;
            }

            Funcionario f = new Funcionario();
            f.setId(funcionarioIdSeleccionado);
            try {
                // Intentamos convertir lo que haya en el cuadro de texto a número
                int documento = Integer.parseInt(txtDocumento.getText().trim());
                f.setDocumento(documento);
            } catch (NumberFormatException e) {
                // Si el usuario escribió letras o dejó vacío, entra aquí
                JOptionPane.showMessageDialog(this, "El documento debe ser un número válido (sin puntos, letras ni espacios)");
                return;
            }
            f.setNombres(txtNombres.getText());
            f.setApellidos(txtApellidos.getText());
            f.setDireccion(txtDireccion.getText());
            f.setTelefono(txtTelefono.getText());
            try {
                f.setFecha_nacimiento(LocalDate.parse(txtFecha_Nacimiento.getText()));
            } catch (java.time.format.DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Formato de fecha invalido (AAAA-MM-DD)");
                return;
            }
            Item tipo = (Item) cbTipoDocumento.getSelectedItem();
            f.setId_tipo_documento(tipo.id);

            Item est = (Item) cbEstadoCivil.getSelectedItem();
            f.setId_estado_civil(est.id);

            dao.modificar(f);
            JOptionPane.showMessageDialog(this, "Datos actualizados correctamente");
            cargarTabla();
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (funcionarioIdSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un funcionario de la tabla");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar este registro?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                Funcionario f = new Funcionario();
                f.setId(funcionarioIdSeleccionado);
                dao.eliminar(f);

                JOptionPane.showMessageDialog(this, "Eliminado correctamente");
                funcionarioIdSeleccionado = -1; // Limpiamos la selección
                cargarTabla();
                limpiarCampos();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    // ... después de tus métodos de los botones ...
    public final void cargarTabla() {
        // Definimos las columnas que queremos ver en la interfaz
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DOCUMENTO");
        modelo.addColumn("NOMBRES");
        modelo.addColumn("APELLIDOS");
        modelo.addColumn("FECHA NAC.");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("TIPO DOC");
        modelo.addColumn("EST.CIVIL");

        try {
            // Llamamos al DAO para obtener la lista
            DAOFuncionario dao = new DAOFuncionarioImpl();
            java.util.List<Funcionario> lista = dao.listar();

            // Recorremos la lista y agregamos cada fila al modelo
            for (iu_1.clases.Funcionario f : lista) {
                Object[] fila = new Object[9];
                fila[0] = f.getId();
                fila[1] = f.getDocumento();
                fila[2] = f.getNombres();
                fila[3] = f.getApellidos();
                fila[4] = f.getFecha_nacimiento();
                fila[5] = f.getDireccion();
                fila[6] = f.getTelefono();
                fila[7] = f.getId_tipo_documento();
                fila[8] = f.getId_estado_civil();
                modelo.addRow(fila);
            }

            tbFuncionarios.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtDocumento.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtFecha_Nacimiento.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        cbTipoDocumento.setSelectedIndex(0);
        cbEstadoCivil.setSelectedIndex(0);
        funcionarioIdSeleccionado = -1;
    }
    
    private void seleccionarItemPorId(javax.swing.JComboBox<Item> comboBox, int idBuscar) {
    for (int i = 0; i < comboBox.getItemCount(); i++) {
        Item item = comboBox.getItemAt(i);
        if (item.id == idBuscar) {
            comboBox.setSelectedIndex(i);
            break;
        }
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VistaFuncionarios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JComboBox<Item> cbEstadoCivil;
    private javax.swing.JComboBox<Item> cbTipoDocumento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFuncionarios;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtFecha_Nacimiento;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
    private DAOFuncionario dao = new DAOFuncionarioImpl();
    private int funcionarioIdSeleccionado = -1;
}

class Item {

    int id;
    String nombre;

    public Item(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}


