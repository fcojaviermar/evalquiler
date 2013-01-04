<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listado de viviendas encontradas</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />
    </head>
<% String  classLine = "fondoAzulOscuro"; %>    
    <body>
    	<%@include file="../comun/Logo.jsp"%>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
	        <div id="titulo">
		        <fieldset class="bordeGrisOscuro borde1 ancho90 fondoGrisMedio">
		            <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
		            	Datos del usuario
		            </legend>
	                <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
                    <html:form action="/IrHacerEncuestaAction.do" method="post">	                
		                <fieldset class="bordeGrisOscuro borde1 alto325 ancho95 alineacionIzquierda fondoBlanco">
		                    <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
		                    	Resultados de la búsqueda
		                    </legend>
                            <div id="tabla" class="alto300">		                    
		                    <table class="ancho100">
		                        <thead>
		                            <tr class="alineacionIzquierda cabecera">
		                                <th class="texto100">Selección</th>
		                                <th class="texto100">Dirección</th>
		                                <th class="texto100">Piso - Puerta</th>
		                                <th class="texto100">Código postal</th>
		                            </tr>
		                        </thead>
		                        <tbody>
		                            <logic:iterate name="datosViviendaActionForm" id="datosViviendaActionFormEnc" indexId="indiceFila">
<%if (indiceFila.intValue()%2 == 0) {
	classLine = "fondoAzulOscuro";
} else {
	classLine = "fondoBlanco";
}%>
                                        <tr class="<%=classLine%>">
			                                <td class="ancho10">
		                                        <bean:define id="idViviendaAux">
		                                            <bean:write name="datosViviendaActionFormEnc" property="idVivienda"/>
		                                        </bean:define>
		                                        <input type="radio" name="idVivienda" value="<bean:write name="datosViviendaActionFormEnc" property="idVivienda"/>"> 
			                                </td>
			                                <td>
			                                	<bean:write name="datosViviendaActionFormEnc" property="nombreVia"/>
			                                	<bean:write name="datosViviendaActionFormEnc" property="numeroVia"/>
											</td>
			                                <td>
			                                	<bean:write name="datosViviendaActionFormEnc" property="planta"/>&nbsp; - 
			                                	<bean:write name="datosViviendaActionFormEnc" property="puerta"/>
			                                </td>
			                                <td>
			                                    <bean:write name="datosViviendaActionFormEnc" property="codigoPostal"/>
			                                </td>
			                            </tr>
									</logic:iterate>                                        
				                </tbody>
				            </table>
                        </div>
				        <div id="botonera">
	                        <html:submit property="BOTON_PULSADO" value="Realizar encuesta" title = "Realizar la encuesta para la vivienda seleccionada"/>
	                        <html:submit property="BOTON_PULSADO" value="Nueva vivienda" title = "Dar de alta una vivienda"/>
	                        <html:submit property="BOTON_PULSADO" value="Cancelar" title = "Cancelar la operación actual"/>
	                    </div>
				    </fieldset>
                </html:form>				    
            <%@include file="../comun/Salir.jsp"%>				        
   	    </fieldset>
		</div>
   
    </body>
</html:html>