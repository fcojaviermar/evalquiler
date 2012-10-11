<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listado de viviendasn</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Colorgeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Tipografia.css" media="screen" />        
    </head>
    <body>
		<html:form action="/IrHacerEncuestaAction.do" method="post">    
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
                    <legend>Resumen de encuestas</legend>
                    <table>
                        <thead>
                            <tr>
                                <th>Selección</th>
                                <th>Dirección</th>
                                <th>Tipo vivienda</th>
                                <th>Vivienda</th>
                            </tr>
                        </thead>
                        <tbody>
							<logic:iterate name="listaViviendas" id="listaViviendasEnc" >
	                            <tr>
	                                <th>
	                                	<html:radio name="listaViviendasEnc" property="idVivienda" value=""/>
	                                </th>
	                                <th>
	                                	<bean:write name="listaViviendasEnc" property="nombreVia"/>
									</th>
	                                <th>
	                                	<bean:write name="listaViviendasEnc" property="planta"/>
	                                	<bean:write name="listaViviendasEnc" property="puerta"/>
	                                </th>
	                                <th>Vivienda</th>
	                            </tr>
							</logic:iterate>                                        
		                </tbody>
		                <tfoot>
		                	<tr>
		                		Pie de la tabla
		                	</tr>
		                </tfoot>
		            </table>
		        </fieldset>
                <html:submit property="BOTON_PULSADO" value="Realizar encuesta"/>
                <html:submit property="BOTON_PULSADO" value="Nueva vivienda"/>
                <html:submit property="BOTON_PULSADO" value="Salir"/>
			</fieldset>
		</html:form>        
    </body>
</html:html>