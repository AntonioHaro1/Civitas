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
public class CivitasJuego {
    
    private int indiceJugadorActual;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private MazoSorpresas mazo;
    private EstadoJuego estado;
    private GestorEstados gestor;
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        
        jugadores = new ArrayList<>();
        
        for(int i=0; i<nombres.size(); i++){
            Jugador jugador = new Jugador(nombres.get(i));
            jugadores.add(jugador);
        }
        
        gestor = new GestorEstados();
        estado = gestor.estadoInicial();
        
        Dado.getInstance().setDebug(debug);
        
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        
        mazo = new MazoSorpresas(false);
        inicializaMazoSorpresas();
        
        tablero = new Tablero();
        inicializaTablero(mazo);
    }
    
    private void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida(jugadorActual);
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
    }
    
    public boolean comprar(){
        boolean res;
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        res = jugadorActual.comprar((CasillaCalle) casilla);
        
        return res;
    }
    
    public boolean construirCasa(int ip){
        return getJugadorActual().construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return getJugadorActual().construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        while(tablero.computarPasoPorSalida()){
            jugadorActual.pasaPorSalida();
        }
    }
    
    public boolean finalDelJuego(){
        boolean bancarrota = false;
        
        for(int i=0; i<jugadores.size(); i++){
            if(jugadores.get(i).enBancarrota()){
                bancarrota = true;
            }
        }
        
        return bancarrota;
    }
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    private void inicializaMazoSorpresas(){
        
        
        //mazo.alMazo(new PagarCobrar("Tu coche se estropea. Pagas 100", -100));
   
        //mazo.alMazo(new PagarCobrar("Tropiezas y te caes en un agujero de obra. Pagas 50", -50));
     
        //mazo.alMazo(new PagarCobrar("es un billete de 100 por la calle y lo coges. Recibes 100", 100));
        
        //mazo.alMazo(new PagarCobrar("Ayudas a una anciana a cruzar la calle y te da 20$. Recibes 20", 20));
        
        //mazo.alMazo(new PagarCobrar("Un indigente te pide un poco de dinero. Pagas 25", -25));
        
        mazo.alMazo(new SorpresaConvertirme("Te conviertes en especulador"));
        
        //mazo.alMazo(new PorCasaHotel("Haces un truco de magia para todo el barrio. Recibes 25 por cada casa y hotel", 25));
        
        //mazo.alMazo(new PorCasaHotel("Ayudas a apagar un incendio en una casa. Los vecinos te lo agradecen. Recibes 50 por cada casa y hotel", 15));
        
        //mazo.alMazo(new PorCasaHotel("Causas un accidente en la calle. Tienes que indemnizar a los afectados. Pagas 25 por cada casa  y hotel", -25));
        
        //mazo.alMazo(new PorCasaHotel("Hay una sequía y la gente no tiene agua. Compras agua para todas ellas. Pagas 50 por cada casa y hotel", -50));
        
    }
    
    private void inicializaTablero(MazoSorpresas mazo){
        CasillaCalle c1 = new CasillaCalle("Gran Vía", 140f, 200f, 250f);
        tablero.añadeCasilla(c1);
        
        CasillaCalle c2 = new CasillaCalle("Paseo de los Tristes", 170f, 210f, 265f);
        tablero.añadeCasilla(c2);
        
        CasillaSorpresa s1 = new CasillaSorpresa("SorpresaQuitaDinero",mazo);
        tablero.añadeCasilla(s1);
        
        CasillaCalle c3 = new CasillaCalle("Alcalá", 200f, 250f, 280f);
        tablero.añadeCasilla(c3);
        
        CasillaCalle c4 = new CasillaCalle("Paseo de Gracia", 120f, 135f, 150f);
        tablero.añadeCasilla(c4);
        
        CasillaSorpresa s2 = new CasillaSorpresa("SorpresaRecibeDinero", mazo);
        tablero.añadeCasilla(s2);
        
        CasillaCalle c5 = new CasillaCalle("Avenida de la Constitución", 145, 180f, 200f);
        tablero.añadeCasilla(c5);
        
        CasillaCalle c6 = new CasillaCalle("Campo del Sur", 230, 255f, 290f);
        tablero.añadeCasilla(c6);
        
        CasillaSorpresa s3 = new CasillaSorpresa("SorpresaTurnoIdle", mazo);
        tablero.añadeCasilla(s3);
        
        CasillaCalle c7 = new CasillaCalle("Las Ramblas", 220f, 245f, 265f);
        tablero.añadeCasilla(c7);
        
        CasillaCalle c8 = new CasillaCalle("Avenida del Mar", 250f, 260f, 300f);
        tablero.añadeCasilla(c8);
        
        Casilla parking = new Casilla("Parking");
        tablero.añadeCasilla(parking);
        
        CasillaSorpresa s4 = new CasillaSorpresa("SorpresaAvanza10", mazo);
        tablero.añadeCasilla(s4);
        
        CasillaCalle c9 = new CasillaCalle("Barrio de Triana", 180f, 195f, 220f);
        tablero.añadeCasilla(c9);
        
        CasillaCalle c10 = new CasillaCalle("Paseo Marítimo", 160f, 175f, 200f);
        tablero.añadeCasilla(c10);
        
        CasillaCalle c11 = new CasillaCalle("Paseo Nuevo", 155f, 210f, 265f);
        tablero.añadeCasilla(c11);
        
        CasillaCalle c12 = new CasillaCalle("Avenida Esperanza", 135f, 170f, 185f);
        tablero.añadeCasilla(c12); 
        
        CasillaCalle c13 = new CasillaCalle("Federico García Lorca", 135f, 170f, 185f);
        tablero.añadeCasilla(c13);
        
        CasillaCalle c14 = new CasillaCalle("Colón", 195f, 75f, 185f);
        tablero.añadeCasilla(c14);
        
    }
    
    private void pasarTurno(){
        indiceJugadorActual = (indiceJugadorActual  +1) % jugadores.size();
    }
    
    public  ArrayList<Jugador> ranking(){
        /*int comparacion;
        
        ArrayList<Jugador> ranking = new ArrayList<>(jugadores);
        
        for(int i=0; i<jugadores.size(); i++){
            comparacion = jugadores.get(i).compareTo(jugadores.get(i+1));
            if (comparacion < 0){
                Collections.swap(ranking, i, i+1);
                Collections.swap(jugadores, i, i+1);
            }
        }
        
        return ranking;*/
        
        Collections.sort(jugadores);
        return jugadores;
    }
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
        if(operacion == OperacionJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        }
        else if(operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estado = gestor.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }
}
