<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Formulario solicitud de informes</title>
    </head>

    <body>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
        <table>
            <thead>
                <th>Formulario solicitud de informes</th>
            </thead>
            <tbody>
	            <tr>
	                <td>
	                    <div class="fondoAzulClaro">
	                        <html:form action="/IrSolicitarInformeAction.do" method="post">
	                            <html:submit property="tipoBoton" value="Aceptar">Aceptar</html:submit>
	                            <html:submit property="tipoBoton" value="Cancelar">Cancelar</html:submit>
	                        </html:form>
	                    </div>
	                </td>
	            </tr>
            </tbody>
        </table>    
    </body>
</html:html>