/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author nelsonrivas
 */
public class Producto extends EntidadBase {
    private double precio;
    
     public Producto() {
    super("", ""); 
    this.precio = 0;
    }

    public Producto(String ID, String nombre, double precio) {
        super(ID, nombre);
        this.precio = precio;
    }
    
  
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
