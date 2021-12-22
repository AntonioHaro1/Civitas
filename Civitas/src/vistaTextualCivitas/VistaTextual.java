package vistaTextualCivitas;

import GUI.Vista;
import civitas.Casilla;
import civitas.CasillaCalle;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }
  
  
  @Override
  public void actualiza(){
      Jugador jugadorActual = juegoModel.getJugadorActual();
      System.out.println(jugadorActual.toString());
      int numCasilla = jugadorActual.getCasillaActual();
      Casilla casillaActual = juegoModel.getTablero().getCasilla(numCasilla);
      System.out.println(casillaActual.toString());
      
      if(juegoModel.finalDelJuego()){
          
          for(int i=0; i<juegoModel.getJugadores().size(); i++){
              System.out.println(juegoModel.getJugadores().get(i).getNombre());
          }
    } 
  }
  
  
  @Override
  public Respuesta comprar(){
      
      String titulo = "¿Quiere comprar la calle?";
      ArrayList<String> lista = new ArrayList<>();
      lista.add("Si");
      lista.add("No");
      
      int opcion = menu(titulo, lista);
      
      Respuesta respuesta = Respuesta.values()[opcion];
      
      return respuesta;
  }
  
  @Override
  public OperacionInmobiliaria elegirOperacion(){
      
      String titulo = "Elegir operación Inmobiliaria";
      ArrayList<String> lista = new ArrayList<>();
      lista.add("CONSTRUIR_CASA");
      lista.add("CONSTRUIR_HOTEL");
      lista.add("TERMINAR");
      
      int opcion = menu(titulo, lista);
      
      OperacionInmobiliaria operacion = OperacionInmobiliaria.values()[opcion];
      
      return operacion;
  }
  
  @Override
  public int elegirPropiedad(){
      Jugador jugadorActual = juegoModel.getJugadorActual();
      ArrayList<CasillaCalle> propiedades = jugadorActual.getPropiedades();
      
      String titulo = "Elije la propiedad sobre la que desea realizar la gestión";
      ArrayList<String> lista = new ArrayList<>();
      
      for(int i=0; i < propiedades.size(); i++){
          lista.add(propiedades.get(i).getNombre());
      }
      
      int indice = menu(titulo, lista);
      
      if(indice > propiedades.size()){
          indice = -1;
      }
      
      return indice;
  }
  
  @Override
  public void mostrarSiguienteOperacion(OperacionJuego operacion){
      System.out.println("Se va a realizar la operación: " + operacion.toString());
  }
  
  
  @Override
  public void mostrarEventos(){
      if(Diario.getInstance().eventosPendientes()){
          
          for(int i=0; i < Diario.getInstance().getEventos().size(); i++){
              System.out.println(Diario.getInstance().leerEvento());
          }
      }
  }
 
 
}
