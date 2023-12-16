<#macro pageTemplate title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Organizer</title>
        <link rel="stylesheet" type="text/css" href="/css/style.x18418.css"/>
    </head>
    <body>
    <nav>
        <#if auth == "ANONYMOUS">
            <a class="nav__button" href="/login">Войти</a>
            <a class="nav__button" href="/registration">Регистрация</a>
        <#else>
            <a class="nav__button" href="/logout">Выйти</a>
            <a class="nav__button" href="/profile">Личный кабинет</a>
        </#if>
    </nav>
    <#nested>
    </body>
    </html>
</#macro>