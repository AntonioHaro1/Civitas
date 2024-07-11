/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2s1;

/**
 *
 * @author antonio
 */
import java.util.ArrayList;

/**
 *
 * @author antonio
 */
class Cliente {
    
    private String dni;
    private String nombre;
    private ArrayList<Reserva> reservas;
    
    public Cliente(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
        reservas = new ArrayList<>();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
    
}