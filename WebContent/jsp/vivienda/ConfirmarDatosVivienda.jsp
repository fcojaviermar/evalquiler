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
        <div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro ancho85 alto75P">
            <fieldset class="fondoAzulMedio bordeNulo relleno0 margen2 alto100P">
                <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco textoRojoClaro bordeCerrado bordeGrisMedio">
                    Confirmar datos de alta de la vivienda
                </legend>
                <div id="div-vacio" class="alto50"></div>
                <div id="div-vacio" class="alto50">
					<label for="tipoVia"><strong >Tipo vía:&nbsp;</strong></label>
					<bean:write name="datosVivienda" property="tipoVia"/>
                </div>
                <div id="" class="alto50">          
					<label for="nombreVia"><strong >Nombre vía:&nbsp;</strong></label>
					<bean:write name="datosVivienda" property="nombreVia"/>
                </div>
				<div id="numerovia-div" class="alto50">
					<label for="numeroVia"><strong >Número vía:&nbsp;</strong>
                    <bean:write name="datosVivienda" property="numeroVia"/>				
                </div>
                <div id="" class="alto50">
					<label for="bloque"><strong >Bloque:&nbsp;</strong></label>
                    <bean:write name="datosVivienda" property="bloque"/>                
                </div>
                <div id="" class="alto50">
					<label for="portal"><strong >Portal:&nbsp;</strong></label>
                    <bean:write name="datosVivienda" property="portal"/>                
                </div>
				<div id="escalera-div" class="alto50">
					<label for="escalera"><strong >Escalera:&nbsp;</strong></label>
					<bean:write name="datosVivienda" property="escalera"/>                                
                </div>
				<div id="planta-div" class="alto50">
                	<label for="planta"><strong >Planta:&nbsp;</strong></label>
					<bean:write name="datosVivienda" property="planta"/>                                
                </div>
				<div id="puerta-div" class="alto50">
					<label for="puerta"><strong >Puerta:&nbsp;</strong></label>
                    <bean:write name="datosVivienda" property="puerta"/>                                
                </div>
               	<div id="codigoposta-div" class="alto50">
					<label for="codigoPostal"><strong >Código Postal:&nbsp;</strong></label>
                	<bean:write name="datosVivienda" property="codigoPostal"/>
               	</div>
               	<div id="municipio-div" class="alto50">
					<label for="municipio"><strong >Municipio:&nbsp;</strong></label>
					<bean:write name="datosVivienda" property="municipio"/>
                </div>                                              
                <div id="provincia-div" class="alto50">
	                <label for="provinvia"><strong >Provincia:&nbsp;</strong></label>
	                <bean:write name="datosVivienda" property="provincia"/>
                </div>                            
                <div id=""pais-div" class="alto50">
					<label for="pais"><strong >País:&nbsp;</strong></label>
                    <bean:write name="datosVivienda" property="pais"/>
                </div>
                <div id="check-propietario-div" class="alto50">
					<label for="esElPropietario">Eres el propietario de esta vivienda</label>
                	<html:checkbox property="esElPropietario" />                                                
				</div>     
             </fieldset>
             <div id="botonera" class="alineacionCentrada alineacionVerticalInferior">
                <html:form action="/IrGuardarDatosViviendaAction.do" method="post">
					<html:submit property="BOTON_PULSADO" value="Guardar"/>
                    <html:submit property="BOTON_PULSADO" value="Cancelar"/>                            
                </html:form>
             </div>
        </div>
        <%@include file="../comun/Salir.jsp"%>        
        
        
    </body>
</html:html>