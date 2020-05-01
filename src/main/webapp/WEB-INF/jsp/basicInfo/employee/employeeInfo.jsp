<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group topcard">
    <div class="row">
        <div class="col-md-7">
            <label for="search"></label>
            <input type="text" id="search" class="form-control secEmpBox" placeholder="输入员工ID/姓名"/>
        </div>
        <div class="col-md-5">
            <button class="btn btn-danger secEmp">搜索员工信息</button><!--搜索-->
            <button class="btn btn-default add" data-toggle="modal" data-target="#createEmpModal">新增员工</button>
            <!--data-toggle data-target 属性插入bootstrap事件自带的模态框事件-->
        </div>
    </div>
</div>
<br>
<div>
    <table class="table table-bordered text-center" id="alterColor">
        <tr>
            <th>员工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>身份证号</th>
            <th>部门</th>
            <th>岗位</th>
            <th>入职日期</th>
            <th>参加工作日期</th>
            <th>用工形式</th>
            <th>人员来源</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr class="aEmployee">
                <td class="employeeId">${employee.employeeId}</td>
                <td class="employeeName">${employee.employeeName}</td>
                <td class="employeeSex">${employee.employeeSex}</td>
                <td class="employeeBirth">${employee.employeeBirth}</td>
                <td class="IdNumber">${employee.idNumber}</td>
                <td class="departmentName">${employee.departmentName}</td>
                <td class="positionName">${employee.positionName}</td>
                <td class="dateOfEntry">${employee.dateOfEntry}</td>
                <td class="dateOfParti">${employee.dateOfParti}</td>
                <td class="formOfEmployment">${employee.formOfEmployment}</td>
                <td class="sourceOfEmployment">${employee.sourceOfEmployment}</td>
                <td>
                    <a href="#" role="button" class="btn btn-primary editEmpBtn" data-toggle="modal"
                       data-target="#updateEmpModal">编辑</a>
                    <a href="#" role="button" class="btn btn-danger deleteEmpBtn">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>