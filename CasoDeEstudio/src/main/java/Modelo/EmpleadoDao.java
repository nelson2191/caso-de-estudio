/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nelsonrivas
 */
public class EmpleadoDao {
    Conexion cn= new Conexion();
    Connection conn;
    

    private static String myBD = "jdbc:sqlite:CasoEstudio.db";
    
       {
        
         // SQL para crear la tabla "Producto"
        String sql = "CREATE TABLE IF NOT EXISTS empleado ("
                + "ID TEXT PRIMARY KEY,"
                + "nombre TEXT NOT NULL,"
                + "puesto TEXT NOT NULL"
                + ");";

        // Conectar a la base de datos y crear la tabla
        try (Connection conn = DriverManager.getConnection(myBD);
            Statement stmt = conn.createStatement()) {
            // Ejecutar la instrucción SQL
            stmt.execute(sql);
            System.out.println("Tabla 'Empleado' creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    
    }
    
    public void RegistrarEmpleado(Empleado empleado){
        String insertSql = "Insert Into empleado( ID,nombre,empleado) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(myBD);
            PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, empleado.getID());
            pstmt.setString(2, empleado.getNombre());
            pstmt.setString(3, empleado.getPuesto());
            pstmt.executeUpdate();
            System.out.println("Registro agregado correctamente.");
        } catch (SQLException e) {
                System.out.println("Error al insertar el registro: " + e.getMessage());
        }
    
    }
    
    public List<Empleado> ListarEmpleado(){
        List<Empleado> ListaEm = new ArrayList<>();
        String selectSql = "SELECT  *  FROM empleado";
        

        try (Connection conn = DriverManager.getConnection(myBD);
             PreparedStatement pstmt = conn.prepareStatement(selectSql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
             
                // Crear un objeto Cursos y añadirlo a la lista
                Empleado empleadoObj = new Empleado(
                     
                        rs.getString("ID"),
                        rs.getString("Nombre"),
                        rs.getString("Puesto")
                        
                );
             
                
                ListaEm.add(empleadoObj);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar los registros: " + e.getMessage());
        }
        for (Empleado Empleado : ListaEm) {
            System.out.println(Empleado);
        }
        return ListaEm;
    
    
    }
}
