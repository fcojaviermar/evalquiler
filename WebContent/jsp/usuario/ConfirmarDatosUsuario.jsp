<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>ConfirmarDatosUsuario.jsp</title>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <div class="signin-box">
                        <h2>Confirmar datos de alta del usuario<strong></strong></h2>
						<table>
                            <tr>
                                <td align="center">Tipo documento:
                                    <bean:write name="datosUsuario" property="descTipoDocumento"/>
                                    <bean:define id="id" name="datosUsuario" property="id"/>
                                    <html:hidden property="tipoDocumentoSeleccionado" value="<%=(String)id %>"/>
                                </td>
                            </tr>
							<tr>
						     	<td align="center">N.I.F./C.I.F.:
			                        <bean:write name="datosUsuario" property="nifcif"/>
			                        <html:hidden name="datosUsuario" property="nifcif"/>
			                    </td>
							</tr>
							<tr>
						     	<td align="center">Usuario:
			                        <bean:write name="datosUsuario" property="user"/>
			                        <html:hidden name="datosUsuario" property="user"/>
			                    </td>
							</tr>
							<tr>
						     	<td align="center">Correo electrónico:
			                        <bean:write name="datosUsuario" property="email"/>
			                        <html:hidden name="datosUsuario" property="email"/>
			                    </td>
							</tr>
						</table>                        
                        <html:form action="/IrAceptarDatosUsuarioAction.do" method="post">
                            <html:submit>Aceptar</html:submit>
                        </html:form>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html:html>