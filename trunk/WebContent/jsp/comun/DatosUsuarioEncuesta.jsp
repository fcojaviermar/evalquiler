<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div id="datosUsuario">
    <br>
       <label for="usuario" title=""><strong >Usuario:&nbsp;</strong>
        <bean:define name="datoRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
           <bean:write name="datosUsuario" property="user"/>
    </label>
    <br>
    <label for="nifcif" title=""><strong >Número documento:&nbsp;</strong>
        <bean:define name="datoRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
        <bean:write name="datosUsuario" property="nifcif"/>
    </label>
    <br>
    <label for="email" title=""><strong >Dirección de correo electrónico:&nbsp;</strong>
        <bean:define name="datoRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
        <bean:write name="datosUsuario" property="email"/>
    </label>
    <br>	    
    <label for="fechaAlta" title=""><strong >Fecha alta:&nbsp;</strong>
        <bean:define name="datoRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
    </label>	
    <br>	    
    <label for="fechaAlta" title=""><strong >Encuestas realizadas:&nbsp;</strong>
        <bean:define name="datoRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
    </label>
</div>

