<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Confirmar la solicitud de informe</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen"/>        
    </head>
    <body>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>    

            <fieldset>
                <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
                	Datos del usuario
                </legend>            
                <%@include file="../comun/DatosCliente.jsp"%>
                <fieldset>
                    <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
                    	<bean:write name="datosRealizacionEncuestaActionForm" property="datosEncuesta.titulo"/>
                    </legend>     
                     <div>
                         <label for="texto1" class="texto100">
                         	<strong>El usuario: &nbsp;</strong>
                         </label>
                         <bean:write name="datosSolicitudInformeActionForm" property="datosUsuario.user"/>
                     </div>
                    	<div>
                        	<label for="texto2" class="texto100">
                        		<strong>Solicita informe de tipo:&nbsp;</strong>
                        	</label>
                        	<bean:write name="datosSolicitudInformeActionForm" property="descTipoInforme"/>
                    	</div>
			<div>                        	
                     	<div>
                         	<label for="texto3" class="texto100">
                         		<strong>Sobre la vivienda situada en :&nbsp;</strong>
                         	</label>
                         </div>
                         
                         <bean:define id="datosViviendaAux">
                                     <bean:write name="datosSolicitudInformeActionForm" property="datosVivienda"/>
                                 </bean:define>
                         
                         <div>
                     <div id="via1-div" class="alto50">
                         <label for="descTipoVia" class="texto100">
                         	<strong>Tipo vía:&nbsp;</strong>
                         </label>
                         <bean:write name="datosViviendaAux" property="descTipoVia"/>
                         <label for="nombreVia" class="texto100 alineacionIzquierda">
                         	<strong>Nombre vía:&nbsp;</strong>
                         </label>
                         <bean:write name="datosViviendaAux" property="nombreVia"/>            
                         <label for="numeroVia" class="texto100">
                         	<strong>Número vía:&nbsp;</strong>
                         </label>
                         <bean:write name="datosViviendaAux" property="numeroVia"/>
                     </div>
                     <div id="via2-div" class="alto50">
                         <label for="bloque" class="texto100">
                         	<strong>Bloque:&nbsp;</strong>
                         </label>
                         <bean:write name="datosViviendaAux" property="bloque"/>                
		                 <label for="portal" class="texto100">
		                 	<strong>Portal:&nbsp;</strong>
		                 </label>
                         <bean:write name="datosViviendaAux" property="portal"/>                
		                 <label for="escalera" class="texto100">
		                 	<strong>Escalera:&nbsp;</strong>
		                 </label>
		                 <bean:write name="datosViviendaAux" property="escalera"/>                                
             	         <label for="planta" class="texto100">
             	         	<strong>Planta:&nbsp;</strong></label>
		                 <bean:write name="datosViviendaAux" property="planta"/>                                
					     <label for="puerta" class="texto100">
					     	<strong>Puerta:&nbsp;</strong>
					     </label>
                         <bean:write name="datosViviendaAux" property="puerta"/>                                
                     </div>
            	     <div id="via3-div" class="alto50">
		                 <label for="codigoPostal">
		                 	<strong>Código Postal:&nbsp;</strong>
		                 </label>
             	         <bean:write name="datosViviendaAux" property="codigoPostal"/>
					     <label for="municipio">
					     	<strong>Municipio:&nbsp;</strong>
					     </label>
					     <bean:write name="datosViviendaAux" property="municipio"/>
	                     <label for="provinvia">
	                     	<strong>Provincia:&nbsp;</strong>
	                     </label>
	                     <bean:write name="datosViviendaAux" property="provincia"/>
					     <label for="pais">
					     	<strong>País:&nbsp;</strong>
					     </label>
                         <bean:write name="datosViviendaAux" property="pais"/>
                     </div>
                     	</div>
                     </div>                                                            
                </fieldset>
        		<html:form action="/IrGuardarSolicitudInformeAction.do" method="post">                
	                <div id="botonera">
	                    <html:submit property="BOTON_PULSADO" value="Guardar solicitud" title = "Guardar solicitud de información"/>
	                    <html:submit property="BOTON_PULSADO" value="Cancelar" title = "Cancelar la operación actual"/>
	                </div>
		        </html:form>		
		    </fieldset>
        <%@include file="../comun/Salir.jsp"%>
    </body>
</html:html>