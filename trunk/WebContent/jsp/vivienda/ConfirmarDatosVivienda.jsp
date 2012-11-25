<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Alta de una nueva vivienda</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
         <fieldset>
             <legend>Datos del usuario</legend>
             <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
             <fieldset>
                 <legend>Datos vivienda</legend>
                 <div id="datosVivienda" >
                     <div id="User-div" class="alto50">
                         <label for="idTipoVia" class="texto90"><strong >Tipo vía:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="idTipoVia"/>
                         <label for="nombreVia" class="texto90 alineacionIzquierda"><strong >Nombre vía:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="nombreVia"/>            
                         <label for="numeroVia" class="texto90" ><strong >Número vía:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="numeroVia"/>
                     </div>
                     <div id="" class="alto50">
                         <label for="bloque"><strong >Bloque:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="bloque"/>                
		                 <label for="portal"><strong >Portal:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="portal"/>                
		                 <label for="escalera"><strong >Escalera:&nbsp;</strong></label>
		                 <bean:write name="datosViviendaActionForm" property="escalera"/>                                
             	         <label for="planta"><strong >Planta:&nbsp;</strong></label>
		                 <bean:write name="datosViviendaActionForm" property="planta"/>                                
					     <label for="puerta"><strong >Puerta:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="puerta"/>                                
                     </div>
            	     <div id="codigoposta-div" class="alto50">
		                 <label for="codigoPostal"><strong >Código Postal:&nbsp;</strong></label>
             	         <bean:write name="datosViviendaActionForm" property="codigoPostal"/>
					     <label for="municipio"><strong >Municipio:&nbsp;</strong></label>
					     <bean:write name="datosViviendaActionForm" property="municipio"/>
	                     <label for="provinvia"><strong >Provincia:&nbsp;</strong></label>
	                     <bean:write name="datosViviendaActionForm" property="provincia"/>
					     <label for="pais"><strong >País:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="pais"/>
                     </div>
                     <div id="check-propietario-div" class="alto50">
					     <label for="esElPropietario">Eres el propietario de esta vivienda: 
					         <logic:equal name="datosViviendaActionForm" property="esElPropietario" value="true">
                                Si
                             </logic:equal>
                             <logic:notEqual name="datosViviendaActionForm" property="esElPropietario" value="true">
                                No
                             </logic:notEqual>
					     </label>
				     </div>     
	            </div>
	         </fieldset>
             <div id="botonera" class="alineacionIzquierda alineacionVerticalInferior">
                 <html:form action="/IrGuardarDatosViviendaAction.do" method="post">
                     <html:submit property="BOTON_PULSADO" value="Guardar" title="Guardar los datos de la nueva vivienda"/>
                     <html:submit property="BOTON_PULSADO" value="Cancelar" title = "Cancelar la operación actual"/>                            
                 </html:form>
             </div>
         </fieldset>
         <%@include file="../comun/Salir.jsp"%>        
    </body>
</html:html>