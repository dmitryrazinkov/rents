<#include "/all/header.ftl">
<h2 align="center">Rooms of ${center}</h2>
<#if roomList??>
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Number</th>
        <th>Floor</th>
        <th>Area</th>
        <th></th>
    </tr>
    <#list roomList as room>

        <tr>
            <td>${room.id}</td>
            <td>${room.num}</td>
            <td>${room.floor}</td>
            <td>${room.area}</td>
            <td><a href="${id}/${room.id}">Orders</a></td>
        </tr>

    </#list>
</table>
</#if>
<a href="${id}/addRoom" class="btn btn-default" role="button">Add Room</a>
<#include "/all/footer.ftl">