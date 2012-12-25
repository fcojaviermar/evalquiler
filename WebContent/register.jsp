<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@taglib uri="/tags/struts-logic" prefix="logic"%>


<html:html>
    <head>
        <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
        <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Página de registro en Evalquiler</title>
        <link rel="stylesheet" type="text/css" href="css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/Tipografia.css" media="screen" />
    </head>

    <body class="fondoBlanco alineacionCentrada">
        <div class="ancho100 bordeInferior">
            <html:image src="./img/LogoEvalquiler2.jpg"></html:image>
        </div>
        <logic:messagesPresent>
            <div id="errores" class="fondoAmarilloOscuro ancho90 alineacionIzquierda cajaScroll">
                <html:errors/>
            </div>
        </logic:messagesPresent>


        <table class="bordeNulo ancho100">
            <tr>
                <td class="ancho35 bordeNulo">
			        <div>
			        	<p class="textoRojoOscuro texto200">
			                <strong>Evalquiler</strong>
			            </p>
			        	<p class="texto150">
			                <strong>¿Qué es esto?</strong>
			            </p>
			            <p class="texto100">
			                Evalquiler es una aplicación para evaluar la relación entre un inquilino y su arrendador y a la inversa.
			            </p>
			        	<p class="texto150">
			                <strong>¿Cómo rellenar una encuesta?</strong>
			            </p>
			            <p class="texto100">
			                Para rellenar una encuesta primero debe registrarse como usuario si no lo está ya y después iniciar la sesión como usuario y seguir los pasos.
			            </p>
			            <p class="texto150">
			                <strong>¿Cómo consultar la información referida a una vivienda?</strong>
			            </p>
			            <p class="texto100">
			                Para consultar la información primero debe registrarse como usuario si no lo está ya y después iniciar la sesión como cliente y seguir los pasos.
			            </p>
			        </div>
                </td>
                <td class="ancho30 bordeNulo">
                    <div  class="ancho30">
	                    <fieldset class="fondoAzulOscuro bordeGrisOscuro borde1 alto350">
	                        <html:form action="/IrInicioSesionAction.do" method="post">
			                    <div class="alto75" id="label-title-u">
			                        <h2 class="alineacionCentrada alto50">Iniciar sesión usuario<strong></strong></h2>
			                    </div>
			                    <div class="ancho75 alineacionIzquierda" id="label-user">
			                        <label for="user" class="texto100">
			                            <strong>Nombre de usuario:&nbsp;</strong>
			                        </label>
			                    </div>
			                    <div class="alto50" id="label-user2">                       
			                        <html:text property="user" size="50" maxlength="20" styleClass="fondoBlanco" title="Nombre de usuario que inicia la sesión"></html:text>
			                    </div>
			                    <div class="ancho75 alineacionIzquierda" id="label-psw">
			                        <label for="Password" class="texto100">
			                            <strong>Contraseña:&nbsp;</strong>
			                        </label>
			                    </div>
			                    <div class="alto50" id="label-psw-u2">                      
			                        <html:password property="password" size="50" maxlength="20" styleClass="fondoBlanco" title="Contraseña del usuario que inicia la sesión"></html:password>
			                    </div>
			                    <div id="User-div" class="alto75 alineacionCentrada">
			                        <label for="user" class="texto100">Usuario
			                            <html:radio property="tipoRol" value="U" title="Marcar si quiere registrarse como usuario"/>                                
			                        </label>
			                        <label for="client" class="texto100">Cliente
			                            <html:radio property="tipoRol" value="C" title="Marcar si quiere registrarse como cliente"/>
			                        </label>
			                    </div>  
			                    <div class="alto50 alineacionCentrada" id="botones-u">
			                        <html:submit property="BOTON_PULSADO" value="Iniciar sesión"/>
			                        <html:submit property="BOTON_PULSADO" value="Registrarse"/>
			                    </div>
	<!--                        <div>
	                                <html:link styleClass="alto25" href="IrFogotYourUserDataAction.do" title="Olvidaste tus datos">¿No puedes acceder a tu cuenta de usuario?</html:link>
	                            </div>
	-->                     </html:form>
	                    </fieldset>                         
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html:html>