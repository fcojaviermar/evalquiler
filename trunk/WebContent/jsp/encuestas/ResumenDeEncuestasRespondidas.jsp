<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>B�squeda de una direcci�n</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
        <div id="titulo">
            <H3 class="alineacionCentrada">�ltimas encuestas respondidas</H3>

            <fieldset class="bordeGrisOscuro borde1">
                <legend>Datos del usuario</legend>
                <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
	            <div id="tabla" class="fondoRojoMedio">
			        <fieldset class="bordeGrisOscuro borde1 alto200 alineacionIzquierda ancho95">
			            <legend>Resumen de �ltimas encuestas</legend>
			            <table class="ancho100">
			                <thead>
			                    <tr class="alineacionIzquierda">
			                        <th class="fondoVerdeMedio texto100" title="Breve descripci�n de la encuesta">Descripci�n encuesta</th>
		                            <th class="fondoVerdeMedio texto100" title="Direcci�n de la vivienda evaluada en la encuesta">Direcci�n vivienda</th>	                        
			                        <th class="fondoVerdeMedio texto100" title="Fecha de realizaci�n de la encuesta">Fecha realizaci�n</th>
			                        <th class="fondoVerdeMedio texto100" title="Periodo que evalua la encuesta">Periodo evaluaci�n</th>
			                    </tr>
			                </thead>
			                <tbody>
			                	<logic:notEmpty name="encuestasRespondidas">
			                        <logic:iterate name="encuestasRespondidas" id="encuesta">
			                            <tr>
			                                <td>
			                                    <bean:write name="encuesta" property="datosEncuesta.titulo"/>
			                                </td>
			                                <td>
			                                    <bean:write name="encuesta" property="datosVivienda.nombreVia"/>
			                                    <bean:write name="encuesta" property="datosVivienda.numeroVia"/>
			                                </td>
			                                <td>
			                                    <bean:write name="encuesta" property="fechaRealizacion"/>
			                                </td>
			                                <td>
			                                    <bean:write name="encuesta" property="fechaInicioEvaluacionAlquiler"/> a
			                                    <bean:write name="encuesta" property="fechaFinEvaluacionAlquiler"/>
			                                </td>
			                            </tr>
			                        </logic:iterate>
			                    </logic:notEmpty>
			                    <logic:empty name="encuestasRespondidas">
	 								<tr class="alineacionCentrada">
			                        	<td colspan="4">Todav�a no ha contestado ninguna encuesta.</td>
			                        </tr>		                    
			                    </logic:empty>
			                </tbody>
			            </table>
			        </fieldset>
			    </div>
		        <div id="botonera">
	               <html:form action="/IrBusquedaDireccionAction.do" method="post">
	                   <html:submit property="BOTON_PULSADO" value="Buscar vivienda" title="Buscar una vivienda por su direcci�n"/>
	               </html:form>
	            </div>
		    </fieldset>
	    </div>
        <%@include file="../comun/Salir.jsp"%>	    
    </body>
</html:html>