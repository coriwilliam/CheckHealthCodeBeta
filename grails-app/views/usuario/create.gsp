<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'Usuario', default: 'Usuario')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<a href="#create-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="create-usuario" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.usuario}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.usuario}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form name="create" url="[action:'save', controller:'usuario']">
        <div>
            <span>Username</span>
            <g:textField name="username" value="${username}" />
        </div>
        <div>
            <span>Name</span>
            <g:textField name="name" value="${name}" />
        </div>
        <div>
            <span>Password</span>
            <g:passwordField name="password" value="${password}" />
        </div>
        <div>
            <span>Role</span>
            <g:select name="role" from="${['ROLE_USER', 'ROLE_ADMIN']}" value="${role}"/>
        </div>
        <g:actionSubmit value="Crear Usuario" action="save" />
    </g:form>
</div>
</body>
</html>

%{--
<fieldset class="form">
    <f:all bean="usuario"/>
</fieldset>
<fieldset class="buttons">
    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
</fieldset>
--}%
