<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>B�squeda de una direcci�n</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Colorgeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <table>
            <thead>
                <th>Resumen de encuestas respondidas</th>
            </thead>
            <tbody>
                <tr>
                    <td>
		        		<div id="capaPrincipal">
						    <fieldset>
						        <legend>Datos del usuario</legend>
						        <dl class="datosSalida">    
						            <dt>Usuario:</dt>
						            <dd><bean:write name="datosInicioSesionActionForm" property="user"/>
						            <dt>N�mero documento:</dt>
						            <dd>50859114L</dd>
						            <dt>Direcci�n de correo electr�nico:</dt>
						            <dd>fcojaviermar@gmail.com</dd>
						            <dt>Fecha de alta:</dt>
						            <dd>12/10/2010</dd>
						            <dt>Encuestas realizadas:</dt>
						            <dd>3</dd>
						        </dl>
						
						        <fieldset>
						            <legend>Resumen de encuestas</legend>
						            <table>
						                <thead>
						                    <tr>
						                        <th>Descripci�n encuestas</th>
						                        <th>Fecha realizaci�n</th>
						                        <th>Vivienda</th>
						                    </tr>
						                </thead>
						                <tbody>
						                    <tr>
						                        <td>Encuesta sobre propietario</td>
						                        <td>12/10/2011</td>
						                        <td>Calle Peregil n�5</td>
						                    </tr>
						                    <tr>
						                        <td>Encuesta sobre propietario</td>
						                        <td>12/10/2012</td>
						                        <td>Calle Peregil n�5</td>
						                    </tr>
						                    <tr>
						                        <td>Encuesta sobre inquilino</td>
						                        <td>12/10/2011</td>
						                        <td>Plaza Col�n n�3</td>
						                    </tr>
						                </tbody>
						            </table>
						        </fieldset>
				                <html:form action="/IrBusquedaDireccionAction.do" method="post">
				                    <html:submit title="Buscar una direcci�n">Buscar</html:submit>
				                    <html:submit title="Volver al listado de encuestas respondidas">Salir</html:submit>
				                </html:form>
						    </fieldset>
		                </div>
		            </td>
		        </tr>
            </tbody>
        </table>            
    </body>
</html:html>