/**
 * 
 */
package com.evalquiler.comun.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author cachorro
 *
 */
public final class UtilidadesFechas {

    public static final String getAhora() {
    	SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	Date fechaDate = new Date();
    	String fechaAlta = formateador.format(fechaDate);
    	return fechaAlta;
	}
    
    
    public static final Date getDate(final String strfecha) {
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
    	Date fecha = null;
    	try {
    		fecha = formatoDelTexto.parse(strfecha);
    	} catch (ParseException ex) {
    		
    	}
    	
    	return fecha;
    }
    
    
    public static final java.sql.Date getDateForSql(final String strfecha) {
    	java.sql.Date fecFormatoDate = null;
    	try {
    	      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", new Locale("es", "ES"));
    	      fecFormatoDate = new java.sql.Date(sdf.parse(strfecha).getTime());
    	      System.out.println("Fecha con el formato java.sql.Date: " + fecFormatoDate);
    	} catch (Exception ex) {
    	      System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
    	}
    	
    	return fecFormatoDate;
    }
    
    
    public static final String dateSqlToString(String fechaSql) {
    	String fecha = null;
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		Date fecFormatoDate = new Date(sdf.parse(fechaSql).getTime());
    		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
    		fecha =sdf1.format(fecFormatoDate);
    	} catch (Exception ex) {
  	      System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
    	}
    	
    	return fecha;
    }
}
