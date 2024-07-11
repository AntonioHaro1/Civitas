/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosP2;

import java.util.ArrayList;
/**
 *
 * @author antonio
 */

class Hotel {
    
    private static int NUM_HOTELES = 0;
    private String nombre;
    private String ciudad;
    private int estrellas;
    private Director director;
    private ArrayList<Reserva> reservas;
    private ArrayList<Empleado> empleados;
    private ArrayList<Habitacion> habitaciones;
    
    public Hotel(String nombre, String ciudad, int estrellas){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        NUM_HOTELES +=1;
        reservas = new ArrayList<>();
        empleados = new ArrayList<>();
        habitaciones = new ArrayList<>();
    }
    
    public static int getNumHoteles(){
        return NUM_HOTELES;
    }
    
    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }
    
    public void setDirector(Director director){
        this.director = director;
    }
    
    public Director getDirector(){
        return director;
    }
    
    public void addReserva(Cliente cliente, String fechaEntrada, String fechaSalida){
        Reserva nueva = new Reserva(fechaEntrada, fechaSalida, cliente, this);
        reservas.add(nueva);
    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
    public boolean addEmpleado(Empleado empleado){
        boolean resultado = false;
        
        if(empleado.addTrabajo(this)){
            empleados.add(empleado);
            resultado = true;
        }
        
        return resultado;
    }
    
    public void addHabitacion(int numero, int capacidad){
        Habitacion nueva = new Habitacion(numero, capacidad);
        habitaciones.add(nueva);
    }
    
    public int buscarHabitacionCapacidad(int capacidad){
        int numero = -1;
        
        for(int i=0; i<habitaciones.size(); i++){
            if(habitaciones.get(i).getCapacidad() >= capacidad){
                numero = habitaciones.get(i).getNumero();
                return numero;
            }
        }
        
        return numero;
    }
}
