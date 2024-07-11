/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosP2;

/**
 *
 * @author antonio
 */
public class EjerciciosJavaP2 {
    public static void main(String[] args){
        //PRUEBAS SESION 2//
         
        Hotel h1 = new Hotel("Alhambra", "Granada", 3);
        Hotel h2 = new Hotel("Gran Vía", "Granada", 4);
        
        System.out.println("Numero total de hoteles: " + Hotel.getNumHoteles());
        
        Director d1 = new Director("Pablo", 695983768);
        Director d2 = new Director("Alex", 76123123);
        
        h1.setDirector(d1);
        h2.setDirector(d2);
        
        System.out.println("Director del primer hotel: " + h1.getDirector().getNombre());
        System.out.println("Director del segundo hotel: " + h2.getDirector().getNombre());

        Cliente c1 = new Cliente("234324A", "María");
        Reserva r1 = new Reserva("25/02/2021", "05/03/2021", c1, h2);
        c1.addReserva(r1);
        h2.addReserva(c1, "25/02/2021", "05/03/2021");
        
        for(int i=0; i<h2.getReservas().size(); i++){
            System.out.println("Reserva en hotel. Cliente: " + h2.getReservas().get(i).getCliente().getNombre() + ". Fecha entrada: " + h2.getReservas().get(i).getFechaEntrada());
        }
        
        for(int i=0; i<c1.getReservas().size(); i++){
            System.out.println("Reserva de cliente " + c1.getNombre() + " " + c1.getReservas().get(i).getFechaEntrada());
        }
        
        //PRUEBAS P2 S2//
        
        Empleado e1 = new Empleado("Antonio");
        e1.addTrabajo(h1);
        h1.addEmpleado(e1);
        
        System.out.println("Número de empleados del primer hotel: " + h1.getEmpleados().size());
        
        
        h1.addHabitacion(1, 3);
        h1.addHabitacion(2, 6);
        
        int num_huespedes = 4;
        int numero_habitacion = h1.buscarHabitacionCapacidad(num_huespedes);
        
        System.out.println("Número de habitación disponible para " + num_huespedes + " huespedes: Habitación:" + numero_habitacion);
        
    }
}
