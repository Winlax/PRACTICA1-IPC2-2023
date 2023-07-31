import java.util.InputMismatchException;
import java.util.Scanner;

public class seleccionJuegos {

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        int opcionJuego = 0;
        boolean activador;

        String mensaje1 =  //Mensajes posiblemente a reutilizarse
                """
                        > > > JUEGOS DISPONIBLES < < <
                        (1) AHORCADO x.x
                        (2) BASKETBALL Oo.
                        (3) JUEGO DE CARTAS [J][Q][K]
                                                 
                        (0) SALIR
                                                 
                        Ingrese numero del juego a jugar ->\s""";
        String mensaje2 = "### ERROR - Ingrese un numero valido...";
        String mensaje3 = "### ERROR - Debe ingresar una de las opciones -> ";

        do {
            print(mensaje1);

            do try {
                activador = false;
                opcionJuego = teclado.nextInt();

                if (opcionJuego < 0 || opcionJuego > 3) {
                    print(mensaje3);
                    activador = true;
                }

            } catch (InputMismatchException e) {
                System.out.print(mensaje2 +
                        "\nIngrese numero del juego a jugar -> ");
                teclado.next();
                activador = true;
            } while (activador);

            juegoAhorcado juego1 = new juegoAhorcado();
            Basketball basketball = new Basketball();


            switch (opcionJuego) {
                case 1:
                    juego1.juego();
                    break;
                case 2:
                    basketball.inicioBasketball();
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Nos vemos...");
                    break;
            }

        } while (opcionJuego != 0);

    }

    public void print(String msg) {
        System.out.print(msg);
    }

}
