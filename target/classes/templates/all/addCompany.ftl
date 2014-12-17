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

    <form method="post" action="<#if company?? && company.id??>/rent/company/update/${company.id}<#else>/rent/company/add</#if>" name="company">
        <div class="form-group">
            <label>Название:</label>
            <input type="text" name="name" class="form-control" <#if company?? && company.name??>value=${company.name}</#if> >
        </div>
        <div class="form-group">
            <label>Контактное лицо:</label>
            <input type="text" name="contact" class="form-control" <#if company?? && company.contact??>value=${company.contact}</#if>>
        </div>
        <div class="form-group">
            <label>Телефон:</label>
            <input type="number" name="tel" class="form-control" <#if company?? && company.tel??>value=${company.tel}</#if>>
        </div>
        <input type="submit" value="Submit"  class="btn btn-default">
    </form>
    <#include "/all/footer.ftl">