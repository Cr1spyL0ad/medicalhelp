<#import "common.ftl" as common>
<@common.pageTemplate>
    <h2>Регистрация</h2>
    <form class="login-form" method="post" action="/registration">
        <fieldset class="login-form__fieldset">
            <label>
                Логин<br>
                <input class="login-form__input" name="username" type="text" placeholder="Введите логин" required>
            </label>
            <label>
                Пароль<br>
                <input class="login-form__input"  name="password" type="password" placeholder="Введите пароль" required>
            </label>
            <label>
                Повторите пароль<br>
                <input class="login-form__input"  name="confirmedPassword" type="password" placeholder="Повторите пароль" required>
            </label>
            <label>
                ФИО<br>
                <input class="login-form__input" name="name" type="text" placeholder="Иванов Игорь Александрович" required>
            </label>
            <label>
                Страховой полис<br>
                <input class="login-form__input" name="policyNumber" type="number" placeholder="1122 3344 5566 7788" required>
            </label>
            <label>
                Серия и номер паспорта<br>
                <input class="login-form__input" name="passportNumber" type="number" placeholder="12 34 555666" required>
            </label>
            <label>
                Дата рождения<br>
                <input class="login-form__input" name="dateOfBirth" type="date" placeholder="01.01.2000" required>
            </label>
            <button type="submit">Зарегистрироваться</button>
        </fieldset>
    </form>
</@common.pageTemplate>

