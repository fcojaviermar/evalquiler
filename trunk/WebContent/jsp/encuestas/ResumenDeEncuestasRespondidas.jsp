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
        <div id="titulo">
            <H3 class="alineacionCentrada">�ltimas encuestas respondidas</H3>
        </div>
	    <fieldset class="bordeGrisOscuro borde1">
            <legend>Datos del usuario</legend>
		    <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
<!--  	    <jsp:include page="../comun/DatosUsuarioEncuesta.jsp"/>-->
	    
	        <fieldset class="bordeGrisOscuro borde1 alto200">
	            <legend>Resumen de �ltimas encuestas</legend>
	            <table class="ancho100">
	                <thead>
	                    <tr class="alineacionIzquierda">
	                        <th class="fondoVerdeMedio texto100">Descripci�n encuesta</th>
                            <th class="fondoVerdeMedio texto100">Direcci�n vivienda</th>	                        
	                        <th class="fondoVerdeMedio texto100">Fecha realizaci�n</th>
	                        <th class="fondoVerdeMedio texto100">Periodo evaluaci�n</th>
	                    </tr>
	                </thead>
	                <tbody>
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
	                </tbody>
	            </table>
	        </fieldset>
	        <div id="botonera">
               <html:form action="/IrBusquedaDireccionAction.do" method="post">
                   <html:submit title="Buscar una direcci�n">Buscar</html:submit>
                   <html:submit title="Volver al listado de encuestas respondidas">Salir</html:submit>
               </html:form>
            </div>
	    </fieldset>
    </body>
</html:html>