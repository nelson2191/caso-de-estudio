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
public class ClienteDao {
    
    
    Conexion cn= new Conexion();
    Connection conn;
    

    private static String myBD = "jdbc:sqlite:CasoEstudio.db";
    
       {
        
         // SQL para crear la tabla "Cliente"
        String sql = "CREATE TABLE IF NOT EXISTS cliente ("
                + "cedula TEXT PRIMARY KEY,"
                + "nombre TEXT NOT NULL,"
                + "correo TEXT NOT NULL"
                + ");";

        // Conectar a la base de datos y crear la tabla
        try (Connection conn = DriverManager.getConnection(myBD);
            Statement stmt = conn.createStatement()) {
            // Ejecutar la instrucción SQL
            stmt.execute(sql);
            System.out.println("Tabla 'Cliente' creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    
    }
    
    public void RegistrarCliente(Cliente cliente){
        String insertSql = "Insert Into clientes( ID,nombre,correo) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(myBD);
            PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, cliente.getID());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getCorreo());
            pstmt.executeUpdate();
            System.out.println("Registro agregado correctamente.");
        } catch (SQLException e) {
                System.out.println("Error al insertar el registro: " + e.getMessage());
        }
    
    }
    
    public List<Cliente> ListarCliente(){
        List<Cliente> ListaCl = new ArrayList<>();
        String selectSql = "SELECT  *  FROM cliente";
        

        try (Connection conn = DriverManager.getConnection(myBD);
             PreparedStatement pstmt = conn.prepareStatement(selectSql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
             
                // Crear un objeto Cursos y añadirlo a la lista
                Cliente clienteObj = new Cliente(
                     
                        rs.getString("correo"),
                        rs.getString("ID"),
                        rs.getString("Nombre")
                );
             
                
                ListaCl.add(clienteObj);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar los registros: " + e.getMessage());
        }
        for (Cliente Cliente : ListaCl) {
            System.out.println(Cliente);
        }
        return ListaCl;
    
    
    }
  
    
}