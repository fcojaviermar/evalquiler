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
        <title>P�gina de registro en Evalquiler</title>
        <link rel="stylesheet" type="text/css" href="css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/Tipografia.css" media="screen" />
    </head>

    <body class="fondoBlanco alineacionCentrada">
        <div class="ancho100">
            <html:image src="./img/LogoEvalquiler2.jpg"></html:image>
        </div>
        <logic:messagesPresent>
            <div id="errores" class="fondoAmarilloOscuro col90 alineacionIzquierda cajaScroll">
                <html:errors/>
            </div>
        </logic:messagesPresent>
        <logic:messagesNotPresent>
            <div id="errores" class="alto75">
            </div>
        </logic:messagesNotPresent>        
        <logic:messagesPresent message="true">
            <div id="mensajes" class="fondoAmarilloOscuro col90 alineacionIzquierda cajaScroll">
                <html:messages id="message" message="true">
                    <bean:write name="message"/><br/>
                </html:messages>
            </div>
        </logic:messagesPresent>
        <logic:messagesNotPresent message="true">
            <div id="mensajes" class="alto75">
            </div>
        </logic:messagesNotPresent>

        <table class="bordeNulo ancho100">
            <tr>
                <td class="ancho35 bordeNulo">
			        <div>
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
                </td>
                <td class="ancho30 bordeNulo">
                    <div  class="ancho30">
	                    <fieldset class="fondoAzulOscuro bordeGrisOscuro borde1 alto350">
	                        <html:form action="/IrInicioSesionAction.do" method="post">
			                    <div class="alto75" id="label-title-u">
			                        <h2 class="alineacionCentrada alto50">Iniciar sesi�n usuario<strong></strong></h2>
			                    </div>
			                    <div class="ancho75 alineacionIzquierda" id="label-user">
			                        <label for="user" class="texto100">
			                            <strong>Nombre de usuario:&nbsp;</strong>
			                        </label>
			                    </div>
			                    <div class="alto50" id="label-user2">                       
			                        <html:text property="user" size="50" maxlength="20" styleClass="fondoBlanco" title="Nombre de usuario que inicia la sesi�n"></html:text>
			                    </div>
			                    <div class="ancho75 alineacionIzquierda" id="label-psw">
			                        <label for="Password" class="texto100">
			                            <strong>Contrase�a:&nbsp;</strong>
			                        </label>
			                    </div>
			                    <div class="alto50" id="label-psw-u2">                      
			                        <html:password property="password" size="50" maxlength="20" styleClass="fondoBlanco" title="Contrase�a del usuario que inicia la sesi�n"></html:password>
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
			                        <html:submit property="BOTON_PULSADO" value="Iniciar sesi�n"/>
			                        <html:submit property="BOTON_PULSADO" value="Registrarse"/>
			                    </div>
	<!--                        <div>
	                                <html:link styleClass="alto25" href="IrFogotYourUserDataAction.do" title="Olvidaste tus datos">�No puedes acceder a tu cuenta de usuario?</html:link>
	                            </div>
	-->                     </html:form>
	                    </fieldset>                         
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html:html>