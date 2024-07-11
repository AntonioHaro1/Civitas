/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author antonio
 */
public class CasillaCalle extends Casilla{
    
    private int numCasas;
    
    CasillaCalle(String nombre, int numCasas){
        super(nombre);
        this.numCasas = numCasas;
    }
    
    //reutilizando código del padre
    @Override
    boolean recibeJugador(){
        boolean resultado = super.recibeJugador();
        if(resultado){
            System.out.println(" y además soy una casilla calle");
            return true;
        }
        else{
            return false;
        } 
    }
    
    void construirCasa(){
        this.numCasas++;
        System.out.println("Número de casas: " + numCasas);
    }
    
    
}
