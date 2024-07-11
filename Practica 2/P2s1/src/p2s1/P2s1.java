/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p2s1;

/**
 *
 * @author antonio
 */
public class P2s1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           //PRUEBAS SESION 2//
         //CREAMOS LOS HOTELES Y PROBAMOS EL NUM_HOTELES//
        Hotel h1 = new Hotel("El Chiringito", "Granada", 3);
        Hotel h2 = new Hotel("Gran VIDA", "Granada", 4);
        
        System.out.println("Numero total de hoteles: " + Hotel.getNumHoteles());
        
        Director d1 = new Director("Don Alejandro", 693456789);
        
        h1.setDirector(d1);
        
        System.out.println("Director del primer hotel: " + h1.getDirector().getNombre());

        Cliente c1 = new Cliente("99376543G", "Lucia de los dolores");
        Reserva r1 = new Reserva("20/05/2021", "25/05/2021", c1, h2);
        h2.addReserva(c1, "25/02/2021", "05/03/2021");
        
        for(int i=0; i<h2.getReservas().size(); i++){
            System.out.println("Reserva en hotel. Cliente: " + h2.getReservas().get(i).getCliente().getNombre() + ". Fecha entrada: " + h2.getReservas().get(i).getFechaEntrada());
        }
        
        for(int i=0; i<c1.getReservas().size(); i++){
            System.out.println("Reserva de cliente " + c1.getNombre() + " " + c1.getReservas().get(i).getFechaEntrada());
        }
        
        System.out.println("\nPRUEBAS SESION 2\n");

        Empleado e1 = new Empleado("Antonio");
        e1.addTrabajo(h1);
        h1.addEmpleado(e1);

        System.out.println("Número de empleados del primer hotel: " + h1.getEmpleados());
        System.out.println("Número de empleados del segundo hotel: " + h2.getEmpleados());

        h1.addHabitacion(1, 3);
        h1.addHabitacion(2, 6);

        int num_huespedes = 4;
        int numero_habitacion = h1.buscarHabitacionCapacidad(num_huespedes);

        System.out.println("Número de habitación disponible para " + num_huespedes + " huespedes: Habitación:" + numero_habitacion);
        
        
    }
}

