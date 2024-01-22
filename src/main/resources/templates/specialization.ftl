<#import "common.ftl" as common>
<#import "popup.ftl" as popup>
<@common.pageTemplate>
    <h2>Выберите специальность нужного вам врача</h2>
    <#if noDoctor??>
        <@popup.pageTemplate "На данный момент врачей с такой специальностью нет"></@popup.pageTemplate>
    </#if>
    <ul class="specialization-list">
        <li><a class="specialization-link" href="/appointment/cardiologist">Кардиолог</a></li>
        <li><a class="specialization-link" href="/appointment/therapist">Терапевт</a></li>
        <li><a class="specialization-link" href="/appointment/psychiatrist">Психиатр</a></li>
        <li><a class="specialization-link" href="/appointment/surgeon">Хирург</a></li>
        <li><a class="specialization-link" href="/appointment/allergist">Аллерголог</a></li>
        <li><a class="specialization-link" href="/appointment/oncologist">Онколог</a></li>
    </ul>
</@common.pageTemplate>