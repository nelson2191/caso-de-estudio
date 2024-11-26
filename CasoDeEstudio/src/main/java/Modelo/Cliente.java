/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cliente extends EntidadBase{
    
    private String correo;
    
    public Cliente() {
    super("", ""); 
    this.correo = "";
    }

    public Cliente(String correo, String ID, String nombre) {
        super(ID, nombre);
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

      @Override
    public String toString() {
        return "Nuevo empleado{" +
                
                ", correo='" + this.getCorreo() + '\'' +
                ", ID='" + this.getID() + '\'' +
                ", nombre=" + this.getNombre() +
                '}';
    }

  
    
}