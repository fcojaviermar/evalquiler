<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Alta de un cliente</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
    	<%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
		<div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro ancho85 alto75P">
    		<html:form action="/IrConfirmarDatosClienteAction.do" method="post">
				<fieldset class="fondoAzulMedio bordeNulo relleno0 margen2 alto100P">
					<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco textoRojoClaro bordeCerrado bordeGrisMedio">
						Datos de alta del cliente
					</legend>        
	            	<div id="div-vacio" class="alto25"></div>
	                <div id="User-div" class="alto25">
	                   <label for="user" class="texto90 col20"><strong>Usuario:&nbsp;</strong></label>
	                   <html:text property="user" size="20" maxlength="20" styleClass="fondoBlanco" title="Introducir usuario"></html:text>
	                </div>
	                <div id="Password-div"  class="alto25">
	                   <label for="Password" class="texto90 col20"><strong>Contrase�a:&nbsp;</strong></label>
	                   <html:password property="password" size="20" maxlength="20" styleClass="fondoBlanco" title="Introducir contrase�a"></html:password>
	                </div>
	                <div id="Password-div" class="alto25">
	                   <label for="Password" class="texto90 col20"><strong>Repetir contrase�a:&nbsp;</strong></label>
	                   <html:password property="password2" size="20" maxlength="20" styleClass="fondoBlanco" title="Repetir contrase�a"></html:password>
	                </div>                            
	                <div id="tipo_nifcif-div" class="alto25">
	                    <label for="tipo_nifcif" class="texto90 col20"><strong>Tipo documento:&nbsp;</strong></label>
						<html:select name="tipoDocumentoSeleccionado" property="idTipoDocumento" styleClass="fondoBlanco" title="Seleccionar tipo de documento">
						   <html:optionsCollection name="tipoDocumento" value="idTipoDocumento" label="descripcion"/>
						</html:select>
	                </div>                                              
	                <div id="nifcif-div" class="alto25">
	                   <label for="nifcif" class="texto90 col20"><strong>N.I.F./C.I.F:&nbsp;</strong></label>
	                   <html:text property="nifcif" size="9" maxlength="9" styleClass="fondoBlanco" title="Introducir NIF"></html:text>
	                </div>                            
	                <div id="email-div" class="alto25">
	                   <label for="email" class="texto90 col20"><strong>Correo electr�nico:&nbsp;</strong></label>
	                   <html:text property="email" size="100" maxlength="30" styleClass="fondoBlanco" title="Introducir direcci�n de correo electr�nico"></html:text>
	                </div>
	                <div id="email2-div" class="alto25">
	                   <label for="email2" class="texto90 col20"><strong>Correo electr�nico:&nbsp;</strong></label>
	                   <html:text property="email2" size="100" maxlength="30" styleClass="fondoBlanco" title="Repetir direcci�n de correo electr�nico"></html:text>
	                </div>
                    <%@include file="../comun/LOPD.jsp"%>
                 	<div id="botonera" class="alineacionCentrada alineacionVerticalInferior">
                        <html:submit property="BOTON_PULSADO" value="Aceptar" title="Aceptar los datos introducidos"/>
                 	</div>
        		</fieldset>
			</html:form>
        </div>
		<%@include file="../comun/Salir.jsp"%>		
    </body>
</html:html>