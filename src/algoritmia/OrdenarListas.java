package algoritmia;

import java.util.ArrayList;
import java.util.Collections;

public class OrdenarListas {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList();
        ArrayList<Integer> B = new ArrayList();

        for (int i = 1; i <= 60; i++) {
            B.add(i);
        }
        for (int i = 61; i <= 160; i++) {
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

        ArrayList<Integer> C = crearListaMezclada(A, B);

        System.out.println("La lista C ORDENADA a partir de A y B: " + C.toString());
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
                j--;
            }
            lista.set(j + 1, key);
        }
    }

    private static ArrayList<Integer> crearListaMezclada(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> listaNueva = new ArrayList<Integer>();
        int i = 0, j = 0;
        int listaUnoSize = lista1.size();
        int listaDosSize = lista2.size();

        while (i < listaUnoSize && j < listaDosSize) {// voy agregando correspondientemente el valor en la nueva lista
            if (lista1.get(i) < lista2.get(j)) {// hasta que una haya completado al menos una lista
                listaNueva.add(lista1.get(i));
                i++;
            } else {
                listaNueva.add(lista2.get(j));
                j++;
            }
        }
        while (i < listaUnoSize) {  // si quedan elementos en la primera lista, los agrego,
            listaNueva.add(lista1.get(i));// ya que serian mayores a los ya agregados anteriormente
            i++;
        }
        while (j < listaDosSize) {
            listaNueva.add(lista2.get(j));
            j++;
        }
        return listaNueva;
    }
}
