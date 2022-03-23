package pruebas;

public class Pruebas {

	public static void main(String[] args) {
		//
		String dni = "12345678A";
		String digitos = dni;
		digitos = digitos.substring(0, dni.length()-1);
		System.out.println(digitos);
		Character ultimoNumero = dni.charAt(dni.length()-1);
		boolean esLetra = Character.isLetter(ultimoNumero);
		Boolean esNumero;
		try {
			Double.parseDouble(digitos);
			System.out.println("It is numerical string");
			esNumero = true;
		}catch(NumberFormatException e) {
			System.out.println("It is not numerical string");
			esNumero = false;
		}
		System.out.println("ultimo caracter: "+ultimoNumero);
		System.out.println("devuelve true si el ultimo caracter es una letra: "+esLetra);
		System.out.println(esNumero);


	}

}
