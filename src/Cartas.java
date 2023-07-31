import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author josec
 */
public class Cartas {
    
    public void inicioCartas() {    
        Scanner scanner = new Scanner(System.in);
        int saldo,apuesta;
       
                    
         System.out.println("Bienvenidos a basketball");       
         System.out.println("El casino presenta dos cartas y si la siguiente carta que salga se encuentre entre el valor de las dos cartas el jugador gana la apuesta.");
         System.out.println("Ingrese dinero de entrada ");
         saldo = scanner.nextInt(); 
       
        while(saldo > 0){       
         int carta1 = cartaAleatoria();    
         int carta2 = cartaAleatoria();
         int carta3 =cartaAleatoria();
                if(carta1 == carta2){   // se repite la asignacion si las cartas son iguales
                    carta1 = cartaAleatoria();
                    carta2 = cartaAleatoria();
                }  
                else{ 
                    if((carta1 - carta2) == 1 || (carta2-carta1) == 1){   //se asegura que los numeros no sean consecutivos  
                    carta2 = cartaAleatoria();
                    }
                    else{   
                        
                    String primeraCarta = String.valueOf(carta1);   // asigna caracteres de letras
                    String segundaCarta = String.valueOf(carta2);
                    String terceraCarta = String.valueOf(carta3);
                          
                        if(carta1==1){
                            primeraCarta = "A️";
                        }
                        if(carta2==1){
                            segundaCarta = "A️";
                        }
                        if(carta3==1){
                            terceraCarta = "A️";
                        }
                        if(carta1==11){
                            primeraCarta = "J";
                        }
                        if(carta2==11){
                            segundaCarta = "J";
                        }
                        if(carta3==11){
                            terceraCarta = "J";
                        }
                        if(carta1==12){
                            primeraCarta = "Q";
                        }
                        if(carta2==12){
                            segundaCarta = "Q";
                        }
                        if(carta3==12){
                            terceraCarta = "Q";
                        }
                        if(carta1==13){
                            primeraCarta = "K";
                        }
                        if(carta2==13){
                            segundaCarta = "K";
                        }
                        if(carta3==13){
                            terceraCarta = "K";
                        }   
                        

                            System.out.println("Las cartas son = "+primeraCarta+"  "+segundaCarta);                                                     
                            System.out.println("Ingrese apuesta: ");
                            apuesta = scanner.nextInt();
                            while(apuesta > saldo){
                            
                            System.out.println("No puede apostar mas de lo que tiene: ");
                            System.out.println("Ingrese apuesta: ");
                            apuesta = scanner.nextInt();
                            }
                            System.out.println("La carta es: "+terceraCarta); 
                                     
                                if((carta3<carta2 && carta3>carta1) || (carta3>carta2 && carta3<carta1) ){      //determina si el jugador gano              
                                        saldo = saldo + apuesta;
                                        System.out.println("Gano");
                                        System.out.println("Saldo: "+saldo);
                    
                                }                
                                else{ 
                                    saldo = saldo - apuesta;                    
                                        if(saldo <= 0 ){    
                                           
                                            System.out.println("No tiene dinero para jugar, su saldo es "+saldo);
                                     
                                        }   
                                        else{
                                            System.out.println("Perdio");
                                            System.out.println("Saldo: "+saldo);    
                                        }
                                }                                                                                               
                    }
                }
        }
        
    }         
    public static int cartaAleatoria(){    // genera una carata aleatoria   
        Random random = new Random();
        return random.nextInt(13)+1;
    }
}
