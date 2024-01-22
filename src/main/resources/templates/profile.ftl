<#import "common.ftl" as common>
<@common.pageTemplate>
    <h2>Ваши записи</h2>
    <table class="usersTable">
        <tr class="tableHeader">
            <td>Врач</td>
            <td>Кабинет</td>
            <td>Время</td>
        </tr>
        <#foreach tableRow in table>
            <tr class="tableBody">
                <td class="tableBody-info_cell">${tableRow.name}</td>
                <td class="tableBody-info_cell">${tableRow.cabinet}</td>
                <td class="tableBody-info_cell">${tableRow.time}</td>
                <td class="tableBody-button_cell">
                    <form action="/profile/deleteSlot" method="post">
                        <input type="hidden" name="slotId" value="${tableRow.slotId}"/>
                        <button type="submit">Отменить</button>
                    </form>
                </td>
            </tr>
        </#foreach>

    </table>
</@common.pageTemplate>