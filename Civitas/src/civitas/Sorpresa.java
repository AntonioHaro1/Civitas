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
abstract class Sorpresa {
    
    private String texto;
    
    
    Sorpresa(String texto){
        this.texto = texto;
        
    }
    
    
       
    
    
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);
       
    
    
    /*private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
         informe(actual,todos);
         todos.get(actual).modificarSaldo(this.valor);
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
         informe(actual,todos);
         todos.get(actual).modificarSaldo(this.valor*todos.get(actual).cantidadCasasHoteles());
         
    }
    */
    protected void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Se está aplicando una "
                + "sorpresa al jugador " + todos.get(actual).getNombre());
    }
    
    public String toString(){
        return texto;
    }
    
}
