<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div id="datosPersonales" class="alineacionIzquierda fondoGrisMedio">
    <div id="User-div" class="alto25 alineacionIzquierda">
        <label for="usuario" title="" class="texto100 ancho30">
            <strong >Usuario:&nbsp;</strong>
	        <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
	        <bean:write name="datosUsuario" property="user"/>
        </label>
        <label for="nifcif" title="" class="texto100 ancho20">
            <strong >Número documento:&nbsp;</strong>
	        <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
	        <bean:write name="datosUsuario" property="nifcif"/>
        </label>
        <label for="fechaAlta" title="" class="texto100 ancho20">
            <strong >Fecha alta:&nbsp;</strong>
	        <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>
	        <bean:write name="datosUsuario" property="fechaAlta"/>          
        </label>
    </div>
    <div id="email-div" class="alto25 alineacionIzquierda">
        <label for="email" title="" class="texto100 ancho70">
            <strong >Dirección de correo electrónico:&nbsp;</strong>
            <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
            <bean:write name="datosUsuario" property="email"/>
        </label>
    </div>
</div>