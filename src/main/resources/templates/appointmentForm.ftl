<#import "common.ftl" as common>
<@common.pageTemplate>
    <form class="login-form" method="post" action="/chooseDay">
        <fieldset class="login-form__fieldset">
            <label>
                Выберите врача <br>
                <select  class="login-form__input" name="doctorId" required>
                    <#list doctorList as doctor>
                        <option value="${doctor.id}">${doctor.name}</option>
                    </#list>
                </select>
            </label>
            <label>
                Выберите день <br>
                <input class="login-form__input" type="date" name="unfinishedDate" min="${minDate}" max="${maxDate}" required/>
            </label>
            <button type="submit">Зарегистрироваться</button>
        </fieldset>
    </form>
</@common.pageTemplate>