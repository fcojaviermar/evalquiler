<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Búsqueda de una dirección</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <div id="titulo">
            <H3 class="alineacionCentrada">Últimas encuestas respondidas</H3>

            <fieldset class="bordeGrisOscuro borde1">
                <legend>Datos del usuario</legend>
                <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
	            <div id="tabla" class="fondoRojoMedio">
			        <fieldset class="bordeGrisOscuro borde1 alto200 alineacionIzquierda ancho95">
			            <legend>Resumen de últimas encuestas</legend>
			            <table class="ancho100">
			                <thead>
			                    <tr class="alineacionIzquierda">
			                        <th class="fondoVerdeMedio texto100">Descripción encuesta</th>
		                            <th class="fondoVerdeMedio texto100">Dirección vivienda</th>	                        
			                        <th class="fondoVerdeMedio texto100">Fecha realización</th>
			                        <th class="fondoVerdeMedio texto100">Periodo evaluación</th>
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
	 								<tr>
			                        	<td>Todavía no ha contestado ninguna encuesta.
			                        	</td>
			                        </tr>		                    
			                    </logic:empty>
			                </tbody>
			            </table>
			        </fieldset>
			    </div>
		        <div id="botonera">
	               <html:form action="/IrBusquedaDireccionAction.do" method="post">
	                   <html:submit title="Buscar una dirección">Buscar dirección</html:submit>
	               </html:form>
	            </div>
		    </fieldset>
	    </div>
        <%@include file="../comun/Salir.jsp"%>	    
    </body>
</html:html>