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
		<html:form action="/IrAceptarDatosViviendaAction.do" method="post">    	
	        <fieldset>
		        <legend>Datos del usuario</legend>
		        <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
	            <fieldset>
	                <legend>Datos nueva vivienda</legend>
	                    <div id="datosVivienda" >
                            <div id="User-div" class="alto50">
	                            <label for="idTipoVia" class="texto90"><strong >Tipo v�a:&nbsp;</strong>
	                                <html:select name="tipoViaSeleccionado" property="idTipoVia" styleClass="fondoBlanco" title="Seleccionar tipo de v�a">
                                        <html:optionsCollection name="tipoVia" value="idTipoVia" label="descripcion"/>
                                    </html:select>
	                            </label>
	                            <label for="nombreVia" class="texto90 alineacionIzquierda"><strong >Nombre v�a:&nbsp;</strong>
	                                <html:text property="nombreVia" size="100" maxlength="100" styleClass="fondoBlanco" title="Nombre de la v�a"></html:text>                  
	                            </label>
	                            <label for="numeroVia" class="texto90" ><strong >N�mero v�a:&nbsp;</strong>
	                                <html:text property="numeroVia" size="3" maxlength="5" styleClass="fondoBlanco" title="N�mero de la v�a"></html:text>                  
	                            </label>
	                        </div>
	                        <div id="User-div" class="alto50">
	                            <label for="bloque" class="texto90"><strong >Bloque:&nbsp;</strong>
	                                <html:text property="bloque" size="10" maxlength="10" styleClass="fondoBlanco" title="Bloque en le que est� situada la vivienda"></html:text>                  
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
	                            <label for="codigoPostal" class="texto90"><strong >C�digo Postal:&nbsp;</strong>
	                                <html:text property="codigoPostal" size="10" maxlength="10" styleClass="fondoBlanco" title="C�digo postal de la vivienda"></html:text>                  
	                            </label>
	                            <label for="municipio" class="texto90"><strong >Municipio:&nbsp;</strong>
	                                <html:text property="municipio" size="10" maxlength="10" styleClass="fondoBlanco" title="Municipio de la vivienda"></html:text>                  
	                            </label>
	                            <label for="provinvia" class="texto90"><strong >Provincia:&nbsp;</strong>
	                                <html:text property="provincia" size="10" maxlength="10" styleClass="fondoBlanco" title="Provincia de la vivienda"></html:text>                  
	                            </label>
	                            <label for="pais" class="texto90"><strong >Pa�s:&nbsp;</strong>
	                                <html:text property="pais" size="10" maxlength="10" styleClass="fondoBlanco" title="Pa�s de la vivienda"></html:text>                  
	                            </label>
	                        </div>
	                        <div id="User-div" class="alto50">
                                <label for="codigoPostal" title="">Eres el propietario de esta vivienda
                                   <html:checkbox property="esElPropietario" value="true" title="Marcar si eres el propietario de la vivienda"/>                                                
                                </label>	                        
	                        </div>  
	                    </div>			                      
                   </fieldset>
                   <div id="botonera" class="alineacionIzquierda alineacionVerticalInferior">                                               
                       <html:submit property="BOTON_PULSADO" value="Aceptar" title="Aceptar los datos de la vivienda introducidos"/>
                       <html:submit property="BOTON_PULSADO" value="Cancelar" title="Cancelar la operaci�n actual"/>
                   </div>
			</fieldset>
	    </html:form>
		<%@include file="../comun/Salir.jsp"%>		                             
    </body>
</html:html>