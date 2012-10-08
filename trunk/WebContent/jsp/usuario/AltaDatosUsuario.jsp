<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>AltaDatosUsuario.jsp</title>
    </head>
    <body>
        <html:errors/>
        <table border="1">
            <tr>
                <td>
                    <div class="signin-box">
                        <h2>Datos de alta del usuario<strong></strong></h2>
                        <html:form action="/IrConfirmarDatosUsuarioAction.do" method="post">
                            <div class="User-div">
                               <label for="user"><strong class="user-label">Usuario:&nbsp;</strong></label>
                               <html:text property="user" size="20" maxlength="20" ></html:text>
                            </div>
                            <div class="Password-div">
                               <label for="Password"><strong class="passwd-label">Contraseña:&nbsp;</strong></label>
                               <html:password property="password" size="20" maxlength="20"></html:password>
                            </div>
                            <div class="Password-div">
                               <label for="Password"><strong class="passwd-label">Repetir contraseña:&nbsp;</strong></label>
                               <html:password property="password2" size="20" maxlength="20"></html:password>
                            </div>                            
							<div class="tipo_nifcif-div">
                                <label for="tipo_nifcif"><strong class="tipo_nifcif-label">Tipo documento:&nbsp;</strong></label>
							    <html:select name="elementoSeleccionado" property="id">
							        <html:optionsCollection name="tipoDocumento" value="id" label="descripcion"/>
							    </html:select>
                            </div>                                              
                            <div class="nifcif-div">
                               <label for="nifcif"><strong class="nifcif-label">N.I.F./C.I.F:&nbsp;</strong></label>
                               <html:text property="nifcif" size="9" maxlength="9" ></html:text>
                            </div>                            
                            <div class="email-div">
                               <label for="email"><strong class="email-label">Correo electrónico:&nbsp;</strong></label>
                               <html:text property="email" size="30" maxlength="30" ></html:text>
                            </div>
                            <html:submit>Aceptar</html:submit>
                        </html:form>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html:html>