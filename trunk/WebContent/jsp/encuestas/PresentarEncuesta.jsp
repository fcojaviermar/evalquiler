<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Encuesta a responder</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Colorgeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <html:form action="/IrConfirmarRespuestasAction.do" method="post">            
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
		            <legend>Preguntas de la encuesta</legend>
		            <table>
		                <thead>
		                    <tr>
		                        <td>
		                           <th>Reponder encuesta</th>
		                    </tr>
		                </thead>

		                <tbody>
							<logic:iterate name="listaPreguntas" id="listaPreguntasEnc" >
	                            <tr>
	                                <th>
	                                	<html:radio name="listaPreguntasEnc" property="idVivienda" value=""/>
	                                </th>
	                            </tr>
							</logic:iterate>
		                </tbody>

		                <tbody>
		                    <tr>
		                        <td>
						          	<div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro">
										<fieldset class="fondoAzulMedio bordeNulo relleno0 margen2">
											<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco textoRojoClaro bordeCerrado bordeGrisMedio"><span class="oculto">Pregunta</span> 1</legend>		
											<p class="p1 rellenoIzq12 margenSup0 rellenoSup0 textoAmarilloMedio"> Usted calificaría su carga de trabajo habitual como:</p>
									    	<p class="margen0 relleno12 fondoAmarilloClaro bordeSuperior bordeAzulOscuro"> 
										      	<label><input name="encuestaPeriodica1"  type="radio" value="01" />Excesiva</label>
										      	<label><input name="aleatoria1" type="radio" value="02" />Abundante</label>
											    <label><input name="respUnica1" type="radio" value="03" />Adecuada</label>
												<label><input name="anonima1"   type="radio" value="04" />Limitada</label>
												<label><input name="anonima1"   type="radio" value="04" />Insuficiente</label>
										    </p>							
										</fieldset>
						  			</div>
						          	<div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro">
										<fieldset class="fondoAzulMedio bordeNulo relleno0 margen2">
											<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco textoRojoClaro bordeCerrado bordeGrisMedio"><span class="oculto">Pregunta</span> 1</legend>		
											<p class="p1 rellenoIzq12 margenSup0 rellenoSup0 textoAmarilloMedio"> Usted calificaría su carga de trabajo habitual como:</p>
									    	<p class="margen0 relleno12 fondoAmarilloClaro bordeSuperior bordeAzulOscuro"> 
										      	<label><input name="encuestaPeriodica2"  type="radio" value="01" />Excesiva</label>
										      	<label><input name="aleatoria2" type="radio" value="02" />Abundante</label>
											    <label><input name="respUnica2" type="radio" value="03" />Adecuada</label>
												<label><input name="anonima2"   type="radio" value="04" />Limitada</label>
												<label><input name="anonima2"   type="radio" value="04" />Insuficiente</label>
										    </p>							
										</fieldset>
						  			</div>
	                              	<html:submit property="BOTON_PULSADO" value="Responder"/>
	                              	<html:submit property="BOTON_PULSADO" value="Cancelar"/>
							    </td>
							</tr>
		                </tbody>
		            </table>
		    	</fieldset>
			</fieldset>
        </html:form>							
    </body>
</html:html>