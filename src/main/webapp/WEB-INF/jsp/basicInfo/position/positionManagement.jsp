<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/20
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>岗位管理</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css"/>
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

                <%--岗位信息--%>
                <%@include file="positionInfo.jsp" %>
            </div>
        </div>
    </div>
        <div class="footer">
            <p>Copyright &copy; 2019 Lee & Ning</p>
        </div>
    <%@include file="createPosition.jsp" %>
    <%@include file="updatePosition.jsp" %>
</div>
<!--显示岗员工信息-->
<div class="modal fade emplymd" tabindex="-1" role="dialog" id="employeeModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">岗下员工</h4>
            </div>
            <div class="modal-body">
                <!--  在这添加信息  -->

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
</div>
</div>
<script type="text/javascript" src="${path}/static/js/jquery-3.4.1.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script type="text/javascript" src="${path}/static/js/bootstrap.min.js"></script>
<script src="${path}/static/js/toastr.min.js"></script>
<script src="${path}/static/js/bootbox.min.js"></script>
<script src="${path}/static/js/bootbox.locales.min.js"></script>
<script src="${path}/static/js/firmstyle.js"></script>
<script src="${path}/static/js/basicInfo/positionManagement.js"></script>
</body>
</html>
