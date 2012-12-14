<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div id="datosPersonales" class="alineacionIzquierda fondoGrisMedio">
    <div id="User-div" class="alto25 alineacionIzquierda ancho60">
        <label for="usuario" title="" class="texto100 col40">
            <strong >Usuario:&nbsp;</strong>
            <bean:write name="datosClienteActionForm" property="user"/>
        </label>
        <label for="nifcif" title="" class="texto100 col40">
            <strong >Número documento:&nbsp;</strong>
            <bean:write name="datosClienteActionForm" property="nifcif"/>
        </label>
    </div>
    <div id="email-div" class="alto25 alineacionIzquierda ancho60">
        <label for="email" title="" class="texto100 col60">
            <strong >Dirección de correo electrónico:&nbsp;</strong>
            <bean:write name="datosClienteActionForm" property="email"/>
        </label>
    </div>
</div>