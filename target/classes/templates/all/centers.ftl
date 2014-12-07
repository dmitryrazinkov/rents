<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <#list centerList as center>

        <tr>
            <td>${center.id}</td>
            <td>${center.name}</td>
        </tr>

    </#list>
</table>