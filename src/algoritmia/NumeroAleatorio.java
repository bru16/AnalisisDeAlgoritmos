package algoritmia;

import java.util.Scanner;

public class NumeroAleatorio {
    static final int MAXIMO = 1000;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numeroGenerado = (int) (Math.random() * MAXIMO) + 1; // Número aleatorio de 1 a MAXIMO.
        System.out.println(numeroGenerado);
        System.out.println("El juego consiste en adivinar un numero aleatorio entre 1-100\n" +
                "se te ira avisando si es mayor o menor al que introduciste ");

        System.out.print("EMPIEZA EL JUEGO: Por favor introduzca un numero entre 1-" + MAXIMO + ": ");
        int numJugador = s.nextInt();
        while (numJugador <= MAXIMO && numJugador >= 1) {   // itero hasta que haya adivinado o hasta que introduzca
            if (numJugador == numeroGenerado) {             // un numero invalido.
                System.out.println("Haz acertado! felicitaciones");
                return;
            }
            if (numJugador > numeroGenerado)
                System.out.println("El numero introducido es mayor que el que se desea adivinar");
            else
                System.out.println("El numero introducido es menor que el que se desea adivinar");

            System.out.print("Introduzca nuevamente un numero: ");
            numJugador = s.nextInt();
        }
        System.out.println("Lo siento, has violado las reglas.");
    }
}
