<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/28
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department Management</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css"/>
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/static/css/toastr.css">
    <link rel="stylesheet" href="${path}/static/css/firmstyle.css">
</head>
<body>
<div class="card mainbody">
    <%--头部--%>
    <%@include file="../../reuse/mainHead.jsp" %>
    <div class="container main">
        <div class="row" style="width:100%">
            <%--侧边栏--%>
            <%@include file="../../reuse/leftside.jsp" %>

            <div class="col-md-10 col-lg-10 basicInfo">
                <div class="container topcard" style="padding-top: 15px;"><!--整个盒子居中-->
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-5">
                                <input type="text" class="form-control secPosBox" placeholder="输入岗位编号/名称/类型"/>
                            </div>
                            <div class="col-md-7">
                                <%--<button class="btn btn-danger sec">搜索岗位信息</button><!--搜索-->--%>
                                <button class="btn btn-success secPosEmp">搜索岗下员工</button>
                                <button class="btn btn-default createPosBtn" data-toggle="modal"
                                        data-target="#createPosModal">新建岗位
                                </button>
                                <!--data-toggle data-target 属性插入bootstrap事件自带的模态框事件-->
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <c:if test="${empty employees}">
                    <h3 style="color: #b21f2d">${title}</h3>
                </c:if>
                <c:if test="${not empty employees}">
                    <h3 style="color: #1d2124">${title}</h3>
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
                </c:if>
            </div>
        </div>
    </div>
    <div class="footer">
        <p>Copyright &copy; 2019 Lee & Ning</p>
    </div>
    <%@include file="createPosition.jsp" %>
    <%@include file="../employee/createEmployee.jsp" %>
    <%@include file="../employee/updateEmployee.jsp" %>
</div>

<%--在bootstrap之前引入--%>
<script src="${path}/static/js/jquery-3.4.1.min.js"></script>
<%--bootstrap日期控件--%>
<script src="https://cdn.bootcss.com/moment.js/2.22.0/moment-with-locales.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script src="${path}/static/js/toastr.min.js"></script>
<script src="${path}/static/js/bootbox.min.js"></script>
<script src="${path}/static/js/bootbox.locales.min.js"></script>
<script src="${path}/static/js/firmstyle.js"></script>
<script src="${path}/static/js/basicInfo/positionManagement.js"></script>
<script src="${path}/static/js/basicInfo/employee.js"></script>
</body>
</html>
