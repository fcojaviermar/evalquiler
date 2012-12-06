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
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
        <html:form action="/IrSolicitarInformeAction.do" method="post">    
			<fieldset>
			    <legend>Datos del usuario</legend>
                <%@include file="../comun/DatosCliente.jsp"%>			
			    <fieldset>
			        <legend>Buscar una vivienda</legend>
                    <div id="criteriosBusqueda" >
                        <div id="User-div" class="alto50">
                            <label for="idTipoVia" class="texto90"><strong >Tipo vía:&nbsp;</strong>
                                    <html:select name="tipoViaSeleccionado" property="idTipoVia" styleClass="fondoBlanco" title="Seleccionar tipo de vía">
                                        <html:optionsCollection name="tipoVia" value="idTipoVia" label="descripcion"/>
                                    </html:select>
                            </label>
                            <label for="nombreVia" class="texto90 alineacionIzquierda"><strong >Nombre vía:&nbsp;</strong>
                                <html:text property="nombreVia" size="100" maxlength="100" styleClass="fondoBlanco" title="Nombre de la vía"></html:text>                  
                            </label>
                            <label for="numeroVia" class="texto90" ><strong >Número vía:&nbsp;</strong>
                                <html:text property="numeroVia" size="3" maxlength="5" styleClass="fondoBlanco" title="Número de la vía"></html:text>                  
                            </label>
                        </div>
                        <div id="User-div" class="alto50">
			                <label for="bloque" class="texto90"><strong >Bloque:&nbsp;</strong>
			                    <html:text property="bloque" size="10" maxlength="10" styleClass="fondoBlanco" title="Bloque en le que está situada la vivienda"></html:text>                  
			                </label>
			                <label for="portal" class="texto90"><strong >Portal:&nbsp;</strong>
			                    <html:text property="portal" size="3" maxlength="5" styleClass="fondoBlanco" title="Portal de la vivienda"></html:text>                  
			                </label>
			                <label for="escalera" class="texto90"><strong >Escalera:&nbsp;</strong>
			                    <html:text property="escalera" size="3" maxlength="5" styleClass="fondoBlanco" title="Escalera de la vivienda"></html:text>                  
			                </label>
			                <label for="planta" class="texto90"><strong >Planta:&nbsp;</strong>
			                    <html:text property="planta" size="3" maxlength="5" styleClass="fondoBlanco" title="Planta de la vivienda"></html:text>                  
			                </label>
			                <label for="puerta" class="texto90"><strong >Puerta:&nbsp;</strong>
			                    <html:text property="puerta" size="3" maxlength="5" styleClass="fondoBlanco" title="Puerta de la vivienda"></html:text>                  
			                </label>
			            </div>
			            <div id="User-div" class="alto50">
                            <label for="provinvia" class="texto90"><strong >(*)Provincia:&nbsp;</strong>
                                <html:select name="elementoProvincia" property="idProvincia" styleClass="fondoBlanco" title="Seleccionar tipo de vía">
                                    <html:optionsCollection name="comboProvincia" value="idProvincia" label="descripcion"/>
                                </html:select>                          
                            </label>
                            <label for="municipio" class="texto90"><strong >Municipio:&nbsp;</strong>
                                <html:text property="idMunicipio" size="10" maxlength="10" styleClass="fondoBlanco" title="Municipio de la vivienda"></html:text>                  
                            </label>
                            <label for="codigoPostal" class="texto90"><strong >Código Postal:&nbsp;</strong>
                                <html:text property="codigoPostal" size="10" maxlength="10" styleClass="fondoBlanco" title="Código postal de la vivienda"></html:text>                  
                            </label>
			            </div>
			            <div id="User-div" class="alto50">
			                <label for="nifPropietario" class="texto90"><strong >N.I.F/C.I.F:&nbsp;</strong>
                                <html:text property="nifPropietario" size="9" maxlength="10"  styleClass="fondoBlanco" title="NIF del propietario de la vivienda"></html:text>                  
			                </label>
			            </div>  
			        </div>               
	            </fieldset>
                <div id="botonera" class="alineacionIzquierda alineacionVerticalInferior">
                    <html:submit property="BOTON_PULSADO" value="Buscar" title="Buscar una vivienda"/>
                </div>
	        </fieldset>
        </html:form>          
        <%@include file="../comun/Salir.jsp"%>              
    </body>
</html:html>