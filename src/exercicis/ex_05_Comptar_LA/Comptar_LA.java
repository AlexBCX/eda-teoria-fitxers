package exercicis.ex_05_Comptar_LA;

import java.io.*;

import classes.Teclat;
import classes.Teclat.*;

public class Comptar_LA {

    public static void main(String[] args) throws IOException {
        File file;
        String filename;
        BufferedReader entrada;
        String linia;
        int aparicions = 0;

        System.out.println();
        System.out.print("nom de l'arxiu TXT (sense extensión): ");
        filename = "arxiuLA";  // Leer el nombre del archivo desde el teclado
        filename = filename + ".txt";  // Añadir la extensión .txt al nombre del archivo

        file = new File(filename);  // Crear un objeto File con el nombre de archivo completo
        entrada = new BufferedReader(new FileReader(file));  // Abrir el archivo para leer

        // Leer y procesar cada línea del archivo
        while ((linia = entrada.readLine()) != null) {
            aparicions += processarLinia(linia);  // Sumar las apariciones encontradas en cada línea
        }
        entrada.close();  // Cerrar el BufferedReader

        System.out.println("la cadena LA apareix " + aparicions + " vegades");
    }

    private static int processarLinia(String linia) {
        int pos, resultat;
        linia = linia.toUpperCase();  // Convertir la línea a mayúsculas para la búsqueda uniforme
        resultat = 0;
        pos = linia.indexOf("LA");  // Buscar la primera aparición de "LA"

        // Contar todas las apariciones de "LA"
        while (pos != -1) {
            resultat++;
            pos = linia.indexOf("LA", pos + 1);  // Buscar la próxima aparición después de la actual
        }

        return resultat;
    }
}
