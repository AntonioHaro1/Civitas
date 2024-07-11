/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;
/**
 *
 * @author antonio
 */
public class Jugador implements Comparable<Jugador>{
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    private static int CasasMax = 4;
    private static int CasasPorHotel = 4;
    private static int HotelesMax = 4;
    private static float PasoPorSalida = 1000;
    private static float SaldoInicial = 7500;
    private ArrayList<Casilla> propiedades;
    
    Jugador(String nombreJ){
        nombre = nombreJ;
        saldo = SaldoInicial;
        casillaActual= 0;
    }
    
    Jugador(Jugador otro){
        nombre = otro.nombre;
        saldo = otro.saldo;
        casillaActual = otro.casillaActual;
    }
    
    boolean existeLaPropiedad(int ip){
        return ip < propiedades.size();
    }
    
    boolean puedeComprarCasilla(){
        puedeComprar = true;
        return puedeComprar;
    }
    
    boolean paga(float cantidad){
        return modificaSaldo((cantidad)*(-1));
    }
    
    boolean pagaAlquiler(float cantidad){
        return paga(cantidad);
    }
    
    boolean recibe(float cantidad){
        return modificaSaldo(cantidad);
    }
    
    boolean modificaSaldo(float cantidad){
        saldo += cantidad;
        Diario.getInstance().ocurreEvento("el jugador" + nombre + "ha modificado el saldo a" + saldo);
        return true;
    }
    
    boolean moverACasilla(int c){
        casillaActual = c;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("El jugador" + nombre + "se mueve de casilla a la" + c);
        return true;
    }
    
    boolean puedoGastar(float precio){
        return saldo >= precio;
    }
    
    boolean tieneAlgoQueGestionar(){
        return propiedades.size() >0;
    }
    
    boolean pasaPorSalida(){
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento("El jugador " + nombre + "pasa por salida y recibe 1000");
        return true;
    }
    
    //NOSE HACERLO
    @Override
    public int compareTo(Jugador otro){
        int resultado = Float.compare(otro.saldo, saldo);
        return resultado;
    }
    
    int cantidadCasasHoteles(){
        int casas = 0;
        int hoteles = 0;
        
        for(int i=0; i <= propiedades.size(); i++){
            casas =+ propiedades.get(i).getNumCasas();
            hoteles =+ propiedades.get(i).getNumHoteles();
        }        
        return casas+hoteles;
    }
    
    boolean comprar(Casilla titulo){
        if(puedeComprarCasilla() && puedoGastar(titulo.getPrecioCompra())){
            propiedades.add(titulo);
            paga(titulo.getPrecioCompra());
            return true;
        }
        return false;
    }
    
    boolean construirHotel(int ip){
        boolean result = false;
        Casilla propiedad;
        float precio;
        
        boolean puedoEdificarHotel;
        if(existeLaPropiedad(ip)){
            propiedad = propiedades.get(ip);
            puedoEdificarHotel = puedeEdificarHotel(propiedad);
            precio = propiedad.getPrecioCompra();
            if(puedoGastar(precio)){
                if(propiedad.getNumHoteles() < getHotelesMax()){
                    if(propiedad.getNumCasas() >= getCasasMax()){
                        puedoEdificarHotel = true;
                    }
                }
            }
            if(puedoEdificarHotel){
                result = propiedad.construitHotel(this);
                paga(precio);
                propiedad.numHoteles++;
                result = true;
                propiedad.derruirCasa(CasasPorHotel,this);
            }
            
        }
    
    }
   
    /*boolean construirCasa(int ip){
        if(puedeGastar(propiedades.get(ip).getPrecioEdificar())){
            propiedades.get(ip).construirCasa(this);
        
    */
    
    boolean enBancarrota(){
        return saldo <= 0;
    }
    
    int getCasasMax(){
        return CasasMax;
    }
    
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    int getCasillaActual(){
        return casillaActual;
    }
    
    int getHotelesMax(){
        return HotelesMax;
    }
    
    String getNombre(){
        return nombre;
    }
    
    float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    ArrayList<Casilla> getPropiedades(){
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    float getSaldo(){
        return saldo;
    }
    
    boolean puedeEdificarCasa(Casilla propiedad){
        if(propiedad.getNumCasas() < CasasMax && puedeComprar) {
            if (puedoGastar(propiedad.getPrecioEdificar())) {
                return true;
            }
        }
        return false;
    }
    
    boolean puedeEdificarHotel(Casilla propiedad){
        if(propiedad.getNumHoteles() < HotelesMax && puedeComprar){
            if(puedoGastar(propiedad.getPrecioEdificar())){
                return true;
            }
        }
        return false;
    }
    //que pone en jugador de string
    @Override
    public String toString(){
        String cadena = "";
        cadena = "Jugador: " + nombre + ". Saldo: " + saldo + ". Casilla Actual: " + casillaActual;

        for (int i=0; i<propiedades.size(); i++){
            cadena += "Propiedad " + i + propiedades.get(i).getNombre();
        }

        return cadena;
    }
    
    }
