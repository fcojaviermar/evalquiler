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
                                <td align="center">Usuario:
                                    <bean:write name="datosClienteActionForm" property="user"/>
                                    <html:hidden name="datosClienteActionForm" property="user"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">Tipo documento:
                                    <bean:write name="datosClienteActionForm" property="descTipoDocumento"/>
                                    <bean:define id="idTipoDocumento" name="datosClienteActionForm" property="idTipoDocumento"/>
                                    <html:hidden property="tipoDocumentoSeleccionado" value="<%=String.valueOf(idTipoDocumento)%>"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">N.I.F./C.I.F.:
                                    <bean:write name="datosClienteActionForm" property="nifcif"/>
                                    <html:hidden name="datosClienteActionForm" property="nifcif"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">Correo electrónico:
                                    <bean:write name="datosClienteActionForm" property="email"/>
                                    <html:hidden name="datosClienteActionForm" property="email"/>
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