<#include "/all/header.ftl">
    <h2 align="center">Orders of room № ${roomNum}</h2>
    <#if orderList??>
        <table class="table table-striped">
            <tr>
                <th>#</th>
                <th>Room</th>
                <th>Company</th>
                <th>Date Start</th>
                <th>Date End</th>
            </tr>
            <#list orderList as order>

                <tr>
                    <td>${order.id}</td>
                    <td>${order.room.num}</td>
                    <td>${order.company.name}</td>
                    <td>${order.startDate}</td>
                    <td>${order.endDate}</td>
                </tr>

            </#list>
        </table>
    </#if>
    <a href="${id}/addOrder" class="btn btn-default" role="button">Add Order</a>
    <#include "/all/footer.ftl">