<#import "common.ftl" as common>
<@common.pageTemplate>
    <form class="login-form" method="post" action="/chooseTime">
        <fieldset class="login-form__fieldset">
            <input type="hidden" name="unfinishedDate" value="${slot.unfinishedDate}">
            <input type="hidden" name="doctorId" value="${slot.doctorId}">
            <label>
                Выберите время <br>
                <select  class="login-form__input" name="unfinishedTime" required>
                    <#list timeList as time>
                        <option value="${time}:00">${time}</option>
                    </#list>
                </select>
            </label>
            <button type="submit">Записаться</button>
        </fieldset>
    </form>

</@common.pageTemplate>
