/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import static civitas.TipoSorpresa.PAGARCOBRAR;
import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class Sorpresa {
    private String texto;
    private int valor;
    private TipoSorpresa tipo;
    private MazoSorpresas mazo;
    
    Sorpresa(TipoSorpresa tipo, String texto, int valor){
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    
    void informe(int actual,ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador" + todos.get(actual).getNombre() + "ha obtenido un sorpresa");
    }
// como se haria eso
    void aplicarAJugador(int actual,ArrayList<Jugador> todos){
        if(tipo == PAGARCOBRAR){
            aplicarAJugador_pagarCobrar(actual,todos);
        }else{
            aplicarAJugador_porCasaHotel(actual,todos);
        }
    }
        
    void aplicarAJugador_pagarCobrar(int actual,ArrayList<Jugador> todos){
        informe(actual,todos);
        todos.get(actual).modificaSaldo(valor);
    }
    
    void aplicarAJugador_porCasaHotel(int actual,ArrayList<Jugador> todos){
        informe(actual,todos);
        todos.get(actual).modificaSaldo(valor);
    }
}
