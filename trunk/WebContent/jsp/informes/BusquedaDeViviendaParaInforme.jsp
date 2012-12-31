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
    	<%@include file="../comun/Logo.jsp"%>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
        <html:form action="/IrSolicitarInformeAction.do" method="post">    
			<fieldset class="bordeGrisOscuro borde1 ancho90 fondoGrisMedio">
			    <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
			    	Datos del usuario
			    </legend>
                <%@include file="../comun/DatosCliente.jsp"%>
                <%@include file="../comun/Obligatorio.jsp"%>			
			    <fieldset class="bordeGrisOscuro fondoBlanco alto200">
			        <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
			        	Buscar una vivienda
			        </legend>
                    <div id="criteriosBusqueda">
                        <div id="User-div" class="alto50">
                            <label for="idTipoVia" class="texto100"><strong >Tipo vía:&nbsp;</strong>
                                    <html:select name="tipoViaSeleccionado" property="idTipoVia" styleClass="fondoBlanco" title="Seleccionar tipo de vía">
                                        <html:optionsCollection name="tipoVia" value="idTipoVia" label="descripcion"/>
                                    </html:select>
                            </label>
                            <label for="nombreVia" class="texto100 alineacionIzquierda"><strong >Nombre vía:&nbsp;</strong>
                                <html:text property="nombreVia" size="100" maxlength="100" styleClass="fondoBlanco" title="Nombre de la vía"></html:text>                  
                            </label>
                            <label for="numeroVia" class="texto100" ><strong >Número vía:&nbsp;</strong>
                                <html:text property="numeroVia" size="3" maxlength="5" styleClass="fondoBlanco" title="Número de la vía"></html:text>                  
                            </label>
                        </div>
                        <div id="User-div" class="alto50">
			                <label for="bloque" class="texto100"><strong >Bloque:&nbsp;</strong>
			                    <html:text property="bloque" size="10" maxlength="10" styleClass="fondoBlanco" title="Bloque en le que está situada la vivienda"></html:text>                  
			                </label>
			                <label for="portal" class="texto100"><strong >Portal:&nbsp;</strong>
			                    <html:text property="portal" size="3" maxlength="5" styleClass="fondoBlanco" title="Portal de la vivienda"></html:text>                  
			                </label>
			                <label for="escalera" class="texto100"><strong >Escalera:&nbsp;</strong>
			                    <html:text property="escalera" size="3" maxlength="5" styleClass="fondoBlanco" title="Escalera de la vivienda"></html:text>                  
			                </label>
			                <label for="planta" class="texto100"><strong >Planta:&nbsp;</strong>
			                    <html:text property="planta" size="3" maxlength="5" styleClass="fondoBlanco" title="Planta de la vivienda"></html:text>                  
			                </label>
			                <label for="puerta" class="texto100"><strong >Puerta:&nbsp;</strong>
			                    <html:text property="puerta" size="3" maxlength="5" styleClass="fondoBlanco" title="Puerta de la vivienda"></html:text>                  
			                </label>
			            </div>
			            <div id="User-div" class="alto50">
                            <label for="provinvia" class="texto100"><strong >(*)Provincia:&nbsp;</strong>
                                <html:select name="elementoProvincia" property="idProvincia" styleClass="fondoBlanco" title="Seleccionar la provincia donde está la vivienda">
                                    <html:optionsCollection name="comboProvincia" value="idProvincia" label="descripcion"/>
                                </html:select>                          
                                <html:submit property="BOTON_PULSADO" value="Cargar municipios" title="Obtener los municipios de la provincia seleccionada."/>
                            </label>
                            <label for="municipio" class="texto100"><strong >Municipio:&nbsp;</strong>
                                <html:select name="elementoMunicipio" property="idMunicipio" styleClass="fondoBlanco" title="Seleccionar el municipio donde está la vivienda">
                                    <html:optionsCollection name="comboMunicipio" value="idMunicipio" label="descripcion"/>
                                </html:select>                          
                            </label>
                            <label for="codigoPostal" class="texto100"><strong >Código Postal:&nbsp;</strong>
                                <html:text property="codigoPostal" size="10" maxlength="10" styleClass="fondoBlanco" title="Código postal de la vivienda"></html:text>                  
                            </label>
			            </div>
<!-- 			            <div id="User-div" class="alto50">
			                <label for="nifPropietario" class="texto100"><strong >N.I.F/C.I.F:&nbsp;</strong>
                                <html:text property="nifPropietario" size="9" maxlength="10"  styleClass="fondoBlanco" title="NIF del propietario de la vivienda"></html:text>                  
			                </label>
			            </div>  
-->			        </div>
                    <div id="botonera" class="alineacionIzquierda alineacionVerticalInferior">
                        <html:submit property="BOTON_PULSADO" value="Buscar" title="Buscar una vivienda"/>
                    </div>
	            </fieldset>
                <%@include file="../comun/Salir.jsp"%>	            
	        </fieldset>
        </html:form>          
    </body>
</html:html>