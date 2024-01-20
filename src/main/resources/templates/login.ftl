<#import "common.ftl" as common>
<@common.pageTemplate>
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
</@common.pageTemplate>

