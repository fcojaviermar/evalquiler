<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Confirmación de la solicitud de informe</title>
    </head>

    <body>
        <table>
            <thead>
                <th>Confirmar solicitud de informes</th>
            </thead>
            <tbody>
	            <tr>
	                <td>
	                    <div class="fondoAzulClaro">
	                        <html:form action="/IrConfirmarSolicitudInformeAction.do" method="post">
	                            <html:submit property="BOTON_PULSADO" value="Aceptar">Guardar</html:submit>
	                            <html:submit property="BOTON_PULSADO" value="Cancelar">Cancelar</html:submit>
	                        </html:form>
	                    </div>
	                </td>
	            </tr>
	        </tbody>
        </table>    
    </body>
</html:html>