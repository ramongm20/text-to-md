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
int diferenciaÍndices = 0;
for (int i=0; i<coincidencias.length; i++) {
	if(coincidencias[i]) {
		int inicioCoincidencia = i;
		while (i < coincidencias.length && coincidencias[i]) {
			i++;
		}
		int finCoincidencia = i;
		if (finCoincidencia-inicioCoincidencia == 1) {
			int índiceLnMarcada = diferenciaÍndices + inicioCoincidencia;
			String ln = this.get(índiceLnMarcada);
			StringBuilder marca = new StringBuilder(" " + ln);
			int punto = ln.indexOf('.');
			do {
				marca.insert(0, '#');
				punto = ln.indexOf('.', punto+1);
			} while (punto>0 && punto != (ln.length()-1));
			this.set(índiceLnMarcada, marca.toString());
		}
		this.add(diferenciaÍndices + inicioCoincidencia, "ppp");
		this.add(++diferenciaÍndices + finCoincidencia, "fff");
		diferenciaÍndices++;
	}
}
	}

	@Override
	public String toString() {
		return this.stream().reduce("", (s1, s2) -> s1 + "\n" + s2).toString();
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
