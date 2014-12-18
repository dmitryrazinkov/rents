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
     <!--       <input type="text" name="name" class="form-control"> -->
            <select name="name" class="form-control">
                <#list companies as company>
                     <option>${company.name}</option>
                </#list>
            </select>
            <p align="left">
                <small>
                    You also can <a href="/rent/company/add">add</a> new company.
                </small>
            </p>
        </div>
        <div class="form-group">
            <label>Дата начала:</label>
            <input type="date" name="startDate" class="form-control" <#if startDate??>value=${startDate}</#if> >
        </div>
        <div class="form-group">
            <label>Дата окончания:</label>
            <input type="date" name="endDate" class="form-control" <#if endDate??>value=${endDate}</#if> >
        </div>
        <input type="submit" value="Submit"  class="btn btn-default">
    </form>
    <#include "/all/footer.ftl">