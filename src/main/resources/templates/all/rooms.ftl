<#include "/all/header.ftl">

    <#if error??>
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <p> ${error}</p>
        </div>
    </#if>

<h2 align="center">Rooms of ${center}</h2>
<#if roomList??>
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Number</th>
        <th>Floor</th>
        <th>Area</th>
        <th></th>
        <th></th>
    </tr>
    <#list roomList as room>

        <tr>
            <td>${room.id}</td>
            <td>${room.num}</td>
            <td>${room.floor}</td>
            <td>${room.area}</td>
            <td>
                <span class="glyphicon glyphicon-pencil"></span>
                <a href="/rent/center/${id}/update/${room.id}">Edit</a>
                <span class="glyphicon glyphicon-remove"></span>
                <a href="/rent/center/${id}/delete/${room.id}">Delete</a>
            </td>
            <td><a href="${id}/${room.id}">Orders</a></td>
        </tr>

    </#list>
</table>
</#if>
<a href="/rent/center/${id}/addRoom" class="btn btn-default" role="button">Add Room</a>
<#include "/all/footer.ftl">