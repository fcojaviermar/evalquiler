<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Alta de un usuario</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
    	<%@include file="../comun/Logo.jsp"%>
        <%@include file="/jsp/comun/MostrarErroresMensajesRegistro.jsp"%>
        <%@include file="../comun/ObligatorioRegistro.jsp"%>
		<div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro ancho85 alto75P">
			<html:form action="/IrConfirmarDatosUsuarioAction.do" method="post">
				<fieldset class="fondoAzulMedio bordeNulo relleno0 margen2 alto100P">
					<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco bordeCerrado bordeGrisMedio">
		        		Datos de alta del usuario
		        	</legend>
					<div id="div-vacio" class="alto25"></div>
	                <div id="documento-div" class="alto30 alineacionIzquierda ancho100 ">
	                    <label for="user" class="texto90 ancho30"><strong>(*)Usuario:&nbsp;</strong>
	                       <html:text name="datosUsuarioActionForm" property="user" size="20" maxlength="20" styleClass="fondoBlanco" title="Introducir usuario"></html:text>
	                    </label>
                        <label for="nifcif" class="texto90 ancho30"><strong>(*)N.I.F./C.I.F:&nbsp;</strong>
                            <html:text property="nifcif" size="9" maxlength="9" styleClass="fondoBlanco" title="Introducir NIF"></html:text>
                        </label>
                        <label for="tipo_documento" class="texto90 ancho40 margenIzq12"><strong>(*)Tipo documento:&nbsp;</strong>
	                        <html:select name="tipoDocumentoSeleccionado" property="idTipoDocumento" styleClass="fondoBlanco" title="Seleccionar tipo de documento">
	                            <html:optionsCollection name="tipoDocumento" value="idTipoDocumento" label="descripcion"/>
	                        </html:select>
	                    </label>
                    </div>	                
                    <div id="Password-div" class="alto30 alineacionIzquierda ancho100">
                       <label for="Password" class="texto90 ancho30 alineacionIzquierda"><strong>(*)Contraseña:&nbsp;</strong></label>
                       <html:password property="password" size="20" maxlength="20" styleClass="fondoBlanco" title="Introducir contraseña"></html:password>
                       <label for="Password" class="texto90 ancho30 margenIzq12"><strong>(*)Repetir contraseña:&nbsp;</strong></label>
                       <html:password property="password2" size="20" maxlength="20" styleClass="fondoBlanco" title="Repetir contraseña"></html:password>
                    </div>  	                
                    <div id="email-div" class="alto25">
	                    <label for="email" class="texto90 ancho20"><strong>(*)Correo electrónico:&nbsp;</strong></label>
	                    <html:text property="email" size="100" maxlength="30" styleClass="fondoBlanco" title="Introducir dirección de correo electrónico"></html:text>
	                </div>
	                <div id="email2-div" class="alto25">
	                    <label for="email2" class="texto90 ancho20"><strong>(*)Repetir correo electrónico:&nbsp;</strong></label>
	                    <html:text property="email2" size="100" maxlength="30" styleClass="fondoBlanco" title="Repetir dirección de correo electrónico"></html:text>
	                </div>
	                <div id="tipo_usuario-div" class="alto25">
	                     <label for="tipo_usuario" class="texto90 ancho20"><strong>(*)Tipo usuario:&nbsp;</strong></label>
	                     <html:select name="tipoUsuarioSeleccionado" property="idTipoUsuario" styleClass="fondoBlanco" title="Seleccionar tipo de usuario">
	                         <html:optionsCollection name="tipoUsuario" value="idTipoUsuario" label="descripcion"/>
	                     </html:select>
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