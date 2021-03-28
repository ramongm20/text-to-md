package texttomd;

import java.util.ArrayList;

public class Documento extends ArrayList<String> {

	private static final long serialVersionUID = 1L;
	
	public void marcaEncabezados() {
		for (int i=0; i<this.size(); i++) {
		if (this.get(i).matches("^(\\d+\\.)+.*")) {
			String marca = " ";
			int punto = this.get(i).indexOf('.');
			do {
				marca = "#" + marca;
				punto = this.get(i).indexOf('.', punto+1);
			} while (punto>0 && punto != (this.get(i).length()-1));
			this.set(i, marca + this.get(i));
		}
		}
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		this.forEach(ln -> cadena.append(ln + "\n"));
		return cadena.toString();
	}

	
	
}
