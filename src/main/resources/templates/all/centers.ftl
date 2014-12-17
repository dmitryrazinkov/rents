<#include "/all/header.ftl">

    <#if error??>
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <p> ${error}</p>
        </div>
    </#if>

<h2 align="center">Bussines Centers</h2>
<table class="table table-striped">
    <tr>
        <th>#</th>
        <th>Name</th>
        <th></th>
        <th></th>
    </tr>
    <#list centerList as center>

        <tr>
            <td>${center.id}</td>
            <td>${center.name}</td>
            <td>
                <span class="glyphicon glyphicon-pencil"></span>
                <a href="/rent/center/update/${center.id}">Edit</a>
                <span class="glyphicon glyphicon-remove"></span>
                <a href="/rent/center/delete/${center.id}">Delete</a>
            </td>
            <td>
                <a href="/rent/center/${center.id}">Rooms</a>
            </td>
        </tr>

    </#list>
</table>
<a href="/rent/center/add" class="btn btn-default" role="button">Add Center</a>



<#include "/all/footer.ftl">