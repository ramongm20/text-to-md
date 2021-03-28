package texttomd;

public class Prueba {

	public static void main(String[] args) {
		String regex = "^[\\d\\.][\\d\\.]*.*";
		String[] cadenas = {"1.1.1. Prueba", "1.1.2 Moncho me hace trabajar", "1.1 Título segundo"};
		for (String s: cadenas)
		System.out.println(s + " "+ s.matches(regex));
		
		
	}

}
