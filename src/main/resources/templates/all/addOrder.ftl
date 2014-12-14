<#include "/all/header.ftl">
    <form method="post" >
        <div class="form-group">
            <label>Название компании:</label>
            <input type="text" name="name" class="form-control">
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