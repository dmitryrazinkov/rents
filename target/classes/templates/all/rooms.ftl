<table>
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