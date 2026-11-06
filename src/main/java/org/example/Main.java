package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ejercicio6";
        String user = "root";
        String pass = "1234";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement()) {

            st.executeUpdate("update empleado set nombre='Prueba' where nombre='P.Martin'");

            try (ResultSet cursor = st.executeQuery(
                    "select dni, nombre from empleado"
            )) {
                while (cursor.next()) {
                    System.out.println(cursor.getString("dni") + " - " + cursor.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}