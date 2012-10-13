<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listado de viviendasn</title>
        <link rel="stylesheet" type="text/css" href="./css/Colorgeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />
        <style type="text/css">
            body {
                color: purple;
                background-color: #d8da3d }
                
input[type="radio"] {
    display:inline-block;
    height:20px;
    text-indent:-9999px;
    width:20px;
}

input[type="radio"], .notchecked {
    background:url("notchecked.png") no-repeat;
}

input[type="radio"]:checked, .checked {
    background:url("checked.png") no-repeat;
}                

.checkbox, .radio {
  width: 19px;
  height: 25px;
  padding: 0 5px 0 0;
  background: url(checkbox.png) no-repeat;
  display: block;
  clear: left;
  float: left;
  
}

        </style>
    </head>
    <body>
		<html:form action="/IrHacerEncuestaAction.do" method="post">    
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
                    <legend>Resultados de la búsqueda</legend>
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
							<logic:iterate name="listaViviendas" id="listaViviendasEnc" >
	                            <tr>
	                                <th>
                                        <bean:define id="idViviendaAux">
                                            <bean:write name="listaViviendasEnc" property="idVivienda"/>
                                        </bean:define>
	                                	<html:radio name="listaViviendasEnc" property="idVivienda" value="<%=idViviendaAux%>"/>
	                                	
	                                	<html:radio name="listaViviendasEnc" property="idVivienda" styleClass="checked" value=""/>
	                                	
                                        <input type="radio" name="radioProp" value="<bean:write name="listaViviendasEnc" property="idVivienda"/>"> 
	                                	
	                                </th>
	                                <th>
	                                	<bean:write name="listaViviendasEnc" property="nombreVia"/>
	                                	<bean:write name="listaViviendasEnc" property="numeroVia"/>
									</th>
	                                <th>
	                                	<bean:write name="listaViviendasEnc" property="planta"/>&nbsp; -- 
	                                	<bean:write name="listaViviendasEnc" property="puerta"/>
	                                </th>
	                                <th>Vivienda</th>
	                            </tr>
							</logic:iterate>                                        
		                </tbody>
		            </table>
		        </fieldset>
                <html:submit property="BOTON_PULSADO" value="Realizar encuesta"/>
                <html:submit property="BOTON_PULSADO" value="Nueva vivienda"/>
                <html:submit property="BOTON_PULSADO" value="Salir"/>
			</fieldset>
		</html:form>        
    </body>
</html:html>