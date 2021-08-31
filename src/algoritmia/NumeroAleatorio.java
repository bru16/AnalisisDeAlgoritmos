package algoritmia;

import java.util.Scanner;

public class NumeroAleatorio {
    static final int MAXIMO = 1000000;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numeroGenerado = 1; // Número aleatorio de 1 a MAXIMO.
        System.out.println(numeroGenerado);
        System.out.println("El juego consiste en adivinar un numero aleatorio entre 1-100\n" +
                "se te ira avisando si es mayor o menor al que introduciste ");

        System.out.print("EMPIEZA EL JUEGO: Por favor introduzca un numero entre 1-" + MAXIMO + ": ");
        int numJugador = s.nextInt();
        boolean win = false;
        while (numJugador <= MAXIMO && numJugador >= 1 && !win) {
            if (numJugador == numeroGenerado) {
                win = true;
                break;
            }
            if (numJugador > numeroGenerado)
                System.out.println("El numero introducido es mayor que el que se desea adivinar");
            else
                System.out.println("El numero introducido es menor que el que se desea adivinar");

            System.out.print("Introduzca nuevamente un numero: ");
            numJugador = s.nextInt();

        }
        if (win) {
            System.out.println("Haz acertado! felicitaciones");
            return;
        }
        System.out.println("Lo siento, has violado las reglas.");

    }
}
