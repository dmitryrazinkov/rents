<#include "/all/header.ftl">
<h2 align="center">Bussines Centers</h2>
<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th></th>
    </tr>
    <#list centerList as center>

        <tr>
            <td>${center.id}</td>
            <td>${center.name}</td>
            <td>
                <a href="center/${center.id}">Rooms</a>
            </td>
        </tr>

    </#list>
</table>
<a href="center/add" class="btn btn-default" role="button">Add Center</a>
<#include "/all/footer.ftl">