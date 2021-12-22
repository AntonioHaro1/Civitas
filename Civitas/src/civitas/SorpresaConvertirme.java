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
public class SorpresaConvertirme extends Sorpresa {
    
    SorpresaConvertirme(String texto){
        super(texto);
    }
     
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        Jugador jugador = todos.get(actual);
        JugadorEspeculador especulador = jugador.convertir();
        
        int indice = todos.indexOf(jugador);
        todos.remove(jugador);
        todos.add(indice, especulador);
    }
    
}
