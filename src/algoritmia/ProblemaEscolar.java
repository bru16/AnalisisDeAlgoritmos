package algoritmia;

import java.util.Arrays;

public class ProblemaEscolar {

    static final int CANTIDAD_MATERIAS = 5;
    static final int CANTIDAD_ALUMNOS = 3;

    public static void main(String[] args) {

        int[] alumno = {10, 6, 7, 1, 6};
        int[] alumno2 = {5, 6, 8, 8, 9};
        int[] alumno3 = {10, 10, 9, 10, 8};
        int[][] alumnos = {alumno, alumno2, alumno3};

        for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
            System.out.println("Promedio del alumno: " + (i + 1) + " " + Arrays.toString(alumnos[i]) + " ES: " + calcularMediaAlumno(alumnos[i]));
        }
        for (int j = 0; j < CANTIDAD_MATERIAS; j++) {
            System.out.println("Promedio de la asignatura: " + (j + 1) + " es DE: " + calcularMediaAsignatura(alumnos, j));
        }
        System.out.println("Promedio total de la clase es DE: " + calcularMediaTotalDeLaClase(alumnos));
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
}
