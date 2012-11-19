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
        <html:messages id="mensajes"></html:messages>
        <html:form action="/IrConfirmarRespuestasAction.do" method="post">
            <%int iNumeroPreguntas = 0; %>
		    <fieldset>
		        <legend>Datos del usuario</legend>
		        <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
	
		        <fieldset>
                        <legend><bean:write name="datoRealizacionEncuestaActionForm" property="datosEncuesta.titulo"/></legend>		
                        <div class="fechas-div">
                            <label for="fechaInicioEvaluacionAlquiler"><strong class="user-label">Fecha inicial evaluación (dd-mm-aaaa):&nbsp;</strong></label>
                            <html:text property="fechaInicioEvaluacionAlquiler" size="15" maxlength="10" ></html:text>
                            <label for="fechaFinEvaluacionAlquiler"><strong class="user-label">Fecha final evaluación (dd-mm-aaaa):&nbsp;</strong></label>
                            <html:text property="fechaFinEvaluacionAlquiler" size="15" maxlength="10" ></html:text>
                        </div>

						<logic:iterate name="datoRealizacionEncuestaActionForm" property="datosEncuesta.preguntas" id="preguntasEnc" indexId="indicePregunta">
							<div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro">
								<fieldset class="fondoAzulMedio bordeNulo relleno0 margen2">
									<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco textoRojoClaro bordeCerrado bordeGrisMedio">
										<span>Pregunta </span> 
										<bean:write name="indicePregunta"/>
									</legend>		
									<p class="p1 rellenoIzq12 margenSup0 rellenoSup0 textoAmarilloMedio">
										<bean:write name="preguntasEnc" property="descripcion"/>
									</p>
						    		<p class="margen0 relleno12 fondoAmarilloClaro bordeSuperior bordeAzulOscuro">
						    			<logic:iterate name="preguntasEnc" id="respuestasEnc" property="respuestas">
                                            <bean:define id="valorRespuestaAux">
                                                <bean:write name="respuestasEnc" property="idRespuesta"/>
                                            </bean:define>
											<input type="radio" name="idRespuesta<%=indicePregunta%>" value="<%=valorRespuestaAux%>"/>
                               				<bean:write name="respuestasEnc" property="descripcion"/>
    						    		</logic:iterate>
						    		</p>
						    	</fieldset>
					    	</div>		                            
					    	<%iNumeroPreguntas = iNumeroPreguntas + 1;%>
						</logic:iterate>
                    
		            <input type="hidden" name="NumeroPreguntas" value="<%=String.valueOf(iNumeroPreguntas)%>"/>
                  	<html:submit property="BOTON_PULSADO" value="Responder"/>
                  	<html:submit property="BOTON_PULSADO" value="Cancelar"/>
		    	</fieldset>
			</fieldset>
        </html:form>							
    </body>
</html:html>