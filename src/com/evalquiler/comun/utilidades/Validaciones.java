package com.evalquiler.comun.utilidades;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validaciones {

	private final static String PATRON_EMAIL = "[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-zA-Z0-9_-]+[.[a-zA-Z0-9]+]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
	private final static String PATRON_CIF = "[A-Za-z0-9]{9}$";
	private final static String PATRON_PRIMER_DIGITO_CIF = "[ABCDEFGHKLMNPQS]";

	private final static String[] LETRAS_NIF = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E","T"};
	private final static String[] LISTA_LETRAS_ULTIMO_DIGITO_CIF = {"J","A","B","C","D","E","F","G","H","I"};
	private final static String[] LISTA_NUMEROS_ULTIMO_DIGITO_CIF = {"0","2","4","6","8","1","3","5","7","9"};

	
	
	public final static boolean emailValido(final String email) {         
		final Pattern p = Pattern.compile(PATRON_EMAIL); 
		final Matcher m = p.matcher(email);
		return m.matches();
	}
	
	
	public final static boolean nifValido(final String nif) {
		int numero 	  = Integer.parseInt(nif.substring(0, nif.length()-1));
		String letra  = nif.substring(nif.length()-1, 1);
		int resto 	  = numero % 23;
		
		//String letraResultante = letras.substring(resto, resto+1);
  
		if (letra.equals(LETRAS_NIF[resto])) { 
			return true;
		} else {
			return false;
		}
	}
	

/* El primer digito es una letra que indica el tipo de la organizacion y puede ser una de los siguientes:
	    A - Sociedad An�nima.
	    B - Sociedad de responsabilidad limitada.
	    C - Sociedad colectiva.
	    D - Sociedad comanditaria.
	    E - Comunidad de bienes.
	    F - Sociedad cooperativa.
	    G - Asociacion.
	    H - Comunidad de propietarios.
	    K - Formato antiguo.
	    L - Formato antiguo.
	    M - Formato antiguo.
	    N - Formato antiguo.
	    P - Corporacion local.
	    Q - Organismo autonomo
	    S - Organo de la administracion. */
	//La funcion recibe el CIF completo: A58818501
	public final static boolean cifValido(final String cif) {
		boolean esValido = false;
		 
		final Pattern p1 = Pattern.compile(PATRON_CIF); //un CIF consta de 9 digitos
		final Matcher m1 = p1.matcher(cif);
		if (m1.matches()) {
			final Pattern p2 = Pattern.compile(PATRON_PRIMER_DIGITO_CIF);
			final Matcher m2 = p2.matcher(cif.substring(0, 1));
			if (m2.matches()) { //El primer digito es incorrecto, debe ser una letra de las siguientes: A,B,C,D,E,F,G,H,K,L,M,N,P,Q,S
				int temp = 0;
				for (int i=2; i<=6; i+=2 ) {
					temp = temp + Integer.parseInt(LISTA_NUMEROS_ULTIMO_DIGITO_CIF[Integer.parseInt(cif.substring(i-1, 1))]);
					temp = temp + Integer.parseInt(cif.substring(i, 1));
				}
			   
				temp = temp + Integer.parseInt(LISTA_NUMEROS_ULTIMO_DIGITO_CIF[Integer.parseInt(cif.substring(7,1))]);
				temp = 10 - (temp % 10);
				  	
				//CIF de pruebas: A58818501, probar uno que acabe en J
				String digitoControl = cif.substring(8,1);
				try {
					int numero = Integer.parseInt(digitoControl);
					if (numero == temp) {
						esValido = true;
					} 
				} catch (NumberFormatException e) {
					String letra = LISTA_LETRAS_ULTIMO_DIGITO_CIF[temp];
					if (letra.equals(digitoControl)) {
						esValido = true;
					} 
				}
			}
		}
		return esValido;
	}
	
	public final static boolean nieValido(final String nie) {
		boolean esValido = false;
		final Pattern p1 = Pattern.compile("[X-Z0-9]{1}[0-9]{7}$"); 
		final Matcher m1 = p1.matcher(nie);
		if (m1.matches()) {
			char primerDigito = nie.charAt(0);
			switch (primerDigito) {
				case 'X':
					nie.replace('X', '0');
					break;
				case 'Y':
					nie.replace('Y', '1');
					break;
				case 'Z':
					nie.replace('Z', '2');
					break;
				default: esValido = false;
					break;
			}
			
			esValido = nifValido(nie);
		}
		return esValido;
	}

}
