package texttomd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Conversor {

	public static void main(String[] args) {
		try {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		      BufferedWriter bw = new BufferedWriter(new FileWriter(args[0] + ".md"));
		
		String linea = "";
		
		while (linea != null) {
		linea = br.readLine();
		if (linea != null) {
		bw.write(linea + "\n");
		}
		}
		br.close();
		bw.close();
		
		System.out.println(args[0] + ".md creado con éxito.");

		} catch (IOException ioe) {
		System.out.println("Se ha producido un error de lectura/escritura");
		System.err.println(ioe.getMessage());
		}
		}
		}


