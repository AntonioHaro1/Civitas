/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.Random;

/**
 *
 * @author antonio
 */
public class Dado {
    
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    
    static final private Dado instance = new Dado();
    
    private Dado(){
        ultimoResultado = 0;
        debug = false;
    }
    
    static Dado getInstance(){
        return instance;
    }
    
    int tirar(){
        int tirada;
        int min = 1;
        int max = 6;
        
        if(!debug){
            tirada = random.nextInt(max) + min;
        }
        else
            tirada = 1;
        
        ultimoResultado = tirada;
        return tirada;
    }
    
    int quienEmpieza(int n){
        return (random.nextInt(n));
    }
    
    void setDebug(boolean d){
        debug = d;
        Diario.getInstance().ocurreEvento("Cambiado modo debug dado a: " + debug);
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
    
}
