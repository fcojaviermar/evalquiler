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
    <body>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
		<html:form action="/IrHacerEncuestaAction.do" method="post">
	        <div id="titulo">
		        <fieldset class="bordeGrisOscuro borde1 alto400 ancho90">
		            <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
		            	Datos del usuario
		            </legend>
	                <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
                    <div id="tabla" class="fondoRojoMedio">         
		                <fieldset class="bordeGrisOscuro borde1 alto300 ancho95">
		                    <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
		                    	Resultados de la búsqueda
		                    </legend>
		                    <table class="ancho100">
		                        <thead>
		                            <tr class="alineacionIzquierda">
		                                <th class="fondoVerdeMedio texto100">Selección</th>
		                                <th class="fondoVerdeMedio texto100">Dirección</th>
		                                <th class="fondoVerdeMedio texto100">Tipo vivienda</th>
		                                <th class="fondoVerdeMedio texto100">Vivienda</th>
		                            </tr>
		                        </thead>
		                        <tbody>
		                            <logic:iterate name="datosViviendaActionForm" id="datosViviendaActionFormEnc">
			                            <tr>
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
			                                	<bean:write name="datosViviendaActionFormEnc" property="planta"/>&nbsp; -- 
			                                	<bean:write name="datosViviendaActionFormEnc" property="puerta"/>
			                                </td>
			                                <td>Vivienda</td>
			                            </tr>
									</logic:iterate>                                        
				                </tbody>
				            </table>
				        </fieldset>
				    </div>
			        <div id="botonera">
	                    <html:submit property="BOTON_PULSADO" value="Realizar encuesta" title = "Realizar la encuesta para la vivienda seleccionada"/>
	                    <html:submit property="BOTON_PULSADO" value="Nueva vivienda" title = "Dar de alta una vivienda"/>
	                    <html:submit property="BOTON_PULSADO" value="Cancelar" title = "Cancelar la operación actual"/>
	                </div>
			    </fieldset>
			</div>
		</html:form>   
        <%@include file="../comun/Salir.jsp"%>		     
    </body>
</html:html>