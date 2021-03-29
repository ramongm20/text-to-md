package texttomd;

import java.util.ArrayList;
import java.util.Iterator;

public class Documento extends ArrayList<String> {

	private static final long serialVersionUID = 1L;
	
	public void marcaEncabezados() {
		String regex = "(^[\\d]+)(\\.)([\\d\\.]*)(.*)";
		boolean[] coincidencias = new boolean[this.size()];
for (int i=0; i<this.size(); i++) {
	coincidencias[i] = this.get(i).matches(regex);
}
int principio = 0;
int fin = 0;
int p = 0;
int f = 0;
for (int i=0; i<coincidencias.length; i++) {
	if(coincidencias[i]) {
		p = i;
		while (i < coincidencias.length && coincidencias[i]) {
			i++;
			f = i;
		}
		principio += p;
		fin += f;
		if (fin-principio == 1) {
			String lnActiva = this.get(principio);
			StringBuilder marca = new StringBuilder(" ");
			marca.append(lnActiva);
			int punto = lnActiva.indexOf('.');
			do {
				marca.insert(0, '#');
				punto = lnActiva.indexOf('.', punto+1);
			} while (punto>0 && punto != (lnActiva.length()-1));
			this.set(principio, marca.toString());
		}
		this.add(principio, "ppp");
		fin++;
		this.add(fin, "fff");
		principio = principio + 2 - p;
		fin = fin + 1 - f;
	}
}
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		this.forEach(ln -> cadena.append(ln + "\n"));
		return cadena.toString();
	}

	public void eliminaLnDuplicadas() {
		Iterator<String> it = this.iterator();
		String ln = "";
		while (it.hasNext()) {
			if (it.next().equals(ln))
				it.remove();
			ln = it.next();
		}
	}


}
