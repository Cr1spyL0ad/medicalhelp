<#macro pageTemplate>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Запись к врачу</title>
        <link rel="stylesheet" type="text/css" href="./static/main.css"/>
    </head>
    <body>
        <header>
            <nav>
                <#if auth == "ANONYMOUS">
                    <a class="nav__button" href="/login">Войти</a>
                    <a class="nav__button" href="/registration">Регистрация</a>
                <#else>
                    <a class="nav__button" href="/logout">Выйти</a>
                    <a class="nav__button" href="/profile">Личный кабинет</a>
                </#if>
            </nav>
        </header>
    <#nested>
        <footer>

        </footer>
    </body>
    </html>
</#macro>
