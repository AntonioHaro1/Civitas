
package controladorCivitas;

import GUI.CivitasView;
import civitas.CivitasJuego;
import civitas.GestionInmobiliaria;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;

public class Controlador {
    
    private CivitasJuego juegoModel;
    private CivitasView vista;
    
    public Controlador(CivitasJuego juegoModel, CivitasView vista){
        this.juegoModel = juegoModel;
        this.vista = vista;
    }
    
    public void juega(){
        
        boolean terminado;
        Respuesta respuesta;
        OperacionInmobiliaria operacionInmobiliaria;
        int propiedad = -1;
        
        while(!juegoModel.finalDelJuego()){
            
            vista.actualiza();
            vista.pausa();
            OperacionJuego operacion = juegoModel.siguientePaso();
            vista.mostrarSiguienteOperacion(operacion);
            vista.mostrarEventos();
            
            if(operacion != OperacionJuego.PASAR_TURNO){
               
                vista.mostrarEventos();
                terminado = juegoModel.finalDelJuego();
                
               
                if(!terminado){
                    
                    if(operacion == OperacionJuego.COMPRAR){
                        respuesta = vista.comprar();
                        if(respuesta == Respuesta.SI){
                            juegoModel.comprar();
                            juegoModel.siguientePasoCompletado(operacion);
                        }
                        else
                            juegoModel.siguientePasoCompletado(operacion);
                    }
                    else if(operacion == OperacionJuego.GESTIONAR){
                        operacionInmobiliaria = vista.elegirOperacion();
                        
                        if(operacionInmobiliaria != OperacionInmobiliaria.TERMINAR){
                            propiedad = vista.elegirPropiedad();
                            
                        }
                        
                        GestionInmobiliaria gestion = new GestionInmobiliaria(operacionInmobiliaria, propiedad);
                            if(gestion.getOperacion() == OperacionInmobiliaria.TERMINAR){
                                juegoModel.siguientePasoCompletado(operacion);
                            }
                            else if(gestion.getOperacion() == OperacionInmobiliaria.CONSTRUIR_CASA){
                                juegoModel.construirCasa(propiedad);
                                juegoModel.siguientePasoCompletado(operacion);
                            }
                            else if(gestion.getOperacion() == OperacionInmobiliaria.CONSTRUIR_HOTEL){
                                juegoModel.construirHotel(propiedad);
                                juegoModel.siguientePasoCompletado(operacion);
                            }  
                            
                    } 
                }
                
                juegoModel.ranking();
                vista.actualiza();
                
            }
            
        }
    }
    
}
