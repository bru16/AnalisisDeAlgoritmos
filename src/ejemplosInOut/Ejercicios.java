package ejemplosInOut;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios {
    static final String NOMBRE_ARCHIVO = "src/ejemplosInOut/palabras.txt";
    static final int CANT_NUMEROS = 100;
    static final int PISO = -100;
    static final int TECHO = 100;

    public static void main(String[] args) {
        removerEspacios();
        lineasImpares();
        cienNumerosAleatorios();
        hashAleatorio();
        numerosAleatoriosSinRepeticion();
        numerosAleatoriosSinRepeticionV2();
    }

    private static void removerEspacios() {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("src/ejemplosInOut/sinEspacios.txt"));
            Scanner s = new Scanner(buffReader);
            String text = "";
            String sinEspacios[] = null;
            // itero sobre todo el txt.
            while (s.hasNextLine()) {
                sinEspacios = s.nextLine().split("\\s+"); // array with the words.
                text += String.join("", sinEspacios) + "\n"; // I have to join them because its an array of strings.
            }

            buffWriter.write(text);
            s.close();
            buffReader.close();
            buffWriter.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del " + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    private static void lineasImpares() {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("src/ejemplosInOut/lineasImpares.txt"));
            String text = "";
            int contador = 1;
            String linea = null;
            while ((linea = buffReader.readLine()) != null) {
                if (contador % 2 != 0)
                    text += linea + "\n";
                contador++;
            }
            buffWriter.write(text);
            buffReader.close();
            buffWriter.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del " + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    private static void cienNumerosAleatorios() {
        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("src/ejemplosInOut/numerosAleatorios.txt"));
            for (int i = 0; i < CANT_NUMEROS; i++) {
                double num = Math.random() * (TECHO - PISO) + PISO;
                buffWriter.write(num + "\n");
            }
            buffWriter.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del " + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    private static void hashAleatorio() {
        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("src/ejemplosInOut/hash.txt"));
            String candidatos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
            Random random = new Random();
            String hash = "";

            for (int i = 0; i < 10; i++) // devuelve un char aleatorio entre             // (A-Z,a-z,0-9)
                hash += candidatos.charAt(random.nextInt(candidatos.length()));// posicion de los candidatos 0-17

            buffWriter.write(hash);
            buffWriter.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del " + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    private static void numerosAleatoriosSinRepeticion() {
        try {
            BufferedWriter buffWriter = new BufferedWriter(
                    new FileWriter("src/ejemplosInOut/numerosSinRepeticion.txt"));

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i = 1; i <= 1000; i++)
                arr.add(i);

            Random random = new Random();
            int index;
            while (!arr.isEmpty()) {
                index = random.nextInt(arr.size()); // voy a ir generando un numero random a medida que voy removiendo de la lista.
                buffWriter.write(arr.get(index) + "\n");
                arr.remove(index); // remuevo el numero, por lo que no puede ser repetido. (modifico el size delalista)

            }
            buffWriter.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del " + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    private static void numerosAleatoriosSinRepeticionV2() {
        try {
            BufferedWriter buffWriter = new BufferedWriter(
                    new FileWriter("src/ejemplosInOut/numerosSinRepeticionV2.txt"));

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i = 1; i <= 1000; i++)
                arr.add(i);
            Collections.shuffle(arr); // mezcla los numeros aleatoriamente.
            for (int j = 1; j < arr.size(); j++) {
                buffWriter.write(arr.get(j) + "\n");
            }

            buffWriter.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del " + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}
