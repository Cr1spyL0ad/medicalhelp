<#import "common.ftl" as common>
<#import "popup.ftl" as popup>
<@common.pageTemplate>
    <#if tooManySlots??>
        <@popup.pageTemplate "Вы создали слишком много записей"></@popup.pageTemplate>
    </#if>
    <#if noSlots??>
        <@popup.pageTemplate "У вас ещё нет ни одной записи"></@popup.pageTemplate>
    </#if>
    <h1><a href="/appointment">Записаться на приём к специалисту <br>прямо сейчас!</a></h1>
    <a href="/appointment"><img class="index-img" src="img/doctor.png" alt=""></a>
</@common.pageTemplate>