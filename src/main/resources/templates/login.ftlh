<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Organizer</title>
    <link rel="stylesheet" type="text/css" href="/css/style.x18418.css"/>
</head>
<body>
    <h4><a href="/login">Войти</a></h4>
    <h4><a href="/registration">Registration</a></h4>

        <section>
            <h2>Войти в аккаунт</h2>
            <form class="login-form" method="POST" action="/login">
                <fieldset class="login-form__fieldset">
                    <label for="username">Логин</label>
                    <input class="login-form__input" name="username" type="text" placeholder="Введите логин" autofocus="true"/>
                    <label for="password">Пароль</label>
                    <input class="login-form__input" name="password" type="password" placeholder="Введите пароль"/>
                    <button type="submit">Войти</button>
                </fieldset>
            </form>
        </section>

</body>
</html>