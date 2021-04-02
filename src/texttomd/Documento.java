package texttomd;

import java.util.ArrayList;
import java.util.ListIterator;

public class Documento extends ArrayList<String> {

	private static final long serialVersionUID = 1L;
	
	public void marcaEncabezados() {
		String regex = "(^[\\d]+)(\\.)([\\d\\.]*)(.*)";
		this.add("");
		ListIterator<String> li = this.listIterator();
		do {
			if (li.next().matches(regex)) {
				int encabezados = 0;
				if (!li.previous().equals(""))
					li.add("");
				while (li.hasNext() && li.next().matches(regex)) {
					encabezados++;
				}
				li.previous();
				if (encabezados == 1) {
					li.previous();
					String ln = li.next();
					StringBuilder marca = new StringBuilder(" " + ln);
					int punto = ln.indexOf('.');
					do {
						marca.insert(0, '#');
						punto = ln.indexOf('.', punto+1);
					} while (punto>0 && punto != (ln.length()-1));
					li.set(marca.toString());
				}
				li.add("");
			}
		} while (li.hasNext());
	}

	@Override
	public String toString() {
		return this.stream().reduce("", (s1, s2) -> s1 + "\n" + s2).toString();
	}

	public void eliminaLnDuplicadas() {
		ListIterator<String> li = this.listIterator();
		
		while (li.hasNext()) {
			if (li.next().equals("\n"))
				li.set("");
		}
		li = this.listIterator();
		
		while (li.hasNext()) {
			if (li.next().isBlank()) {
				while (li.hasNext() && li.next().isBlank())
					li.remove();
			}
		}

	}


}
