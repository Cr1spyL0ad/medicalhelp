<#macro pageTemplate>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Запись к врачу</title>
        <link rel="stylesheet" type="text/css" href="/main.css"/>
    </head>
    <body>
        <header> 
            <div class="logo-block">
                <a class="logo-link" href="/"><img class="logo-link__img" src="/img/logo.png" alt=""></a>
                <a class="logo-text" href="/"><h2>Медицинская организация <br>Healthy Life</h2></a>
            </div>
            <nav>
                <#if auth == "ANONYMOUS">
                    <a class="nav-link" href="/login">Войти</a>
                    <a class="nav-link" href="/registration">Регистрация</a>
                <#else>
                    <a class="nav-link" href="/logout">Выйти</a>
                    <a class="nav-link" href="/profile">Личный кабинет</a>
                </#if>
            </nav>
        </header>
        <main>
            <#nested>
        </main>
        <footer>
            <p>© 2024 Vechtomov Vsevolod Nikolaevich</p>
        </footer>
        <script src="/script/popup.js"></script>
    </body>
    </html>
</#macro>
