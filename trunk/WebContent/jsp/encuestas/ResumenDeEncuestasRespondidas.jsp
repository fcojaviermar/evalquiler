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
        <div>
            <H3>Resumen de encuestas respondidas</H3>
        </div>
	    <fieldset class="bordeGrisOscuro borde1">
	        <legend>Datos del usuario</legend>
	        <dl class="datosSalida">    
	            <dt>Usuario:</dt>
	            <dd><bean:write name="datosInicioSesionActionForm" property="user"/>
	            <dt>Número documento:</dt>
	            <dd>50859114L</dd>
	            <dt>Dirección de correo electrónico:</dt>
	            <dd>fcojaviermar@gmail.com</dd>
	            <dt>Fecha de alta:</dt>
	            <dd>12/10/2010</dd>
	            <dt>Encuestas realizadas:</dt>
	            <dd>3</dd>
	        </dl>
	
	        <fieldset class="bordeGrisOscuro borde1 alto200">
	            <legend>Resumen de últimas encuestas</legend>
	            <table class="ancho100">
	                <thead>
	                    <tr class="alineacionIzquierda ">
	                        <th class="fondoVerdeMedio texto100">Descripción encuestas</th>
	                        <th>Fecha realización</th>
	                        <th>Vivienda</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr>
	                        <td>Encuesta sobre propietario</td>
	                        <td>12/10/2011</td>
	                        <td>Calle Peregil nº5</td>
	                    </tr>
	                    <tr>
                            <td>Encuesta sobre propietario</td>
                            <td>12/10/2011</td>
                            <td>Calle Peregil nº5</td>
	                    </tr>
	                    <tr>
                            <td>Encuesta sobre propietario</td>
                            <td>12/10/2011</td>
                            <td>Calle Peregil nº5</td>
	                    </tr>
	                </tbody>
	            </table>
	        </fieldset>
	        <div id="botonera">
               <html:form action="/IrBusquedaDireccionAction.do" method="post">
                   <html:submit title="Buscar una dirección">Buscar</html:submit>
                   <html:submit title="Volver al listado de encuestas respondidas">Salir</html:submit>
               </html:form>
            </div>
	    </fieldset>
    </body>
</html:html>