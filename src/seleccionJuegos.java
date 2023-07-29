import java.util.InputMismatchException;
import java.util.Scanner;

public class seleccionJuegos {

    public void menu(){
        Scanner teclado = new Scanner(System.in);
        int opcionJuego = 0;
        boolean activador;

        String mensaje1 =  //Mensajes posiblemente a reutilizarse
                """
                         > > > JUEGOS DISPONIBLES < < <
                         (1) AHORCADO x.x
                         (2) BASKETBALL Oo.
                         (3) JUEGO DE CARTAS [J][Q][K]
                         
                         Ingrese numero del juego a jugar ->\s""";
        String mensaje2 = "### ERROR - Ingrese un numero valido...";
        String mensaje3 = "### ERROR - Debe ingresar una de las opciones -> ";

        print(mensaje1);

        do try {
            activador = false;
            opcionJuego = teclado.nextInt();

            if (opcionJuego < 1 || opcionJuego > 3) {
                print(mensaje3);
                activador = true;
            }

        } catch (InputMismatchException e) {
            System.out.print(mensaje2 +
                    "\nIngrese numero del juego a jugar -> ");
            teclado.next();
            activador = true;
        } while (activador);

        switch (opcionJuego) {
            case 1:
                break;
            case 2:

            Basketball basketball = new Basketball();
            basketball.inicioBasketball();
            
                break;
            case 3:
                break;
        }

    }

    public void print(String msg) {
        System.out.print(msg);
    }

}
