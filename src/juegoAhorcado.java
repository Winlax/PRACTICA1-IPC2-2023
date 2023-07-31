import java.util.Random;
import java.util.Scanner;

public class juegoAhorcado {

    public void juego(){
        final int INTENTOS_TOTALES = 12;
        int intentosJugador = 0;
        int aciertosJugador = 0;

        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        char Respuesta;

        Random escogerPalabra = new Random();

        String listaPalabras[] = new String[10];
        listaPalabras[0] = "william";
        listaPalabras[1] = "lentes";
        listaPalabras[2] = "electrodomestico";
        listaPalabras[3] = "cancelado";
        listaPalabras[4] = "Bolso";
        listaPalabras[5] = "Irene";
        listaPalabras[6] = "outfit";
        listaPalabras[7] = "alcohol";
        listaPalabras[8] = "descafeinado";
        listaPalabras[9] = "Chistosa";

        do {
            int aleatorio = escogerPalabra.nextInt(10);
            char[] descomponer = descompuesto(listaPalabras[aleatorio]);
            char[] copia = descompuesto(listaPalabras[aleatorio]);

            char[] respuestasIngresadas = new char[descomponer.length];

            for (int x = 0; x<respuestasIngresadas.length; x++){
                respuestasIngresadas[x] = '_';
            }

            System.out.println("> > > ADIVINA LA PALABRAS!!! < < <");

            while (intentosJugador < INTENTOS_TOTALES && aciertosJugador != respuestasIngresadas.length){
                imprimirOcultar(respuestasIngresadas);

                System.out.println("\n Introduce una letra -> ");
                Respuesta = teclado.next().toLowerCase().charAt(0);

                for (int x = 0; x < descomponer.length; x++) {
                    if(descomponer[x] == Respuesta) {
                        respuestasIngresadas[x] = descomponer[x];
                        descomponer[x] = ' ';
                        aciertosJugador++;
                    }
                }

                intentosJugador++;
            }

            if (aciertosJugador == respuestasIngresadas.length) {
                System.out.println(" <3 <3 <3 FELICIDADES!!! HAS ACERTADO LA PALABRA");
                imprimirOcultar(respuestasIngresadas);
            } else {
                System.out.print(" :• :c :C HAS PERDIDO, LA PALABRA ERA -> ");
                for (int x = 0; x<copia.length;x++) {
                    System.out.print(copia[x] + " ");
                }
            }
            intentosJugador = 0;
            aciertosJugador = 0;
            Respuesta = pregunta("\n\nQuieres volver a jugar?",teclado);
        } while (Respuesta != 'n');


    }

    private static char[] descompuesto(String palabrAleatoria) {
        char[] letras;
        letras = new char[palabrAleatoria.length()];
        for (int x = 0; x< palabrAleatoria.length(); x++){
            letras[x] = palabrAleatoria.charAt(x);
        }
        return letras;
    }

    private static void imprimirOcultar(char[] respuestasIngresadas) {
        for ( int x = 0; x < respuestasIngresadas.length; x++) {
            System.out.print(respuestasIngresadas[x] + " ");        }
    }

    public static char pregunta(String men, Scanner teclado) {
        char resp;
        System.out.println(men + " (s/n)");
        resp = teclado.next().toLowerCase().charAt(0);
        while (resp != 's' && resp != 'n') {
            System.out.println("Error! solo se admite S o N");
            resp = teclado.next().toLowerCase().charAt(0);
        }
        return resp;
    }


}
