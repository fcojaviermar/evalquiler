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
<% String  classLine = "fondoAzulOscuro"; %>    
    <body>
		<%@include file="../comun/Logo.jsp"%>    
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
        <div id="titulo">
            <fieldset class="bordeGrisOscuro borde1 fondoGrisMedio">
                <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
                	Datos del usuario
                </legend>
                <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
		        <fieldset class="bordeGrisOscuro borde1 alto325 ancho95 alineacionIzquierda fondoBlanco">
		            <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
		            	Resumen de últimas encuestas
		            </legend>
                       <div id="tabla" class="alto300">			            
			            <table class="ancho100">
			                <thead>
			                    <tr class="alineacionIzquierda cabecera">
			                        <th class="texto100" title="Breve descripción de la encuesta">Descripción encuesta</th>
		                            <th class="texto100" title="Dirección de la vivienda evaluada en la encuesta">Dirección vivienda</th>	                        
			                        <th class="texto100" title="Fecha de realización de la encuesta">Fecha realización</th>
			                        <th class="texto100" title="Periodo que evalua la encuesta">Periodo evaluación</th>
			                    </tr>
			                </thead>
			                <tbody>
			                	<logic:notEmpty name="encuestasRespondidas">
			                        <logic:iterate name="encuestasRespondidas" id="encuesta" indexId="indiceFila">
<%if (indiceFila.intValue()%2 == 0) {
	classLine = "fondoAzulOscuro";
} else {
	classLine = "fondoBlanco";
}%>
                                        <tr class="<%=classLine%>">
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
	 								<tr class="alineacionCentrada fondoAzulOscuro">
			                        	<td colspan="4">Todavía no ha contestado ninguna encuesta.</td>
			                        </tr>		                    
			                    </logic:empty>
			                </tbody>
			            </table>
			        </div>
                    <div id="botonera1">
                        <html:form action="/IrBusquedaDireccionAction.do" method="post">
                            <html:submit property="BOTON_PULSADO" value="Buscar vivienda" title="Buscar una vivienda por su dirección"/>
                        </html:form>
                    </div>
		        </fieldset>
                <%@include file="../comun/Salir.jsp"%>		    
            </fieldset>
	    </div>
    </body>
</html:html>