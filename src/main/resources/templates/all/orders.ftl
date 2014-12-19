<#include "/all/header.ftl">
    <h2 align="center">Orders of room № ${roomNum}</h2>
    <#if orderList??>
        <table class="table table-striped" id="table">
            <thead>
            <tr>

                <th data-type="number">Room</th>
                <th data-type="string">Company</th>
                <th data-type="date">Date Start</th>
                <th data-type="date">Date End</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
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
            </tbody>
        </table>
        <script src="/assets/sort.js"></script>
    </#if>
    <a href="${roomId}/addOrder" class="btn btn-default" role="button">Add Order</a>
    <#include "/all/footer.ftl">