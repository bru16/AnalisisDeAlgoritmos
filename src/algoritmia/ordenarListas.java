package algoritmia;

import java.util.ArrayList;
import java.util.Collections;


public class ordenarListas {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList();
        ArrayList<Integer> B = new ArrayList();

        for (int i = 1; i <= 60; i++) {
            A.add(i);
            B.add(i);
        }
        for (int i = 61; i <= 100; i++) {
            A.add(i);
        }

        Collections.shuffle(A);
        Collections.shuffle(B);
        System.out.println("Lista A Mezclada " + A.toString());
        System.out.println("Lista B Mezclada " + B.toString());

        ordenarListaBubbleSort(A);
        ordenarListaInsercion(B);

        System.out.println("La lista A ORDENADA: " + A.toString());
        System.out.println("La lista B ORDENADA: " + B.toString());

        ArrayList<Integer> C = new ArrayList<Integer>();
        
    }


    private static void ordenarListaBubbleSort(ArrayList<Integer> lista) {
        // bubble sort mejorado.
        boolean sorted;
        int temp, i, j;
        int size = lista.size();
        for (i = 0; i < size - 1; i++) {
            sorted = true;
            for (j = 0; j < size - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    private static void ordenarListaInsercion(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 1; i < n; ++i) {
            int key = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) > key) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, key);
        }
    }
}
