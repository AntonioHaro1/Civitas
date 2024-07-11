/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2s1;

/**
 *
 * @author antonio
 */

class Reserva {

    private String fechaEntrada;
    private String fechaSalida;
    private Cliente cliente;
    private Hotel hotel;
    
    public Reserva(String fechaEntrada, String fechaSalida, Cliente cliente, Hotel hotel){
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.hotel = hotel;
    }
    
    public String getFechaEntrada(){
        return fechaEntrada;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
}
