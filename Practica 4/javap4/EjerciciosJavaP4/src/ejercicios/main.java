/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class main {
    
    public static void main(String [] args){
        
        Casilla c1 = new Casilla("Casilla 1");
        CasillaCalle calle1 = new CasillaCalle("Calle1", 2);
        
        c1.recibeJugador();
        calle1.recibeJugador();
        
        //1-CasillaCalle utiliza el método de la clase padre porque es
        //el unico metodo recibeJugador que tiene. Utilizaria el suyo si lo 
        //redefiniese
        
        //2-Al redefinir recibeJugador en CasillaCalle, toda instancia
        //usará ese metodo al llamar a recibeJugador de su clase
        
        //3-Ha ejecutado el de su clase, pero en el metodo de su clase al llamar 
        //a super, ha ejecutado tambien el metodo de la clase padre, pero desde 
        //su clase
        
        //4
        //c1.construirCasa();
        calle1.construirCasa();
        
        ArrayList<Casilla> tablero = new ArrayList<>();
        tablero.add(c1);
        tablero.add(calle1);
        
        
        
        //tablero.get(0).construirCasa();
        //tablero.get(1).construirCasa();
        
        //No encuentra el método construirCasa, dado que al definir el array
        //hemos dicho que son de tipo casilla
        
        //Lo arreglamos haciendo un casting
        
        
        //No se puede construir una casa en una casilla normal.
        //Para resolver el de casillaCalle, hacemos un casting
        ((CasillaCalle) tablero.get(1)).construirCasa();
    
        
        CasillaCalle casilla1 = new CasillaCalle("Casilla1", 0);
        Casilla casilla2 = casilla1;
        casilla1.recibeJugador();
        casilla2.recibeJugador();
        
        //Han llamado al metodo de la clase hija. Casilla2 lo hace porque
        //al asignar casilla2 = casilla1, su tipo dinamico es la clase casillaCalle
        
        casilla1.construirCasa();
        ((CasillaCalle)casilla2).construirCasa();
        
        //Tenemos 2 casas, dado que las dos casillas referencian al mismo objeto
        //por lo que cada una aumenta en 1 el numCasas;
    }
    
}
