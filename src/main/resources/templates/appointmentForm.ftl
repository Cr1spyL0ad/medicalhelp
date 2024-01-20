<#import "common.ftl" as common>
<@common.pageTemplate>
    <form class="registration-form" method="post" action="/chooseDay">
        <fieldset class="registration-form__fieldset">
            <label>
                Выберите врача
                <select name="doctorId" required>
                    <#list doctorList as doctor>
                        <option value="${doctor.id}">${doctor.name}</option>
                    </#list>
                </select>
            </label>
            <label>
                Выберите день
                <input type="date" name="unfinishedDate" min="${minDate}" max="${maxDate}" />
            </label>
            <button type="submit">Зарегистрироваться</button>
        </fieldset>
    </form>
</@common.pageTemplate>