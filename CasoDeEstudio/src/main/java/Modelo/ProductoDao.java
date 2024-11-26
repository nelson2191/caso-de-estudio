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
public class ProductoDao {
    
    Conexion cn= new Conexion();
    Connection conn;
    

    private static String myBD = "jdbc:sqlite:CasoEstudio.db";
    
       {
        
         // SQL para crear la tabla "Producto"
        String sql = "CREATE TABLE IF NOT EXISTS producto ("
                + "ID TEXT PRIMARY KEY,"
                + "nombre TEXT NOT NULL,"
                + "precio TEXT NOT NULL"
                + ");";

        // Conectar a la base de datos y crear la tabla
        try (Connection conn = DriverManager.getConnection(myBD);
            Statement stmt = conn.createStatement()) {
            // Ejecutar la instrucción SQL
            stmt.execute(sql);
            System.out.println("Tabla 'Producto' creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    
    }
    
    public void RegistrarProducto(Producto producto){
        String insertSql = "Insert Into producto( ID,nombre,precio) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(myBD);
            PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, producto.getID());
            pstmt.setString(2, producto.getNombre());
            pstmt.setDouble(3, producto.getPrecio());
            pstmt.executeUpdate();
            System.out.println("Registro agregado correctamente.");
        } catch (SQLException e) {
                System.out.println("Error al insertar el registro: " + e.getMessage());
        }
    
    }
    
    public List<Producto> ListarProducto(){
        List<Producto> ListaPro = new ArrayList<>();
        String selectSql = "SELECT  *  FROM producto";
        

        try (Connection conn = DriverManager.getConnection(myBD);
             PreparedStatement pstmt = conn.prepareStatement(selectSql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
             
                // Crear un objeto Cursos y añadirlo a la lista
                Producto productoObj = new Producto(
                     
                        rs.getString("ID"),
                        rs.getString("Nombre"),
                        rs.getDouble(Integer.parseInt("Precio"))
                        
                );
             
                
                ListaPro.add(productoObj);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar los registros: " + e.getMessage());
        }
        for (Producto Producto : ListaPro) {
            System.out.println(Producto);
        }
        return ListaPro;
    
    
    }
  
    

}
