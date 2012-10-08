/**
 * 
 */
package com.evalquiler.comun.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cachorro
 *
 */
public class UtilidadesFechas {

    public String getAhora() {
    	SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date fechaDate = new Date();
    	String fechaAlta = formateador.format(fechaDate);
    	return fechaAlta;
	}
}
