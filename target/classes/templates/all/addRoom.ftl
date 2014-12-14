<#include "/all/header.ftl">
    <form method="post" name="room">
        <div class="form-group">
            <label>Number of room:</label>
            <input type="number" name="num" class="form-control">
        </div>
        <div class="form-group">
            <label>Floor:</label>
            <input type="number" name="floor" class="form-control">
        </div>
        <div class="form-group">
            <label>Area:</label>
            <input type="number" name="area" class="form-control">
        </div>
        <input type="submit" value="Submit"  class="btn btn-default">
    </form>
    <#include "/all/footer.ftl">