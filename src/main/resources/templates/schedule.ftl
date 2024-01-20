<#import "common.ftl" as common>
<@common.pageTemplate>
    <form class="registration-form" method="post" action="/chooseTime">
        <fieldset class="registration-form__fieldset">
            <input type="hidden" name="unfinishedDate" value="${slot.unfinishedDate}">
            <input type="hidden" name="doctorId" value="${slot.doctorId}">
            <#list timeList as time>
                <label>
                    <input type="radio" name="unfinishedTime" value="${time}:00">
                    ${time}
                </label>
            </#list>
            <button type="submit">Зарегистрироваться</button>
        </fieldset>
    </form>
</@common.pageTemplate>