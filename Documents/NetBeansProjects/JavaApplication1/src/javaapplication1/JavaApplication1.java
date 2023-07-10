package javaapplication1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication1 {

    public static void main(String[] args) {

        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/agrolivery";
        Connection conexion;
        Statement statement;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
conexion = DriverManager.getConnection(url, usuario, password);
statement = conexion.createStatement();
statement.executeUpdate("INSERT INTO usuarios (documento, nombre, direccion, municipio, departamento, celular, fecha_nacimiento, correo) VALUES (123456789, 'John Doe', 'Dirección', 'Municipio', 'Departamento', 1234567890, '2000-01-01', 'correo@example.com')");
rs = statement.executeQuery("SELECT * FROM usuarios");
while (rs.next()) {
    System.out.println(rs.getInt("documento") + " : " + rs.getString("nombre"));
}

        } catch (SQLException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


    

 