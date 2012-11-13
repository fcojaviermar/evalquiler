<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Búsqueda de una dirección</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <html:form action="/IrBuscarViviendaAction.do" method="post">    
			<fieldset>
			    <legend>Datos del usuario</legend>
			    <dl class="datosSalida">    
			        <dt>Usuario:</dt>
			        <dd>
                        <bean:define name="datoRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
                        <bean:write name="datosUsuario" property="user"/>
                    </dd>  
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
			        <legend>Criterios de búsqueda</legend>
			        <table>
			            <thead>
			                <tr>
			                    <th>Búsqueda de vivienda</th>
			                </tr>
			            </thead>
			            <tbody>
			                <tr>
	                            <td>
						            <p>
						                <label for="idTipoVia" title=""><strong >Tipo vía:&nbsp;</strong>
						                    <html:text property="idTipoVia" size="20" maxlength="20"></html:text>                  
						                </label>
						                <label for="nombreVia" title=""><strong >Nombre vía:&nbsp;</strong>
						                    <html:text property="nombreVia" size="100" maxlength="100"></html:text>                  
						                </label>
						                <label for="numeroVia" title=""><strong >Número vía:&nbsp;</strong>
						                    <html:text property="numeroVia" size="3" maxlength="5"></html:text>                  
						                </label>
						            </p>
						            <p>
						                <label for="bloque" title=""><strong >Bloque:&nbsp;</strong>
						                    <html:text property="bloque" size="10" maxlength="10"></html:text>                  
						                </label>
						                <label for="portal" title=""><strong >Portal:&nbsp;</strong>
						                    <html:text property="portal" size="3" maxlength="5"></html:text>                  
						                </label>
						                <label for="escalera" title=""><strong >Escalera:&nbsp;</strong>
						                    <html:text property="escalera" size="3" maxlength="5"></html:text>                  
						                </label>
						                <label for="planta" title=""><strong >Planta:&nbsp;</strong>
						                    <html:text property="planta" size="3" maxlength="5"></html:text>                  
						                </label>
						                <label for="puerta" title=""><strong >Puerta:&nbsp;</strong>
						                    <html:text property="puerta" size="3" maxlength="5"></html:text>                  
						                </label>
						            </p>
						            <p>
						                <label for="codigoPostal" title=""><strong >Código Postal:&nbsp;</strong>
						                    <html:text property="codigoPostal" size="10" maxlength="10"></html:text>                  
						                </label>
						                <label for="municipio" title=""><strong >Municipio:&nbsp;</strong>
						                    <html:text property="municipio" size="10" maxlength="10"></html:text>                  
						                </label>
						                <label for="provinvia" title=""><strong >Provincia:&nbsp;</strong>
						                    <html:text property="provincia" size="10" maxlength="10"></html:text>                  
						                </label>
						                <label for="pais" title=""><strong >País:&nbsp;</strong>
						                    <html:text property="pais" size="10" maxlength="10"></html:text>                  
						                </label>
						            </p>
						            <p>
						                   <label for="nifPropietario" title=""><strong >N.I.F/C.I.F:&nbsp;</strong>
						                       <html:text property="nifPropietario" size="9" maxlength="10"></html:text>                  
						                   </label>
						            </p>                                            	                            
						            <html:submit title="Buscar una dirección">Buscar</html:submit>
						            <html:submit title="Volver al listado de encuestas respondidas">Salir</html:submit>
	                            </td>
	                        </tr>
	                    </tbody>
	                    <tfoot>
	                       <tr>
	                           <td> Pie de la tabla</td>   
	                       </tr>
	                    </tfoot>
	                </table>
	            </fieldset>
	        </fieldset>
        </html:form>                
    </body>
</html:html>