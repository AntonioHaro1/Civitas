/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

/**
 *
 * @author antonio
 */
public class Parcela {

    private String nombre;
    private float precioCompra, precioEdificar, precioAlquilerBase;
    private int numCasas, numHoteles;
    private static float FACTORALQUILERCALLE = 1.0f;
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 4.0f;
    
    Parcela (String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioAlquilerBase = precioBaseAlquiler;
        this.numCasas = 0;
        this.numHoteles = 0;
    }

    String getNombre() {
        return nombre;
    }

    float getPrecioCompra() {
        return precioCompra;
    }

    float getPrecioEdificar() {
        return precioEdificar;
    }

    int getNumCasas() {
        return numCasas;
    }

    int getNumHoteles() {
        return numHoteles;
    }
    
    float getPrecioAlquilerCompleto(){    
        return (precioAlquilerBase * FACTORALQUILERCALLE) * (FACTORALQUILERCASA + numCasas + numHoteles * FACTORALQUILERHOTEL);
    }
    
    boolean construirCasa(){
        numCasas+=1;
        return true;
    }
    
    boolean construirHotel(){
        numHoteles+=1;
        return true;
    }
    
    boolean igualdadIdentidad(Parcela otraParcela){
        boolean resultado;
        
        if(this == otraParcela)
            resultado = true;
        else
            resultado = false;
        
        return resultado;
    }
    
    boolean igualdadEstado(Parcela otraParcela){
        boolean resultado;
        
        resultado = this.nombre.equals(otraParcela.nombre) && this.precioCompra == otraParcela.precioCompra
                && this.precioEdificar == otraParcela.precioEdificar && this.precioAlquilerBase == otraParcela.precioAlquilerBase
                && this.numCasas == otraParcela.numCasas && this.numHoteles == otraParcela.numHoteles;
        
        return resultado;
    }
    
   
}
