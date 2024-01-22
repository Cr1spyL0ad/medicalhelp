<#macro pageTemplate message>
    <div class="modal open" id="modal">
        <div class="modal-inner">
            <p>${message}</p>
            <button onclick="togglePopup()" id="closeModal">Закрыть</button>
        </div>
    </div>
</#macro>