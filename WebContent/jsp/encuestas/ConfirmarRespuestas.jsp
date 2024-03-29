<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Encuesta a responder</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
    	<%@include file="../comun/Logo.jsp"%>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>    
        <html:form action="/IrGuardarRespuestasEncuestaAction.do" method="post">        
			<fieldset class="bordeGrisOscuro borde1 ancho90 fondoGrisMedio">				
				<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
                	Datos del usuario
                </legend>            
                <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
                <fieldset class="bordeGrisOscuro fondoBlanco ancho95">
                    <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
                    	<bean:write name="datosRealizacionEncuestaActionForm" property="datosEncuesta.titulo"/>
                    </legend>
                    <div id="encuesta">     
	                    <div>
	                        <label for="fechaInicioEvaluacionAlquiler" class="texto100">
	                        	<strong>Fecha inicial evaluación:&nbsp;</strong>
	                        </label>
	                        <bean:write name="datosRealizacionEncuestaActionForm" property="fechaInicioEvaluacionAlquiler"/>
	                        <label for="fechaFinEvaluacionAlquiler" class="texto100">
	                        	<strong>Fecha final evaluación:&nbsp;</strong>
	                        </label>
	                        <bean:write name="datosRealizacionEncuestaActionForm" property="fechaFinEvaluacionAlquiler"/>
	                    </div>
                        <div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro">                  
		                    <logic:iterate name="datosRealizacionEncuestaActionForm" property="datosEncuesta.preguntas" id="preguntasEnc" indexId="indicePregunta">
		                        <div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro">
		                            <fieldset class="fondoAzulMedio bordeNulo relleno0 margen2">
		                            	<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
		                                    <span>Pregunta <%=String.valueOf(indicePregunta+1)%></span> 
		                                </legend>       
		                                <p class="p1 rellenoIzq12 margenSup0 rellenoSup0">
		                                    <bean:write name="preguntasEnc" property="descripcion"/>
		                                </p>
		                                <bean:define id="idRespuestaDadaAux">
		                                    <bean:write name="preguntasEnc" property="idRespuestaDada"/>
		                                </bean:define>
		                                
		                                <p class="margen0 relleno12 fondoBlanco bordeSuperior bordeAzulOscuro">
		                                    <logic:iterate name="preguntasEnc" property="respuestas" id="respuestasEnc">
		                                        <bean:define id="valorRespuestaAux">
		                                            <bean:write name="respuestasEnc" property="idRespuesta"/>
		                                        </bean:define>
		                                        <logic:equal name="respuestasEnc" property="idRespuesta" value="<%=idRespuestaDadaAux%>">
		                                            <input type="radio" name="idRespuesta<%=indicePregunta%>" checked="checked" disabled="disabled"/>
		                                        </logic:equal>
		                                        <logic:notEqual name="respuestasEnc" property="idRespuesta" value="<%=idRespuestaDadaAux%>">
		                                            <input type="radio" name="idRespuesta<%=indicePregunta%>" disabled="disabled"/>
		                                        </logic:notEqual>
		                                        <bean:write name="respuestasEnc" property="descripcion"/>
		                                    </logic:iterate>
		                                </p>
		                            </fieldset>
		                        </div>                                  
		                    </logic:iterate>
		                </div>
	                    <div id="botonera">
	                        <html:submit property="BOTON_PULSADO" value="Guardar encuesta" title = "Guardar respuestas de la encuesta"/>
	                        <html:submit property="BOTON_PULSADO" value="Cancelar" title = "Cancelar la operación actual"/>
	                    </div>
                    </div>
                </fieldset>
                <%@include file="../comun/Salir.jsp"%>                    
		    </fieldset>
        </html:form>   
    </body>
</html:html>