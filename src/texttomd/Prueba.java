package texttomd;

public class Prueba {

	public static void main(String[] args) {
		String regex = "";
		String[] cadenas = {"1.1.1. Prueba"};
		for (String s: cadenas)
		System.out.println(s + " "+ s.matches(regex));
		
		
	}

}
