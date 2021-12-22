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
public class PagarCobrar extends Sorpresa{
    
    private int valor;
    
    PagarCobrar(String texto, int valor){
        super(texto);
        this.valor = valor;
    }
    
    
    public int getValor(){
       return valor;   
    }
    
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.informe(actual, todos);
        todos.get(actual).modificarSaldo(this.getValor());
    }
    
}
