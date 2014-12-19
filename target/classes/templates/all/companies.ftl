<#include "/all/header.ftl">
    <#if error??>
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <p> ${error}</p>
        </div>
    </#if>


    <h2 align="center">Companies</h2>
    <table class="table table-striped" id="table">
        <thead>
        <tr>

            <th data-type="string">Name</th>
            <th data-type="string">Contact</th>
            <th data-type="string">Tel.</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list companiesList as company>

            <tr>

                <td>${company.name}</td>
                <td>${company.contact}</td>
                <td>${company.tel}</td>
                <td>
                    <span class="glyphicon glyphicon-pencil"></span>
                    <a href="/rent/company/update/${company.id}">Edit</a>
                    <span class="glyphicon glyphicon-remove"></span>
                    <a href="/rent/company/delete/${company.id}">Delete</a>
                </td>
            </tr>

        </#list>
        </tbody>
    </table>
    <script src="/assets/sort.js"></script>
    <a href="company/add" class="btn btn-default" role="button">Add Company</a>
    <#include "/all/footer.ftl">