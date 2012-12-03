/**
 * 
 */
package com.evalquiler.comun.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cachorro
 *
 */
public final class UtilidadesFechas {

    public final static String FORMATO_FECHA 	   = "dd-MM-yyyy";
    public final static String FORMATO_FECHA_HORA  = "dd-MM-yyyy HH:mm:ss";
    public final static String FORMATO_FECHA_MYSQL = "yyyy-MM-dd";
	
    public static final String getAhora() {
    	Date fechaDate = new Date();
    	String fechaAlta = null;
    	SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA_HORA);    	
    	try {
    		fechaAlta = formateador.format(fechaDate);
    	} catch (Exception ex) {
    		
    	}
    	return fechaAlta;
	}
    
    public static final String getAhoraSoloDia() {
    	Date fechaDate = new Date();
    	String fechaAlta = null;
    	SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);    	
    	try {
    		fechaAlta = formateador.format(fechaDate);
    	} catch (Exception ex) {
    		
    	}
    	return fechaAlta;
	}
    
    public static final Date getDate(final String strfecha) {
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat(FORMATO_FECHA);
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
    	      SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
    	      fecFormatoDate = new java.sql.Date(sdf.parse(strfecha).getTime());
    	      System.out.println("Fecha con el formato java.sql.Date: " + fecFormatoDate);
    	} catch (Exception ex) {
    	      System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
    	}
    	
    	return fecFormatoDate;
    }

    
    public static final String getStringFromDate(final java.sql.Date dateFecha) {
    	String fecha = null;
    	try {
    	      SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
    	      fecha = sdf.format(dateFecha);
    	} catch (Exception ex) {
    	      System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
    	}
    	
    	return fecha;
    }

    
    public static final String dateSqlToString(final String fechaSql) throws ParseException {
    	String fecha = null;
    	try {
    		SimpleDateFormat sdf1 = new SimpleDateFormat(FORMATO_FECHA);
    		Date fecFormatoDate = new Date(sdf1.parse(fechaSql).getTime());
    		fecha = sdf1.format(fecFormatoDate);
    		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA_MYSQL);
    		fecha = sdf.format(fecFormatoDate);
    	} catch (ParseException e) {
    		throw e;
    	} catch (Exception ex) {
  	      System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
    	}
    	
    	return fecha;
    }
    
    
    public static final boolean tieneFormatoCorrecto(final String strfecha, final String formatoFecha) {
    	boolean formatoCorrecto = false;
    	SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formatoFecha);
    	try {
    		formatoDelTexto.parse(strfecha);
    		formatoCorrecto = true;
    	} catch (ParseException ex) {
    		//Si el formato no es correcto se devuelve false, no hay que lanzar ninguna excepci�n.
    	}
    	
    	return formatoCorrecto;
    }    
    
   
}
