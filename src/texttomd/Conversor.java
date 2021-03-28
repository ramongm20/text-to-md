package texttomd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Conversor {

	public static void main(String[] args) {
		Documento doc = new Documento();
		rellena(doc, args[0]);
		doc.marcaEncabezados();
		escribe(doc, args[0]);
				}

public static void rellena(Documento doc, String nombreFichero) {
	try {
		BufferedReader br = new BufferedReader(new FileReader(nombreFichero));

		String linea = "";
		
		while (linea != null) {
		linea = br.readLine();
		if (linea != null && !doc.coincideÚltimaLn(linea)) {
		doc.add(linea);
		}
		}
		br.close();
		} catch (IOException ioe) {
		System.out.println("Se ha producido un error de lectura");
		System.err.println(ioe.getMessage());
		}
}
public static void escribe(Documento doc, String nombreFichero) {
	try {
	BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero + ".md"));
			bw.write(doc.toString());
	bw.close();
	System.out.println(nombreFichero + ".md creado con éxito.");
	} catch (IOException ioe) {
	System.out.println("Se ha producido un error de escritura");
	System.err.println(ioe.getMessage());
	}
}
}
