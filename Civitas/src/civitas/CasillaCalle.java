package civitas;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class CasillaCalle extends Casilla{
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    private static float FACTORALQUILERCALLE = 1.0f;
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 4.0f;
    public Jugador propietario;

    private void init(){

        precioCompra = 0;
        precioEdificar = 0;
        precioBaseAlquiler = 0;
        numCasas = 0;
        numHoteles = 0;
        propietario = null;
    }

    public CasillaCalle(String titulo, float precioCompra, float precioEdificar,float precioBaseAlquiler){
      super(titulo);
        this.init();
      this.precioCompra = precioCompra;
      this.precioEdificar = precioEdificar;
      this.precioBaseAlquiler = precioBaseAlquiler;
    }

    public void actualizaPropiedadesPorConversion(JugadorEspeculador jugador){
        
        this.propietario = jugador;
        
        
    }

    public int cantidadCasasHoteles(){
        return numCasas + numHoteles;
    }

    boolean comprar(Jugador jugador){
        boolean result = true;
        this.propietario = jugador;
        propietario.paga(precioCompra);
        return result;
    }

    boolean construirCasa(Jugador jugador){
        boolean result;
        jugador.paga(precioEdificar);
        numCasas++;
        result = true;
        return result;
    }

    boolean construirHotel(Jugador jugador){
        boolean result;
        jugador.paga(precioEdificar);
        numHoteles++;
        result = true;
        return result;

    }
    
    boolean derruirCasas(int numero, Jugador jugador){
        boolean realizada = false;

        if(esEsteElPropietario(jugador)){
            if(numCasas >= numero){
                numCasas -= numero;
                realizada = true;
            }
        }

        return realizada;
    }

    public boolean esEsteElPropietario(Jugador jugador){
        boolean resultado = false;

        if(jugador == propietario)
            resultado = true;

        return resultado;
    }

    public Jugador getPropietario(){
        return propietario;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    float getPrecioBaseAlquiler(){
        return precioBaseAlquiler;
    }

    public float getPrecioAlquilerCompleto(){
        return (precioBaseAlquiler * FACTORALQUILERCALLE) * (FACTORALQUILERCASA + numCasas + numHoteles * FACTORALQUILERHOTEL);
    }

    float getPrecioCompra() {
        return precioCompra;
    }

    float getPrecioEdificar() {
        return precioEdificar;
    }

    public boolean tienePropietario(){
        boolean resultado = false;

        if(propietario != null)
            resultado = true;

        return resultado;
    }

     void recibeJugador(int actual, ArrayList<Jugador> todos){

            super.recibeJugador(actual, todos);

            recibeJugador_calle(actual, todos);
    }

    private void recibeJugador_calle(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        Jugador jugador = todos.get(actual);

        if(!tienePropietario()){
            jugador.puedeComprarCasilla();
        }

        else
            tramitarAlquiler(jugador);
    }

public void tramitarAlquiler(Jugador jugador){
        if(tienePropietario()){
            if(!esEsteElPropietario(jugador)){
                jugador.pagaAlquiler(getPrecioAlquilerCompleto());
                propietario.recibe(getPrecioAlquilerCompleto());
            }
        }
    }
    public String toString(){
        String cadena = "";
        cadena += super.toString();
        
        if(this instanceof CasillaCalle){
        
            if(tienePropietario()){
                cadena += ". Propietario " + propietario.getNombre() +". Precios: Compra: " + precioCompra + 
                ", Edificar: " + precioEdificar + ", Alquiler base: " + 
                precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + 
                numHoteles;
            }else{
                cadena += ". Precios: Compra: " + precioCompra + 
                ", Edificar: " + precioEdificar + ", Alquiler base: " + 
                precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + 
                numHoteles;
            }
        }
        
        return cadena;

    }

}

