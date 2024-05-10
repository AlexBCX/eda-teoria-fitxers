package exercicis.ex_03_InfoLinies;

import java.io.*;
import javax.swing.JFileChooser;

public class InfoLinies {

	public static void main(String[] args) {
		BufferedReader entrada = null;
		int comptador = 0;

		JFileChooser fileChooser = new JFileChooser(".");
		fileChooser.setDialogTitle("Seleccionar arxiu");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showOpenDialog(null);
		File arxiu = fileChooser.getSelectedFile();

		if (arxiu != null) {
			try {
				entrada = new BufferedReader(new FileReader(arxiu));
				String liniaLegida;

				while ((liniaLegida = entrada.readLine()) != null) {
					comptador++;
					System.out.println("Linia " + comptador + ": " + liniaLegida + " mida=> " + liniaLegida.length());
				}
			} catch (IOException e) {
				System.err.println(e);
				e.printStackTrace();
			} finally {
				try {
					if (entrada != null) {
						entrada.close();
					}
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		} else {
			System.out.println("No file selected.");
		}
	}
}
