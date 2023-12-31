import java.util.Random;
import java.util.Scanner;

public class juegoAhorcado {

    public void juego(){
        final int INTENTOS_TOTALES = 12;
        int intentosJugador = 0;
        int aciertosJugador = 0;
        boolean comprobador = false;
        int contadorLetras = 0;

        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        char Respuesta;

        Random escogerPalabra = new Random();

        String listaPalabras[] = new String[10];
        listaPalabras[0] = "william";
        listaPalabras[1] = "lentes";
        listaPalabras[2] = "electrodomestico";
        listaPalabras[3] = "cancelado";
        listaPalabras[4] = "bolso";
        listaPalabras[5] = "irene";
        listaPalabras[6] = "outfit";
        listaPalabras[7] = "alcohol";
        listaPalabras[8] = "descafeinado";
        listaPalabras[9] = "chistosa";

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

                /*
                while (contadorLetras == descomponer.length-1){
                    switch (contadorFallos) {
                        case 1:
                            System.out.print("\n |--v--");
                        case 2:
                            System.out.print("\n °  |  ");
                        case 3:
                            System.out.print("\n/V/ |  ");
                        case 4:
                            System.out.print("\n |  |  ");
                        case 5:
                            System.out.print("\n/ / |  ");
                        case 6:
                            System.out.print("\n    |  ");
                        case 7:
                            System.out.print("\n    |  ");
                        case 8:
                            System.out.print("\n    |  ");
                        case 9:
                            System.out.print("\n    |  ");
                        case 10:
                            System.out.print("\n    |  ");
                        case 11:
                            System.out.print("\n    |  ");
                        case 12:
                            System.out.print("\n____|__");
                            break;
                    }
                    
                }*/

            }

            if (aciertosJugador == respuestasIngresadas.length) {
                System.out.println("\n <3 <3 <3 FELICIDADES!!! HAS ACERTADO LA PALABRA");
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
        char respuesta;
        System.out.println(men + " (s/n)");
        respuesta = teclado.next().toLowerCase().charAt(0);
        while (respuesta != 's' && respuesta != 'n') {
            System.out.println("Error! solo se admite S o N");
            respuesta = teclado.next().toLowerCase().charAt(0);
        }
        return respuesta;
    }


}
