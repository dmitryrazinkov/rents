<#include "/all/header.ftl">
    <form method="post" action="/rent/company/add" name="company">
        <div class="form-group">
            <label>Название:</label>
            <input type="text" name="name" class="form-control">
        </div>
        <div class="form-group">
            <label>Контактное лицо:</label>
            <input type="text" name="contact" class="form-control">
        </div>
        <div class="form-group">
            <label>Телефон:</label>
            <input type="text" name="tel" class="form-control">
        </div>
        <input type="submit" value="Submit"  class="btn btn-default">
    </form>
    <#include "/all/footer.ftl">