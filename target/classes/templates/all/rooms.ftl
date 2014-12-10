<#include "/all/header.ftl">
<h2 align="center">Rooms</h2>
<#if roomList??>
<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>Number</th>
        <th>Floor</th>
        <th>Area</th>
    </tr>
    <#list roomList as room>

        <tr>
            <td>${room.id}</td>
            <td>${room.num}</td>
            <td>${room.floor}</td>
            <td>${room.area}</td>
        </tr>

    </#list>
</table>
</#if>
<a href="${id}/addRoom" class="btn btn-default" role="button">Add Room</a>
<#include "/all/footer.ftl">