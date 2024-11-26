/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author nelsonrivas
 */
public class Ventas extends Producto {

    private int cantidad;
    

    public Ventas() {
    }

    public Ventas(String ID, String nombre, double precio, int cantidad) {
        super(ID, nombre, precio);
        this.cantidad=cantidad;
    }

  

    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    

    
}
