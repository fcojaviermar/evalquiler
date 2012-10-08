<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listado de viviendasn</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Colorgeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <td>
                       <th>Resultados de la búsqueda</th>
</td>                       
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
                                    <legend>Resumen de encuestas</legend>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Selección</th>
                                                <th>Dirección</th>
                                                <th>Tipo vivienda</th>
                                                <th>Vivienda</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th>
                                                
                                                </th>
                                                <th>C/ Camarillo nº 23 3º A</th>
                                                <th>Piso</th>
                                                <th>Vivienda</th>
                                            </tr>
                                        
                                            <tr>
                                                <th>
                                                
                                                </th>
                                                <td>Calle Camarillo nº1 Bajo B</td>
                                                <td>Piso</td>
                                                <td>Calle Peregil nº5</td>
                                            </tr>
                                            <tr>
                                                <th>
                                                
                                                </th>
                                                <td>Calle Camarena 32 3F</td>
                                                <td>Unifamiliar</td>
                                                <td>Calle Peregil nº5</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </fieldset>
                                <html:form action="/IrHacerEncuestaAction.do" method="post">                                
                                    <html:submit property="BOTON_PULSADO" value="Realizar encuesta"/>
                                    <html:submit property="BOTON_PULSADO" value="Nueva vivienda"/>
                                    <html:submit property="BOTON_PULSADO" value="Salir"/>
                                </html:form>                                    
                            </fieldset>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html:html>