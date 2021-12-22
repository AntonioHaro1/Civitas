
import GUI.CapturaNombres;
import GUI.CivitasView;
import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antonio
 */
public class TestP5 {
    public static void main(String[] args){
         CivitasView vista = new CivitasView();
         CapturaNombres nombres = new CapturaNombres(vista, true);
         ArrayList<String> jugadores = new ArrayList<>();
         
         jugadores = nombres.getNombres();
        
         CivitasJuego juego = new CivitasJuego(jugadores, true);
         Controlador controlador = new Controlador(juego, vista);
         vista.setCivitasJuego(juego);
         controlador.juega();
    }    
}
