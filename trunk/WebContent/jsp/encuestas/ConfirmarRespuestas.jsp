<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Encuesta a responder</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Colorgeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <html:form action="/IrGuardarRespuestasEncuestaAction.do" method="post">            
            <fieldset>
                <legend>Datos del usuario</legend>
                <dl class="datosSalida">    
                    <dt>Usuario:</dt>
                    <dd><bean:write name="datosUsuario" property="user"/></dd>
                    <dt>Número documento:</dt>
                    <dd>50859114L</dd>
                    <dt>Dirección de correo electrónico:</dt>
                    <dd>fcojaviermar@gmail.com</dd>
                    <dt>Fecha de alta:</dt>
                    <dd>12/10/2010</dd>
                    <dt>Encuestas realizadas:</dt>
                    <dd>3</dd>
                </dl>

                <fieldset>
                        <legend><bean:write name="datosEncuesta" property="titulo"/></legend>                   
                        <logic:iterate name="datosEncuesta" id="preguntasEnc" property="preguntas" indexId="indicePregunta">
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
                                            <html:radio property="respuestas" value="idRespuesta" disabled="true"></html:radio>
                                            <bean:write name="respuestas" property="descripcion"/>
                                        </logic:iterate>
                                    </p>
                                </fieldset>
                            </div>                                  
                        </logic:iterate>
                    <html:submit property="BOTON_PULSADO" value="Responder"/>
                    <html:submit property="BOTON_PULSADO" value="Cancelar"/>
                </fieldset>

                
                <html:submit property="BOTON_PULSADO" value="Guardar"/>
                <html:submit property="BOTON_PULSADO" value="Cancelar"/>
		    </fieldset>
        </html:form>							
    </body>
</html:html>