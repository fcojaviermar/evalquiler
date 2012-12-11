<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<div class="bordeAmarilloOscuro">
    <logic:messagesPresent>
        <div id="errores" class="col90 cajaScroll">
            <html:errors/>
        </div>
    </logic:messagesPresent>
    <logic:messagesPresent message="true">
        <div id="mensajes" class="col90 cajaScroll">
            <html:messages id="message" message="true">
                <bean:write name="message"/><br/>
            </html:messages>
        </div>
    </logic:messagesPresent>
</div>