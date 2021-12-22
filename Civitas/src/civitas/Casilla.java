package civitas;

import java.util.ArrayList;
/**
 *
 * @author antonio
 */
public class Casilla {

    private TipoCasilla tipo;
    private String nombre;
    private MazoSorpresas mazo;


    private void init(){
        nombre = "";
        tipo = null;
    }

    //Constructor Casillas DESCANSO
    Casilla (String nombre){
        this.init();
        this.nombre = nombre;
        this.tipo = TipoCasilla.DESCANSO;
    }

    //Constructor Casilla CALLE
    /*Casilla (String titulo, float precioCompra, float precioEdificar,
                float precioBaseAlquiler){
        this.init();
        this.tipo = TipoCasilla.CALLE;
        this.nombre = titulo;
    }
    */
    /*
    //Constructor Casilla SORPRESA
    Casilla (String nombre, MazoSorpresas mazo){
        this.init();
        this.tipo = TipoCasilla.SORPRESA;
        this.nombre = nombre;
        this.mazo = mazo;
    }
*/

    public String getNombre() {
        return nombre;
    }

    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(actual) +
                " ha caido en la casilla " + this.toString());
    }

    void recibeJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);

    }

    public String toString(){
        String cadena = "";
      
        cadena = "Calle " + this.getNombre() + " ";
       
        return cadena;
    }

}
    