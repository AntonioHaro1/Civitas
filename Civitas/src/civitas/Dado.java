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
    static private int VALORDEBUG = 1;
    static private int VALORESDADO = 6;
    
    static final private Dado instance = new Dado();
    
    private Dado(){
        ultimoResultado = 0;
        debug = false;
    }
    
    public static Dado getInstance(){
        return instance;
    }
    
    int tirar(){
        int tirada;
        int min = 1;
           
        if(!debug){
            tirada = random.nextInt(VALORESDADO) + min;
        }
        else
            tirada = 1;
        
        ultimoResultado = tirada;
        return tirada;
    }
    
    public int quienEmpieza(int n){
        return (random.nextInt(n));
    }
    
    public void setDebug(boolean d){
        debug = d;
        Diario.getInstance().ocurreEvento("Cambiado modo debug dado a: " + debug);
    }
    
    public boolean getDebug(){
        return debug;
    }
    
    public int getUltimoResultado(){
        return ultimoResultado;
    }
    
}
