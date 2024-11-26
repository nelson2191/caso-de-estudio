/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author nelsonrivas
 */
public class Empleado extends EntidadBase {
    private String puesto;

    public Empleado( String ID, String nombre,String puesto) {
        super(ID, nombre);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
     public Empleado() {
    super("", ""); 
    this.puesto = "";
    }
    
}