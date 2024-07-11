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
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    
    Tablero(){
        casillas = new ArrayList<>();
        añadeCasilla(new Casilla("Salida"));
        porSalida = false;
    }
    
    private boolean correcto(int numCasilla){
        boolean resultado = false;
        
        if(numCasilla >=0 && numCasilla <= casillas.size())
            resultado = true;
        return resultado;
    }
    
    int getSize(){
        return casillas.size();
    }
    
    boolean computarPorSalida(){
        boolean resultado;
        resultado = porSalida;
        porSalida = false;
        return resultado;
    }
    
    void añadeCasilla(Casilla casilla){
        if(casillas.size() < 20)
            casillas.add(casilla);
        else 
            System.out.println("Número máximo de casillas alcanzado");
    }
    
    Casilla getCasilla(int numCasilla){
        if(correcto(numCasilla)){
            return casillas.get(numCasilla);
        }
        return null;
    }
    
    int nuevaPosicion(int actual, int tirada){
        int nueva;
        
        nueva = (actual + tirada) % casillas.size();
        
        if(nueva != actual + tirada)
            porSalida = true;
        
        return nueva;
        
    }
    
    ArrayList<Casilla> getCasillas(){
        return casillas;
    }
    
}
