package civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class CasillaSorpresa extends Casilla{

    private Sorpresa sorpresa;
    private MazoSorpresas mazo = new MazoSorpresas();

    private void init(){

         sorpresa = null; 

    }


    public CasillaSorpresa(String nombre, MazoSorpresas mazo){
        super(nombre);
        this.mazo = mazo;
        init();
        sorpresa = this.mazo.siguiente();
        
    }

    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos){

            super.recibeJugador(actual, todos);

            recibeJugador_sorpresa(actual, todos);
    }

    private void recibeJugador_sorpresa(int actual, ArrayList<Jugador> todos){
        
        Sorpresa sor = mazo.siguiente();
        informe(actual, todos);
        sor.aplicarAJugador(actual, todos);
    }


    @Override
    public String toString(){
        String cadena = "";

        cadena ="Casilla de Sorpresa";

        return cadena;
    }

}
