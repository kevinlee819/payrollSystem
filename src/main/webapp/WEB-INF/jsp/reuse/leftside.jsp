<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/18
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<div class="col-md-2 col-lg-2"><br>
    <div class="card side">

        <%--<img class="card-img-top" src="${path}/static/img/mng.jpg" alt="Card image cap">--%>
        <div class="card-body" style="padding: 10px 0 10px 0">
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <h3 id="f1"><i></i>基础信息管理&nbsp;</h3>
                    <div class="ItemDet">
                        <a id="f1h1" href="${path}/basicInfo/department" target="_top">部门管理</a><br>
                        <a id="f1h2" href="${path}/basicInfo/position" target="_top">岗位管理</a><br>
                        <a id="f1h3" href="${path}/basicInfo/employee" target="_top">员工信息管理</a>
                    </div>
                </li>
                <li class="list-group-item">
                    <h3 id="f2"><i></i>工资管理</h3>
                    <div class="ItemDet">
                        <a id="f2h1" href="${path}/salary/salaryPro" target="_top">工资项目管理</a><br>
                        <a id="f2h2" href="${path}/salary/fixedSalary" target="_top">固定工资管理</a><br>
                        <a id="f2h3" href="${path}/salary/importPro" target="_top">导入项目数据录入</a><br>
                        <a id="f2h4" href="${path}/salary/calculatePage" target="_top">工资结算</a>
                    </div>
                </li>
                <li class="list-group-item">
                    <h3 id="f3"><i></i>报表管理</h3>
                    <div class="ItemDet">
                        <a id="f3h1" href="${path}/form/formManagement" target="_top">工资查询报表</a><br>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>