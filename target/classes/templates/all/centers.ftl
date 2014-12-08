<#include "/all/header.ftl">
<h2 align="center">Bussines Centers</h2>
<table class="table table-striped">
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
<#include "/all/footer.ftl">