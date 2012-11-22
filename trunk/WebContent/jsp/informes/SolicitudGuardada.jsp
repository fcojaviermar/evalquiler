<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Solicitud guardada</title>
    </head>

    <body>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
        <table>
            <thead>
                <th>Solicitud de informes guardada</th>
            </thead>
            <tbody>
	            <tr>
	                <td>
	                    <div class="fondoAzulClaro">
	                        El informe te llegará vía email.
	                        <html:form action="/IrFinSesionAction.do" method="post">
	                            <html:submit property="BOTON_PULSADO" value="Salir"></html:submit>
	                            <html:submit property="BOTON_PULSADO" value="Nueva solicitud"></html:submit>
	                        </html:form>
	                    </div>
	                </td>
	            </tr>
	        </tbody>
        </table>    
    </body>
</html:html>