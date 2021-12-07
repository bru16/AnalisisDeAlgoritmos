package TPOfinal;

import java.util.*;

public class main {
    public static void main(String[] args) {
        int prefer[][] = new int[][]{
                {2, 3},   //0
                {2, 3},   //1       --->    HOMBRES

                {1, 0},   //2
                {0, 1},   //3       ---> MUJERES
        };
        stableMarriage(prefer);
    }



    // número de hombres o mujeres.
    static int N = 2;

    //retorna true si la mujer prefiere al hombre con el que ya esta casado antes que al nuevo
    static boolean wPrefersM1OverM(int prefer[][], int w, int m, int m1) {
        for (int i = 0; i < N; i++) {
            if (prefer[w][i] == m1)
                return true;

            if (prefer[w][i] == m)
                return false;
        }
        return false;
    }


    static void stableMarriage(int prefer[][]) {
        // wPartner[i] indica el companero asignado a la mujer N+i
        //-1 indica que la mujer está libre.
        int wPartner[] = new int[N];        //i = N+i
        //i+1 = N+i+1

        // guarda los hombres libres, si está libre mFree[i] = false
        boolean mFree[] = new boolean[N];

        // Inicializo a todos como libres.
        Arrays.fill(wPartner, -1);  // Mujer N+i esta libre
        int freeCount = N;
        // Mientras hayan hombres libres
        while (freeCount > 0) {
            //Agarramos el primer hombre libre
            int m;
            System.out.println(Arrays.toString(mFree));
            for (m = 0; m < N; m++)
                if (mFree[m] == false)
                    break;

            //uno por uno ir a todas las mujeres
            // de acuerdo a su orden de preferencia

            for (int i = 0; i < N && mFree[m] == false; i++) {
                int w = prefer[m][i];

                // La mujer está libre y se comprometen.
                if (wPartner[w - N] == -1) {
                    wPartner[w - N] = m;    // los comprometo
                    mFree[m] = true;
                    freeCount--;
                } else {
                    int m1 = wPartner[w - N];

                    // si prefiere a su nuevo hombre
                    if (wPrefersM1OverM(prefer, w, m, m1) == false) {
                        wPartner[w - N] = m;
                        mFree[m] = true;
                        mFree[m1] = false;
                    }
                }
            }
        }


// Imprime la solucion
        System.out.println("Woman Man");
        for (int i = 0; i < N; i++) {
            System.out.print(" ");
            System.out.println(i + N + "     " +
                    wPartner[i]);
        }
    }
}
