<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
        <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Página de registro en Evalquiler</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Colorgeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Tipografia.css" media="screen" />
    </head>
<!--     
<style type="text/css">
  html, body, div, h1, h2, h3, h4, h5, h6, p, img, dl,
  dt, dd, ol, ul, li, table, tr, td, form, object, embed,
  article, aside, canvas, command, details, fieldset,
  figcaption, figure, footer, group, header, hgroup, legend,
  mark, menu, meter, nav, output, progress, section, summary,
  time, audio, video {
  	margin: 0;
  	padding: 0;
  	border: 0;
  }
  
.signin-box .user-label {
	MARGIN:0px 0px 0.5em; DISPLAY:block; FONT-WEIGHT:bold; -webkit-user-select:none; -moz-user-select:none; user-select:none;
}  
.signin-box .password-label {
	MARGIN:0px 0px 0.5em; DISPLAY:block; FONT-WEIGHT:bold; -webkit-user-select:none; -moz-user-select:none; user-select:none;
}

.signin-box {
	BORDER-BOTTOM:#e5e5e5 1px solid; BORDER-LEFT:#e5e5e5 1px solid; PADDING-BOTTOM:15px; MARGIN:12px 0px 0px; PADDING-LEFT:25px; 
	PADDING-RIGHT:25px; BACKGROUND:#f1f1f1; BORDER-TOP:#e5e5e5 1px solid; BORDER-RIGHT:#e5e5e5 1px solid; PADDING-TOP:20px;
	WIDTH:350px 
}

.g-button {
	BORDER-BOTTOM:#dcdcdc 1px solid; MIN-WIDTH:46px; TEXT-ALIGN:center; BORDER-LEFT:#dcdcdc 1px solid; PADDING-BOTTOM:0px; LINE-HEIGHT:27px; 
	BACKGROUND-COLOR:#f5f5f5; PADDING-LEFT:8px; PADDING-RIGHT:8px; DISPLAY:inline-block; HEIGHT:27px; COLOR:#444; FONT-SIZE:11px; 
	BORDER-TOP:#dcdcdc 1px solid; CURSOR:default; FONT-WEIGHT:bold; BORDER-RIGHT:#dcdcdc 1px solid; PADDING-TOP:0px; 
}

.g-button-submit {
	BORDER-BOTTOM: #3079ed 1px solid; BORDER-LEFT: #3079ed 1px solid; BACKGROUND-COLOR: #4d90fe; COLOR: #fff; BORDER-TOP: #3079ed 1px solid; 
	BORDER-RIGHT: #3079ed 1px solid; text-shadow: 0 1px rgba(0, 0, 0, 0.1)
}

.signin-box LABEL.remember {
	LINE-HEIGHT: 25px; MARGIN: 4px 0px 0px; DISPLAY: inline-block; VERTICAL-ALIGN: top
}

.signin-box .remember-label {
	PADDING-BOTTOM:0px; LINE-HEIGHT:0; PADDING-LEFT:0.4em; PADDING-RIGHT:0px; COLOR:#666; FONT-WEIGHT:normal; PADDING-TOP:0px; 
	
}
</style> -->
    <body>
        <html:errors/>
		<div class="fondoAzulClaro">
		    <h2>Iniciar sesión usuario<strong></strong></h2>
		    <html:form action="/IrInicioSesionUsuarioAction.do" method="post">
		        <div>
		           <label for="user"><strong class="user-label">Usuario:&nbsp;</strong></label>
		           <html:text property="user" size="20" maxlength="20"></html:text>
		        </div>
		        <div>
                   <label for="Password"><strong class="password-label">Contraseña:&nbsp;</strong></label>
                   <html:password property="password" size="20" maxlength="20"></html:password>
		        </div>
                <html:submit property="BOTON_PULSADO" value="Iniciar sesión"/>
                <html:submit property="BOTON_PULSADO" value="Registrarse"/>
            </html:form>
            <html:link styleClass="remember" href="IrFogotYourUserDataAction.do" title="Olvidaste tus datos">¿No puedes acceder a tu cuenta de usuario?</html:link>						    
		</div>

        <div  class="fondoAzulMedio">
            <h2>Iniciar sesión cliente<strong></strong></h2>
            <html:form action="/IrInicioSesionClienteAction.do" method="post">
                <div class="User-div">
                   <label for="user"><strong class="user-label">Usuario:&nbsp;</strong></label>
                   <html:text property="user" size="20" maxlength="20" ></html:text>
                </div>
                <div class="passwd-div">
                    <label for="Password"><strong class="password-label">Contraseña:&nbsp;</strong></label>
                     <html:password property="password" size="20" maxlength="20"></html:password>
                </div>
                      <html:submit property="BOTON_PULSADO" value="Iniciar sesión"/>
                      <html:submit property="BOTON_PULSADO" value="Registrarse"/>
                  </html:form>
                  <html:link styleClass="remember" href="IrFogotYourClientDataAction.do" title="Olvidaste tus datos">¿No puedes acceder a tu cuenta de cliente?</html:link>
        </div>

    </body>
</html:html>