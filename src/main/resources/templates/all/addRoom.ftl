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

    <form method="post" action="<#if room?? && room.id??>/rent/center/${id}/update/${room.id}<#else>/rent/center/${id}/addRoom</#if>" name="room">
        <div class="form-group">
            <label>Number of room:</label>
            <input type="number" name="num" class="form-control" <#if room?? && room.num??>value=${room.num}</#if> >
        </div>
        <div class="form-group">
            <label>Floor:</label>
            <input type="number" name="floor" class="form-control" <#if room?? && room.floor??>value=${room.floor}</#if> >
        </div>
        <div class="form-group">
            <label>Area:</label>
            <input type="number" name="area" class="form-control" <#if room?? && room.area??>value=${room.area}</#if> >
        </div>
        <input type="submit" value="Submit"  class="btn btn-default">
    </form>
    <#include "/all/footer.ftl">