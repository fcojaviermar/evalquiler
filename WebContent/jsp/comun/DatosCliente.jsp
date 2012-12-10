<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div id="datosPersonales" class="alineacionIzquierda fondoAzulMedio">
    <div id="User-div" class="alto25 alineacionIzquierda">
        <label for="usuario" title="" class="texto100 col30"><strong >Usuario:&nbsp;</strong>
            <bean:write name="datosClienteActionForm" property="user"/>
        </label>
        <label for="nifcif" title="" class="texto100 col30"><strong >Número documento:&nbsp;</strong>
            <bean:write name="datosClienteActionForm" property="nifcif"/>
        </label>
    </div>
    <div id="email-div" class="alto25 alineacionIzquierda">
        <label for="email" title="" class="texto100">
            <strong >Dirección de correo electrónico:&nbsp;</strong>
        </label>
        <bean:write name="datosClienteActionForm" property="email"/>        
    </div>
</div>