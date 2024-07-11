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
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    //*****************PRUEBA 1********************//    
    
        System.out.println("PRUEBA 1");
    
        int numJugadores = 4;
        int j1 = 0, j2 = 0, j3 = 0, j4 = 0;
        
        for(int i=0; i<100; i++){
            int num = Dado.getInstance().quienEmpieza(numJugadores);
            System.out.println(num);
            
            switch (num){
                case 0:
                    j1 ++;
                    break;
                    
                case 1:
                    j2 ++;
                    break;
                    
                case 2:
                    j3 ++;
                    break;
                    
                case 3:
                    j4 ++;
                    break;       
            }
        }
        
        System.out.println("El jugador 1 ha comenzado: " + j1 + " veces");
        System.out.println("El jugador 2 ha comenzado: " + j2 + " veces");
        System.out.println("El jugador 3 ha comenzado: " + j3 + " veces");
        System.out.println("El jugador 4 ha comenzado: " + j4 + " veces");
        
        //*****************PRUEBA 2********************//  
        
        System.out.println("PRUEBA 2");
        
        Dado.getInstance().setDebug(true);
        System.out.println("Tirada modo debug activado: " + Dado.getInstance().tirar());
        System.out.println("Tirada modo debug activado: " + Dado.getInstance().tirar());
        Dado.getInstance().setDebug(false);
        System.out.println("Tirada modo debug desactivado: " + Dado.getInstance().tirar());
        System.out.println("Tirada modo debug desactivado: " + Dado.getInstance().tirar());
        
        //*****************PRUEBA 3********************//  
        
        System.out.println("PRUEBA 3");
        
        System.out.println("El ultimo resultado del dado fue: " + Dado.getInstance().getUltimoResultado());
        
        //*****************PRUEBA 4********************//  
        
        System.out.println("PRUEBA 4");
        
        System.out.println("Tipo casilla: " + TipoCasilla.CALLE );
        System.out.println("Tipo casilla: " + TipoCasilla.DESCANSO );
        System.out.println("Tipo sorpresa: " + TipoSorpresa.PAGARCOBRAR);
        System.out.println("Tipo sorpresa: " + TipoSorpresa.PORCASAHOTEL);
        
        //*****************PRUEBA 5********************//  
        
        System.out.println("PRUEBA 5");
        
        Tablero tablero = new Tablero();
        Casilla calle1 = new Casilla(TipoCasilla.CALLE, "Gran Via", 1750, 350, 200);
        Casilla calle2 = new Casilla(TipoCasilla.CALLE, "Colón", 975, 200, 100);
        Casilla calle3 = new Casilla(TipoCasilla.CALLE, "Paseo de los Tristes", 2500, 650, 400);
        Casilla calle4 = new Casilla(TipoCasilla.CALLE, "Albaicín", 2000, 450, 300);
        
        tablero.añadeCasilla(calle1);
        tablero.añadeCasilla(calle2);
        tablero.añadeCasilla(calle3);
        tablero.añadeCasilla(calle4);
        
        for(int i=0; i<tablero.getSize(); i++){
            System.out.println(tablero.getCasilla(i).toString());
        }
        
        //*****************PRUEBA 6********************//  
        
        System.out.println("PRUEBA 6");
        
        /* Cogemos de casilla mas cara la primera, con un bucle for recorremos el
        array y a la casilla "masCara" se asignará la casilla más cara del array
        */
        
        Casilla masCara = tablero.getCasilla(0);
        
        /* Para encontrar la más barata, asignamos "masBarata" a la primera casilla de tipo 
        calle válida, e iremos comparando con un bucle con las restantes casillas 
        del array
        */
        
        Casilla masBarata = tablero.getCasilla(1);
        
        int media = 0;
        
        
        for(int i=1; i < tablero.getSize(); i++){    //Bucle para encontrar la más cara
            if(tablero.getCasilla(i).getPrecioCompra() > masCara.getPrecioCompra()){
                masCara = tablero.getCasilla(i);
            }
        }
        
        for(int i=2; i < tablero.getSize(); i++){    //Bucle para encontrar la más barata
            if(tablero.getCasilla(i).getPrecioCompra() < masBarata.getPrecioCompra()){
                masBarata = tablero.getCasilla(i);
            }
        }
        
        for(int i=1; i < tablero.getSize(); i++){   //Bucle para calcular la media
            media += tablero.getCasilla(i).getPrecioCompra();
        }
        
        media = media / (tablero.getSize() -1);    //-1 porque la casilla de salida no cuenta
        
        System.out.println("La casilla más cara es: " + masCara.toString());
        System.out.println("La casilla más barata es: " + masBarata.toString());
        System.out.println("La media del valor de las calles es : " + media);
        
        
        //*****************PRUEBA 7********************//
        
        System.out.println("PRUEBA 7");
         
        boolean pendientes = Diario.getInstance().eventosPendientes();
        
        Diario.getInstance().ocurreEvento("Prueba de Diario");
        
        if(pendientes){ 
            System.out.println("Hay eventos pendientes");
            System.out.println(Diario.getInstance().leerEvento());
            System.out.println(Diario.getInstance().leerEvento());
            System.out.println(Diario.getInstance().leerEvento());
        }
        
        pendientes = Diario.getInstance().eventosPendientes();
        
        if(!pendientes){
            System.out.println("No hay eventos pendientes");
        }
        
        //*****************PRUEBA 8********************//
         
        System.out.println("PRUEBA 8");
        
        int actual = 4;
        int tirada = Dado.getInstance().tirar();

        int nueva = tablero.nuevaPosicion(actual, tirada);
        
        // Como el tablero tiene 5 casillas, se realiza la operación % 5 //
        // Los indices van de 0 a 4, 0 es la casilla de salida, 1 es la calle1 ...//
        
        System.out.println("Tirada de : " + tirada);
        System.out.println("Nueva posicion: " + nueva);
        
        
        
        
        
        
        
    }
    
}
