<#include "/all/header.ftl">
<form method="post" action="<#if center?? && center.id??>/rent/center/update/${center.id}<#else>/rent/center/add</#if>" name="center">
    <div class="form-group">
        <label>Название бизнес центра:</label>
        <input type="text" name="name" class="form-control" <#if center?? && center.name??>value="${center.name}"</#if>>
    </div>
    <input type="submit" value="Submit"  class="btn btn-default">
</form>
<#include "/all/footer.ftl">