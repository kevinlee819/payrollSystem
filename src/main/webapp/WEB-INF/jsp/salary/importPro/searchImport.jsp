<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/26
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
    <title>Department Management</title>

    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css"/>
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
          rel="stylesheet">
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
                <div class="row topcard">
                    <div class="col-md-5" style="padding-right: 0px; padding-left:10px">
                        <input type="text" class="form-control secbox" placeholder="通过员工ID或者部门名搜索导入项目"/>
                    </div>
                    <div class="col-md-1" style="padding: 0 0 0 0;">
                        <button type="button" class="btn btn-success sec">
                            <i class="fa fa-search"></i>
                            <span>搜索</span>
                        </button>
                    </div>
                    <div class="col-md-3" style="padding-left:30px; padding-right:0px">
                        <form>
                            <label class="input-group-btn">
                            <span class="btn btn-primary">
                                <i class="fa fa-folder-open"></i>导入
                            </span>
                                <input type="file"
                                       accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
                                       onchange="show();importExcel(this)" style="display: none;" id="upload" single>
                            </label>
                            <button type="button" class="btn btn-default importProBtn">
                                <i class="fa fa-upload"></i>
                                <span class="hidden-xs">提交</span>
                            </button>
                        </form>
                    </div>
                    <div class="col-md-2" style="padding-top: 5px; padding-left: 0px">
                        <input type="text" id="des" placeholder="尚无文件被导入" disabled="disabled" style="width:210px"/>
                    </div>
                </div>
                <c:if test="${empty searchPros}">
                    <h2 style="color: #b21f2d">没有搜索到信息</h2>
                </c:if>
                <c:if test="${not empty searchPros}">
                    <h2 style="color: #1d2124">搜索信息</h2>
                    <div class="row">
                        <table class="table table-bordered text-center" id="alterColor">
                            <tr>
                                <th>员工编号</th>
                                <th>员工姓名</th>
                                <th>病假天数</th>
                                <th>事假天数</th>
                                <th>迟到次数</th>
                                <th>加班天数</th>
                                <th>补发</th>
                                <th>导入日期</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach var="searchPro" items="${searchPros}" varStatus="status">
                                <tr>
                                    <td>${searchPro.empId}</td>
                                    <td>${searchPro.empName}</td>
                                    <td>${searchPro.sickLeaveDay}</td>
                                    <td>${searchPro.personalLeaveDay}</td>
                                    <td>${searchPro.lateNum}</td>
                                    <td>${searchPro.overtimeDay}</td>
                                    <td>${searchPro.reissue}</td>
                                    <td>${searchPro.importDate}</td>
                                    <td>
                                        <a href="#" role="button" class="btn btn-info updateImportBtn" data-toggle="modal"
                                           data-target="#updateImportModal">更新</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </div>
        </div>
        <%@include file="updateImport.jsp"%>
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
<script src="${path}/static/js/salary/importPro.js"></script>

</body>