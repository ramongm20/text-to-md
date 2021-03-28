package texttomd;

import java.util.ArrayList;

public class Documento extends ArrayList<String> {

	private static final long serialVersionUID = 1L;
	
	public void marcaEncabezados() {
		for (int i=0; i<this.size(); i++) {
		if (this.get(i).matches("^(\\d+\\.)+.*")) {
			StringBuilder marca = new StringBuilder(" ");
			int punto = this.get(i).indexOf('.');
			do {
				marca.insert(0, '#');
				punto = this.get(i).indexOf('.', punto+1);
			} while (punto>0 && punto != (this.get(i).length()-1));
			if (i>0) {
			if (!this.get(i-1).isBlank())
				marca.insert(0, '\n');
			}
			marca.append(this.get(i));
			if ((i+1)<this.size()) {
			if (!this.get(i+1).isBlank())
				marca.append('\n');
			}
			this.set(i, marca.toString());
		}
		}
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		this.forEach(ln -> cadena.append(ln + "\n"));
		return cadena.toString();
	}

	public boolean coincideÚltimaLn(String ln) {
		if (this.size()==0) return false;
		return ln.equals(this.get(this.size()-1)) ? true: false;
	}
	
}
