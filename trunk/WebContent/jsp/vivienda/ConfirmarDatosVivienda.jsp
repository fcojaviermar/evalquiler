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
         <fieldset class="bordeGrisOscuro borde1 alto400 ancho90">
             <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
             	Datos del usuario
             </legend>
             <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
             <fieldset class="bordeGrisOscuro borde1 alto300 ancho95">
                 <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
                 	Datos vivienda
                 </legend>
                 <div id="datosVivienda" >
                     <div id="via1-div" class="alto50">
                         <label for="descTipoVia" class="texto100"><strong >Tipo vía:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="descTipoVia"/>
                         <label for="nombreVia" class="texto100 alineacionIzquierda"><strong >Nombre vía:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="nombreVia"/>            
                         <label for="numeroVia" class="texto100" ><strong >Número vía:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="numeroVia"/>
                     </div>
                     <div id="via2-div" class="alto50">
                         <label for="bloque" class="texto100"><strong >Bloque:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="bloque"/>                
		                 <label for="portal" class="texto100"><strong >Portal:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="portal"/>                
		                 <label for="escalera" class="texto100"><strong >Escalera:&nbsp;</strong></label>
		                 <bean:write name="datosViviendaActionForm" property="escalera"/>                                
             	         <label for="planta" class="texto100"><strong >Planta:&nbsp;</strong></label>
		                 <bean:write name="datosViviendaActionForm" property="planta"/>                                
					     <label for="puerta" class="texto100"><strong >Puerta:&nbsp;</strong></label>
                         <bean:write name="datosViviendaActionForm" property="puerta"/>                                
                     </div>
            	     <div id="via3-div" class="alto50">
		                 <label for="codigoPostal" class="texto100"><strong >Código Postal:&nbsp;</strong></label>
             	         <bean:write name="datosViviendaActionForm" property="codigoPostal"/>
					     <label for="municipio" class="texto100"><strong >Municipio:&nbsp;</strong></label>
					     <bean:write name="datosViviendaActionForm" property="municipio"/>
	                     <label for="provinvia" class="texto100"><strong >Provincia:&nbsp;</strong></label>
	                     <bean:write name="datosViviendaActionForm" property="provincia"/>
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