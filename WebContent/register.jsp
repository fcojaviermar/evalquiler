<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%
Logger logger = Logger.getLogger(getClass().getName());
System.out.println ("Pagina register.jsp");

logger.debug("Logging Log4 Debug Statement...");
logger.info("Logging Log4 Info Statement...");
 %>

<%@page import="org.apache.log4j.Logger"%><html:html>
    <head>
        <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
        <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Página de registro en Evalquiler</title>
        <link rel="stylesheet" type="text/css" href="css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/Tipografia.css" media="screen" />
    </head>

    <body class="fondoBlanco">
        <logic:messagesPresent>
            <div id="errores" class="fondoAmarilloOscuro col90 alto100">
                <html:errors/>
            </div>
        </logic:messagesPresent>
        <logic:messagesNotPresent>
            <div id="errores" class="alto100">
            </div>
        </logic:messagesNotPresent>        
        <logic:messagesPresent message="true">
            <div id="mensajes" class="fondoAmarilloOscuro col90 alto50">
                <html:messages id="message" message="true">
                    <bean:write name="message"/><br/>
                </html:messages>
            </div>
        </logic:messagesPresent>
        <logic:messagesNotPresent message="true">
            <div id="mensajes" class="alto50">
            </div>
        </logic:messagesNotPresent>

        <div class="col40 alto350 rellenoIzq12 rellenoDer12">
            <fieldset class="fondoAzulOscuro bordeGrisOscuro borde1 alto300">
                <html:form action="/IrInicioSesionUsuarioAction.do" method="post">
                    <div class="alto75" id="label-title-u">
                        <h2 class="alineacionCentrada alto50">Iniciar sesión usuario<strong></strong></h2>
                    </div>
                    <div class="ancho75" id="label-user1">
                        <label for="user"><strong class="alineacionIzquierda">Nombre de usuario:&nbsp;</strong></label>
                    </div>
                    <div class="alto50 alineacionIzquierda" id="label-user2">                       
                        <html:text property="user" size="50" maxlength="20" styleClass="fondoBlanco"></html:text>
                    </div>
                    <div class="ancho75" id="label-psw-u1">
                        <label for="Password"><strong class="ancho25">Contraseña:&nbsp;</strong></label>
                    </div>
                    <div class="alto50" id="label-psw-u2">                      
                        <html:password property="password" size="50" maxlength="20" styleClass="fondoBlanco"></html:password>
                    </div>
                    <div class="alto50 alineacionCentrada" id="botones-u">
                        <html:submit property="BOTON_PULSADO" value="Iniciar sesión"/>
                        <html:submit property="BOTON_PULSADO" value="Registrarse"/>
                    </div>
                    <div>
                       <html:link styleClass="alto25" href="IrFogotYourUserDataAction.do" title="Olvidaste tus datos">¿No puedes acceder a tu cuenta de usuario?</html:link>
                    </div>
                </html:form>
                
            </fieldset>                         
        </div>

        <div class="col40 alto350 rellenoIzq12 rellenoDer12">
            <fieldset class="fondoAzulOscuro bordeGrisOscuro borde1 alto300">
                <html:form action="/IrInicioSesionClienteAction.do" method="post">
                    <div class="alto75" id="label-title-c">
                        <h2 class="alineacionCentrada alto50">Iniciar sesión cliente<strong></strong></h2>
                    </div>              
                    <div class="ancho75" id="label-client1">
                        <label for="user"><strong class="alineacionIzquierda">Nombre de cliente:&nbsp;</strong></label>
                    </div>
                    <div class="alto50 alineacionIzquierda" id="label-client2">                     
                        <html:text property="user" size="50" maxlength="20" styleClass="fondoBlanco"></html:text>
                    </div>
                    <div class="ancho75" id="label-psw-u1">                     
                        <label for="Password"><strong class="ancho25">Contraseña:&nbsp;</strong></label>
                    </div>
                    <div class="alto50" id="label-psw-u2">                      
                        <html:password property="password" size="50" maxlength="20" styleClass="fondoBlanco"></html:password>
                    </div>
                    <div class="alto50 alineacionCentrada" id="botones-c">
                        <html:submit property="BOTON_PULSADO" value="Iniciar sesión"/>
                        <html:submit property="BOTON_PULSADO" value="Registrarse"/>
                    </div>
                    <div>
                        <html:link styleClass="alto25" href="IrFogotYourClientDataAction.do" title="Olvidaste tus datos">¿No puedes acceder a tu cuenta de cliente?</html:link>                    
                    </div>
                </html:form>
            </fieldset>
        </div>
    </body>
</html:html>