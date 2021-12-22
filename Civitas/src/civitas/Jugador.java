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
public class Jugador implements Comparable<Jugador>{
    
    protected static int CasasMax = 4;
    protected static int HotelesMax = 4;
    protected static int CasasPorHotel = 4;
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    protected static float PasoPorSalida = 1000;
    private static float SaldoInicial = 7500;
    private ArrayList<CasillaCalle> propiedades = new ArrayList<>();
    
    
    Jugador (String nombre){
        this.nombre = nombre;
        casillaActual = 0;
        puedeComprar = false;
        saldo = SaldoInicial;
    }
    
    Jugador (Jugador otro){
        this.nombre = otro.nombre;
        this.casillaActual = otro.casillaActual;
        this.puedeComprar = otro.puedeComprar;
        this.saldo = otro.saldo;
    }
    
    
    
    
    public JugadorEspeculador convertir(){
       JugadorEspeculador nuevoJugador = new JugadorEspeculador(this); 
       return nuevoJugador;
    }
    
    public boolean esEspeculador(){
        boolean resultado = false;
        
        if(this instanceof JugadorEspeculador){
            resultado = true;
        }
        
        return resultado;
    }
    
    
    int cantidadCasasHoteles(){
        int suma = 0;
        
        for (int i=0; i < propiedades.size(); i++){
            suma += propiedades.get(i).cantidadCasasHoteles();
        }
        
        return suma;
    }
    
    public int compareTo(Jugador otro){
        int orden = 0;
        
        if(this.getSaldo() > otro.getSaldo())
            orden = 1;
        else if(this.getSaldo() < otro.getSaldo())
            orden = -1;
        
        return orden;
        
        //1 si saldo es mayor que el saldo del otro
        //-1 si saldo es menor que el saldo del otro
        //0 si los saldos son iguales
    }

    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        
        if(puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador" + this.nombre +
                        " compra la propiedad " + titulo.getNombre());
                this.puedeComprar = false;
            }
            else{
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre +
                        " no tiene saldo para comprar la propiedad " + titulo.getNombre());
            }
        }
        
        return result;
    }
    
    boolean construirCasa(int ip){
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        
        if(existe){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            
            if(puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre +
                        " construye casa en la propiedad " + propiedad.getNombre());
            }
        }
        
        return result;
    }
    
    boolean construirHotel(int ip){
        boolean result = false;
        
        if(existeLaPropiedad(ip)){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
       
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " +
                        this.nombre + " construye hotel en la propiedad " + propiedad.getNombre());
            }
        }
        
        return result;
        
    }
    
    boolean enBancarrota(){
        boolean bancarrota = false;
        
        if(saldo <= 0)
            bancarrota = true;
        
        return bancarrota;
    }
    
    private boolean existeLaPropiedad(int ip){
        boolean existe = false;
        
        if(ip < propiedades.size())
            existe = true;
        
        return existe;
    }
    
    private int getCasasMax(){
        return CasasMax;
    }
    
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    public int getCasillaActual(){
        return casillaActual;
    }
    
    private int getHotelesMax(){
        return HotelesMax;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    private float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    public ArrayList<CasillaCalle> getPropiedades(){
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    public float getSaldo(){
        return saldo;
    }
    
    boolean modificarSaldo(float cantidad){
        saldo += cantidad;
        Diario.getInstance().ocurreEvento(("Saldo modificado con la cantidad: " + cantidad + 
                    ". Saldo restante: " + saldo));
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        casillaActual = numCasilla;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("El jugador " + nombre + " se ha movido a la casilla " + casillaActual);
        return true;
    }
    
    boolean paga(float cantidad){
        boolean pagar = modificarSaldo(cantidad * (-1));
        return pagar;
        
    }
    
    boolean pagaAlquiler(float cantidad){
        boolean pagar = paga(cantidad);
        return pagar;
        
    }
    
    boolean pasaPorSalida(){
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento("El jugador " + nombre + " ha recibido "
                + "el premio por pasar por salida");
        
        return true;
    }
    
    boolean puedeComprarCasilla(){
        puedeComprar = true;
        return puedeComprar;
    }
    
    private boolean puedoEdificarCasa(CasillaCalle propiedad){
        boolean puedo = false;
        
        float precioEdificar = propiedad.getPrecioEdificar();
        
        if(puedoGastar(precioEdificar)){
            if(propiedad.getNumCasas() < CasasMax){
                puedo = true;
            }
        }
        
        return puedo;
    }
    
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        boolean puedo = false;
        
        float precio = propiedad.getPrecioEdificar();
        
        if(puedoGastar(precio)){
            if(propiedad.getNumHoteles() < HotelesMax){
                if(propiedad.getNumCasas() >= CasasPorHotel){
                    puedo = true;
                }
            }
        }
        
        return puedo;
    }
    
    private boolean puedoGastar(float precio){
        boolean puedo = false;
        
        if(saldo >= precio)
            puedo = true;
        
        return puedo;
    }
    
    boolean recibe(float cantidad){
        boolean recibe = modificarSaldo(cantidad);
        return recibe;    
    }
    
    boolean tieneAlgoQueGestionar(){
        boolean tiene = false;
        
        if(propiedades.size() != 0)
            tiene = true;
        
        return tiene;
    }
    
    public String toString(){
        String cadena = "";
        cadena = "Jugador: " + nombre + ". Saldo: " + saldo + ". Casilla Actual: " + casillaActual;
        
        if(propiedades.size() > 0){
            for (int i=0; i<propiedades.size(); i++){
                cadena += " Propiedad " + i + " " + propiedades.get(i).getNombre();
            }
        }
        
        return cadena; 
    }
}
