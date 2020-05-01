<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>mainWindow</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link href="${path}/static/css/mainwindow.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">

    <!--bootstrap-->
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/firmstyle.css">
</head>
<body>
<div class="card mainbody">
    <%--引入head文件--%>
    <%@include file="reuse/mainHead.jsp" %>
    <br>
    <div class="container main">
        <div class="row" style="width:100%">
            <%--侧边栏--%>
            <%@include file="reuse/leftside.jsp" %>
        </div>
    </div>
    <!--- footer --->
    <div class="footer">
        <p>Copyright &copy; 2019 Lee & Ning</p>
    </div>
</div>
<script src="${path}/static/js/jquery-3.4.1.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script src="${path}/static/js/firmstyle.js"></script>
</body>


</html>