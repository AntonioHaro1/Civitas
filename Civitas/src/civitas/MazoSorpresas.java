/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author antonio
 */
public class MazoSorpresas {
    
    private ArrayList<Sorpresa> sorpresas;
    private int usadas;
    private boolean barajada;
    private boolean debug;
    
    private void init(){
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0;
    }
    
    MazoSorpresas(boolean d){
        init();
        debug = d;
        
        if(debug){
            Diario.getInstance().ocurreEvento("El modo debug del dado está activado");
        }
    }
    
    MazoSorpresas(){
        init();
        debug = false;
    }
    
    void alMazo(Sorpresa s){
        if(!barajada){
            sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente(){
        
        
        if((!barajada || usadas == sorpresas.size()) && !debug){
            Collections.shuffle(sorpresas);
            barajada = true;
            usadas = 0;
        }    
        
        Sorpresa carta = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(carta);
        usadas++;
        return carta;
    }
    
    
}
