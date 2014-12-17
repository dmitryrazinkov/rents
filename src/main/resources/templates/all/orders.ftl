<#include "/all/header.ftl">
    <h2 align="center">Orders of room № ${roomNum}</h2>
    <#if orderList??>
        <table class="table table-striped">
            <tr>

                <th>Room</th>
                <th>Company</th>
                <th>Date Start</th>
                <th>Date End</th>
                <th></th>
            </tr>
            <#list orderList as order>

                <tr>

                    <td>${order.room.num}</td>
                    <td>${order.company.name}</td>
                    <td>${order.startDate}</td>
                    <td>${order.endDate}</td>
                    <td>
                        <span class="glyphicon glyphicon-remove"></span>
                        <a href="/rent/center/${id}/${roomId}/delete/${order.id}">Delete</a>
                    </td>
                </tr>

            </#list>
        </table>
    </#if>
    <a href="${roomId}/addOrder" class="btn btn-default" role="button">Add Order</a>
    <#include "/all/footer.ftl">