<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<div id="datosPersonales" class="alineacionIzquierda fondoAzulMedio">
    <div id="User-div" class="alto25">
        <label for="usuario" title="" class="texto100"><strong >Usuario:&nbsp;</strong>
            <bean:write name="datosClienteActionForm" property="user"/>
        </label>
    </div>
    <div id="Nif-div" class="alto25">
        <label for="nifcif" title="" class="texto100"><strong >N�mero documento:&nbsp;</strong>
            <bean:write name="datosClienteActionForm" property="nifcif"/>
        </label>
    </div>
    <div id="email-div" class="alto25">
        <label for="email" title="" class="texto100"><strong >Direcci�n de correo electr�nico:&nbsp;</strong>
            <bean:write name="datosClienteActionForm" property="email"/>
        </label>
    </div>
</div>