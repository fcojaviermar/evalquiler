package com.evalquiler.comun.constantes;

public abstract class Constantes {

	public final static int LONGITUD_NIF_CIF 		 = 9;
	
	public final static int RESULTADO_OK   	 		 = 0;
	public final static int RESULTADO_NOOK 	 		 = 1;
	
	public final static int SIN_REGISTROS    		 = 0;
	
	public final static String LOPD_ACEPTADA 		 = "S";
	
	public final static int ELEMENTO_NO_SELECCIONADO = 0;
	public final static int SIN_NUMERICO_EN_VIA		 = 0;
	
	public final static int MAXIMO_TIPO_VIA 	= 99;
	public final static int MAXIMO_NUMERO_VIA 	= 9999;
	public final static int MAXIMO_PORTAL 		= 99;
	public final static int MAXIMO_CODIGOPOTAL	= 99999;
	public final static int MAXIMA_PROVINCIA	= 54;	
	public final static int MAXIMO_PAIS			= 54;
	
	public final static int LONGITUD_MAXIMA_NOMBREVIA 	= 100;
	public final static int LONGITUD_MAXIMA_BLOQUE 		= 2;
	public final static int LONGITUD_MAXIMA_ESCALERA	= 10;
	public final static int LONGITUD_MAXIMA_PLANTA		= 4;
	public final static int LONGITUD_MAXIMA_PUERTA		= 2;
	public final static int LONGITUD_PASSWORD			= 50;
	public final static int LONGITUD_USUARIO			= 20;
	public final static int LONGITUD_EMAIL				= 100;
	
	public final static String CHECK_SELECCIONADO = "S";
	
	
	
	public final static String PATRON_EMAIL = "[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-zA-Z0-9_-]+[.[a-zA-Z0-9]+]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
	public final static String PATRON_CIF = "[A-Za-z0-9]{9}$";
	public final static String PATRON_PRIMER_DIGITO_CIF = "[ABCDEFGHKLMNPQS]";
	public final static String PATRON_NIE = "[X-Z0-9]{1}[0-9]{7}$";
	
	public final static String[] LETRAS_NIF = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E","T"};
	public final static String[] LISTA_LETRAS_ULTIMO_DIGITO_CIF = {"J","A","B","C","D","E","F","G","H","I"};
	public final static String[] LISTA_NUMEROS_ULTIMO_DIGITO_CIF = {"0","2","4","6","8","1","3","5","7","9"};	
}
