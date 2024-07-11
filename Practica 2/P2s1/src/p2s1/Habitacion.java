/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2s1;

/**
 *
 * @author antonio
 */
public class Habitacion {
    private int numero;
    private int capacidad;
    
    public Habitacion(int numero, int capacidad){
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
    public int getNumero(){
        return numero;
    }
}
