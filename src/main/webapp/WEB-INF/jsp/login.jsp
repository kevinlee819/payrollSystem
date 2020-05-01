<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/17
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${path}/static/css/toastr.css">
    <link href="${path}/static/css/loginStyle.css" rel="stylesheet" type="text/css" media="all"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

</head>
<body>
<!-- contact-form -->
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>工资管理系统</h1>
        </div>
        <form class="form-signin" method="post">
            <li>
                <input type="text" name="userName" id="userName" class="form-control" placeholder="用户名"
                       required autofocus>
            </li>
            <div class="clear"></div>
            <li>
                <!-- <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"> <a href="#" class="icon lock"></a> -->
                <input type="password" name="password" id="password" class="form-control"
                       placeholder="密码" required>
            </li>
            <button type="button" id="signin_btn" class="loginbtn"  onclick="login()" value="Sign in"
                    style="
				position: absolute;
				left:30%;
				color: #fff;
				cursor: pointer;
				font-weight: 900;
				outline: none;
				font-family: 'Raleway', sans-serif;
				padding: 12px 0px;
				width: 35%;
				font-size: 18px;
				background:rgb(44,85,60);
				border:2px solid rgb(44,85,60);
				border-radius: 0.5em;
				-webkit-border-radius:0.5em;
				-moz-border-radius:0.5em;
				-o-border-radius:0.5em;">Sign in</button>

        </form>
    </div>
</div>
<!--- footer --->
<div class="footer">
    <p>Copyright &copy; 2019 Lee & Ning</p>
</div>
<script src="${path}/static/js/jquery-3.4.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${path}/static/js/bootstrap.min.js"></script>
<script src="${path}/static/js/toastr.min.js"></script>
<script type="text/javascript">
    $(function () {
        toastr.options.positionClass = 'toast-top-center';
    });
    //登录操作
    function login(){
        var userName = $("#userName").val();
        var password = $("#password").val();
        if(userName == 0){
            toastr.error("名称不能为空");
        }else if(password == 0){
            toastr.error("密码不能为空");
        }else{
        toastr.options.positionClass = 'toast-top-center';
            $.ajax({
                url: "dologin?userName="+userName + "&password=" + password,
                type: "POST",
                async: true,
                dataType: "json",
                success: function (res) {
                    if (res.code === 1) {
                        toastr.success("登录成功");
                        window.location.href = "basicInfo/department";
                    } else {
                        toastr.error("输入用户名或者密码错误");
                    }
                },
                error: function () {
                    toastr.error("请求失败！！！");
                }
            });
        }
    }
</script>
</body>
</html>
