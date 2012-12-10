<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%
System.out.println ("Pagina register.jsp");
 %>


<html:html>
    <head>
        <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
        <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Página de registro en Evalquiler</title>
        <link rel="stylesheet" type="text/css" href="css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/Tipografia.css" media="screen" />
    </head>

    <body class="fondoBlanco alineacionCentrada">
        <logic:messagesPresent>
            <div id="errores" class="fondoAmarilloOscuro col90 alto100 alineacionIzquierda">
                <html:errors/>
            </div>
        </logic:messagesPresent>
        <logic:messagesNotPresent>
            <div id="errores" class="alto100 alineacionIzquierda">
            </div>
        </logic:messagesNotPresent>        
        <logic:messagesPresent message="true">
            <div id="mensajes" class="fondoAmarilloOscuro col90 alto50 alineacionIzquierda">
                <html:messages id="message" message="true">
                    <bean:write name="message"/><br/>
                </html:messages>
            </div>
        </logic:messagesPresent>
        <logic:messagesNotPresent message="true">
            <div id="mensajes" class="alto50 ">
            </div>
        </logic:messagesNotPresent>
<div class="ancho100">
        <div class="alto350 ancho40">
        	<p>
        		Textos a estilo gmail
        	</p>
        	<p>
        		Textos a estilo gmail
        	</p>
        	<p>
        		Textos a estilo gmail
        	</p>
			<p>
        		Textos a estilo gmail
        	</p>
        </div>
        <div class="ancho35">
            <fieldset class="fondoAzulOscuro bordeGrisOscuro borde1 alto300">
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
<!--                      <div>
                       <html:link styleClass="alto25" href="IrFogotYourUserDataAction.do" title="Olvidaste tus datos">¿No puedes acceder a tu cuenta de usuario?</html:link>
                    </div>
-->                </html:form>
                
            </fieldset>                         
        </div>
 </div>
    </body>
</html:html>