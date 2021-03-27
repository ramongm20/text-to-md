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
		linea = marcaEncabezados(linea);
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

public static String marcaEncabezados(String ln) {
	if (ln.matches("^(\\d+\\.)+.*")) {
		String marca = " ";
		int punto = ln.indexOf('.');
		do {
			marca = "#" + marca;
			punto = ln.indexOf('.', punto+1);
		} while (punto>0 && punto != (ln.length()-1));
		ln = marca + ln;
	}
	return ln;
}

}


