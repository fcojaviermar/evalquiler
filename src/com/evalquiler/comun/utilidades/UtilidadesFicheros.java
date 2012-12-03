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

	public static void escribir(final String cadena) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("c:/prueba.txt", true);
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
