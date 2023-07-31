import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author josec
 */
public class Basketball {
    
    static int puntosJugador1,puntosJugador2,puntosTiroNormal,puntosTiroLibre,opcionlanzamiento,opcionDefensa,probabilidadAnotar,probabilidadFalta,tiroLibre;
    
     public void inicioBasketball(){
         
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String jugador1,jugador2,turnos;
        int orden;
        
        System.out.println("Bienvenidos a basketball");
        System.out.print("Ingrese el nombre de Jugador 1:  ");
        jugador1 = scanner.nextLine();
        System.out.print("Ingrese el nombre de Jugador 2:  ");
        jugador2 = scanner.nextLine();
        
        orden = random.nextInt(2)+1;  //se calcula aleatoriamente quien inicia.
           
            if(orden ==1){    
                System.out.println("El primer jugador sera "+jugador1);
                System.out.println("El segundo jugador sera "+jugador2);
            }
            else{
                System.out.println("El primer jugador sera "+jugador2);
                System.out.println("El segundo jugador sera "+jugador1);
            }            
                System.out.print("Ingrese la cantidad de turnos ");   //se define la cantidad de turnos que tendrá el juego
                turnos = scanner.nextLine();
                int turno = Integer.parseInt(turnos);
                turno = turno*2;
                
        while(turno > 0){    //Inicia la partida
                        System.out.println("Queda "+turno+" turnos ");                
                if(orden ==1){    // inica jugador 1
                    if(turno%2==0){  // determina de quien es el turno
                        System.out.println("Lanza: "+jugador1);
                        System.out.println("Defiende: "+jugador2);
                        lanzamientosJugador();
                        defensaJugador();
                        puntos();
                        faltas();
                        System.out.println(jugador1+" anoto "+puntosTiroNormal+" puntos");
                        System.out.println(jugador1+" anoto "+puntosTiroLibre+" puntos por falta");
                        puntosJugador1 = puntosJugador1 + (puntosTiroNormal + puntosTiroLibre);                       
                    }
                    else{
                        System.out.println("Lanza: "+jugador2);
                        System.out.println("Defiende: "+jugador1);
                        lanzamientosJugador();
                        defensaJugador();
                        puntos();
                        faltas();
                        System.out.println(jugador2+" anoto "+puntosTiroNormal+" puntos");
                        System.out.println(jugador2+" anoto "+puntosTiroLibre+" puntos por falta");
                        puntosJugador2 = puntosJugador2 + (puntosTiroNormal + puntosTiroLibre);
                    }                                     
                }
                else{   //Inicia jugador 2                   
                    if(turno%2==0){  // determina de quien es el turno
                        System.out.println("Lanza : "+jugador2);
                        System.out.println("Defiende: "+jugador1);
                        lanzamientosJugador();
                        defensaJugador();
                        puntos();
                        faltas();
                        System.out.println(jugador2+" anoto "+puntosTiroNormal+" puntos");
                        System.out.println(jugador2+" anoto "+puntosTiroLibre+" puntos por falta");
                        puntosJugador2 = puntosJugador2 + (puntosTiroNormal + puntosTiroLibre);                        
                    }
                    else{
                        System.out.println("Lanza : "+jugador1);
                        System.out.println("Defiende: "+jugador2);
                        lanzamientosJugador();
                        defensaJugador();
                        puntos();
                        faltas();
                        System.out.println(jugador1+" anoto "+puntosTiroNormal+" puntos");
                        System.out.println(jugador1+" anoto "+puntosTiroLibre+" puntos por falta");
                        puntosJugador1 = puntosJugador1 + (puntosTiroNormal + puntosTiroLibre);
                    }
                }   
                System.out.println("Marcador");
                System.out.println(jugador1+"     "+puntosJugador1);
                System.out.println(jugador2+"     "+puntosJugador2);        
                turno--;
                if(turno == 0){  
                    if(puntosJugador1 > puntosJugador2) {
                        System.out.println("El ganador es "+jugador1);
                    }                         
                    if(puntosJugador2 > puntosJugador1){
                        System.out.println("El ganador es "+jugador2);
                    }
                    if(puntosJugador1 == puntosJugador2){
                        System.out.println("Es un empate");
                    }                    
                    
                }
        }   
         
         
     }
       
    public static int lanzamientosJugador(){   // opcion para elegir tipo de lanzamiento     
            Scanner lanzar = new Scanner(System.in);
                System.out.println("Elija el tipo de lanzamiento: ");
                System.out.println("1.Salto largo desde 5 metros    3 Puntos   65% Probalidad de Acierto");
                System.out.println("2.Salto corto desde 3 metros    2 Puntos   80% Probalidad de Acierto");     
            opcionlanzamiento = lanzar.nextInt();        
        return opcionlanzamiento;
    }        
    public static int defensaJugador (){        // opcion para elegir tipo de defenza 
            Scanner defender = new Scanner(System.in);       
                System.out.println("Elija el tipo de defenza: ");
                System.out.println("1.Defensa cuerpo a cuerpo   Reduce probabilidad de acierto en 15%   Probabilidad de falta 35%");
                System.out.println("2.Defensa fuerte            Reduce probabilidad de acierto en 30%   Probabilidad de falta 65% ");
            opcionDefensa = defender.nextInt();                        
        return opcionDefensa;            
    }
    public static int porcentaje(){  // Generar random aleatorio
        Random random = new Random();
        return random.nextInt(99)+1;
    }


    public static int puntos(){//calula puntos y aciertos
        probabilidadAnotar = porcentaje();
                if(opcionlanzamiento == 1 && opcionDefensa ==1){                    
                        if(probabilidadAnotar <= 50){
                            puntosTiroNormal = 3;
                        }
                        else{
                            puntosTiroNormal = 0;
                        }
                }
                if(opcionlanzamiento == 1 && opcionDefensa ==2){
                        if(probabilidadAnotar <= 35){
                            puntosTiroNormal = 3;
                        }
                        else{
                            puntosTiroNormal = 0;
                        }
                }
                if(opcionlanzamiento == 2 && opcionDefensa ==1){
                        if(probabilidadAnotar <= 65 ){
                            puntosTiroNormal = 2;
                        }
                        else{
                            puntosTiroNormal = 0;
                        }
                }
                if(opcionlanzamiento == 2 && opcionDefensa ==2){
                        if(probabilidadAnotar <= 50){
                            puntosTiroNormal = 2;
                        }
                        else{
                            puntosTiroNormal = 0;
                        }
                }                                            
        return puntosTiroNormal;  
    }  
    public static int faltas(){//determina si hay tiroLibre
            probabilidadFalta = porcentaje();
        
        if(opcionDefensa == 1){                                        
                        if(probabilidadFalta <= 35){
                            puntosFalta();
                        }else{puntosTiroLibre = 0;
                        }
                }
                else{
                        if(probabilidadFalta <= 65){
                            puntosFalta();
                        } else{puntosTiroLibre = 0;
                        }              
                }
        return puntosTiroLibre;
    }
   public static int puntosFalta (){ // determina si acierta tiro libre y asigna puntos
        tiroLibre = porcentaje();  
        System.out.println("Falta");
                if(tiroLibre <= 90){  
                    System.out.println("Se anoto el tiro libre");
                    puntosTiroLibre = 2;
                }
                else{
                    System.out.println("Se fallo el tiro libre");
                    puntosTiroLibre = 0;
                } 
    return puntosTiroLibre;
    
    
    }
}
