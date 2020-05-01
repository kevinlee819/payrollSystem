<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工信息管理</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css"/>
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.44/css/bootstrap-datetimepicker.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
    <link href="${path}/static/css/toastr.css"/>
    <link rel="stylesheet" href="${path}/static/css/firmstyle.css">
</head>
<body>
<div class="card mainbody">
    <%@include file="../../reuse/mainHead.jsp" %>
    <div class="container main">
        <div class="row" style="width:100%">
            <%--侧边栏--%>
            <%@include file="../../reuse/leftside.jsp" %>
            <div class="col-md-10 col-lg-10 basicInfo">
                <%@include file="employeeInfo.jsp" %>
            </div>
        </div>
    </div>
    <div class="footer">
        <p>Copyright &copy; 2019 Lee & Ning</p>
    </div>
    <%@include file="createEmployee.jsp" %>
    <%@include file="updateEmployee.jsp" %>
</div>

<!-- <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.0.js"></script> -->
<script src="${path}/static/js/jquery-3.4.1.min.js"></script>
<script src="https://cdn.bootcss.com/moment.js/2.22.0/moment-with-locales.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.44/js/bootstrap-datetimepicker.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script src="${path}/static/js/toastr.min.js"></script>
<script src="${path}/static/js/bootbox.min.js"></script>
<script src="${path}/static/js/bootbox.locales.min.js"></script>
<script src="${path}/static/js/firmstyle.js"></script>
<script src="${path}/static/js/basicInfo/employee.js"></script>
</body>
</html>