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
public class VentaDao {
    Conexion cn= new Conexion();
    Connection conn;
    

    private static String myBD = "jdbc:sqlite:CasoEstudio.db";
    
       {
        
         // SQL para crear la tabla "Ventas"
        String sql = "CREATE TABLE IF NOT EXISTS ventas ("
                + "ID TEXT PRIMARY KEY,"
                + "nombre TEXT NOT NULL,"
                + "precio TEXT NOT NULL"
                + "cantidad TEXT NOT NULL"
          
                + ");";

        // Conectar a la base de datos y crear la tabla
        try (Connection conn = DriverManager.getConnection(myBD);
            Statement stmt = conn.createStatement()) {
            // Ejecutar la instrucción SQL
            stmt.execute(sql);
            System.out.println("Tabla 'Ventas' creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    
    }
    
    public void RegistrarVenta(Ventas ventas){
        String insertSql = "Insert Into venta( ID,nombre,precio,cantidad) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(myBD);
            PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, ventas.getID());
            pstmt.setString(2, ventas.getNombre());
            pstmt.setDouble(3, ventas.getPrecio());
            pstmt.setInt(4, ventas.getCantidad());
            pstmt.executeUpdate();
            System.out.println("Registro agregado correctamente.");
        } catch (SQLException e) {
                System.out.println("Error al insertar el registro: " + e.getMessage());
        }
    
    }
    
    public List<Ventas> ListarVentas(){
        List<Ventas> ListaVen = new ArrayList<>();
        String selectSql = "SELECT  *  FROM ventas";
        

        try (Connection conn = DriverManager.getConnection(myBD);
             PreparedStatement pstmt = conn.prepareStatement(selectSql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
             
                // Crear un objeto Cursos y añadirlo a la lista
                Ventas ventasObj = new Ventas(
                     
                        rs.getString("ID"),
                        rs.getString("Nombre"),
                        rs.getDouble(Integer.parseInt("Precio")),
                        rs.getInt(Integer.parseInt("Cantidad"))
                        
                );
             
                
                ListaVen.add(ventasObj);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar los registros: " + e.getMessage());
        }
        for (Ventas Ventas : ListaVen) {
            System.out.println(Ventas);
        }
        return ListaVen;
    
    
    }
}
