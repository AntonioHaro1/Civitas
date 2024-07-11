/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2s1;

/**
 *
 * @author antonio
 */
class Director {
    
    private String nombre;
    private long telefono;
    
    public Director(String nombre, long telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public String getNombre(){
        return nombre;
    }
    
}
