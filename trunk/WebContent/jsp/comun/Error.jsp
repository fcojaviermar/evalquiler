<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Encuesta a responder</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
		<div class="">
			<div id="error" class="banda alineacionVerticalInferior alineacionIzquierda">
			    <label for="labelError"><strong>SE HA PRODUCIDO UN ERROR</strong></label>
				<html:errors/>
			 </div>
			<%@include file="../comun/Salir.jsp"%>
		</div>    
    </body>
</html:html>