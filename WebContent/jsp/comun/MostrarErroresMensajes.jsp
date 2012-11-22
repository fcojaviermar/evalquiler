<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

        <logic:messagesPresent>
            <div id="errores" class="fondoAmarilloOscuro col90 alto100">
                <html:errors/>
            </div>
        </logic:messagesPresent>
        <logic:messagesPresent message="true">
            <div id="mensajes" class="fondoAmarilloOscuro col90 alto50">
                <html:messages id="message" message="true">
                    <bean:write name="message"/><br/>
                </html:messages>
            </div>
        </logic:messagesPresent>
