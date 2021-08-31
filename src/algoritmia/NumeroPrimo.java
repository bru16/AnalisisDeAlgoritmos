package algoritmia;

import java.util.Scanner;

public class NumeroPrimo {
    public static void main(String[] args) {
        System.out.println(esPrimo(3));
        Scanner s = new Scanner(System.in);

        System.out.println("Introduzca un numero mayor a 1");
        int n = s.nextInt();
        int contador = 0;
        for (int i = 1; i < n; i++)
            if (esPrimo(i)) contador++;
        System.out.println("Hay " + contador + " numeros primos entre 1-" + n);
    }


    private static boolean esPrimo(int n) {
        if (n == 1) return false;
        if (n % 2 == 0 && n != 2) return false;
        for (int i = 3; i < n; i += 2) {    // solo veo los impares
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
