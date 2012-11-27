<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div id="datosPersonales" class="alineacionIzquierda fondoAzulMedio">
    <div id="User-div" class="alto25">
        <label for="usuario" title="" class="texto100"><strong >Usuario:&nbsp;</strong>
            <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
            <bean:write name="datosUsuario" property="user"/>
        </label>
    </div>
    <div id="Nif-div" class="alto25">
        <label for="nifcif" title="" class="texto100"><strong >Número documento:&nbsp;</strong>
            <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
            <bean:write name="datosUsuario" property="nifcif"/>
        </label>
    </div>
    <div id="email-div" class="alto25">
        <label for="email" title="" class="texto100"><strong >Dirección de correo electrónico:&nbsp;</strong>
            <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
            <bean:write name="datosUsuario" property="email"/>
        </label>
    </div>
    <div id="fechaAlta-div" class="alto25">
        <label for="fechaAlta" title="" class="texto100"><strong >Fecha alta:&nbsp;</strong>
            <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
        </label>
    </div>	
    <div id="NumEncuestas-div" class="alto25">
        <label for="fechaAlta" title="" class="texto100"><strong >Encuestas realizadas:&nbsp;</strong>
            <bean:define name="datosRealizacionEncuestaActionForm" property="datosUsuario" id="datosUsuario"/>  
        </label>
    </div>
</div>