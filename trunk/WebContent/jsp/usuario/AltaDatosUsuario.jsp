<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>AltaDatosUsuario.jsp</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <html:errors/>
		<html:form action="/IrConfirmarDatosUsuarioAction.do" method="post">
			<div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro ancho50">
				<fieldset class="fondoAzulMedio bordeNulo relleno0 margen2">
					<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco textoRojoClaro bordeCerrado bordeGrisMedio">
		        		Datos de alta del usuario
		        	</legend>	
	                <div id="User-div" class="alto25">
	                    <label for="user"><strong class="user-label">Usuario:&nbsp;</strong></label>
	                    <html:text property="user" size="20" maxlength="20" styleClass="fondoBlanco"></html:text>
	                </div>
	                <div id="Password-div" class="alto25">
	                    <label for="Password"><strong class="passwd-label">Contraseña:&nbsp;</strong></label>
	                    <html:password property="password" size="20" maxlength="20" styleClass="fondoBlanco"></html:password>
	                </div>
	                <div id="Password2-div" class="alto25">
	                    <label for="Password"><strong class="passwd-label">Repetir contraseña:&nbsp;</strong></label>
	                    <html:password property="password2" size="20" maxlength="20" styleClass="fondoBlanco"></html:password>
	                </div>                            
					<div id="tipo_nifcif-div" class="alto25">
	                        <label for="tipo_nifcif"><strong class="tipo_nifcif-label">Tipo documento:&nbsp;</strong></label>
						    <html:select name="tipoDocumentoSeleccionado" property="idTipoDocumento" styleClass="fondoBlanco">
						    <html:optionsCollection name="tipoDocumento" value="idTipoDocumento" label="descripcion"/>
						</html:select>
	                 </div>                                              
	                 <div id="nifcif-div" class="alto25">
	                    <label for="nifcif"><strong class="nifcif-label">N.I.F./C.I.F:&nbsp;</strong></label>
	                    <html:text property="nifcif" size="9" maxlength="9" styleClass="fondoBlanco"></html:text>
	                 </div>                            
	                 <div id="email-div" class="alto25">
	                    <label for="email"><strong class="email-label">Correo electrónico:&nbsp;</strong></label>
	                    <html:text property="email" size="50" maxlength="30" styleClass="fondoBlanco"></html:text>
	                 </div>
	                 <div id="email2-div" class="alto25">
	                    <label for="email2"><strong class="email-label">Correo electrónico:&nbsp;</strong></label>
	                    <html:text property="email2" size="50" maxlength="30" styleClass="fondoBlanco"></html:text>
	                 </div>
	                 <div id="tipo_usuario-div" class="alto25">
	                     <label for="tipo_usuario"><strong class="tipo_usuario-label">Tipo usuario:&nbsp;</strong></label>
	                     <html:select name="tipoUsuarioSeleccionado" property="idTipoUsuario" styleClass="fondoBlanco">
	                         <html:optionsCollection name="tipoUsuario" value="idTipoUsuario" label="descripcion"/>
	                     </html:select>
	                 </div>                                              
	                 <div id="botonera" class="alineacionCentrada">
	                 	<html:submit>Aceptar</html:submit>
	                 </div>
				</fieldset>
			</div>  
		</html:form>
		<%@include file="../comun/Salir.jsp"%>		
    </body>
</html:html>