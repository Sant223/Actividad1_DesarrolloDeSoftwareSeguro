package iu_1.service;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class DbConnection {

    protected Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/actividad_1";
    private String user = "root";
    private String pass = "root1234";

    public Connection connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La conexion NO fue exitosa, error: " + e.toString());
            e.printStackTrace();
        }

        return connection;
    }

    public void cerrar() {
        try {

            if (connection != null && !connection.isClosed()) {

                connection.close();

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se logro cerrar la conexion, error: " + e.toString());
        }
    }
}
