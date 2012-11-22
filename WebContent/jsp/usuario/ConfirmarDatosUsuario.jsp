<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Confirmar datos de un usuario</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
        <%@include file="/jsp/comun/MostrarErroresMensajes.jsp"%>
        <div class="bordeCerrado bordeGrisMedio margen10 relleno2 fondoAzulOscuro ancho85 alto75P">
            <fieldset class="fondoAzulMedio bordeNulo relleno0 margen2 alto100P">
                <legend class="texto080 flotarDcha margen0 rellenoSup0 rellenoInf0 rellenoIzq4 rellenoDer4 fondoBlanco textoRojoClaro bordeCerrado bordeGrisMedio">
                    Confirmar datos de alta del usuario
                </legend>
                <div id="div-vacio" class="alto50"></div>
               <div id="User-div" class="alto50">
                   <label for="user" class="texto100 col20"><strong>Usuario:&nbsp;</strong></label>
                   <bean:write name="datosUsuarioActionForm" property="user"/>
               </div>
               <div id="tipo_nifcif-div" class="alto50">
                   <label for="tipo_nifcif" class="texto100 col20"><strong>Tipo documento:&nbsp;</strong></label>
                   <bean:write name="datosUsuarioActionForm" property="descTipoDocumento"/>
                   <bean:define id="idTipoDocumento" name="datosUsuarioActionForm" property="idTipoDocumento"/>
                </div>                                              
                <div id="nifcif-div" class="alto50">
                   <label for="nifcif" class="texto100 col20"><strong>N.I.F./C.I.F:&nbsp;</strong></label>
                   <bean:write name="datosUsuarioActionForm" property="nifcif"/>
                </div>                            
                <div id="email-div" class="alto50">
                   <label for="email" class="texto100 col20"><strong>Correo electrónico:&nbsp;</strong></label>
                   <bean:write name="datosUsuarioActionForm" property="email"/>
                </div>
                <div id="tipo_usuario-div" class="alto50">
                    <label for="tipo_usuario" class="texto100 col20"><strong>Tipo usuario:&nbsp;</strong></label>
                   <bean:define id="idTipoUsuario" name="datosUsuarioActionForm" property="idTipoUsuario"/>
                </div>     
             </fieldset>
             <div id="botonera" class="alineacionCentrada alineacionVerticalInferior">
                <html:form action="/IrAceptarDatosUsuarioAction.do" method="post">
                    <html:submit property="BOTON_PULSADO" value="Aceptar"/>                            
                    <html:submit property="BOTON_PULSADO" value="Cancelar"/>                            
                </html:form>
             </div>
        </div>
        <%@include file="../comun/Salir.jsp"%>                
    </body>
</html:html>