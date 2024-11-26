/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nelsonrivas
 */
public class Conexion {
    Connection conn;
    public Connection getConnection(){
        try{
            String myBD = "jdbc:sqlite:CasoEstudio.db";
            conn= DriverManager.getConnection(myBD);
            return conn;
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
        return null;
    }
}
