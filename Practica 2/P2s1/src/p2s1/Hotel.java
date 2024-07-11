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
    
    
    public void setDirector(Director director){
        this.director = director;
    }
    
    public Director getDirector(){
        return director;
    }
    
    public void addReserva(Cliente cliente, String fechaEntrada, String fechaSalida){
        Reserva nueva = new Reserva(fechaEntrada, fechaSalida, cliente, this);
        reservas.add(nueva);
        cliente.addReserva(nueva);
    }
   
    public boolean addEmpleado(Empleado empleado){
        
        if(empleado.addTrabajo(this)){
            empleados.add(empleado);
            return true;
        }else{
            return false;
        }
    }
    
    public int getEmpleados(){
        return empleados.size();
    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
    public void addHabitacion(int numero,int cantidad){
       Habitacion nueva = new Habitacion(numero,cantidad);
       habitaciones.add(nueva);
    }
    
    public int buscarHabitacionCapacidad(int capacidad){
        int num = -1;
        
        for(int i= 0; i< habitaciones.size(); i++){
            if(habitaciones.get(i).getCapacidad() >= capacidad){
                num = habitaciones.get(i).getNumero();
            }
        }
        return num;
    }
    
   
}
