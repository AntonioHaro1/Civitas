/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author antonio
 */
public class Casilla {
    
    private TipoCasilla tipo;
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    private Sorpresa sorpresa;
    private static float FACTORALQUILERCALLE = 1.0f;
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 4.0f;
    
    Casilla (TipoCasilla unTipo, String unNombre, float unPrecioCompra,
            float unPrecioEdificar, float unPrecioAlquilerBase){
        tipo = unTipo;
        nombre = unNombre;
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
        numCasas = 0;
        numHoteles = 0;
    }
    
    //Constructor para casilla de salida
    Casilla (String unNombre){
        tipo = TipoCasilla.DESCANSO;
        nombre = unNombre;
        precioCompra = 0;
        precioEdificar = 0;
        precioBaseAlquiler = 0;
        numCasas = 0;
        numHoteles = 0;
    }
    
    String getNombre() {
        return nombre;
    }

    float getPrecioCompra() {
        return precioCompra;
    }

    float getPrecioEdificar() {
        return precioEdificar;
    }

    int getNumCasas() {
        return numCasas;
    }

    int getNumHoteles() {
        return numHoteles;
    }
    
    float getPrecioAlquilerCompleto(){    
        return (precioBaseAlquiler * FACTORALQUILERCALLE) * (FACTORALQUILERCASA + numCasas + numHoteles * FACTORALQUILERHOTEL);
    }
    
    public String toString(){
        String cadena = "";
        
        
        if(tipo == TipoCasilla.CALLE)
             cadena = "Calle " + nombre + ". Precios: Compra: " + precioCompra + 
                ", Edificar: " + precioEdificar + ", Alquiler base: " + 
                precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + 
                numHoteles;
        else if(tipo == TipoCasilla.DESCANSO)
            cadena = "Casilla de salida";
        else if(tipo == TipoCasilla.SORPRESA)
            cadena = "Casilla sorpresa";
        
       
        return cadena;
    }
}
