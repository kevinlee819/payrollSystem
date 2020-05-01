<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 宁鑫
  Date: 2019/6/18
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container navigation">
    <div class="row">
        <h1 style="position: relative; left:35%">工资管理系统
            <small class="subhead" style="color: #ccc"></small></h1>

        <div class="dropdown" style="position:absolute;left:85%;top:10px">
            <a class="dropdown-toggle" data-toggle="dropdown" style="height: 40px" href="#">
                <img alt="" class="img-circle" src="${path}/static/img/user.png" width="33px" height="33px">
                <span style="color: #FFFFFF;font-size: 15px"></span>
            </a>
            <div class="dropdown-menu" style="background:whitesmoke;width: 140px;overflow: hidden;" onfocus="">
                <style>
                    .choicebar:hover{
                        background-color: rgba(255, 255, 255, 0.664);
                        box-shadow: 1px 2px 3px 1px #ccc;
                    }
                </style>
                <div class="row choicebar" style="margin:0 0 0 0; padding:0 0 0 0;cursor: pointer; ">
                    <div class="text-center account" style="padding:0 10px 5px 10px;margin: 0;color: #323534;" data-toggle="modal" data-target="#accountManageModal">
                        <i class="fa fa-gear" style="font-size: 25px;line-height: 45px;"></i>&nbsp;账号管理
                    </div>
                </div>

                <div class="row choicebar"  style="margin:0 0 0 0;padding:0 0 0 0;cursor: pointer;">
                    <div class="text-center logout" style="padding:5px 10px 5px 10px;margin: 0;color: #323534;" onclick="logout()">
                        <i class="fa fa-sign-out" style="font-size: 25px;line-height: 45px;"></i>&nbsp;退出登入界面
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--账号管理模态框-->
<div class="modal fade up" tabindex="-1" role="dialog" id="accountManageModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改密码</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" ><span aria-hidden="true">&times;</span></button>

            </div>
            <div class="modal-body">
                <b id="passModifyMess" style="color: red;"></b>
                <style>
                    .modal-title{
                        left:10%;
                        padding-top:10px;
                    }

                    .modal-header{
                        background-color: rgb(44,85,60);
                    }
                    .modal-header h4{
                        color: #FFFFFF;
                    }
                    .close{
                        margin: 0;
                        color:white;
                    }
                    input[type="button"] {
                        position: relative;
                        left:19%;
                        color: #fff;
                        cursor: pointer;
                        font-weight: 900;
                        outline: none;
                        font-family: 'Raleway', sans-serif,'微软雅黑';
                        padding: 8px 0px;
                        width: 20%;
                        font-size: 16px;
                        background:rgb(44,85,60);
                        border:1px solid rgb(44,85,60);
                        border-radius: 0.5em;
                        -webkit-border-radius:0.5em;
                        -moz-border-radius:0.5em;
                        -o-border-radius:0.5em;
                    }
                    input[type="button"]:hover {
                        background: #fff;
                        color:rgb(44,85,60);
                        border:2px solid rgb(44,85,60);
                    }
                    input[type="reset"] {
                        position: relative;

                        left:40%;
                        color: #fff;
                        cursor: pointer;
                        font-weight: 900;
                        outline: none;
                        font-family: 'Raleway', sans-serif,'微软雅黑';
                        padding: 8px 0px;
                        width: 20%;
                        font-size: 16px;
                        background:rgb(44,85,60);
                        border:1px solid rgb(44,85,60);
                        border-radius: 0.5em;
                        -webkit-border-radius:0.5em;
                        -moz-border-radius:0.5em;
                        -o-border-radius:0.5em;
                    }
                    input[type="reset"]:hover {
                        background: #fff;
                        color:rgb(44,85,60);
                        border:2px solid rgb(44,85,60);
                    }
                    .psdchange{
                        padding:10px 20px 10px 20px;
                    }
                    .psdchange label{
                        font-weight: bold;
                    }
                </style>
                <form method="post">
                    <div class="form-group row psdchange">
                        <label for="oldpass" class="control-label">旧密码：</label>
                        <input type="password" placeholder="old password" class="form-control" id="oldpass"/>
                    </div>
                    <div class="form-group row psdchange">
                        <label for="oldpass" class="control-label">新密码：</label>
                        <input type="password" placeholder="new password" class="form-control" id="newpass"/>
                    </div>
                    <div class="form-group row psdchange">
                        <label for="oldpass" class="control-label">确认密码：</label>
                        <input type="password" placeholder="confirm password" class="form-control" id="confirmpass"/>
                    </div>
                    <input type="button" id="submit" value="提交" onclick="submitPass()"/>
                    <input type="reset" id="reset" value="重置" />
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>