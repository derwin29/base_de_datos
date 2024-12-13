
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DERWIN
 */

public class conexion {
   
    private final String usuario = "postgres";
    private final String contraseña = "24256674";
    private final String bd = "derwin_valecillos";
    private final String ip = "localhost";
    private final String puerto = "5432";

    private final String url = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;

    public Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
