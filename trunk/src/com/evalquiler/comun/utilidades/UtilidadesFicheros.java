/**
 * 
 */
package com.evalquiler.comun.utilidades;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author cachorro
 *
 */
public final class UtilidadesFicheros {

	private static boolean bEscribir = true; 
	
	public static void escribir(final String cadena) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        if (bEscribir) {
	        try {
	        	
	            fichero = new FileWriter("c:/logs/prueba_" + UtilidadesFechas.getAhoraSoloDia() +".txt", true);
	            if (null == fichero) {
	            	fichero = new FileWriter("c:/logs/prueba_" + UtilidadesFechas.getAhoraSoloDia() +".txt");
	            }
	            pw = new PrintWriter(fichero);
	            pw.println(cadena);
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        try {
	        	if (null != fichero)
	        		fichero.close();
	        } catch (Exception e2) {
	          e2.printStackTrace();
	        } 
        } 
	}

}
