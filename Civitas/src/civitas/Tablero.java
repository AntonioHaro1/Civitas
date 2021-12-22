/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Tablero {
    
    private ArrayList<Casilla> tablero;
    private boolean porSalida;
    
    Tablero(){
        tablero = new ArrayList<>();
        añadeCasilla(new Casilla("Salida"));
        porSalida = false;
    }
    
    private boolean correcto(int numCasilla){
        boolean resultado = false;
        
        if(numCasilla >=0 && numCasilla <= tablero.size())
            resultado = true;
        return resultado;
    }
    
    int getSize(){
        return tablero.size();
    }
    
    boolean computarPasoPorSalida(){
        boolean resultado;
        resultado = porSalida;
        porSalida = false;
        return resultado;
    }
    
    void añadeCasilla(Casilla casilla){
        if(tablero.size() < 20)
            tablero.add(casilla);
        else 
            System.out.println("Número máximo de casillas alcanzado");
    }
    
    
    
    public Casilla getCasilla(int numCasilla){
        if(correcto(numCasilla)){
            return tablero.get(numCasilla);
        }
        return null;
    }
    
    ArrayList<Casilla> getCasillas(){
        return tablero;
    }
    
    int nuevaPosicion(int actual, int tirada){
        int nueva;
        
        nueva = (actual + tirada) % tablero.size();
        
        if(nueva != actual + tirada)
            porSalida = true;
        
        return nueva;
        
    }
    
}
