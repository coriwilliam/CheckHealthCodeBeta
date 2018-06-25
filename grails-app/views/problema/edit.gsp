<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'problema.label', default: 'Problema')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
       <pre id="editor" style="height:500px; width: inherit;">
public class FactorialMath {
    static int run(int num){
        if (num < 2)
            return 1
        def factorial = (1..num).inject {result, i ->
            result *= i
            result
        }
        factorial
    }
}
        </pre>
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
                    <f:all bean="problema"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
        <asset:javascript src="Ace/src-noconflict/ace.js"/>
        <script>
            var editor = ace.edit("editor");
            editor.session.setMode("ace/mode/groovy");
            editor.setTheme("ace/theme/chrome");

            // enable autocompletion and snippets
            editor.setOptions({
                enableBasicAutocompletion: true,
                enableSnippets: true,
                enableLiveAutocompletion: true,
            });
            //        editor.setReadOnly(true);
        </script>
    </body>
</html>