<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/20
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container topcard" style="padding-top: 15px;"><!--整个盒子居中-->
    <div class="form-group">
        <div class="row">
            <div class="col-md-5">
                <input type="text" class="form-control secDepBox" placeholder="输入部门编号/名称/类型"/>
            </div>
            <div class="col-md-7">
                <%--<button class="btn btn-danger sec">搜索部门信息</button><!--搜索-->--%>
                <button class="btn btn-success secDepEmp">搜索部门下员工</button>
                <button class="btn btn-default createPosBtn" data-toggle="modal"
                        data-target="#createDepModal">
                    新建部门
                </button>
                <!--data-toggle data-target 属性插入bootstrap事件自带的模态框事件-->
            </div>
        </div>
    </div>
</div>
<br>
<div class="table-responsive departmentInfo">
    <%--显示员工信息--%>
    <table class="table table-bordered table-hover" id="alterColor">
        <tr>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>部门电话</th>
        <th>部门类别</th>
        <th>操作</th>
        </tr>
        <c:forEach items="${departments}" var="department">
            <tr class="aDepartment">
                <td class="departmentId">${department.departmentId}</td>
                <td class="departmentName">${department.departmentName}</td>
                <td class="departmentTel">${department.departmentTel}</td>
                <td class="departmentType">${department.departmentType}</td>
                <td>
                    <a href="#" role="button" class="btn btn-primary editDepBtn" data-toggle="modal"
                       data-target="#updateDepModal">编辑</a>
                    <a href="#" role="button" class="btn btn-danger deleteDepBtn">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
