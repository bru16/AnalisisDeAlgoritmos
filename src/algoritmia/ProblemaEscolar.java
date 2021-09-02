package algoritmia;

import java.util.Arrays;

public class ProblemaEscolar {

    static final int CANTIDAD_MATERIAS = 5;
    static final int CANTIDAD_ALUMNOS = 4;

    public static void main(String[] args) {

        // datos de prueba
        int[] alumno = {1, 6, 7, 1, 6};
        int[] alumno2 = {5, 6, 8, 8, 9};
        int[] alumno3 = {10, 10, 9, 10, 8};
        int[] alumno4 = {3, 3, 3, 3, 3};
        int[][] alumnos = {alumno, alumno2, alumno3, alumno4};

        int[] promedioNotasAlumnos = new int[CANTIDAD_ALUMNOS];
        for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
            promedioNotasAlumnos[i] = calcularMediaAlumno(alumnos[i]);
            System.out.println("Promedio del alumno: " + (i + 1) + " " + Arrays.toString(alumnos[i]) + " ES: " + promedioNotasAlumnos[i]);
        }
        for (int j = 0; j < CANTIDAD_MATERIAS; j++) {
            System.out.println("Promedio de la asignatura: " + (j + 1) + " es DE: " + calcularMediaAsignatura(alumnos, j));
        }
        System.out.println("Promedio total de la clase es DE: " + calcularMediaTotalDeLaClase(alumnos));

        ordenarPromediosBubbleSort(promedioNotasAlumnos);
        System.out.println("El promedio de notas ordenado de forma decreciente: " + Arrays.toString(promedioNotasAlumnos));

        // ordenarPromediosInsercion(promedioNotasAlumnos);
        //System.out.println("El promedio de notas ordenado de forma decreciente: " + Arrays.toString(promedioNotasAlumnos));

    }

    private static int calcularMediaAlumno(int[] alumno) {
        int media = 0;
        for (int i = 0; i < alumno.length; i++) {
            media += alumno[i];
        }
        return media / CANTIDAD_MATERIAS;
    }

    private static int calcularMediaAsignatura(int[][] alumnos, int asignatura) {
        int media = 0;
        for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
            media += (alumnos[i])[asignatura];
        }   //alumnos[i] me devuelve un alumno y alumno[asignatura] me devuelve la nota
        return media / CANTIDAD_ALUMNOS;
    }

    private static int calcularMediaTotalDeLaClase(int[][] alumnos) {
        int notasAlumno = 0;
        int total = 0;
        for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
            for (int materia = 0; materia < CANTIDAD_MATERIAS; materia++) {
                notasAlumno += (alumnos[i])[materia];
            }
            total += notasAlumno;
            notasAlumno = 0;
        }
        return total / (CANTIDAD_ALUMNOS * CANTIDAD_MATERIAS);
    }

    // burbuja mejorado (hago este ya que es el mas facil :-) )
    private static void ordenarPromediosBubbleSort(int[] notas) {
        int aux, length = notas.length;
        boolean sorted;
        for (int i = 0; i < length - 1; i++) {
            sorted = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (notas[j] < notas[j + 1]) {  // para ordenar de forma decreciente cambio el operador a "<"
                    aux = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = aux;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    private static void ordenarPromediosInsercion(int[] notas) {
        for (int i = 1; i < notas.length; ++i) {
            int key = notas[i];
            int j = i - 1;
            while (j >= 0 && notas[j] < key) {  // cambio operador ">" a "<" para ordenar decreciente.
                notas[j + 1] = notas[j];
                j--;
            }
            notas[j + 1] = key;
        }
    }
}
