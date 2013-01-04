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
<%int iNumeroPreguntas = 0; %>
        <fieldset class="bordeGrisOscuro borde1 ancho90 fondoGrisMedio">
            <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
	       	   Datos del usuario
	        </legend>
	        <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
	        <html:form action="/IrConfirmarRespuestasAction.do" method="post">			        
	           <fieldset class="bordeGrisOscuro fondoBlanco ancho95">
                     <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
                     	<bean:write name="datosRealizacionEncuestaActionForm" property="datosEncuesta.titulo"/>
                     </legend>	
                     <div id="encuesta">
                      <div class="fechas-div">
                          <label for="fechaInicioEvaluacionAlquiler" class="texto100">
                          	<strong class="user-label">Fecha inicial evaluación (dd-mm-aaaa):&nbsp;</strong>
                          </label>
                          <html:text property="fechaInicioEvaluacionAlquiler" size="15" maxlength="10" ></html:text>
                          <label for="fechaFinEvaluacionAlquiler" class="texto100">
                          	<strong class="user-label">Fecha final evaluación (dd-mm-aaaa):&nbsp;</strong>
                          </label>
                          <html:text property="fechaFinEvaluacionAlquiler" size="15" maxlength="10" ></html:text>
                      </div>
                      <div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro">
                          <logic:iterate name="datosRealizacionEncuestaActionForm" property="datosEncuesta.preguntas" id="preguntasEnc" indexId="indicePregunta">
                            <fieldset class="fondoAzulMedio bordeNulo relleno0 margen2">
								<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
									<span>Pregunta <%=String.valueOf(iNumeroPreguntas + 1)%></span> 
								</legend>		
								<p class="p1 rellenoIzq12 margenSup0 rellenoSup0">
									<bean:write name="preguntasEnc" property="descripcion"/>
								</p>
					    		<p class="margen0 relleno12 fondoBlanco bordeSuperior bordeAzulOscuro">
					    			<logic:iterate name="preguntasEnc" id="respuestasEnc" property="respuestas">
	                                          <bean:define id="valorRespuestaAux">
	                                              <bean:write name="respuestasEnc" property="idRespuesta"/>
	                                          </bean:define>
										<input type="radio" name="idRespuesta<%=indicePregunta%>" value="<%=valorRespuestaAux%>"/>
	                             		<bean:write name="respuestasEnc" property="descripcion"/>
	  						    	</logic:iterate>
					    		</p>
					    	</fieldset>
                              <%iNumeroPreguntas = iNumeroPreguntas + 1;%>
				    </logic:iterate>
                      </div>                    
                   <div>
	                 <input type="hidden" name="NumeroPreguntas" value="<%=String.valueOf(iNumeroPreguntas)%>"/>
                 	     <html:submit property="BOTON_PULSADO" value="Responder" title = "Responder encuesta"/>
                 	     <html:submit property="BOTON_PULSADO" value="Cancelar" title = "Cancelar la operación actual"/>
                   </div>                  	
                </div>
	    	</fieldset>
	                </html:form>				    	
			<%@include file="../comun/Salir.jsp"%>
   	   </fieldset>
    </body>
</html:html>