<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Alta de una nueva vivienda</title>
        <link rel="stylesheet" type="text/css" href="./css/ColorGeneral.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="./css/Tipografia.css" media="screen" />        
    </head>
    <body>
         <table>
             <thead>
                 <tr>
                     <td>
                        <th>Alta nueva vivienda</th>
                 </tr>
             </thead>
             <tbody>
                 <tr>
                    <td>
                        <div id="capaPrincipal">
                            <fieldset>
                                <legend>Datos del usuario</legend>
                                <dl class="datosSalida">    
                                    <dt>Usuario:</dt>
                                    <dd><bean:write name="datosUsuario" property="user"/></dd>
                                    <dt>Número documento:</dt>
                                    <dd>50859114L</dd>
                                    <dt>Dirección de correo electrónico:</dt>
                                    <dd>fcojaviermar@gmail.com</dd>
                                    <dt>Fecha de alta:</dt>
                                    <dd>12/10/2010</dd>
                                    <dt>Encuestas realizadas:</dt>
                                    <dd>3</dd>
                                </dl>
                         
                                <fieldset>
                                    <html:form action="/IrGuardarDatosViviendaAction.do" method="post">
                                        <legend>Datos vivienda</legend>
                                           <p>
                                               <label for="tipoVia" title=""><strong >Tipo vía:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="tipoVia"/>
                                                    <html:hidden name="datosVivienda" property="tipoVia"/>
                                               </label>
                                               <label for="nombreVia" title=""><strong >Nombre vía:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="nombreVia"/>
                                                    <html:hidden name="datosVivienda" property="nombreVia"/>
                                               </label>
                                               <label for="numeroVia" title=""><strong >Número vía:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="numeroVia"/>
                                                    <html:hidden name="datosVivienda" property="numeroVia"/>
                                               </label>
                                           </p>
                                           <p>
                                               <label for="bloque" title=""><strong >Bloque:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="bloque"/>
                                                    <html:hidden name="datosVivienda" property="bloque"/>
                                               </label>
                                               <label for="portal" title=""><strong >Portal:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="portal"/>
                                                    <html:hidden name="datosVivienda" property="portal"/>
                                               </label>
                                               <label for="escalera" title=""><strong >Escalera:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="escalera"/>
                                                    <html:hidden name="datosVivienda" property="escalera"/>
                                               </label>
                                               <label for="planta" title=""><strong >Planta:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="planta"/>
                                                    <html:hidden name="datosVivienda" property="planta"/>
                                               </label>
                                               <label for="puerta" title=""><strong >Puerta:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="puerta"/>
                                                    <html:hidden name="datosVivienda" property="puerta"/>
                                               </label>
                                           </p>
                                           <p>
                                               <label for="codigoPostal" title=""><strong >Código Postal:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="codigoPostal"/>
                                                    <html:hidden name="datosVivienda" property="codigoPostal"/>
                                               </label>
                                               <label for="municipio" title=""><strong >Municipio:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="municipio"/>
                                                    <html:hidden name="datosVivienda" property="municipio"/>
                                               </label>
                                               <label for="provinvia" title=""><strong >Provincia:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="provincia"/>
                                                    <html:hidden name="datosVivienda" property="provincia"/>
                                               </label>
                                               <label for="pais" title=""><strong >pais:&nbsp;</strong>
                                                    <bean:write name="datosVivienda" property="pais"/>
                                                    <html:hidden name="datosVivienda" property="pais"/>
                                               </label>
                                           </p>
                                           <p>
                                               <label for="esElPropietario" title="">Eres el propietario de esta vivienda
                                                   <html:checkbox property="esElPropietario" />                                                
                                               </label>
                                           </p>                                            
                                           <html:submit property="BOTON_PULSADO" value="Guardar"/>
                                           <html:submit property="BOTON_PULSADO" value="Cancelar"/>
                                       </html:form>
                                    </fieldset>                         
                             </fieldset>
                         </div>
                     </td>
                 </tr>
             </tbody>
        </table>
    </body>
</html:html>