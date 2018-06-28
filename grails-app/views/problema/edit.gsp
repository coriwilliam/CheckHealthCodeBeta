<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'problema.label', default: 'Problema')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-problema" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-problema" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.problema}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.problema}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.problema}" method="PUT">
                <g:hiddenField name="version" value="${this.problema?.version}" />
                <fieldset class="form">
                    <f:all bean="problema" except="interfazAtestear,testsDeUnidad"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>

            <div class="fieldcontain required" style="display: none;">
                <label for="interfazAtestear">Interfaz a implementar</label> <br/>
                <g:textArea name="interfazAtestear" id="interfazAtestear"
                            placeholder="" form="problemaForm">

                </g:textArea>
            </div>

            <div class="fieldcontain required" style="display: none;">
                <label for="testsDeUnidad">Interfaz a implementar</label> <br/>
                <g:textArea name="testsDeUnidad" id="testsDeUnidad"
                            placeholder="" form="problemaForm">
                </g:textArea>
            </div>

            <h3>Definicion de Interfaz</h3>
            <pre id="editorInterfaz" class="interfaz" style="height:400px; width: inherit;">
                ${this.problema.interfazAtestear}
            </pre>

            <h3>Tests de Unidad que deberan ejecutar correctamente</h3>
            <pre id="editorTestsUnidad" class="testsUnidad" style="height:400px; width: inherit;">
                ${this.problema.testsDeUnidad}
            </pre>
        </div>
        <asset:javascript src="Ace/src-noconflict/ace.js"/>
        <asset:javascript src="Ace/src-noconflict/ext-language_tools.js"/>

        <script>
            //Para acceder al text en edicion es -> $("#editorTestsUnidad")[0].innerText
            var editorInterfaz = ace.edit("editorInterfaz");
            editorInterfaz.session.setMode("ace/mode/groovy");
            editorInterfaz.setTheme("ace/theme/chrome");

            // enable autocompletion and snippets
            editorInterfaz.setOptions({
                enableBasicAutocompletion: true,
                enableSnippets: true,
                enableLiveAutocompletion: true
            });
            editorInterfaz.setAutoScrollEditorIntoView(true);


            var editorTestsUnidad = ace.edit("editorTestsUnidad");
            editorTestsUnidad.session.setMode("ace/mode/groovy");
            editorTestsUnidad.setTheme("ace/theme/chrome");

            // enable autocompletion and snippets
            editorTestsUnidad.setOptions({
                enableBasicAutocompletion: true,
                enableSnippets: true,
                enableLiveAutocompletion: true
            });
            //        editor.setReadOnly(true);
        </script>
    </body>
</html>
