<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>ConfirmarDatosCliente.jsp</title>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <div class="signin-box">
                        <h2>Confirmar datos de alta del cliente<strong></strong></h2>
                        <table>
                            <tr>
                                <td align="center">Tipo documento:
                                    <bean:write name="datosCliente" property="descTipoDocumento"/>
                                    <bean:define id="id" name="datosCliente" property="id"/>
                                    <html:hidden property="elementoSeleccionado" value="<%= (String)id %>"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">N.I.F./C.I.F.:
                                    <bean:write name="datosCliente" property="nifcif"/>
                                    <html:hidden name="datosCliente" property="nifcif"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">Usuario:
                                    <bean:write name="datosCliente" property="user"/>
                                    <html:hidden name="datosCliente" property="user"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">Correo electrónico:
                                    <bean:write name="datosCliente" property="email"/>
                                    <html:hidden name="datosCliente" property="email"/>
                                </td>
                            </tr>
                        </table>                        
                        <html:form action="/IrAceptarDatosClienteAction.do" method="post">
                            <html:submit>Aceptar</html:submit>
                        </html:form>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html:html>