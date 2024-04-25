package ex_04_Censurar;

import java.io.*;

import classes.Teclat;

public class Censurar {

	public static void main (String [] args) throws IOException {
		BufferedReader bur = null;
		BufferedWriter buw = null;
		File arxiuEntrada;
		File arxiuSortida;

		System.out.println();
		System.out.print("Nom de l'arxiu d'entrada (amb extensió, si la té): ");
		arxiuEntrada = new File(Teclat.llegirCadena());
		System.out.print("Nom de l'arxiu de sortida (amb extensió si la té): ");
		arxiuSortida = new File(Teclat.llegirCadena());

		try{
			bur = new BufferedReader(new FileReader(arxiuEntrada));
			buw = new BufferedWriter(new FileWriter(arxiuSortida));
			String Line;
			while((Line = bur.readLine()) != null){
				if(Line.startsWith("Censurar")){
					buw.write(Line);
					buw.newLine();
				}
			}
		} catch(FileNotFoundException e){
			System.err.println("File not found");
		} catch(IOException e){
			System.err.println("I/O Exception");
		}
		finally {
			try{
				if(buw != null){buw.close();}
				if(bur != null){bur.close();}

			}catch (IOException e){
				System.err.println("I/O Exception");
			}
		}
	}

}
