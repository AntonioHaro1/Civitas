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
public class JugadorEspeculador extends Jugador{
    
    private static int FactorEspeculador = 2;
    protected static int CasasMax = 4 * FactorEspeculador;
    protected static int HotelesMax = 4 * FactorEspeculador; 
    
    JugadorEspeculador(Jugador jugador){
        super(jugador);
        actualizaPropietarioPorConversion(jugador);
    }
    
    
    void actualizaPropietarioPorConversion(Jugador jugador){
        
        int tam = jugador.getPropiedades().size();
        
        if(tam > 0){
            for(int i=0; i < tam; i++){
                jugador.getPropiedades().get(i).actualizaPropiedadesPorConversion(this);
            }
        }
    }
    
    @Override
    public String toString(){
        String cadena = "";
        cadena = "Jugador: " + this.getNombre()+ ", es un jugador especulador" + ". Saldo: " + this.getSaldo() + ". Casilla Actual: " + this.getCasillaActual();
        
        if(this.getPropiedades().size() > 0){
            for (int i=0; i<this.getPropiedades().size(); i++){
                cadena += " Propiedad " + i + " " + this.getPropiedades().get(i).getNombre();
            }
        }
        
        return cadena; 
    }
    
    
}
