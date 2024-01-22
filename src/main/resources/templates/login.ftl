<#import "common.ftl" as common>
<@common.pageTemplate>
    <h2>Войти в аккаунт</h2>
    <form class="login-form" method="POST" action="/login">
        <fieldset class="login-form__fieldset">
            <label>
                Логин <br>
                <input required class="login-form__input" name="username" type="text" placeholder="Введите логин" autofocus="true"/>
            </label>
            <label>
                Пароль <br>
                <input required class="login-form__input" name="password" type="password" placeholder="Введите пароль"/>
            </label>
            <button type="submit">Войти</button>
        </fieldset>
    </form>
</@common.pageTemplate>

