<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/18
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css"/>
</head>
<body>

<%@include file="reuse/mainHead.jsp"%>
<script src="${path}/static/js/bootstrap.min.js"></script>
</body>
</html>
