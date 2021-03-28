package texttomd;

import java.util.ArrayList;

public class Documento extends ArrayList<String> {

	private static final long serialVersionUID = 1L;
	
	public void marcaEncabezados() {
		String regex = "^(\\d+\\.)+.*";
		for (int i=0; i<this.size(); i++) {
			String lnActiva = this.get(i);
			String lnAnterior = getLn(i-1);
			String lnSiguiente = getLn(i+1);
		if (lnActiva.matches(regex) && lnSiguiente != null && !lnSiguiente.matches(regex)) {
			StringBuilder marca = new StringBuilder(" ");
			int punto = lnActiva.indexOf('.');
			do {
				marca.insert(0, '#');
				punto = lnActiva.indexOf('.', punto+1);
			} while (punto>0 && punto != (lnActiva.length()-1));
			if (lnAnterior != null && !lnAnterior.isBlank())
				marca.insert(0, '\n');
			marca.append(lnActiva);
			if (lnSiguiente != null && !lnSiguiente.isBlank())
				marca.append('\n');
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

	private String getLn(int i) {
		return i>0 && i<(this.size()-1) ? this.get(i): null;
	}
	
}
