<#include "/all/header.ftl">
    <h2 align="center">Companies</h2>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Contact</th>
            <th>Tel.</th>
        </tr>
        <#list companiesList as company>

            <tr>
                <td>${company.id}</td>
                <td>${company.contact}</td>
                <td>${company.tel}</td>
            </tr>

        </#list>
    </table>
    <a href="company/add" class="btn btn-default" role="button">Add Company</a>
    <#include "/all/footer.ftl">