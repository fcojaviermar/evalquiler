<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Alta de una nueva vivienda</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
    	<div>
			<html:form action="/IrAceptarDatosViviendaAction.do" method="post">    	
		        <fieldset>
			        <legend>Datos del usuario</legend>
			        <%@include file="../comun/DatosUsuarioEncuesta.jsp"%>
	               	<div>
			            <fieldset>
			               <legend>Datos vivienda</legend>
	                       <p>
	                           <label for="tipoVia" title=""><strong>Tipo vía:&nbsp;</strong>
	                               <html:text property="tipoVia" size="20" maxlength="20" title="Tipo de vía donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="nombreVia" title=""><strong >Nombre vía:&nbsp;</strong>
	                               <html:text property="nombreVia" size="100" maxlength="100" title="Nombre de vía donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="numeroVia" title=""><strong >Número vía:&nbsp;</strong>
	                               <html:text property="numeroVia" size="3" maxlength="5" title="Numero de vía donde está la vivienda"></html:text>                  
	                           </label>
	                       </p>
	                       <p>
	                           <label for="bloque" title=""><strong >Bloque:&nbsp;</strong>
	                               <html:text property="bloque" size="10" maxlength="2" title="Bloque donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="portal" title=""><strong >Portal:&nbsp;</strong>
	                               <html:text property="portal" size="3" maxlength="2" title="Portal donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="escalera" title=""><strong >Escalera:&nbsp;</strong>
	                               <html:text property="escalera" size="3" maxlength="10" title="Escalera donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="planta" title=""><strong >Planta:&nbsp;</strong>
	                               <html:text property="planta" size="3" maxlength="4" title="Planta donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="puerta" title=""><strong >Puerta:&nbsp;</strong>
	                               <html:text property="puerta" size="3" maxlength="2" title="Puerta donde está la vivienda"></html:text>                  
	                           </label>
	                       </p>
	                       <p>
	                           <label for="codigoPostal" title=""><strong >Código Postal:&nbsp;</strong>
	                               <html:text property="codigoPostal" size="10" maxlength="10" title="Código postal donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="municipio" title=""><strong >Municipio:&nbsp;</strong>
	                               <html:text property="municipio" size="10" maxlength="11" title="Municipio donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="provinvia" title=""><strong >Provincia:&nbsp;</strong>
	                               <html:text property="provincia" size="10" maxlength="2" title="Provincia donde está la vivienda"></html:text>                  
	                           </label>
	                           <label for="pais" title=""><strong >Pais:&nbsp;</strong>
	                               <html:text property="pais" size="10" maxlength="3" title="País donde está la vivienda"></html:text>                  
	                           </label>
	                       </p>
	                       <p>
	                           <label for="codigoPostal" title="">Eres el propietario de esta vivienda
	                               <html:checkbox property="esElPropietario" title="Marcar si eres el propietario de la vivienda"/>                                                
	                           </label>
	                       </p>
	                   </fieldset>
					</div>			                      
			    	<div id="botonera">                                                             
			            <html:submit property="BOTON_PULSADO" value="Aceptar"/>
						<html:submit property="BOTON_PULSADO" value="Cancelar"/>
					</div>
				</fieldset>
			</html:form>
		</div>
		<%@include file="../comun/Salir.jsp"%>		                             
    </body>
</html:html>