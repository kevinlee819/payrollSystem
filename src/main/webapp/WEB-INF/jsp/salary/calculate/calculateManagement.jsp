<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/27
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
    <title>Department Management</title>

    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css"/>
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/static/css/toastr.css">
    <link rel="stylesheet" href="${path}/static/css/firmstyle.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
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
                <%@include file="calculateInfo.jsp"%>
            </div>
        </div>
    </div>
        <div class="footer">
            <p>Copyright &copy; 2019 Lee & Ning</p>
        </div>
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
<%--上传文件--%>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<%--处理excel--%>
<script src="http://oss.sheetjs.com/js-xlsx/xlsx.full.min.js"></script>
<script src="${path}/static/js/firmstyle.js"></script>
<script src="${path}/static/js/salary/calculate.js"></script>

</body>