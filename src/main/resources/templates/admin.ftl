<#import "common.ftl" as common>
<@common.pageTemplate>
    <form class="login-form" method="post" action="/admin/add">
        <fieldset class="login-form__fieldset">
            <label>
                ФИО <br>
                <input pattern="[А-Яа-яЁё\ы]{10,50}" class="login-form__input" type="text" name="name" required/>
            </label>
            <label>
                Кабинет <br>
                <input class="login-form__input" type="number" name="cabinetNumber" pattern="[0-9]{,3}" required/>
            </label>
            <label>
                Выберите специальность <br>
                <select  class="login-form__input" name="specialization" required>
                    <option value="therapist">Терапевт</option>
                    <option value="cardiologist">Кардиолог</option>
                    <option value="psychiatrist">Психиатр</option>
                    <option value="surgeon">Хирург</option>
                    <option value="allergist">Аллерголог</option>
                    <option value="oncologist">Онколог</option>
                </select>
            </label>
            <button type="submit">Добавить</button>
        </fieldset>
    </form>
    <table class="usersTable">
        <tr class="tableHeader">
            <td>ID</td>
            <td>Имя</td>
            <td>Кабинет</td>
            <td>Специальность</td>
        </tr>
        <#foreach doctor in doctorList>
            <tr class="tableBody">
                <td class="tableBody-info_cell">${doctor.id}</td>
                <td class="tableBody-info_cell">${doctor.name}</td>
                <td class="tableBody-info_cell">${doctor.cabinetNumber}</td>
                <td class="tableBody-info_cell">${doctor.specialization}</td>
                <td class="tableBody-button_cell">
                    <form action="/admin/delete" method="post">
                        <input type="hidden" name="doctorId" value="${doctor.id}"/>
                        <button type="submit">Удалить</button>
                    </form>
                </td>
            </tr>
        </#foreach>

    </table>
</@common.pageTemplate>