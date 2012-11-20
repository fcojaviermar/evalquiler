<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<div id="ARQpie">
    <div id="botoneraSalir" class="banda alineacionVerticalInferior alineacionCentrada">
   	    <html:form action="/IrFinSesionAction.do" method="post">
	       <html:submit property="BOTON_PULSADO" value="Salir" title="Salir de la aplicación"/>
	   </html:form>
    </div>
</div>