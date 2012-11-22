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
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
		<div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro ancho85 alto75P">
			<html:form action="/IrConfirmarDatosUsuarioAction.do" method="post">
				<fieldset class="fondoAzulMedio bordeNulo relleno0 margen2 alto100P">
					<legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco textoRojoClaro bordeCerrado bordeGrisMedio">
		        		Datos de alta del usuario
		        	</legend>
					<div id="div-vacio" class="alto50"></div>
	                <div id="User-div" class="alto50">
	                    <label for="user" class="texto100 col20"><strong>Usuario:&nbsp;</strong></label>
	                    <html:text property="user" size="20" maxlength="20" styleClass="fondoBlanco" title="Introducir usuario"></html:text>
	                </div>
	                <div id="Password-div" class="alto50">
	                    <label for="Password" class="texto100 col20"><strong>Contraseña:&nbsp;</strong></label>
	                    <html:password property="password" size="20" maxlength="20" styleClass="fondoBlanco" title="Introducir contraseña"></html:password>
	                </div>
	                <div id="Password2-div" class="alto50">
	                    <label for="Password" class="texto100 col20"><strong>Repetir contraseña:&nbsp;</strong></label>
	                    <html:password property="password2" size="20" maxlength="20" styleClass="fondoBlanco" title="Repetir contraseña"></html:password>
	                </div>                            
					<div id="tipo_nifcif-div" class="alto50">
	                    <label for="tipo_nifcif" class="texto100 col20"><strong>Tipo documento:&nbsp;</strong></label>
						<html:select name="tipoDocumentoSeleccionado" property="idTipoDocumento" styleClass="fondoBlanco" title="Seleccionar tipo de documento">
						    <html:optionsCollection name="tipoDocumento" value="idTipoDocumento" label="descripcion"/>
						</html:select>
	                 </div>                                              
	                 <div id="nifcif-div" class="alto50">
	                    <label for="nifcif" class="texto100 col20"><strong>N.I.F./C.I.F:&nbsp;</strong></label>
	                    <html:text property="nifcif" size="9" maxlength="9" styleClass="fondoBlanco" title="Introducir NIF"></html:text>
	                 </div>                            
	                 <div id="email-div" class="alto50">
	                    <label for="email" class="texto100 col20"><strong>Correo electrónico:&nbsp;</strong></label>
	                    <html:text property="email" size="100" maxlength="30" styleClass="fondoBlanco" title="Introducir dirección de correo electrónico"></html:text>
	                 </div>
	                 <div id="email2-div" class="alto50">
	                    <label for="email2" class="texto100 col20"><strong>Repetir correo electrónico:&nbsp;</strong></label>
	                    <html:text property="email2" size="100" maxlength="30" styleClass="fondoBlanco" title="Repetir dirección de correo electrónico"></html:text>
	                 </div>
	                 <div id="tipo_usuario-div" class="alto50">
	                     <label for="tipo_usuario" class="texto100 col20"><strong>Tipo usuario:&nbsp;</strong></label>
	                     <html:select name="tipoUsuarioSeleccionado" property="idTipoUsuario" styleClass="fondoBlanco" title="Seleccionar tipo de usuario">
	                         <html:optionsCollection name="tipoUsuario" value="idTipoUsuario" label="descripcion"/>
	                     </html:select>
	                 </div>     
	                 <div id="botonera" class="alineacionCentrada alineacionVerticalInferior">
	                 	<html:submit title="Aceptar los datos introducidos">Aceptar</html:submit>
	                 </div>
					 <%@include file="../comun/LOPD.jsp"%>
				</fieldset>
			</html:form>
		</div>
		<%@include file="../comun/Salir.jsp"%>		
    </body>
</html:html>