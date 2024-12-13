/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class crudL {
    conexion miConexion = new conexion(); 


    public void crearInstitucion(String nombre, String tipo, String nivel, int estudiantes, java.sql.Date fecha) {
        String sql = "INSERT INTO institucion_educativa (nombre, tipo_institucion, nivel_educativo, enum_estudiante, fecha) VALUES (?, ?, ?, ?, ?)";
        Connection con = null;
        try {
            con = miConexion.conectar(); 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, tipo);
            pst.setString(3, nivel);
            pst.setInt(4, estudiantes);
            pst.setDate(5, fecha);
            pst.executeUpdate();
            System.out.println("Institución creada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear institución: " + e.getMessage());
        } finally {
            miConexion.cerrarConexion(con); 
        }
    }

    
    public void consultarInstitucion(int id) {
        String sql = "SELECT * FROM institucion_educativa WHERE id = ?";
        Connection con = null;
        try {
            con = miConexion.conectar(); 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Tipo: " + rs.getString("tipo_institucion"));
                System.out.println("Nivel: " + rs.getString("nivel_educativo"));
                System.out.println("Estudiantes: " + rs.getInt("enum_estudiante"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
            } else {
                System.out.println("No se encontró una institución con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar institución: " + e.getMessage());
        } finally {
            miConexion.cerrarConexion(con); 
        }
    }
    
     
    public void actualizarInstitucion(int id, String nombre, String tipo, String nivel, int estudiantes, java.sql.Date fecha) {
        String sql = "UPDATE institucion_educativa SET nombre = ?, tipo_institucion = ?, nivel_educativo = ?, enum_estudiante = ?, fecha = ? WHERE id = ?";
        Connection con = null;
        try {
            con = miConexion.conectar(); 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, tipo);
            pst.setString(3, nivel);
            pst.setInt(4, estudiantes);
            pst.setDate(5, fecha);
            pst.setInt(6, id);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Institución actualizada exitosamente.");
            } else {
                System.out.println("No se encontró una institución con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar institución: " + e.getMessage());
        } finally {
            miConexion.cerrarConexion(con); 
        }
    }

    
    public void eliminarInstitucion(int id) {
        String sql = "DELETE FROM institucion_educativa WHERE id = ?";
        Connection con = null;
        try {
            con = miConexion.conectar(); 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Institución eliminada exitosamente.");
            } else {
                System.out.println("No se encontró una institución con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar institución: " + e.getMessage());
        } finally {
            miConexion.cerrarConexion(con); 
        }
    }

    
    public List<String> listarInstituciones() {
        String sql = "SELECT * FROM institucion_educativa";
        List<String> instituciones = new ArrayList<>();
        Connection con = null;
        try {
            con = miConexion.conectar(); 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String institucion = "ID: " + rs.getInt("id") +
                                     ", Nombre: " + rs.getString("nombre") +
                                     ", Tipo: " + rs.getString("tipo_institucion") +
                                     ", Nivel: " + rs.getString("nivel_educativo") +
                                     ", Estudiantes: " + rs.getInt("enum_estudiante") +
                                     ", Fecha: " + rs.getDate("fecha");
                instituciones.add(institucion);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar instituciones: " + e.getMessage());
        } finally {
            miConexion.cerrarConexion(con);
        }
        return instituciones;
    }
}
