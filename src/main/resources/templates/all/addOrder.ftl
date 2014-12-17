<#include "/all/header.ftl">
    <#if errors??>
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <#list errors as error>
                <p> ${error}</p>
            </#list>
        </div>
    </#if>


    <form method="post" action="/rent/center/${id}/${roomId}/addOrder"  >
        <div class="form-group">
            <label>Название компании:</label>
            <input type="text" name="name" class="form-control">
            <p align="left">
                <small>
                    You also can <a href="/rent/company/add">add</a> company.
                </small>
            </p>
        </div>
        <div class="form-group">
            <label>Дата начала:</label>
            <input type="date" name="startDate" class="form-control">
        </div>
        <div class="form-group">
            <label>Дата окончания:</label>
            <input type="date" name="endDate" class="form-control">
        </div>
        <input type="submit" value="Submit"  class="btn btn-default">
    </form>
    <#include "/all/footer.ftl">