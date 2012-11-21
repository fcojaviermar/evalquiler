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
                                <td align="center">Usuario:
                                    <bean:write name="datosUsuarioActionForm" property="user"/>
                                    <html:hidden name="datosUsuarioActionForm" property="user"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">Tipo documento:
                                    <bean:write name="datosUsuarioActionForm" property="descTipoDocumento"/>
                                    <bean:define id="idTipoDocumento" name="datosUsuarioActionForm" property="idTipoDocumento"/>
                                    <html:hidden property="tipoDocumentoSeleccionado" value="<%=String.valueOf(idTipoDocumento)%>"/>
                                </td>
                            </tr>
							<tr>
						     	<td align="center">N.I.F./C.I.F.:
			                        <bean:write name="datosUsuarioActionForm" property="nifcif"/>
			                        <html:hidden name="datosUsuarioActionForm" property="nifcif"/>
			                    </td>
							</tr>
							<tr>
						     	<td align="center">Correo electrónico:
			                        <bean:write name="datosUsuarioActionForm" property="email"/>
			                        <html:hidden name="datosUsuarioActionForm" property="email"/>
			                    </td>
							</tr>
						</table>                        
                        <html:form action="/IrAceptarDatosUsuarioAction.do" method="post">
                            <html:submit property="BOTON_PULSADO" value="Aceptar"/>                            
                            <html:submit property="BOTON_PULSADO" value="Cancelar"/>                            
                        </html:form>
                    </div>
                </td>
            </tr>
        </table>
        <%@include file="../comun/Salir.jsp"%>        
    </body>
</html:html>