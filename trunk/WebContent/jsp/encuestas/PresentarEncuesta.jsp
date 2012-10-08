<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Encuesta a responder</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Colorgeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <html:form action="/IrConfirmarRespuestasAction.do" method="post">            
            <table>
                <thead>
                    <tr>
                        <td>
                           <th>Reponder encuesta</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
							<div id="capaPrincipal">
							    <fieldset>
							        <legend>Datos del usuario</legend>
							        <dl class="datosSalida">    
							            <dt>Usuario:</dt>
							            <dd><bean:write name="datosUsuario" property="user"/></dd>
							            <dt>Número documento:</dt>
							            <dd>50859114L</dd>
							            <dt>Dirección de correo electrónico:</dt>
							            <dd>fcojaviermar@gmail.com</dd>
							            <dt>Fecha de alta:</dt>
							            <dd>12/10/2010</dd>
							            <dt>Encuestas realizadas:</dt>
							            <dd>3</dd>
							        </dl>
							
							        <fieldset>
							            <legend>Preguntas de la encuesta</legend>
							        </fieldset>
                                    <html:submit property="BOTON_PULSADO" value="Responder"/>
                                    <html:submit property="BOTON_PULSADO" value="Cancelar"/>
							    </fieldset>
							</div>
					    </td>
					</tr>
                </tbody>
            </table>
        </html:form>							
    </body>
</html:html>