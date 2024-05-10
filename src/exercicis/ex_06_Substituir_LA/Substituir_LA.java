    package exercicis.ex_06_Substituir_LA;

    import java.io.*;

    import classes.Teclat;
    import classes.Teclat.*;

    public class Substituir_LA {

        public static void main (String [] args) throws IOException {
            File fileIn, fileOut;
            String filename, filenameIn, filenameOut;
            BufferedReader entrada = null;
            BufferedWriter sortida = null;
            String linia;

            System.out.println();
            System.out.print("nom de l'arxiu TXT (sense extensió): ");
            filename = Teclat.llegirCadena();
            filenameIn = filename + ".txt";
            filenameOut = filename + "_PROC.txt";

            try {
                entrada = new BufferedReader(new FileReader(filenameIn));
                sortida = new BufferedWriter(new FileWriter(filenameOut));

                while ((linia = entrada.readLine()) != null) {
                    linia = processarLinia(linia); // Processar cada línia amb la funció definida
                    sortida.write(linia);
                    sortida.newLine(); // Escriure una nova línia després de cada línia processada
                }
            } catch (IOException e) {
                System.err.println("Error handling the file: " + e.getMessage());
            } finally {
                if (entrada != null) entrada.close();
                if (sortida != null) sortida.close();
            }

            System.out.println(">>>>Arxiu processat");
        }

        private static String processarLinia (String linia) {
            // genera una versió de la línia en què LA ha estat substituit
            // per **

            int pos;
            String versioMaj;
            StringBuffer sb;

            versioMaj = linia.toUpperCase();
            sb = new StringBuffer(linia);

            while ((pos = versioMaj.indexOf("LA")) != -1) {
                sb.replace(pos, pos + 2, "**"); // Substitueix "LA" per "**"
                // Actualitzar la versió majúscula per reflectir el canvi a la StringBuffer
                versioMaj = sb.toString().toUpperCase();
            }

            return sb.toString();
        }
    }
