

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
    <section class="registration">
        <h2>Регистрация</h2>
        <form class="registration-form" method="post" action="/registration">
            <fieldset class="registration-form__fieldset">
                <p>${passwordError!""}${usernameError!""}${sizeError!""}</p>
                <label for="username">Логин</label>
                <input class="registration-form__input" name="username" type="text" placeholder="Введите логин" required>
                <label for="password">Пароль</label>
                <input class="registration-form__input"  name="password" type="password" placeholder="Введите пароль" required>
                <label for="passwordConfirm">Повторите пароль</label>
                <input class="registration-form__input"  name="confirmedPassword" type="password" placeholder="Повторите пароль" required>
                <label for="username">fio</label>
                <input class="registration-form__input" name="name" type="text" placeholder="Введите ФИО" required>
                <label for="policyNumber">polis</label>
                <input class="registration-form__input" name="policyNumber" type="number" placeholder="Введите polis" required>
                <label for="passportNumber">passport</label>
                <input class="registration-form__input" name="passportNumber" type="number" placeholder="Введите passport" required>
                <label for="dateOfBirth">dob</label>
                <input class="registration-form__input" name="dateOfBirth" type="date" placeholder="Введите dob" required>
                <button type="submit">Зарегистрироваться</button>
            </fieldset>
        </form>
    </section>
</body>
</html>